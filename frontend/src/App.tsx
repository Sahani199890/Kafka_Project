import { useEffect, useState } from "react";
import { BrowserRouter as Router, Routes, Route, Navigate } from "react-router-dom";
import { connectWebSocket, disconnectWebSocket } from "./socket";
import Sidebar from "./components/Sidebar";
import ChatWindow from "./components/ChatWindow";
import Login from "./pages/Login";
import Signup from "./pages/Signup";
import "./App.css";

interface Message {
  text: string;
  isSent: boolean;
  timestamp?: string;
}

const ChatApp: React.FC = () => {
  const [messages, setMessages] = useState<Message[]>([]);

  useEffect(() => {
    connectWebSocket((messageText: string) => {
      const newMessage: Message = {
        text: messageText,
        isSent: false,
        timestamp: new Date().toLocaleTimeString([], { hour: '2-digit', minute: '2-digit' })
      };
      setMessages((prev) => [...prev, newMessage]);
    });

    return () => {
      disconnectWebSocket();
    };
  }, []);

  const handleSendMessage = (text: string) => {
    const newMessage: Message = {
      text,
      isSent: true,
      timestamp: new Date().toLocaleTimeString([], { hour: '2-digit', minute: '2-digit' })
    };
    setMessages((prev) => [...prev, newMessage]);
  };

  return (
    <div className="app-container">
      <Sidebar />
      <ChatWindow messages={messages} onSendMessage={handleSendMessage} />
    </div>
  );
};

const ProtectedRoute = ({ children }: { children:any }) => {
  const user = localStorage.getItem("user");
  if (!user) {
    return <Navigate to="/login" replace />;
  }
  return children;
};

const App: React.FC = () => {
  return (
    <Router>
      <Routes>
        <Route path="/login" element={<Login />} />
        <Route path="/signup" element={<Signup />} />
        <Route
          path="/"
          element={
            <ProtectedRoute>
              <ChatApp />
            </ProtectedRoute>
          }
        />
      </Routes>
    </Router>
  );
};

export default App;
