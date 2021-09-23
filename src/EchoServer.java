import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class EchoServer {
    private int port;
    private ServerSocket ss;

    public EchoServer(int port) {
        this.port = port;
    }

    public void startServer() throws IOException {
        ss = new ServerSocket(port);
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        while(true){
            System.out.println("Waiting for client");
            Socket s = ss.accept();
            ClientHandler ch = new ClientHandler(s);
            executorService.execute(ch);
        }
    }
}
