import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class main {

    public static void main(String[] args) throws Exception {
        String start;
        String end;
        ServerSocket welcomeSocket = new ServerSocket(5000);
        while (true) {
            Socket connectionSocket = welcomeSocket.accept();
            BufferedReader inFromClient =
                    new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));
            PrintWriter outToClient = new PrintWriter(connectionSocket.getOutputStream(), true);


            start = inFromClient.readLine();
            System.out.println("Received: " + start);
            end = inFromClient.readLine();
            System.out.println("Received: " + end);


            Long startTimer = System.currentTimeMillis();

            end = Integer.toString(howMany(Integer.parseInt(start), Integer.parseInt(end)));
            startTimer = System.currentTimeMillis() - startTimer;
            System.out.println();
            outToClient.println(end);
            outToClient.println(startTimer.toString());
        }
    }

    public static int howMany(int start, int end) {
        int buf = 0;
        boolean t;

        for (int i = start; i <= end; i++) {

            if (i == 1) continue;

            if (i == 2 || i == 3) {
                buf++;
                continue;
            }
            if (i % 2 == 0) continue;
            t = true;
            for (int ii = 3; ii <= Math.round(Math.sqrt(i)); ii++) {

                if (i % ii == 0) {
                    t = false;
                    break;
                }

            }
            if (t) {
                buf++;
            }
        }
        return buf;
    }
}
