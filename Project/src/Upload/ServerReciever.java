package Upload;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerReciever extends Thread {

	public final static int SOCKET_PORT = 4444;
	public String fileName;
	public final static int FILE_SIZE = 4000000;
	
	public ServerReciever(String name) {
		super();
		fileName = name;
	}
	
public void run() {
	    
		int bytesRead;
		int current = 0;
	    try (ServerSocket servsock = new ServerSocket(SOCKET_PORT)) {
	    	while (true) {
		    	System.out.println("Waiting...");
		    	try (Socket sock = servsock.accept();
		    			FileOutputStream fos = new FileOutputStream(fileName);
		    			BufferedOutputStream bos = new BufferedOutputStream(fos);
		    			InputStream is = sock.getInputStream();){
		    		
		    		
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
		    	}
	    	}
	    	
	    } catch (IOException e) {
	    	System.out.println("Client, io");
	    	e.printStackTrace();
		}
	}    

}
