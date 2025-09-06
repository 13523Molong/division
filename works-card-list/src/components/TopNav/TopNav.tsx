import React from "react";
import "./TopNav.scss";

type TabItem = {
    label: string;
    value: string;
};

interface TopNavProps {
    active: string;
    onChange: (value: string) => void;
    tabs?: TabItem[];
}

const DEFAULT_TABS: TabItem[] = [
    { label: "推荐", value: "recommend" },
    { label: "榜单", value: "ranking" },
    { label: "关注", value: "follow" },
];

const TopNav: React.FC<TopNavProps> = ({ active, onChange, tabs = DEFAULT_TABS }) => {
    return (
        <nav className="topNav">
            <div className="navList">
                {tabs.map(tab => (
                    <button
                        key={tab.value}
                        className={`navItem${active === tab.value ? " active" : ""}`}
                        onClick={() => onChange(tab.value)}
                    >
                        {tab.label}
                    </button>
                ))}
            </div>
        </nav>
    );
};

export default TopNav;
