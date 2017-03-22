package it.polito.tdp.spellchecker.controller;

import java.net.URL;
import java.util.ResourceBundle;

import it.polito.tdp.spellchecker.model.Dictionary;
import it.polito.tdp.spellchecker.model.RichWord;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;
import java.util.*;

public class SpellCheckerController {
	
	Dictionary d;
	
	public void setModel(Dictionary d){
		this.d=d;
	}

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ComboBox<String> cmbLanguage;

    @FXML
    private TextArea txtText;

    @FXML
    private Button btnSpellCheck;

    @FXML
    private TextArea txtResult;

    @FXML
    private Label lblResult;

    @FXML
    private Button btnClearText;

    @FXML
    private Label lblTempo;

    @FXML
    void doClearText(ActionEvent event) {

    	txtText.setText("");
    	txtResult.setText("");
    	lblTempo.setText("");
    	lblResult.setText("");
    }

    @FXML
    void doLanguage(ActionEvent event) {

    }

    @FXML
    void doResult(MouseEvent event) {

    }

    @FXML
    void doSpellCheck(ActionEvent event) {
    	if (cmbLanguage.getValue()==null)
    		cmbLanguage.setValue("English");
    	d.loadDictionary(cmbLanguage.getValue());
    	List<String>input=new ArrayList<String>();
    	List<RichWord>result=new ArrayList<RichWord>();
         String str=txtText.getText();
    	 //str.replaceAll("[ \\p{Punct}]", "");
    	 if(str!=null){
    		 String[] testo=str.split(" ");
    		 for(int i=0;i<testo.length;i++){
    			 input.add(testo[i].replaceAll("[ \\p{Punct}]", ""));
    		 }
    		 result=d.spellCheckText(input);
    		 for(RichWord r:result){
    			 txtResult.appendText(r.getParola()+" ");
    		 }
    	 }
    }

    @FXML
    void initialize() {
        assert cmbLanguage != null : "fx:id=\"cmbLanguage\" was not injected: check your FXML file 'SpellChecker.fxml'.";
        assert txtText != null : "fx:id=\"txtText\" was not injected: check your FXML file 'SpellChecker.fxml'.";
        assert btnSpellCheck != null : "fx:id=\"btnSpellCheck\" was not injected: check your FXML file 'SpellChecker.fxml'.";
        assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'SpellChecker.fxml'.";
        assert lblResult != null : "fx:id=\"lblResult\" was not injected: check your FXML file 'SpellChecker.fxml'.";
        assert btnClearText != null : "fx:id=\"btnClearText\" was not injected: check your FXML file 'SpellChecker.fxml'.";
        assert lblTempo != null : "fx:id=\"lblTempo\" was not injected: check your FXML file 'SpellChecker.fxml'.";

        cmbLanguage.getItems().addAll("Italian", "English");
    }
}