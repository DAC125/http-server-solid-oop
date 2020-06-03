package edu.byohttp;

import org.junit.Test;

public class InternalServerErrorTest {
    Log log = new ConsoleLog();

    @Test public void testInitializeServerSocket() throws InternalServerErrorException {
        //ThreadManager threadManager = new ThreadManager();
        //threadManager.initializeServerSocket(8085);
        //assertFalse("Server should not have started \n", threadManager.getStatus());
        log.logInformation("Now server should start properly.");
        //threadManager.initializeServerSocket(8008);
    }
}
