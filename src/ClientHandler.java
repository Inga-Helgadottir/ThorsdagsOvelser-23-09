import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class ClientHandler implements Runnable{
    Socket client;
    PrintWriter pw;
    Scanner sc;

    public ClientHandler(Socket client) throws IOException, NullPointerException {
        this.client = client;
        this.pw = new PrintWriter(client.getOutputStream(),true);
        this.sc = new Scanner(client.getInputStream());
    }

    public void protocol() throws IOException{
        Counter c = new Counter();
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
                    pw.println("Someone has entered the stadium");
                    System.out.println(Thread.currentThread().getName() + "- someone has entered the stadium, current count -" + c.getCount());
                    break;
                case "SEE":
                    c.getCount();
                    pw.println("Current count - " + c.getCount());
                    System.out.println(Thread.currentThread().getName() + " is checking out the current count" + c.getCount());
                    break;
                case "REMOVE":
                    c.removeFromCount();
                    pw.println("Someone has left the stadium");
                    System.out.println(Thread.currentThread().getName() + "- someone has left the stadium, current count -" + c.getCount());
                    break;
                case "CLOSE":
                    break;
                default:
                    pw.println("Your input does not match any of our options, try again");
                    userInfo = "";
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
