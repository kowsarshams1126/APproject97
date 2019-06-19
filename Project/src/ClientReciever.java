import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.net.UnknownHostException;


public class ClientReciever extends Thread {

	
	public final static int SOCKET_PORT = 4444;
	public final static String SERVER = "127.0.0.1";
	public final static String FILE_TO_RECEIVED = "file-rec.txt";
	public final static int FILE_SIZE = 50;
	
	  
	public ClientReciever() {
		super();
		// TODO Auto-generated constructor stub
	}


	public void run() {
	    
		int bytesRead;
		int current = 0;
	    try (Socket sock = new Socket(SERVER, SOCKET_PORT);
	    		FileOutputStream fos = new FileOutputStream(FILE_TO_RECEIVED);
	    		BufferedOutputStream bos = new BufferedOutputStream(fos);
		    	) {
	    	
	    	System.out.println("Connecting...");
	    	byte [] mybytearray  = new byte [FILE_SIZE];
	    	InputStream is = sock.getInputStream();
	    	bytesRead = is.read(mybytearray,0,mybytearray.length);
	    	current = bytesRead;
	      
	    	do {
	         
	    		bytesRead = is.read(mybytearray, current, (mybytearray.length-current));
	    		if(bytesRead >= 0) 
	    			current += bytesRead;
	      
	    	} while(bytesRead > -1);
	    	
	    	bos.write(mybytearray, 0 , current);
	    	bos.flush();    
	    	System.out.println("File " + FILE_TO_RECEIVED + " downloaded (" + current + " bytes read)");
	  
	    } catch (UnknownHostException e) {
			// TODO Auto-generated catch block
	    	System.out.println("Client, Unknown host");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Client, io");
			// TODO Auto-generated catch block
			e.printStackTrace();
		}    
	}    
}
