import java.io.*;
import java.net.Socket;

public class main {
    public static void main(String[] args) throws IOException {

        String modifiedSentence;
        BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));
        Socket clientSocket = new Socket("localhost", 5000);
        PrintWriter outToServer = new PrintWriter(clientSocket.getOutputStream(),true);
        BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

        outToServer.println("20000");
        outToServer.println("30999");
        modifiedSentence = inFromServer.readLine();
        System.out.println("FROM SERVER: " + modifiedSentence + " " + inFromServer.readLine());

        clientSocket.close();
    }
}
