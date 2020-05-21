package test.com.httpserver;

import main.com.httpserver.ThreadManager;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;

public class ThreadManagerTest {

    @Test public void testInitializeServerSocket() throws IOException {
        ThreadManager threadManager = new ThreadManager();
        //threadManager.initializeServerSocket(8008);
        //assertTrue("Server Started.\\nListening for connections on port: \" + port + \"...\\n", threadManager.getStatus());

    }

}
