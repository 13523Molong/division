import React from "react";
import styles from "./Grid.module.scss";

const Grid: React.FC<{ children: React.ReactNode }> = ({ children }) => {
  return <div className={styles.grid}>{children}</div>;
};

export default Grid;