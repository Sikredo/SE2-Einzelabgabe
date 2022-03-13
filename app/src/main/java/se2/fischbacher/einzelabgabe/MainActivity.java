package se2.fischbacher.einzelabgabe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView matrikelNummerInput;
    TextView matrikelNummerOutput;
    Button sendToServerButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        matrikelNummerInput = findViewById(R.id.MatrikelnummerEingabe);
        matrikelNummerOutput = findViewById(R.id.OutputTextField);
        sendToServerButton = findViewById(R.id.SendToServerButton);

        sendToServerButton.setOnClickListener(view -> {
            MatrikelNummerHandler mNummerHandler = new MatrikelNummerHandler(this.matrikelNummerInput.getText().toString(),this.matrikelNummerOutput);
            TCPThread tcpThread = new TCPThread("se2-isys.aau.at", 53212, mNummerHandler);
            new Thread(tcpThread).start();
        });
    }
}