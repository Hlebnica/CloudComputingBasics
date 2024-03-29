package org.example;
import java.io.*;
import java.net.*;

public class Client {
  private static final String HOST = "localhost";
  private static final int PORT = 19001;
  public static void main(String[] args) {
    try (Socket socket = new Socket(HOST, PORT);
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in))) {
      String userInput;
      while ((userInput = stdIn.readLine()) != null && !userInput.isEmpty()) {
        out.println(userInput);
        String serverResponse = in.readLine();
        System.out.println("Server response: " + serverResponse);
      }
    } catch (IOException e) {
      System.out.println("Ошибка при подключении к серверу: " + e.getMessage());
    }
  }
}