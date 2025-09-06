import React from "react";
import styles from "./SearchBar.module.scss";

interface SearchBarProps {
  value: string;
  onChange: (value: string) => void;
}

const SearchBar: React.FC<SearchBarProps> = ({ value, onChange }) => {
  return (
    <div className={styles.topBar}>
      <div className={styles.iconLeft}>
        <i className="fa-solid fa-bars fa-sm"></i>
      </div>
      <div className={styles.searchBox}>
        <div className={styles.inputWrapper}>
          <i className="fa-solid fa-magnifying-glass"></i>
          <input
            type="text"
            placeholder="搜索作品"
            value={value}
            onChange={e => onChange(e.target.value)}
            className={styles.searchInput}
          />
        </div>
      </div>
    </div>
  );
};

export default SearchBar;