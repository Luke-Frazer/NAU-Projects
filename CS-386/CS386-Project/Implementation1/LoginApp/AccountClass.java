package helloworld_mvn;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

import com.amazonaws.auth.BasicAWSCredentials;

public class AccountClass 
   {

	public boolean signedIn;
	public String signedUsername;
	private AWSManager AWSManager;
	private DatabaseManager DBManager;
	
	public AccountClass()
	   {
		signedIn = false;
		signedUsername = null;
		
		BasicAWSCredentials awsCreds = new BasicAWSCredentials(AWSCredentials.access_key_id, AWSCredentials.secret_access_key);
		AWSManager = new AWSManager(awsCreds);
		
		DBManager = new DatabaseManager();
	   }
	
    public boolean registerAccount(String username, String password)
       {
    	if(DBManager.isUsernameUnique(username))
    	   {
		    try 
		       {
	    	    Writer output = new BufferedWriter(new FileWriter("logindatabase.csv", true));
	    	    String text = username + "," + password + "\n";
			    output.append(text);
	    	    output.close();
	    	
	    	    AWSManager.uploadObject("cs386projecteast", "logindatabase.csv", "logindatabase.csv");
	    	    signedUsername = username;
	    	    
	    	    System.out.printf("Successfully registered an account under the username: '%s'\n", username);
	    	    
	    	    return true;
		       } 
		    catch (IOException e)
		       {
			    e.printStackTrace();
		       }
           }
    	
    	System.out.println("Could not register an account under the username / password!");
    	return false;
       }
    
    public boolean signIn(String username, String password) 
       {
    	if( username.isEmpty() || password.isEmpty() )
    	   {
    		System.out.println("Could not login. Invalid username or password!");
    		return false;
    	   }
    	
    	String signInKey = username + "," + password;

    	AWSManager.downloadObject("cs386projecteast", "logindatabase.csv");
    	
    	try 
    	   { 
    		BufferedReader br = new BufferedReader(new FileReader("logindatabase.csv")); 
    	    String line;
    	    while ((line = br.readLine()) != null) 
    	       {
    	       if(line.contains(signInKey))
    	          {
    	    	   System.out.println("Successfully logged in");
    	    	   signedIn = true;
    	    	   
    	    	   br.close();
    	    	   
    	    	   return true;
    	          }
    	       }
    	    
    	    br.close();
    	   }
    	catch(Exception e)
    	   {
    		System.err.println(e);
    	   }
 
    	System.out.println("Could not login. Invalid username or password!");   	
    	return false;
       }
   }
