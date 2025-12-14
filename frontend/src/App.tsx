import { useEffect, useState } from "react";
import { connectWebSocket, disconnectWebSocket } from "./socket";

const App: React.FC = () => {
  const [messages, setMessages] = useState<string[]>([]);

  useEffect(() => {
    connectWebSocket((message: string) => {
      setMessages((prev) => [...prev, message]);
    });

    return () => {
      disconnectWebSocket();
    };
  }, []);

  return (
    <div style={{ padding: 20 }}>
      <h2>Kafka Live Messages</h2>
      <ul>
        {messages.map((msg, index) => (
          <li key={index}>{msg}</li>
        ))}
      </ul>
    </div>
  );
};

export default App;
