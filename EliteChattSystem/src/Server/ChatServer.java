package Server;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;


public class ChatServer extends AbstractServer {

	public ChatServer(int port) throws IOException {
		super(port);
	}

	
	//Lists to keep track of which user has what PrintWriter
	protected static LinkedList<String> ListNames  = new LinkedList<String>();
	protected static LinkedList<PrintWriter> ListWriters  = new LinkedList<PrintWriter>();
	
  //Main method to start server first makes a socket then it trys to run the handlers thread.
  
    public static void main(String[] args) throws Exception {
    	new ChatServer(9001);
    }
}