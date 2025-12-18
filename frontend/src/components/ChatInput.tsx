import React, { useState } from "react";
import "../App.css";

interface ChatInputProps {
  onSendMessage: (message: string) => void;
}

const ChatInput: React.FC<ChatInputProps> = ({ onSendMessage }) => {
  const [input, setInput] = useState("");

  const handleSend = () => {
    if (input.trim()) {
      onSendMessage(input);
      setInput("");
    }
  };

  const handleKeyDown = (e: React.KeyboardEvent) => {
    if (e.key === "Enter") {
      handleSend();
    }
  };

  return (
    <div className="chat-footer">
      <div className="icon-btn">😊</div>
      <div className="icon-btn">➕</div>
      <div className="input-container">
        <input
          type="text"
          placeholder="Type a message"
          value={input}
          onChange={(e) => setInput(e.target.value)}
          onKeyDown={handleKeyDown}
        />
      </div>
      {input.trim() ? (
        <div className="icon-btn send-btn" onClick={handleSend}>
          ➤
        </div>
      ) : (
        <div className="icon-btn">🎤</div>
      )}
    </div>
  );
};

export default ChatInput;
