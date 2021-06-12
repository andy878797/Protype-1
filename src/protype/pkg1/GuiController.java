/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package protype.pkg1;

import protype.pkg1.Account;
import com.sun.scenario.effect.Flood;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.beans.binding.Bindings;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.PieChart.Data;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javax.script.ScriptEngine;





/**
 *
 * @author s1083729
 */
public class GuiController implements Initializable {
    
    @FXML
    private AnchorPane scene_01;
    
    @FXML
    private Button addEvent;
    
    @FXML
    private DatePicker datePicker;
    
    @FXML
    private PieChart piechart_test;
    
    @FXML
    private Button showPieChart;

    @FXML
    private TextField descriptionTextField;
    
    @FXML
    private TextField descriptionAddChoice;
    
    @FXML
    private Button addChoice;
    
    @FXML
    private ChoiceBox<String> series;
    
    @FXML
    private Button Trans;
    
    @FXML
    private ListView<LocalEvent> ListView;
    
    @FXML
    private Button show;
    
    Account food = new Account("food", 0);
    Account cloth = new Account("cloth", 0);
    Account living = new Account("living", 0);
    Account traffic = new Account("traffic", 0);
    Account[] tempAccounts = new Account[100];

    int k = 0;
    int Number_choice = 0;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        int i = 0;
        datePicker.setValue(LocalDate.now());
        series.getItems().addAll("food","cloth","living","traffic");
    }
    
    ObservableList<LocalEvent> list = FXCollections.observableArrayList();
    
    @FXML
    private void addEvent(Event event) {
            int i = 0;
            list.add(new LocalEvent(datePicker.getValue(),descriptionTextField.getText() + "$ in " + series.getValue()));
            ListView.setItems(list);
            if(series.getValue().equals("food")){
                food.plusnumber((Double.parseDouble(descriptionTextField.getText())));
            }else if(series.getValue().equals("cloth")){
                cloth.plusnumber(Double.parseDouble(descriptionTextField.getText()));
            }else if(series.getValue().equals("living")){
                living.plusnumber(Double.parseDouble(descriptionTextField.getText()));
            }else if(series.getValue().equals("traffic")){
                traffic.plusnumber(Double.parseDouble(descriptionTextField.getText()));
            }else if (!series.getValue().equals("food") || !series.getValue().equals("cloth") || !series.getValue().equals("living") || !series.getValue().equals("traffic")){
                for(int j = 0;j <= 100; j++){
                    if(series.getValue().equals(tempAccounts[j].PrintName())){
                    tempAccounts[j].plusnumber(Double.parseDouble(descriptionTextField.getText()));
                    break;
                    }
                }
            }
        descriptionTextField.setText(null);
    }
        
    
    
    @FXML
    private void addChoice() throws IOException{
            
            if(!descriptionAddChoice.getText().equals("")){
                series.getItems().add(descriptionAddChoice.getText());
                tempAccounts[Number_choice] = new Account(descriptionAddChoice.getText(), 0);
                descriptionAddChoice.setText(null);
                Number_choice++;
            }
            else{
                System.out.println("empty");
            }     
    }
    
    @FXML
    void Trans(ActionEvent event) {
        final FileChooser fileChooser = new FileChooser();
        FileChooser.ExtensionFilter extFilter = 
                new FileChooser.ExtensionFilter("TXT files (*.txt)", "*.txt");
        fileChooser.getExtensionFilters().add(extFilter);
        File file = fileChooser.showSaveDialog(null);
        if(file != null)
            SaveFile(list.toString(), file);
        
    }
    
    private void SaveFile(String content,File file){
        try {
            FileWriter fileWriter;
            fileWriter = new FileWriter(file);
            fileWriter.write(content);
            fileWriter.close();
        } catch (Exception e) {
        }
    }
    
    
    @FXML
    void show(ActionEvent event) {
        
        System.out.println(ListView.getItems().size());
        System.out.println(list);
        System.out.println(Number_choice);
        //System.out.println(tempAccounts[1].Printnumber());
        
    }
    
    @FXML
    void showPieChart(ActionEvent event) {
        ObservableList<PieChart.Data> pcData = FXCollections.observableArrayList();
        pcData = FXCollections.observableArrayList();
        pcData.add(new PieChart.Data("food", food.Printnumber()));
        pcData.add(new PieChart.Data("cloth", cloth.Printnumber()));
        pcData.add(new PieChart.Data("living", living.Printnumber()));
        pcData.add(new PieChart.Data("traffic", traffic.Printnumber()));
        for(int g =0; g < Number_choice ;g++)
            pcData.add(new PieChart.Data(tempAccounts[g].PrintName(), tempAccounts[g].Printnumber()));
        piechart_test.setData(pcData);
        PieChart piechart = new PieChart();
        
    }
    
    /*private ObservableList<Data> getChartData(){
        ObservableList<Data> list = FXCollections.observableArrayList();
        list.addAll(
                new PieChart.Data("food",food.Printnumber()),
                new PieChart.Data("cloth",cloth.Printnumber()),
                new PieChart.Data("living",living.Printnumber()),
                new PieChart.Data("traffic",traffic.Printnumber())
        );
        /*while(Number_choice>0)
            for(int g = 0; g < Number_choice ;++g){
                list.add(new PieChart.Data(tempAccounts[g].PrintName(), tempAccounts[g].Printnumber()));
            }
            */
        //return list;
    //} 
}
        

