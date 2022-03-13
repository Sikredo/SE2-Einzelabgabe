package se2.fischbacher.einzelabgabe.handler.impl;

import android.widget.TextView;

import se2.fischbacher.einzelabgabe.handler.interfaces.TCPHandler;

public class ServerMatrikelNummerHandler implements TCPHandler {
    private String matrikelNummer;
    private TextView matrikelNummerOutput;

    public ServerMatrikelNummerHandler(String matrikelNummer, TextView output) {
        this.matrikelNummer = matrikelNummer;
        this.matrikelNummerOutput = output;
    }

    @Override
    public String getRequestString() {
        return this.matrikelNummer;
    }

    @Override
    public void handleServerResponse(String serverResponse) {
        this.matrikelNummerOutput.setText(serverResponse);
    }
}
