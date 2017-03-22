package it.polito.tdp.spellchecker.model;

import java.io.*;
import java.util.*;

public class Dictionary {

	List<RichWord> dizionario; 
	//List<RichWord> dizionarioItaliano; 
	
	
	public Dictionary(){
		dizionario=new ArrayList<RichWord>();
		
		
	}

	public void loadDictionary(String language){
		
		/* Metodo che permette di caricare in memoria il dizionario della lingua desiderata. A questo
proposito, utilizzare i file Italian.txt e English.txt nella cartella rsc. I file contentengono una
parola per riga. Salvare le parole del dizionario in una struttura dati appropriata. Di seguito
viene riportato un esempio della sequenza di operazioni necessarie per leggere le parole dal
file:
*/
	if(language.compareTo("English")==0){
		try {
			FileReader fr = new
			FileReader("rsc/English.txt");
			BufferedReader br = new BufferedReader(fr);
			String word;
			while ((word = br.readLine()) != null) {
			// Aggiungere parola alla struttura dati
				RichWord r=new RichWord(word);
				dizionario.add(r);
				
			}
			br.close();
			} catch (IOException e){
			System.out.println("Errore nella lettura del file");
			}
	}
	if(language.compareTo("Italian")==0){
		try {
			FileReader fr = new
			FileReader("rsc/Italian.txt");
			BufferedReader br = new BufferedReader(fr);
			String word;
			while ((word = br.readLine()) != null) {
			// Aggiungere parola alla struttura dati
				RichWord r=new RichWord(word);
				dizionario.add(r);
			}
			br.close();
			} catch (IOException e){
			System.out.println("Errore nella lettura del file");
			}
	}

	
	

	}

public List<RichWord> spellCheckText(List<String> inputTextList){
		List<RichWord> result=new ArrayList<RichWord>();
		RichWord r=null;
		for(String s:inputTextList){
			r=new RichWord(s);
			
			if(!dizionario.contains(r)){
				r.setCorretta(false);
				}
			if(!r.isCorretta()){
				result.add(r);
			}
			}
		
		return result;
	}
}
