package com.sample;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Test {

	  // JDBC driver name and database URL
	   static final String JDBC_DRIVER = "org.postgresql.Driver";  
	   static final String DB_URL = "jdbc:postgresql://localhost:5432/hannover";

	   //  Database credentials
	   static final String USER = "postgres";
	   static final String PASS = "postgres";
	   
	   public static void main(String[] args) {
	   Connection conn = null;
	   Statement stmt = null;
	   try{
	      //STEP 2: Register JDBC driver
	      Class.forName("org.postgresql.Driver");

	      //STEP 3: Open a connection
	      System.out.println("Connecting to database...");
	      conn = DriverManager.getConnection(DB_URL,USER,PASS);

	      DatabaseMetaData dbmd = conn.getMetaData();
          String[] types = {"TABLE"};
          ResultSet rs = dbmd.getTables(null, null, "%", types);
          while (rs.next()) {
        	  System.out.println("");
        	  System.out.println(rs.getString("TABLE_NAME"));
        	  ResultSet rs2 = dbmd.getColumns(null, null, rs.getString("TABLE_NAME"), "%");
        	  String cName =  null;
        	  String preFix = null;
        	  while (rs2.next()) {
        		  cName = rs2.getString("COLUMN_NAME");
        		  int dataType =  rs2.getInt("DATA_TYPE");
        		   
        		  if(dataType == java.sql.Types.VARCHAR){
        			  preFix = "		private String ";
        		  }
        		  else if(dataType == java.sql.Types.DATE){
        			  preFix = "		private Date ";
        		  }
        		  else if(dataType == java.sql.Types.BIGINT){
        			  preFix = "		private Long ";
        		  }
        		  else if(dataType == java.sql.Types.NUMERIC){
        			  preFix = "		private Integer ";
        		  }

        		  String[] tmp =  cName.split("_");
        		  String temp2= "";
        		  String temp3="";
        		  if(tmp.length >1){
        			  temp2= tmp[1].substring(0, 1).toUpperCase()+tmp[1].substring(1, tmp[1].length());
        			  if(tmp.length >2){
        				  temp3= tmp[2].substring(0, 1).toUpperCase()+tmp[2].substring(1, tmp[2].length());
        			  }
        		  }
        		  System.out.println(preFix+tmp[0]+temp2+temp3+";");
        	  }
          }

	      conn.close();
	   }catch(SQLException se){
	      //Handle errors for JDBC
	      se.printStackTrace();
	   }catch(Exception e){
	      //Handle errors for Class.forName
	      e.printStackTrace();
	   }finally{
	      //finally block used to close resources
	      try{
	         if(stmt!=null)
	            stmt.close();
	      }catch(SQLException se2){
	      }// nothing we can do
	      try{
	         if(conn!=null)
	            conn.close();
	      }catch(SQLException se){
	         se.printStackTrace();
	      }//end finally try
	   }//end try
	   System.out.println("Goodbye!");
	}//end main

}
