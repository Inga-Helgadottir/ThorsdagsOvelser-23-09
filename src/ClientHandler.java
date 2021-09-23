import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class ClientHandler implements Runnable{
    Socket client;
    PrintWriter pw;
    Scanner sc;
    Counter c = new Counter();

    public ClientHandler(Socket client) throws IOException {
        this.client = client;
        this.pw = new PrintWriter(client.getOutputStream(),true);
        this.sc = new Scanner(client.getInputStream());
    }

    public void protocol() throws IOException{
        String userInfo = "";
        pw.println("You are connected, here are your options:");
        pw.println("-To see the current count write SEE");
        pw.println("-To add to the count write ADD");
        pw.println("-To remove from the count write REMOVE");
        pw.println("-To close program write CLOSE");
        while (!userInfo.equals("CLOSE")){
            userInfo = sc.nextLine().toUpperCase();
            switch (userInfo){
                case "ADD":
                    c.addToCount();
                    break;
                case "SEE":
                    c.getCount();
                    break;
                case "REMOVE":
                    c.removeFromCount();
                    break;
                default:
                    userInfo = "CLOSE";
            }
        }
        client.close();
        pw.println(userInfo + " - fra serveren");
    }

    @Override
    public void run() {
        while (true) {
            try {
                this.protocol();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
