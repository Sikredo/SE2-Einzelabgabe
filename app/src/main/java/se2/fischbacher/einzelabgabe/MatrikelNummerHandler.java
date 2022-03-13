package se2.fischbacher.einzelabgabe;

import android.widget.TextView;

public class MatrikelNummerHandler implements TCPHandler {
    private String matrikelNummer;
    private TextView matrikelNummerOutput;

    public MatrikelNummerHandler(String matrikelNummer, TextView output) {
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
