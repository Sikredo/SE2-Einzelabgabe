package se2.fischbacher.einzelabgabe;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import se2.fischbacher.einzelabgabe.handler.impl.PrimeMatrikelNummerHandler;
import se2.fischbacher.einzelabgabe.handler.impl.ServerMatrikelNummerHandler;
import se2.fischbacher.einzelabgabe.threads.TCPThread;

public class MainActivity extends AppCompatActivity {
    TextView matrikelNummerInput;
    TextView matrikelNummerOutput;
    Button sendToServerButton;
    Button calculatePrimNumbersButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        matrikelNummerInput = findViewById(R.id.MatrikelnummerEingabe);
        matrikelNummerOutput = findViewById(R.id.OutputTextField);
        sendToServerButton = findViewById(R.id.SendToServerButton);
        calculatePrimNumbersButton = findViewById(R.id.CalculatePrimNumbersButton);

        sendToServerButton.setOnClickListener(view -> {
            ServerMatrikelNummerHandler mNummerHandler = new ServerMatrikelNummerHandler(this.matrikelNummerInput.getText().toString(), this.matrikelNummerOutput);
            TCPThread tcpThread = new TCPThread("se2-isys.aau.at", 53212, mNummerHandler);
            new Thread(tcpThread).start();
        });

        calculatePrimNumbersButton.setOnClickListener(view -> {
            PrimeMatrikelNummerHandler primHandler = new PrimeMatrikelNummerHandler(this.matrikelNummerInput.getText().toString(), this.matrikelNummerOutput);
            primHandler.calculateOutput();
            primHandler.handleOutput();
        });
    }
}