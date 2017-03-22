package it.polito.tdp.spellchecker.model;

import java.util.*;

public class TestDictionary {

	public static void main(String[] args) {
		Dictionary d=new Dictionary();
		List<String> input=new LinkedList<String>();
		
		d.loadDictionary("Italian");
		
		input.add("ciao");
		input.add("sdf");
		input.add("xf");
		
		List<RichWord> result=d.spellCheckText(input);
		for(RichWord s:result){
			System.out.println(s.getParola());
		}
		

	}

}
