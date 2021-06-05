/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package protype.pkg1;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
 
/**
 * FXML Controller class
 *
 * @author s1083729
 */
public class AddChoiceController implements Initializable {
    static boolean answer;
    /**
     * Initializes the controller class.
     */
    @FXML
    private AnchorPane scene_02;
    
    @FXML
    private Button Summit;

    @FXML
    private TextArea descriptionAddChoice;

    @FXML
    private Button goback;

    @FXML
    private void goback(ActionEvent event) throws IOException {
        AnchorPane scene_01 = FXMLLoader.load(getClass().getResource("Gui.fxml"));
        scene_02.getChildren().removeAll(goback.getParent());
        scene_02.getChildren().setAll(scene_01);
        //Data.text.equals(null);
    }

    @FXML
    void summit(ActionEvent event) {
        //series.getItems().add(descriptionAddChoice.getText());
        Data.text = (String)descriptionAddChoice.getText();
        descriptionAddChoice.setText(null);
        //System.out.println(Data.text);
    } 

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
