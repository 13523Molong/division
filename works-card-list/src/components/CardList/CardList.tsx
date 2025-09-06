import React, { useState, useEffect, useCallback, useRef } from 'react';
import { WorkItem } from '../../types';
import Card from '../Card/Card';
import SkeletonCard from '../SkeletonCard/SkeletonCard';
import Grid from '../Grid/Grid';
import { worksService } from '../../services/worksService';
import styles from './CardList.module.scss';

const CardList: React.FC = () => {
  const [works, setWorks] = useState<WorkItem[]>([]);
  const [loading, setLoading] = useState(false);
  const [hasMore, setHasMore] = useState(true);
  const [page, setPage] = useState(1);
  const [initialLoading, setInitialLoading] = useState(true);
  const observer = useRef<IntersectionObserver>();
  const loadingRef = useRef<HTMLDivElement>(null);

  // 加载初始数据
  useEffect(() => {
    const loadInitialWorks = async () => {
      try {
        setInitialLoading(true);
        const result = await worksService.getInitialWorks();
        setWorks(result.data);
        setHasMore(result.hasMore);
        setPage(2);
      } catch (error) {
        console.error('加载初始数据失败:', error);
      } finally {
        setInitialLoading(false);
      }
    };

    loadInitialWorks();
  }, []);

  // 加载更多数据
  const loadMore = useCallback(async () => {
    if (loading || !hasMore) return;

    try {
      setLoading(true);
      const result = await worksService.getWorks(page, 10);
      setWorks(prev => [...prev, ...result.data]);
      setHasMore(result.hasMore);
      setPage(prev => prev + 1);
    } catch (error) {
      console.error('加载更多数据失败:', error);
    } finally {
      setLoading(false);
    }
  }, [loading, hasMore, page]);

  // 设置交叉观察器
  useEffect(() => {
    if (initialLoading || loading || !hasMore) return;

    if (observer.current) observer.current.disconnect();

    observer.current = new IntersectionObserver(
      (entries) => {
        if (entries[0].isIntersecting && hasMore && !loading) {
          loadMore();
        }
      },
      { threshold: 0.1 }
    );

    const timer = setTimeout(() => {
      if (loadingRef.current) {
        observer.current?.observe(loadingRef.current);
      }
    }, 100);

    return () => {
      clearTimeout(timer);
      if (observer.current) {
        observer.current.disconnect();
      }
    };
  }, [loading, hasMore, loadMore, page, initialLoading]);

  // 渲染骨架屏
  const renderSkeletons = (count: number) => {
    return Array.from({ length: count }, (_, index) => (
      <SkeletonCard key={`skeleton-${index}`} />
    ));
  };

  if (initialLoading) {
    return (
      <div className={styles.cardList}>
        <Grid>
          {renderSkeletons(12)}
        </Grid>
      </div>
    );
  }

  return (
    <div className={styles.cardList}>
      <Grid>
        {works.map(work => (
          <Card
            key={work.id}
            title={work.title}
            description={work.description}
            image={work.image}
            budget={work.budget}
            dueDate={work.dueDate}
          />
        ))}

        {/* 加载更多区域 */}
        {hasMore && (
          <div ref={loadingRef} className={styles.loadingArea}>
            {loading && (
              <div className={styles.loadingIndicator}>
                <i className="fa-solid fa-spinner"></i>
                <span>正在加载中...</span>
              </div>
            )}
            {!loading && renderSkeletons(6)}
          </div>
        )}
        {!hasMore && (
          <div className={styles.noMoreData}>
            <i className="fa-solid fa-check-circle"></i>
            <span>已加载全部内容</span>
          </div>
        )}
      </Grid>
    </div>
  );
};

export default CardList;