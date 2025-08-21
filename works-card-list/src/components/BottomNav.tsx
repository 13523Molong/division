import React from "react";
import { Link, useLocation } from "react-router-dom";
import styles from "./BottomNav.module.scss";

const BottomNav: React.FC = () => {
  const location = useLocation();

  const navItems = [
    { name: "首页", path: "/" },
    { name: "创作者", path: "/creator" },
    { name: "社区", path: "/community" },
    { name: "消息", path: "/messages" },
    { name: "我的", path: "/profile" },
  ];

  return (
    <nav className={styles.bottomNav}>
      {navItems.map((item) => (
        <Link
          key={item.path}
          to={item.path}
          className={location.pathname === item.path ? styles.active : ""}
        >
          {item.name}
        </Link>
      ))}
    </nav>
  );
};

export default BottomNav;