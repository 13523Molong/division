import React from 'react';
import styles from './Card.module.scss';

interface CardProps {
  title: string;
  description: string;
  image: string;
  budget?: number;
  dueDate?: string;
}

const Card: React.FC<CardProps> = ({ title, description, image, budget, dueDate }) => {
  const formatBudget = (budget?: number) => budget ? `¥${budget.toLocaleString()}` : '';
  const formatDate = (date?: string) => date ? new Date(date).toLocaleDateString('zh-CN', { month: 'short', day: 'numeric' }) : '';

  return (
    <div className={styles.card}>
      <div className={styles.imageContainer}>
        <img src={image} alt={title} className={styles.image} />
      </div>
      <div className={styles.content}>
        <h3 className={styles.title}>{title}</h3>
        <p className={styles.description}>{description}</p>
        <div className={styles.meta}>
          {budget && <span className={styles.budget}>{formatBudget(budget)}</span>}
          {dueDate && <span className={styles.dueDate}>{formatDate(dueDate)}</span>}
        </div>
      </div>
    </div>
  );
};

export default Card;