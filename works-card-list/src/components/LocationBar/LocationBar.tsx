import React from "react";
import styles from "./LocationBar.module.scss";

const LocationBar: React.FC = () => (
    <div className={styles.locationBar}>
        <i className="fa-solid fa-map-location-dot"></i>
        <span className={styles.locationText}>New York, USA</span>
        <i className="fa-solid fa-chevron-down"></i>
    </div>
);

export default LocationBar;
