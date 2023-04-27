package com.igate.igateapi.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

import org.springframework.stereotype.Component;

//@Component
public class CustomerTCP {

//    public CustomerTCP() throws IOException {
//        ServerSocket serverSocket = new ServerSocket(8080);
//        System.out.println("Server started on port 8080");
//        while (true) {
//            Socket clientSocket = serverSocket.accept();
//            System.out.println("Client connected: " + clientSocket.getInetAddress().getHostAddress());
//
//            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
//            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
//
//            String request = in.readLine();
//            System.out.println("Received request: " + request);
//
//            out.println("Hello, client!");
//
//            in.close();
//            out.close();
//            clientSocket.close();
//        }
//    }
}