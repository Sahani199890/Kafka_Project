import React, { useRef, useEffect } from "react";
import MessageBubble from "./MessageBubble";
import ChatInput from "./ChatInput";
import "../App.css";

interface Message {
  text: string;
  isSent: boolean;
  timestamp?: string;
}

interface ChatWindowProps {
  messages: Message[];
  onSendMessage: (message: string) => void;
}

const ChatWindow: React.FC<ChatWindowProps> = ({ messages, onSendMessage }) => {
  const messagesEndRef = useRef<HTMLDivElement>(null);

  const scrollToBottom = () => {
    messagesEndRef.current?.scrollIntoView({ behavior: "smooth" });
  };

  useEffect(() => {
    scrollToBottom();
  }, [messages]);

  return (
    <div className="chat-window">
      <div className="chat-header">
        <div className="avatar-icon"></div>
        <div className="header-info">
          <div className="header-name">Broadcast Channel</div>
          <div className="header-status">online</div>
        </div>
        <div className="header-icons">
          <span>🔍</span>
          <span>⋮</span>
        </div>
      </div>

      <div className="chat-body">
        {messages.map((msg, index) => (
          <MessageBubble key={index} text={msg.text} isSent={msg.isSent} timestamp={msg.timestamp} />
        ))}
        <div ref={messagesEndRef} />
      </div>

      <ChatInput onSendMessage={onSendMessage} />
    </div>
  );
};

export default ChatWindow;
