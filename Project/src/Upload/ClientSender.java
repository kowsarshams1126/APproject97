package Upload;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;


public class ClientSender extends Thread {

	
	public final static int SOCKET_PORT = 4444;
	public final static String SERVER = "127.0.0.1";
	public String fileName;
	public final static int FILE_SIZE = 4000000;
	
	  
	public ClientSender(String name) {
		super();
		fileName = name;
	}

	

	public String getFileName() {
		return fileName;
	}



	public void run() {

		File myFile = new File (fileName);
		
		try (Socket sock = new Socket(SERVER, SOCKET_PORT);
	    		FileInputStream fis = new FileInputStream(myFile);
		  	    BufferedInputStream bis = new BufferedInputStream(fis);
				OutputStream os = sock.getOutputStream();){
				
			byte [] mybytearray  = new byte [(int)myFile.length()];
			bis.read(mybytearray, 0, mybytearray.length);
			System.out.println("Sending " + fileName + "(" + mybytearray.length + " bytes)");
			os.write(mybytearray,0,mybytearray.length);
			os.flush();	
			System.out.println("Done.");
		    	
			
		} catch (IOException ex) {
				System.out.println(ex.getMessage()+": An Inbound Connection Was Not Resolved");
		}
	}
}
