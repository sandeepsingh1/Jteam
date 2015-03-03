package com.hannover.helper;

import org.drools.spi.KnowledgeHelper;

public class RulesHelper {
	

	 
	    public static void log(final KnowledgeHelper drools, final String message){
	       
	    	System.out.println("\nrule triggered: " + drools.getRule().getName());
	        System.out.println(drools.getActivation().getFactHandles());
	    }
	    
	    
	    
	    public static int string_occurence(String str) {
	    	
	    	int start = 0;
	    	  while (true) {
	    	    int found = str.indexOf("OOP", start);
	    	    if (found != -1) {
	    	    	return 0 ;
	    	    }
	    	    if (found == -1) 
	    	    	return 1 ;
	    	  }
	    	
	    	
	    }
	 
	}


