import React, { useState } from "react";
import CardList from "../../components/CardList/CardList";
import styles from "./WorksPage.module.scss";
import { Link } from "react-router-dom"; 
import worksData from "../../data/worksData";
import { WorkItem } from "../../types"; 

const WorksPage: React.FC = () => {
  const [works] = useState<WorkItem[]>(worksData);

  return (
    <div className={styles.container}>
      <div style={{ display: "flex", justifyContent: "space-between", alignItems: "center" }}>
        <h2>作品列表</h2>
        <Link to="/publish">发布需求</Link>
      </div>
      <CardList items={works} />
    </div>
  );
};

export default WorksPage;