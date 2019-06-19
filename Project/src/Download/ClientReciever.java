package Download;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.net.UnknownHostException;


public class ClientReciever extends Thread {

	
	public final static int SOCKET_PORT = 4444;
	public final static String SERVER = "127.0.0.1";
	public String fileName;
	public final static int FILE_SIZE = 4000000;
	
	  
	public ClientReciever(String name) {
		super();
		// TODO Auto-generated constructor stub
		fileName = name;
	}


	public void run() {
	    
		int bytesRead;
		int current = 0;
	    try (Socket sock = new Socket(SERVER, SOCKET_PORT);
	    		FileOutputStream fos = new FileOutputStream(fileName);
	    		BufferedOutputStream bos = new BufferedOutputStream(fos);
	    		InputStream is = sock.getInputStream();
		    	) {
	    	
	    	System.out.println("Connecting...");
	    	byte [] mybytearray  = new byte [FILE_SIZE];
	    	bytesRead = is.read(mybytearray, 0, mybytearray.length);
	    	System.out.println("bytes Read : " + bytesRead);
	    	current = bytesRead;
	      
	    	do {
	    		bytesRead = is.read(mybytearray, current, (mybytearray.length-current));
	    		if(bytesRead >= 0) 
	    			current += bytesRead;
	      
	    	} while(!(bytesRead <= 0));
	    	
	    	System.out.println("bytes Read : " + bytesRead);
	    	
	    	bos.write(mybytearray, 0 , current);
	    	bos.flush();
	    	System.out.println("File " + fileName + " downloaded (" + current + " bytes read)");
	  
	    } catch (UnknownHostException e) {
	    	System.out.println("Client, Unknown host");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Client, io");
			e.printStackTrace();
		}    
	}    
}
