package sample;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.awt.*;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class client_main_thread  {
    private String hostname;
    private int port;
    private String username;



    public client_controller controller;



    public client_main_thread(String hostname, int port, String username,client_controller controller)
    {
        this.hostname=hostname;
        this.port=port;
        this.username=username;
        this.controller=controller;

    }

    public void execute()
    {
        try
        {
            Socket soc=new Socket(hostname,port);
            System.out.println("connected to the server");
            controller.setname("UserName: "+ username);
            new client_reader_thread(soc,this).start();
            new client_writter_thread(soc,this,username).start();




        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public String getusername()
    {
        return this.username;
    }


}
