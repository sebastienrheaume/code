package application;

import java.sql.SQLException;

import application.classes.Student;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class EditStudentController {	
	    //Fields
	    @FXML 
	    private TextField firstNameField, lastNameField, studentIdField, parent1NameField, parent1EmailField, parent2NameField, parent2EmailField;
	    @FXML
	    private ComboBox<String> grades;
	    private Main main;
	    private Stage thisStage;
	    private Student s;
	    private ObservableList<String> gradeData = FXCollections.observableArrayList("PK","JK","SK","1","2","3","4","5","6","7","LI","LII","LIII","LIV","LV");
	    private boolean newStudent;
	    
	    @FXML
	    private void initialize() {
	    	grades.setItems(gradeData);
	    	
	    }
	    
	    public void setMain (Main main) {
	    	this.main=main;	
	    }  
	    
	    public void setStudent (Student s) {
	    	this.s=s;
	    	firstNameField.setText(s.getFirstName());
	    	lastNameField.setText(s.getLastName());
	    	studentIdField.setText(Integer.toString(s.getStudentId()));
	    	parent1NameField.setText(s.getParent1Name());
	    	parent1EmailField.setText(s.getParent1Email());
	    	parent2NameField.setText(s.getParent2Name());
	    	parent2EmailField.setText(s.getParent2Email());
	    	grades.setValue(s.getLevelGrade());
	    }
	    
	    @FXML
	    private void saveChanges() {
	    	if(inputValidityCheck()) {
	    		//Find grade	
	    		int g = gradeData.indexOf(grades.getValue())-2;

	    		try {
	    			if(newStudent)
	    				DBActions.addStudent(Integer.valueOf(studentIdField.getText()), firstNameField.getText(), lastNameField.getText(), g, parent1NameField.getText(), parent1EmailField.getText(), parent2NameField.getText(), parent2EmailField.getText());
	    			else	
	    				DBActions.updateStudent(this.s.getId(), Integer.valueOf(studentIdField.getText()), firstNameField.getText(), lastNameField.getText(), g, parent1NameField.getText(), parent1EmailField.getText(), parent2NameField.getText(), parent2EmailField.getText());
				} catch (NumberFormatException | ClassNotFoundException | SQLException e) {
					Alert alert=new Alert(AlertType.ERROR);
					alert.setHeaderText("An error has occured");
					alert.setTitle("Error");
					alert.setContentText("An error occured while attempting to update the student in the database.");
					alert.show();
				}
	    	}
	    }
	    
	    private boolean inputValidityCheck() {
	    	boolean valid = true;
	    	String errorMessage = "";
	    	//If nothing has been put in for studentId, it will be marked as 0
	    	if(studentIdField.getText().equals("")||studentIdField.getText().equals(null))
	    		studentIdField.setText("0");
	    	try {
	    		if(Integer.valueOf(studentIdField.getText())<0) {
	    			valid = false;
	    			errorMessage += "The Student ID must be an integer greater than or equal to zero";
	    		}
	    			
	    	} catch (NumberFormatException e) {
	    		valid = false;
	    		errorMessage += "The Student ID must be an integer greater than or equal to zero";
	    	}
	    	if(!errorMessage.equals("")) {
	    	Alert alert=new Alert(AlertType.ERROR);
			alert.setHeaderText("An error has occured");
			alert.setTitle("Error");
			alert.setContentText(errorMessage);
			alert.show();
	    	}
	    	return valid;
	    }
	    @FXML
	    private void close() {
	    	thisStage.close();
	    }
	    
	    
	    
}
