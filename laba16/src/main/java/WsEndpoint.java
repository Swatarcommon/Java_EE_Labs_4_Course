import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.Date;

@ServerEndpoint("/ws")
public class WsEndpoint {
    @OnOpen
    public void onOpen(Session session) throws IOException, InterruptedException {
        while (session.isOpen() == true) {
            session.getBasicRemote().sendText(new Date().toString());
            Thread.currentThread().sleep(2000);
        }
    }

    @OnClose
    public void onClose(Session session) throws IOException {
        session.close();
    }

    @OnError
    public void onError(Session session, Throwable throwable) {
        System.out.println("Error on websocket");
    }
}
