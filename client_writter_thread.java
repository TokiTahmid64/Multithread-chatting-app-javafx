package sample;

import java.io.Console;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class client_writter_thread extends Thread{

    Socket socket;
    client_main_thread client_;
    PrintWriter writer;
    String username;


    public client_writter_thread(Socket socket, client_main_thread client,String username) {
        this.socket=socket;
        this.client_=client;
        this.username=username;

        try
        {
            writer=new PrintWriter(socket.getOutputStream(),true);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void run()
    {
        Scanner scan=new Scanner(System.in);
        writer.println(this.username);
        //String text_;

        //Console console = System.console();
        while (true){



            client_.controller.send.setOnAction(e->
            {
               String text=client_.controller.textfield.getText();
               client_.controller.settext("\n"+"["+username+"]" + text);
               writer.println(text);


            });



        }

        /*try{
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }*/
    }
}
