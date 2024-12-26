package spring;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ScanOpenPorts {

    private static final int MIN_PORT_NUMBER = 0;
    private static final int MAX_PORT_NUMBER =  65535;
    private static final int TIMEOUT =  100;
    private static final int THREADS =  100;


    public static void scanOpenPorts(String host) throws IOException {
        System.out.println("Scanning ports:");

        String openPortFile = "scanOpenPort/src/main/resources/openPort.txt";
        String closePortFile = "scanOpenPort/src/main/resources/closePort.txt";

        PrintWriter openPrintWriter = new PrintWriter(new FileWriter(openPortFile));
        PrintWriter closePrintWriter = new PrintWriter(new FileWriter(closePortFile));

        ExecutorService executorService = Executors.newFixedThreadPool(THREADS);

        for (int i = MIN_PORT_NUMBER; i < MAX_PORT_NUMBER; i++) {
            final  int port = i;
            executorService.execute(() -> {
                var inetSocketAddress = new InetSocketAddress(host, port);

                try (var socket = new Socket()) {
                    socket.connect(inetSocketAddress, TIMEOUT);
                    openPrintWriter.println("Host: " + host + ", " + port + " is opened!");
                } catch (IOException e) {
                    closePrintWriter.println(port + " — " + e.getMessage());
                }
            });
        }
        executorService.shutdown();
        try {
            executorService.awaitTermination(10, TimeUnit.MINUTES);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        openPrintWriter.close();
        closePrintWriter.close();
        System.out.println("Finish");
    }
}