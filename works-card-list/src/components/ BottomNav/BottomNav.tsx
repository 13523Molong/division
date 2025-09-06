import React from "react";
import { Link, useLocation } from "react-router-dom";
import styles from "./BottomNav.module.scss";

const BottomNav: React.FC = () => {
  const location = useLocation();

  const navItems = [
    {
      name: "首页",
      path: "/",
      icon: "fas fa-home",
    },
    {
      name: "创作者",
      path: "/creator",
      icon: "fas fa-pencil-alt",
    },
    {
      name: "发布",
      path: "/publish",
      icon: "fa-solid fa-circle-plus",
      isPublish: true,
    },
    {
      name: "消息",
      path: "/messages",
      icon: "fas fa-comment",
    },
    {
      name: "我的",
      path: "/profile",
      icon: "fas fa-user",
    },
  ];

  return (
    <nav className={styles.bottomNav}>
      <div className={styles.navRow}>
        {navItems.map((item) => (
          <Link
            key={item.path}
            to={item.path}
            className={`${styles.navItem} ${item.isPublish ? styles.publish : ""} ${location.pathname === item.path ? styles.active : ""}`}
          >
            <i className={item.icon}></i>
            <span className={styles.navText}>{item.name}</span>
          </Link>
        ))}
      </div>
    </nav>
  );
};

export default BottomNav;