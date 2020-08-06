package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.*;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class client_controller {


    @FXML
    public TextField textfield;

    @FXML
    public Button send;

    @FXML
    public Label name;

    @FXML
    private Label nameee;
    @FXML
    private AnchorPane pane;
    @FXML
    private ListView list;


   @FXML
   private TextArea area;






    String got;
    public void settext(String s)

    {
        list.getItems().add("ajib");

        area.appendText("\n" + s);








    }
    public void press(Actioe)
    {
        
    }
    public String gettext()
    {
        return textfield.getText();
    }
    public void setname(String s2)
    {
        nameee.setText(s2);
    }




}
