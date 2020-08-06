package sample;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.function.DoubleToIntFunction;

public class user_thread extends Thread{


    Socket soc;
    new_server_main server;
    PrintWriter output;

    public user_thread(Socket socket, new_server_main Server) {

        soc=socket;
        server=Server;
    }

    public void run(){

        try
        {
            BufferedReader input=new BufferedReader(new InputStreamReader(soc.getInputStream()));
            output=new PrintWriter(soc.getOutputStream(),true);

            printusers();
            String username=input.readLine();
            server.adduser(username);
            String servermessege="New user connected: "+username;
            System.out.println(servermessege);
            server.broadcast(servermessege,this);
            String client_messege;
            do {
                client_messege=input.readLine();
                servermessege="["+username+"] "+client_messege;
                server.broadcast(servermessege,this);
            }while(!client_messege.equals("exit"));

            server.removeuser(username,this);
            soc.close();
            servermessege="Client "+username+" has gone :) ";
            server.broadcast(servermessege,this);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    void printusers() {
        if(server.has_user())
        {
            output.println("Connected users: "+"[ "+server.getusernames() + " ]");
        }
        else
            output.println("No other user connected");
    }

    public void sendmessege(String msg) {
        output.println(msg);
    }
}
