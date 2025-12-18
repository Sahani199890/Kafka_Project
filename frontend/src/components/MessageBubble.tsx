import React from "react";
import "../App.css";

interface MessageBubbleProps {
  text: string;
  isSent: boolean;
  timestamp?: string;
}

const MessageBubble: React.FC<MessageBubbleProps> = ({ text, isSent, timestamp }) => {
  return (
    <div className={`message-row ${isSent ? "sent" : "received"}`}>
      <div className="message-bubble">
        <div className="message-text">{text}</div>
        <div className="message-time">{timestamp || "12:00"}</div>
      </div>
    </div>
  );
};

export default MessageBubble;
