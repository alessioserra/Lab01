package it.polito.tdp.parole;

/**
 * Sample Skeleton for 'Parole.fxml' Controller Class
 */


import it.polito.tdp.parole.model.Parole;

import java.net.URL;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class ParoleController {
	
	Parole elenco ;

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="txtParola"
    private TextField txtParola; // Value injected by FXMLLoader

    @FXML // fx:id="txtResult"
    private TextArea txtResult; // Value injected by FXMLLoader
    
    @FXML // fx:id="txtAreaTime"
    private TextArea txtAreaTime; // Value injected by FXMLLoader
    
    @FXML
    private Button btnReset;

    @FXML // fx:id="btnInserisci"
    private Button btnInserisci; // Value injected by FXMLLoader
    
    @FXML
    private Button cancella;
    
    Parole p = new Parole();

    @FXML
    void doInsert(ActionEvent event) {
    	
    	double inizio = System.nanoTime();
    	
    	//AddParola
    	p.addParola(txtParola.getText());
    	//Ordino
    	
    	//Ottengo la lista
    	List<String> lista = p.getElenco();
    	
    	//Prima di mostrare cancello i precedenti
    	txtParola.clear();
    	txtResult.clear();
    	
    	//Stampo risultati nella TextArea
    	for (String ss : lista) {
    	txtResult.appendText(ss+"\n");
    	}
    	
    	double fine = System.nanoTime();
    			
    	//Tempo di esecuzione
    	txtAreaTime.setText("Tempo d'esecuzione:\n"+String.valueOf(fine-inizio) +" nanosecondi");
    }
    
    @FXML
    void doReset(ActionEvent event) {
    	
    	double inizio = System.nanoTime();
    	
    	//Svuoto Lista e cancello TextArea
    	p.reset();
    	txtResult.clear();
    	
    	double fine = System.nanoTime();
    	
    	//Tempo di esecuzione
    	txtAreaTime.setText("Tempo d'esecuzione:\n"+String.valueOf(fine-inizio) +" nanosecondi");
    }
    

    @FXML
    void doCanc(ActionEvent event) {
    	
    	double inizio = System.nanoTime();
    	
    	String r = txtResult.getSelectedText();    //Scelgo parola dall'aerea di testo
    	if (p.getElenco().contains(r)) p.getElenco().remove(r);
    	
    	//Prima di mostrare cancello i precedenti
    	txtParola.clear();
    	txtResult.clear();
    	
    	//Ottengo la lista aggiornata
    	List<String> lista = p.getElenco();
    	
    	//Stampo risultati nella TextArea
    	for (String ss : lista) {
    	txtResult.appendText(ss+"\n");
    	}
    	
    	double fine = System.nanoTime();
    	
    	//Tempo di esecuzione
    	txtAreaTime.setText("Tempo d'esecuzione:\n"+String.valueOf(fine-inizio) +" nanosecondi");
    	
    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert txtParola != null : "fx:id=\"txtParola\" was not injected: check your FXML file 'Parole.fxml'.";
        assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Parole.fxml'.";
        assert btnInserisci != null : "fx:id=\"btnInserisci\" was not injected: check your FXML file 'Parole.fxml'.";

        elenco = new Parole() ;
        
    }
}
