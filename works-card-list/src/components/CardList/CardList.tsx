import React from 'react';
import { WorkItem } from '../../types';
import Card from '../Card/Card';
import Grid from '../Grid/Grid';
import styles from './CardList.module.scss';

type CardListProps = {
  items: WorkItem[];
};

const CardList: React.FC<CardListProps> = ({ items }) => {
  return (
    <div className={styles.cardList}>
      <Grid>
        {items.map(work => (
          <Card 
            key={work.id} 
            id={work.id}
            title={work.title} 
            description={work.description} 
            image={work.image} 
          />
        ))}
      </Grid>
    </div>
  );
};

export default CardList;