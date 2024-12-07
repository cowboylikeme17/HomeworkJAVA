import java.io.*;
import java.net.*;

class Calculator {
    private double v;
    private double d;

    public Calculator(double v, double d) {
        this.v = v;
        this.d = d;
    }

    public double calculateTime() {
        return d / v;
    }
}

public class Server {
    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(1717)) {
            System.out.println("Server is running on port 1717...");

            while (true) {
                Socket socket = serverSocket.accept();
                try (BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                     PrintWriter output = new PrintWriter(socket.getOutputStream(), true)) {

                    double v = Double.parseDouble(input.readLine());
                    double d = Double.parseDouble(input.readLine());

                   Calculator calculator = new Calculator(v, d);
                    double t = calculator.calculateTime();

                    output.println(t);
                    System.out.println("Processed: V = " + v + ", D = " + d + ", T = " + t);
                }
                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

