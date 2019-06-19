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
	    		File myFile = new File (FILE_TO_SEND);
	    		try (Socket sock = servsock.accept();
	    				FileInputStream fis = new FileInputStream(myFile);
	    				BufferedInputStream bis = new BufferedInputStream(fis);
	    				OutputStream os = sock.getOutputStream();){
	    			
	    			
	    			System.out.println("Accepted connection : " + sock);
	    			byte [] mybytearray  = new byte [(int)myFile.length()];
	    			bis.read(mybytearray,0,mybytearray.length);
	    			System.out.println("Sending " + FILE_TO_SEND + "(" + mybytearray.length + " bytes)");
	    			os.write(mybytearray,0,mybytearray.length);
	    			os.flush();
	    			System.out.println("Done.");
	    			
	    			
	    		} catch (IOException ex) {	
	    			System.out.println(ex.getMessage()+": An Inbound Connection Was Not Resolved");
	    		}
	      
	    	}
	    } catch (IOException e) {
	    	System.out.println("We are in Server and it's an io exception");
			e.printStackTrace();
		}
	}
	
}
