import React from 'react';
import styles from './SkeletonCard.module.scss';

const SkeletonCard: React.FC = () => {
    return (
        <div className={styles.skeletonCard}>
            <div className={styles.imageContainer}>
                <div className={styles.imageSkeleton}></div>
            </div>
            <div className={styles.content}>
                <div className={styles.titleSkeleton}></div>
                <div className={styles.descriptionSkeleton}></div>
                <div className={styles.meta}>
                    <div className={styles.budgetSkeleton}></div>
                    <div className={styles.dateSkeleton}></div>
                </div>
            </div>
        </div>
    );
};

export default SkeletonCard;
