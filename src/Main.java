import java.io.IOException;

/*
Writing a simple protocol and a matching TCP Server and Client
 simulate a large football stadium with many turnstiles that each updates a central counter,
 for each spectator that passes a turnstile.

 The turnstiles should use a Network Connection (wired or wireless) and
 TCP to update the shared counter.
 each Turnstile is equipped with a small micro computer (Arduino, Raspberry-pi or similar)
 that can detect and send information each time the turnstile rolls.

 Implement a Java Based server that can handle n-turnstile clients without any lost updates.
 Design a TCP server and a simple protocol where each turnstile initially reports its id (turnstile1 - turnstile-n) and
 then sends an "increment" for each spectator that passes the turnstile.
 The server-method is slightly different from the Echoserver where any client that connects will get a clienthandler
 (hence while(true)).
 Here you must count the number of clients - putting each of them in a list -
 and once the requested number of turnstiles has been reached, loop through the list and start the turnstiles.
 So no while(true)

 Design a protocol where a Monitor-Client can request the current amount of spectators
 Identify potential Race Condition Problems and handle the problem(s) -  avoid results like this:
 pool-1-thread-3 is counting 35852
 pool-1-thread-4 is counting 35852
 pool-1-thread-3 is counting 35854
 pool-1-thread-4 is counting 35854
 pool-1-thread-3 is counting 35856

 For this exercise you should implement turnstile-clients.
 Create a writer-thread (and preferably also a reader)
 and let the run-method simulate spectators entering through the turnstile
 (sleep for random seconds and then create a random name that you send to the turnstile via the client printwriter.
 On the receiving end trigger the counter when the name is read from the inputstream.
 The clients are best handled via the terminal. Compile with “javac Main.java” and then run clients in separate terminals
 - start the client with command “java Main”
 Implement a simple Java Monitor-Client
 which constantly must print the current total updated by your telnet clients in the previous step

telnet localhost 8080
*/
public class Main {
    public static int port = 8080;
    public static void main(String[] args) throws IOException {
        EchoServer es = new EchoServer(port);
        System.out.println("starting server on port : " + port);
        es.startServer();
    }
}
