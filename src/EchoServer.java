import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class EchoServer {
    private int port;
    private ServerSocket ss;
    private Counter c;

    public EchoServer(int port, Counter c) {
        this.port = port;
        this.c = c;
    }

    public void startServer() throws IOException {
        ss = new ServerSocket(port);
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        while(true){
            System.out.println("Waiting for client");
            Socket s = ss.accept();
            System.out.println("Welcome client");
            ClientHandler ch = new ClientHandler(s);
            executorService.execute(ch);
        }
    }

    public Counter getC() {
        return c;
    }
}
