import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        final String SERVER_ADDRESS = "localhost";

        try (Socket socket = new Socket(SERVER_ADDRESS, 1717);
             PrintWriter output = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {

            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter V in m/s: ");
            double v = scanner.nextDouble();
            System.out.print("Enter D in meters: ");
            double d = scanner.nextDouble();

            output.println(v);
            output.println(d);

            double t = Double.parseDouble(input.readLine());
            System.out.println("You need :"+ t + " "+ "hours");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

