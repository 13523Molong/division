import React from "react";
import { BrowserRouter as Router, Routes, Route } from "react-router-dom";
import WorksPage from "./pages/works/WorksPage";
import PublishPage from "./pages/publish/PublishPage";
import CreatorPage from "./pages/creator/CreatorPage";
import CommunityPage from "./pages/community/CommunityPage";
import MessagesPage from "./pages/messages/MessagesPage";
import ProfilePage from "./pages/profile/ProfilePage";
import BottomNav from "./components/BottomNav";

const App: React.FC = () => {
  return (
    <Router>
      <div style={{ paddingBottom: "60px" }}> {
        }
        <Routes>
          <Route path="/" element={<WorksPage />} />
          <Route path="/publish" element={<PublishPage />} />
          <Route path="/creator" element={<CreatorPage />} />
          <Route path="/community" element={<CommunityPage />} />
          <Route path="/messages" element={<MessagesPage />} />
          <Route path="/profile" element={<ProfilePage />} />
        </Routes>
      </div>
      <BottomNav />
    </Router>
  );
};

export default App;