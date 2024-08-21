package helloworld_mvn;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

import com.amazonaws.auth.BasicAWSCredentials;

public class DatabaseManager 
   {
	
	private AWSManager AWSmanager;
	private ArrayList<String> allUsernames;
	private ArrayList<String> allPasswords;
	
    public DatabaseManager()
       {
    	BasicAWSCredentials awsCreds = new BasicAWSCredentials(AWSCredentials.access_key_id, AWSCredentials.secret_access_key);
		AWSmanager = new AWSManager(awsCreds);
		
		allUsernames = new ArrayList<String>();
		allPasswords = new ArrayList<String>();
		
		refreshLists();
       }
    
    public void refreshLists()
       {
    	AWSmanager.downloadObject("cs386projecteast", "logindatabase.csv");
    	
    	try 
	       { 
		    BufferedReader br = new BufferedReader(new FileReader("logindatabase.csv")); 
	        String line;
	        while ((line = br.readLine()) != null) 
	           {
	        	String[] lineParts = line.split(",");
	        	String aUsername = lineParts[0];
	        	String aPassword = lineParts[1];
	        	
	        	allUsernames.add(aUsername);
	        	allPasswords.add(aPassword);
	           }
	        
	        br.close();
	       }
	    catch(Exception e)
	       {
		    System.err.println(e);
	       }
       }
    
    public boolean isUsernameUnique(String username)
       {
    	
    	for(int i = 0; i < allUsernames.size(); i++)
    	   {
    		if(username.equalsIgnoreCase(allUsernames.get(i)))
    		   {
    			return false;
    		   }
    	   }
    	return true;
       }
    
    
    public ArrayList<String> getUsernames()
       {
    	return allUsernames;
 	   }

    
    public ArrayList<String> getPasswords()
       {
 	    return allPasswords;
       }
    
   }
