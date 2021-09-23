/*
Writing a simple protocol and a matching TCP Server and Client
 simulate a large football stadium with many turnstiles that each updates a central counter,
 for each spectator that passes a turnstile.

 The turnstiles should use a Network Connection (wired or wireless) and
 TCP to update the shared counter.
 each Turnstile is equipped with a small micro computer (Arduino, Raspberry-pi or similar) that can detect and send information each time the turnstile rolls.

 Implement a Java Based server that can handle n-turnstile clients without any lost updates.
 Design a TCP server and a simple protocol where each turnstile initially reports its id (turnstile1 - turnstile-n),
 then sends an "increment" for each spectator that passes the turnstile

 Design a protocol where a Monitor-Client can request the current amount of spectators
 Identify potential Race Condition Problems and handle the problem(s).
 For this exercise you don’t have to implement the turnstile-clients. Use Telnet to simulate the turnstiles.
 Implement a simple Java Monitor-Client which constantly must print the current total updated by your telnet clients in the previous step
*/
public class Main {

    public static void main(String[] args) {
	// write your code here
    }
}
