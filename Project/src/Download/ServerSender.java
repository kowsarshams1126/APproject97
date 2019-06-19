package Download;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;



public class ServerSender extends Thread {
	public final static int SOCKET_PORT = 4444;
	public String FILE_TO_SEND;
	
	

	public ServerSender(String name) {
		super();
		FILE_TO_SEND = name;
	}

	


	public String getFILE_TO_SEND() {
		return FILE_TO_SEND ;
	}




	public void run() {
		
	    try (ServerSocket servsock = new ServerSocket(SOCKET_PORT)){
	      while (true) {
	    	System.out.println("Waiting...");
	    	FileInputStream fis = null;
	  	    BufferedInputStream bis = null;
	  	    OutputStream os = null;
	  	    Socket sock = null;
	    	try {
	    		  
	    	  sock = servsock.accept();
	    	  System.out.println("Accepted connection : " + sock);
	   		  File myFile = new File (FILE_TO_SEND);
	   		  byte [] mybytearray  = new byte [(int)myFile.length()];
	   		  fis = new FileInputStream(myFile);
	   		  bis = new BufferedInputStream(fis);
	   		  bis.read(mybytearray,0,mybytearray.length);
	   		  os = sock.getOutputStream();
	   		  System.out.println("Sending " + FILE_TO_SEND + "(" + mybytearray.length + " bytes)");
	   		  os.write(mybytearray,0,mybytearray.length);
	   		  os.flush();
	   		  System.out.println("Done.");
	    		  
	    	  
	    	} catch (IOException ex) {	
	    		System.out.println(ex.getMessage()+": An Inbound Connection Was Not Resolved");
	        
			}finally {
	     
	    		if (bis != null) bis.close();
	        	if (os != null) os.close();
	        	if (sock!=null) sock.close();
	     
	        }
	      }
	    } catch (IOException e) {
	    	System.out.println("We are in Server and it's an io exception");
			e.printStackTrace();
		}
	}
	
}
