/**
 * ConnectionHandler is the thread that listens to the server and sends replies.
 */

package client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ConnectionHandler extends Thread {

    Socket socket;
    Client client;
    View view;
    BufferedReader din;
    PrintWriter dout;


    public ConnectionHandler(Socket socket, Client client) {
        super("ConnectionHandler");
        this.socket = socket;
        this.client = client;
        this.view = new View();
        try {
            din = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            dout = new PrintWriter(socket.getOutputStream(), false);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    // Listen for input
    public void run() {
        while (true){
            try{
                String input = din.readLine();
                if (input != null){
                    view.UpdateGameView(input);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void sendToServer(String text){
        dout.println(text);
        dout.flush();
    }

}
