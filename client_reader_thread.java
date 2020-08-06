package sample;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class client_reader_thread extends Thread{
    Socket socket;
    client_main_thread client;
    BufferedReader input;
    public client_reader_thread(Socket soc, client_main_thread client) {
        this.socket=soc;
        this.client=client;

        try
        {
            input=new BufferedReader(new InputStreamReader(socket.getInputStream()));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public void run()
    {
        while(true)
        {
            try {
                String response=input.readLine();
                client.controller.settext(response);


                System.out.println("\n"+ response);
            } catch (IOException e) {
                e.getMessage();
            }

        }

    }
}
