package ru.geekbrains.courses.java_2.hw6;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
    private static final int PORT = 8189;
    private static ServerSocket server;
    private static Socket socket;

    public static void startServer() {
        try {
            server = new ServerSocket(PORT);
            System.out.println("Server started");
            socket = server.accept();
            System.out.println("Client connected");

            Scanner sc = new Scanner(System.in);
            Scanner scInput = new Scanner(socket.getInputStream());
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            Thread threadInput = new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        while (true) {
                            String str = scInput.nextLine();
                            if (str.equals("/end")) {
                                System.out.println("Client disconnected");
                                break;
                            }
                            System.out.println(str);
                        }

                    } catch (Exception e) {
                        e.printStackTrace();
                    } finally {
                        try {
                            socket.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }

            });
            threadInput.start();

            Thread threadOut = new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        while (true) {
                            String str = sc.nextLine();
                            if (str.equals("/end"))  {
                                System.out.println("Server disconnected");
                                out.println(str);
                                break;
                            }
                            out.println("Server:" + str);
                        }

                    } catch (Exception e) {
                        e.printStackTrace();
                    } finally {
                        try {
                            socket.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }

            });

            threadOut.start();


        } catch (IOException e) {
            e.printStackTrace();
        }

            try {
                server.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

