import java.io.*;

import com.amazonaws.AmazonClientException;
import com.amazonaws.AmazonServiceException;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.auth.profile.ProfileCredentialsProvider;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.DeleteObjectRequest;
import com.amazonaws.services.s3.model.GetObjectRequest;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazonaws.services.s3.model.S3Object;
import com.amazonaws.services.s3.model.S3ObjectInputStream;

public class upload {
	private static String bucketName     = "uploadbycode";	//bucket name in your S3
	private static String keyName     = "thisfile";		//file name with which you want to upload
	private static String uploadFileName    = "C:\\Users\\Rohan\\Documents\\test.txt";	//address to the file which you want to upload
	
	void uploadfile(AWSCredentials credentials)
	{
		AmazonS3 s3client = new AmazonS3Client(credentials);
		
		try {
            System.out.println("Uploading a new object to S3 from a file\n");
            File file = new File(uploadFileName);
            s3client.putObject(new PutObjectRequest(
            		                 bucketName, keyName, file));

         } catch (AmazonServiceException ase) {
            System.out.println("Caught an AmazonServiceException, which " +
            		"means your request made it " +
                    "to Amazon S3, but was rejected with an error response" +
                    " for some reason.");
            System.out.println("Error Message:    " + ase.getMessage());
            System.out.println("HTTP Status Code: " + ase.getStatusCode());
            System.out.println("AWS Error Code:   " + ase.getErrorCode());
            System.out.println("Error Type:       " + ase.getErrorType());
            System.out.println("Request ID:       " + ase.getRequestId());
        } catch (AmazonClientException ace) {
            System.out.println("Caught an AmazonClientException, which " +
            		"means the client encountered " +
                    "an internal error while trying to " +
                    "communicate with S3, " +
                    "such as not being able to access the network.");
            System.out.println("Error Message: " + ace.getMessage());
        }
	}
	public static void main(String[] args) throws IOException {
		AWSCredentials Credentials = new BasicAWSCredentials(		
				"AKIAJNCZLJHMV7CMQ3SA", 
				"uejvpse68EC7q9Jlct3UnfgJefvjr+nzRSJJhZKa");
		upload s3client = new upload();
        	s3client.uploadfile(Credentials);
 	
  }
}
