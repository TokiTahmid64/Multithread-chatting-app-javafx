package sample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Scanner;

public class client_main extends Application {






    @FXML
    private TextField username;

    @FXML
    private TextField hostname;

    @FXML
    private TextField port;

    @FXML
    private Button send;

    public client_controller controller;

    public Button button = new Button("Send");




    public void start(Stage primaryStage) throws IOException {


        Parent root = FXMLLoader.load(getClass().getResource("/sample/sample.fxml"));
        Scene scene=new Scene(root,400,300);
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(scene);
        primaryStage.show();









    }

    public void press(ActionEvent e1) {

        String user=username.getText();
        String host=hostname.getText();
        String port_=(port.getText());

        int port_num=Integer.parseInt(port_);




        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/sample/client.fxml"));
        try {
            loader.load();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
        System.out.println("kire");
        controller = loader.getController();
        Parent p = loader.getRoot();
        Stage stage = new Stage();
        stage.setScene(new Scene(p));
        stage.show();

        client_main_thread client=new client_main_thread(host,port_num,user,controller);
        client.execute();
    }













    public static void main(String[] args)
    {

        launch(args);
    }
}
