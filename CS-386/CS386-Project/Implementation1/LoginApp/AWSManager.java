package helloworld_mvn;

import java.util.List;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.Bucket;
import com.amazonaws.services.s3.model.S3ObjectSummary;
import com.amazonaws.AmazonServiceException;
import com.amazonaws.services.s3.model.S3Object;
import com.amazonaws.services.s3.model.S3ObjectInputStream;

public class AWSManager 
   {
	
	final private AmazonS3 s3;
	final private boolean useable;
	
	public AWSManager()
	   {
		s3 = null;
		useable = false;
	   }
	
	public AWSManager(BasicAWSCredentials awsCreds) 
	   {
		s3 = AmazonS3ClientBuilder.standard()
				.withCredentials(new AWSStaticCredentialsProvider(awsCreds))
				.build();
		useable = true;
	   }
	
	public void listBuckets()
	   {
		List<Bucket> buckets = s3.listBuckets();
		System.out.println("Your Amazon S3 buckets are:");
		for(Bucket b : buckets)
		   {
			System.out.println(" " + b.getName());
		   }
	   }
	
	public void listObjects(String bucketName)
	   {
		List<S3ObjectSummary> objects = s3.listObjectsV2(bucketName).getObjectSummaries();
		
		System.out.format("The objects inside the S3 bucket '%s' are:\n", bucketName);

		for(S3ObjectSummary os : objects)
		   {
			System.out.println(" * " + os.getKey());
		   }
	   }
	
	public void downloadObject(String bucketName, String objectName)
	   {
		System.out.format("Downloading '%s' from the S3 bucket '%s'\n", objectName, bucketName);
		try 
		   {
		    S3Object o = s3.getObject(bucketName, objectName);
		    S3ObjectInputStream s3is = o.getObjectContent();
		    File loginData = new File(objectName);
		    FileOutputStream fos = new FileOutputStream(loginData);
		    
		    byte[] read_buf = new byte[1024];
		    int read_len = 0;
		    
		    while ((read_len = s3is.read(read_buf)) > 0) {
		        fos.write(read_buf, 0, read_len);
		    }
		    s3is.close();
		    fos.close();
		    System.out.format("Sucessfully finished downloading '%s' from the S3 bucket\n", objectName);
		    
		   } 
		catch (AmazonServiceException e)
		   {
		    System.err.println(e.getErrorMessage());
		    System.exit(1);
	 	   } 
		catch (FileNotFoundException e)
		   {
		    System.err.println(e.getMessage());
		    System.exit(1);
		   } 
		catch (IOException e) 
		   {
		    System.err.println(e.getMessage());
		    System.exit(1);
	       }
	   }
		
	public void uploadObject(String bucketName, String objectName, String filePath)
	   {
		System.out.format("Uploading '%s' to S3 bucket '%s'\n", objectName, bucketName);
		try 
		   {
		    s3.putObject(bucketName, objectName, new File(filePath));
		   } 
		catch (AmazonServiceException e)
		   {
		    System.err.println(e.getErrorMessage());
		    System.exit(1);
	       }
      }
 }
