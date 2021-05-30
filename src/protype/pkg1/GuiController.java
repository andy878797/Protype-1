/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package protype.pkg1;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

/**
 *
 * @author s1083729
 */
public class GuiController implements Initializable {
  
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        datePicker.setValue(LocalDate.now());
    }    
    @FXML
    private Button addButton;

    @FXML
    private DatePicker datePicker;

    @FXML
    private TextField descriptionTextField;

    @FXML
    private ListView<LocalEvent> eventList;
    
    ObservableList<LocalEvent> list = FXCollections.observableArrayList();
    
    @FXML
    private void addEvent(Event event) {
        list.add(new LocalEvent(datePicker.getValue(),descriptionTextField.getText()));
        eventList.setItems(list);
        refresh();
    }
    
    private void refresh(){
        datePicker.setValue(LocalDate.now());
        descriptionTextField.setText(null);
    }
}
