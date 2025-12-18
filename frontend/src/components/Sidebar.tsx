import React from "react";
import "../App.css";

const Sidebar: React.FC = () => {
  return (
    <div className="sidebar">
      <div className="sidebar-header">
        <div className="avatar-icon"></div>
        <div className="header-icons">
          <span>〇</span>
          <span>💬</span>
          <span>⋮</span>
        </div>
      </div>
      <div className="search-bar">
        <div className="search-input-container">
          <span>🔍</span>
          <input type="text" placeholder="Search or start new chat" />
        </div>
      </div>
      <div className="chat-list">
        {/* Dummy Contacts */}
        {[...Array(10)].map((_, i) => (
          <div key={i} className="chat-list-item">
            <div className="avatar-icon-small"></div>
            <div className="chat-info">
              <div className="chat-name">Contact {i + 1}</div>
              <div className="chat-preview">Hey there! I am using Dev Chat.</div>
            </div>
            <div className="chat-time">12:00</div>
          </div>
        ))}
      </div>
    </div>
  );
};

export default Sidebar;
