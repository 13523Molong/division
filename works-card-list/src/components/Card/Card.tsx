import React from 'react';
import styles from './Card.module.scss';

interface CardProps {
  id: number;
  title: string;
  description: string;
  image: string;
}

const Card: React.FC<CardProps> = ({ title, description, image }) => {
  return (
    <div className={styles.card}>
      {/* 图片始终显示，占 60% */}
      <img src={image} alt={title} className={styles['card-image']} />

      {/* 文字部分，占 40% */}
      <div className={styles['card-content']}>
        <h3 className={styles['card-title']}>{title}</h3>
        <p className={styles['card-description']}>{description}</p>
      </div>
    </div>
  );
};

export default Card;