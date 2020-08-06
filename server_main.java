package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.Scanner;

public class server_main{



    public static void main(String[] args) {

        Scanner scan=new Scanner(System.in);
        int port;
        port=scan.nextInt();
        //int port = Integer.parseInt(args[0]);
        new_server_main server=new new_server_main(port);
        server.execute();

    }
}
