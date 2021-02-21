package ru.geekbrains.courses.java_2.hw6;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    private static final String SERVER_ADDRESS = "localhost";
    private static final int SERVER_PORT = 8189;
    private static Socket socket;

    public static void startClient() {

        try {
            socket = new Socket(SERVER_ADDRESS, SERVER_PORT);

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
                                System.out.println("Server disconnected");
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
            threadInput.setDaemon(true);
            threadInput.start();

            Thread threadOut = new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        while (true) {
                            String str = sc.nextLine();
                            if (str.equals("/end")) {
                                System.out.println("Client disconnected");
                                out.println(str);
                                break;
                            }
                            out.println("Client:" + str);
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
    }
}
