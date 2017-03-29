package com.example.jmj.gpio_toggle;

/**
 * Created by jean-marc on 28-Sep-16.
 */

import android.util.Log;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by jean-marc on 27-Sep-16.
 */

public class Uart1Access {
    public static final String TAG = "Uart1Access";
    private String PATH = "/dev/ttyHS4";

    /* Sending a message to the port */
    public void sendMessage(String message) {
        Log.v(TAG,"Send message");
        BufferedWriter out = null;
        try {
            FileWriter fstream = new FileWriter(PATH, false);
            out = new BufferedWriter(fstream);
            out.write(message);
            out.close();

        } catch (IOException e) {
            Log.e(TAG,"Error: " + e.getMessage());
        }
    }

    /* Reading a message from the port */

    public String readMessage() {
        Log.v(TAG,"Read message");
        BufferedReader inb;
        String line = "";
        try {
            inb = new BufferedReader(new FileReader(PATH));
            line = inb.readLine();
            inb.close();
            Log.v(TAG,"Received: " + line);

        } catch (Exception e) {
            Log.e(TAG,"Error: " + e.getMessage());

        }

        return line;
    }


}
