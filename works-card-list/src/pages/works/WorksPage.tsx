import React, { useState } from "react";
import CardList from "../../components/CardList/CardList";
import SearchBar from "../../components/SearchBar/SearchBar";
import TopNav from "../../components/TopNav/TopNav";
import LocationBar from "../../components/LocationBar/LocationBar";
import styles from "./WorksPage.module.scss";

const WorksPage: React.FC = () => {
  const [search, setSearch] = useState("");
  const [activeTab, setActiveTab] = useState("recommend");

  return (
    <div className={styles.container}>
      <div className={styles.headerRow}>
        <div className={styles.leftHeader}><LocationBar /></div>
        <div className={styles.rightHeader}><i className="fa-regular fa-bell"></i></div>
      </div>
      <SearchBar value={search} onChange={setSearch} />
      <TopNav active={activeTab} onChange={setActiveTab} />
      <CardList />
    </div>
  );
};

export default WorksPage;