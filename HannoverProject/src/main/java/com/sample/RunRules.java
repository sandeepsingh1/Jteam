package com.sample;

import java.io.File;
import java.util.Properties;

import org.drools.KnowledgeBase;
import org.drools.KnowledgeBaseFactory;
import org.drools.builder.KnowledgeBuilder;
import org.drools.builder.KnowledgeBuilderError;
import org.drools.builder.KnowledgeBuilderErrors;
import org.drools.builder.KnowledgeBuilderFactory;
import org.drools.builder.ResourceType;
import org.drools.compiler.PackageBuilderConfiguration;
import org.drools.io.ResourceFactory;

public class RunRules {
	
	   public static KnowledgeBase readKnowledgeBase() throws Exception {
	    	Properties properties = new Properties();
	    	properties.setProperty( "drools.dialect.java.compiler.lnglevel","1.6" );
	    	PackageBuilderConfiguration cfg =new PackageBuilderConfiguration( properties );
	        KnowledgeBuilder kbuilder = KnowledgeBuilderFactory.newKnowledgeBuilder(cfg);
	        System.out.println("E:/Hannover/Sample1.drl");
	        kbuilder.add(ResourceFactory.newClassPathResource("Sample1.drl"), ResourceType.DRL);
	        KnowledgeBuilderErrors errors = kbuilder.getErrors();
	        if (errors.size() > 0) {
	            for (KnowledgeBuilderError error: errors) {
	                System.err.println(error);
	            }
	            throw new IllegalArgumentException("Could not parse knowledge.");
	        }
	        KnowledgeBase kbase = KnowledgeBaseFactory.newKnowledgeBase();
	        kbase.addKnowledgePackages(kbuilder.getKnowledgePackages());
	        return kbase;
	    }

}
