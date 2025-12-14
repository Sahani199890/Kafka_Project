import { Client, type IMessage } from "@stomp/stompjs";

let client: Client | null = null;

export const connectWebSocket = (onMessage: (message: string) => void) => {
  client = new Client({
    brokerURL: "ws://localhost:8080/ws",
    reconnectDelay: 5000,
    onConnect: () => {
      client?.subscribe("/topic/kafka-messages", (msg: IMessage) => {
        onMessage(msg.body);
      });
    },
    debug: (str) => console.log(str),
  });

  client.activate();
};

export const disconnectWebSocket = () => {
  client?.deactivate();
};
