package se2.fischbacher.einzelabgabe.threads;

import android.util.Log;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

import se2.fischbacher.einzelabgabe.handler.interfaces.TCPHandler;

public class TCPThread implements Runnable {
    private String host;
    private Integer port;
    private TCPHandler handler;

    public TCPThread(String host, Integer port, TCPHandler handler) {
        this.host = host;
        this.port = port;
        this.handler = handler;
    }

    @Override
    public void run() {
        try {
            Socket socket = new Socket(this.host, this.port);
            DataOutputStream toServer = new DataOutputStream(socket.getOutputStream());
            BufferedReader fromServer = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            toServer.writeBytes(this.handler.getRequestString()+"\n");
            this.handler.handleServerResponse(fromServer.readLine());
            socket.close();
        } catch (IOException exception) {
            Log.e(this.getClass().toString(), exception.getMessage());
        }
    }
}
