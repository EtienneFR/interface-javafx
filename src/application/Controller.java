package application;

import java.io.File;
import java.time.format.DateTimeFormatter;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.Window;

public class Controller {

    @FXML
    private Button newTypologyBtn;

    @FXML
    private DatePicker date;
    
    @FXML
    private ChoiceBox<String> typology;

    @FXML
    private ChoiceBox<String> subType;

    @FXML
    private ChoiceBox<String> subSubType;

    @FXML
    private ComboBox<String> frequency;

    @FXML
    private ComboBox<String> severity;

    @FXML
    private ComboBox<String> nonDetectability;

    @FXML
    private TextArea comment;

    @FXML
    private ListView<String> documentsListView;

    @FXML
    private Button deleteFileBtn;

    @FXML
    private Button fileChooser;
    
    @FXML
    private Button btnViderListe;

    @FXML
    private TableView<ActionQR> actionTableQR;

    @FXML
    public TableColumn<ActionQR, String> colDate;

    @FXML
    public TableColumn<ActionQR, String> colWho;

    @FXML
    public TableColumn<ActionQR, String> colWhat;

    @FXML
    private TableView<ActionQC> actionTableQC;

    @FXML
    private TableColumn<ActionQC, String> colDate2;

    @FXML
    private TableColumn<ActionQC, String> colWho2;

    @FXML
    private TableColumn<ActionQC, String> colWhat2;

    @FXML
    private Button valActionBtn;

    @FXML
    private Button addActionBtn;

    @FXML
    private Button deleteIncidentBtn;

    @FXML
    private Button btnExit;
    
    private String[] typologyValues = { "Type 1", "Type 2", "Type 3" };
    private String[] subTypeValues = { "A1", "A2", "A3" }; 
    private String[] subSubTypeValues = { "Général", "Partiel" }; 
    
    private String[] frequencyValues = { "X1", "X2", "X3", "X10", "X20" }; 
    private String[] severityValues = { "Peu importante", "Moyenne", "Importante", "Très importante"};
    private String[] nonDetectabilityValues = { "Avant réception", "Après réception" };
    
    @FXML
    public void initialize() {
    	typology.setItems(FXCollections.observableArrayList(typologyValues));
    	subType.setItems(FXCollections.observableArrayList(subTypeValues));
    	subSubType.setItems(FXCollections.observableArrayList(subSubTypeValues));
    	
        frequency.setItems(FXCollections.observableArrayList(frequencyValues));
        severity.setItems(FXCollections.observableArrayList(severityValues));
        nonDetectability.setItems(FXCollections.observableArrayList(nonDetectabilityValues));
        
        colDate.setCellValueFactory(new PropertyValueFactory<>("colDate"));
    	colWho.setCellValueFactory(new PropertyValueFactory<>("colWho"));
    	colWhat.setCellValueFactory(new PropertyValueFactory<>("colWhat"));
    	
    	colDate2.setCellValueFactory(new PropertyValueFactory<>("colDate2"));
    	colWho2.setCellValueFactory(new PropertyValueFactory<>("colWho2"));
    	colWhat2.setCellValueFactory(new PropertyValueFactory<>("colWhat2"));

    }
    
    @FXML
    void deleteFile(ActionEvent event) {
    	ObservableList<String> selectedIndices = documentsListView.getSelectionModel().getSelectedItems();
    	if(!(selectedIndices.isEmpty())) {
    		for(Object o : selectedIndices){
                documentsListView.getItems().remove(o);
            }
    	} 
    }
    
    @FXML
    void emptyListFiles(ActionEvent event) {
    	documentsListView.getItems().clear();
    }

    @FXML
    void selectFile(ActionEvent event) {
    	FileChooser filePicker = new FileChooser();
    	filePicker.setTitle("Open Resource File");
    	File f = filePicker.showOpenDialog(Window.getWindows().get(0));
    	if (f != null) {
    		documentsListView.getItems().add(f.getName());
        }
    }

    @FXML
    void quit(ActionEvent event) {
    	Platform.exit();
    }
    
    @FXML
    void addAction(ActionEvent event) {
    	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd LLLL yyyy");
    	
    	if(date.getValue() != null && !comment.getText().isEmpty()) {
    		actionTableQR.getItems().add(
    				new ActionQR(date.getValue().format(formatter), "Moi", comment.getText())
    		);
    	} else {
    		final Stage dialog = new Stage();
            dialog.initModality(Modality.APPLICATION_MODAL);
            GridPane gp = new GridPane();
			gp.setAlignment(Pos.CENTER);
			gp.setVgap(5.0);
			gp.setHgap(5.0);
 			Text info = new Text("Les champs date et/ou description sont manquants");
 			info.setFill(Color.RED);
 			info.setFont(Font.font("Verdana", FontWeight.BOLD, 12));		
 			GridPane.setHalignment(info, HPos.CENTER);
 			gp.addRow(1, info);
            Scene dialogScene = new Scene(gp, 400, 40);
            dialog.setTitle("Informations Action Rapide");
            dialog.setScene(dialogScene);
            dialog.show();
        
    	}
    }
    
    @FXML
    void addActionQC(ActionEvent event) {
    	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd LLLL yyyy");
    	
    	if(date.getValue() != null && !comment.getText().isEmpty()) {
    		actionTableQC.getItems().add(
    				new ActionQC(date.getValue().format(formatter), "Moi", comment.getText())
    		);
    	} else {
    		final Stage dialog = new Stage();
            dialog.initModality(Modality.APPLICATION_MODAL);
            GridPane gp = new GridPane();
			gp.setAlignment(Pos.CENTER);
			gp.setVgap(5.0);
			gp.setHgap(5.0);
 			Text info = new Text("Les champs date et/ou description sont manquants");
 			info.setFill(Color.RED);
 			info.setFont(Font.font("Verdana", FontWeight.BOLD, 12));		
 			GridPane.setHalignment(info, HPos.CENTER);
 			gp.addRow(1, info);
            Scene dialogScene = new Scene(gp, 400, 40);
            dialog.setTitle("Informations Action Long Terme");
            dialog.setScene(dialogScene);
            dialog.show();
    	}
    }
    
}

