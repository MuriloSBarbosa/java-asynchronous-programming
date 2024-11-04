package school.sptech;

import com.sun.net.httpserver.HttpServer;
import java.io.IOException;
import java.net.InetSocketAddress;

public class Utils {

    public static int getFactorial(int num) {
        System.out.println("Calculating factorial of " + num);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        int value = calculate(num);
        System.out.println("Factorial of " + num + " is: " + value);
        return value;
    }

    private static int calculate(int num) {
        if (num == 0) {
            return 1;
        }
        return num * calculate(num - 1);
    }

    public static void createServer() {
        try {
            HttpServer server = HttpServer.create(new InetSocketAddress(8000), 0);
            server.createContext("/test", exchange -> {
                String response = "Hello world!";
                exchange.sendResponseHeaders(200, response.length());
                exchange.getResponseBody().write(response.getBytes());
                exchange.close();
            });
            server.start();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
