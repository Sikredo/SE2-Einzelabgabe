package se2.fischbacher.einzelabgabe.handler.impl;

import android.widget.TextView;

import se2.fischbacher.einzelabgabe.handler.interfaces.CalculationHandler;
import se2.fischbacher.einzelabgabe.helper.Prime;

public class PrimeMatrikelNummerHandler implements CalculationHandler {
    private String matrikelNummer;
    private TextView matrikelNummerOutput;
    private String allPrimeNumbers;

    public PrimeMatrikelNummerHandler(String matrikelNummer, TextView output) {
        this.matrikelNummer = matrikelNummer;
        this.matrikelNummerOutput = output;
    }

    @Override
    public void calculateOutput() {
        this.allPrimeNumbers = "";
        for (int i = 0; i < this.matrikelNummer.length(); i++) {
            Integer currentNumber = Integer.parseInt(String.valueOf(this.matrikelNummer.charAt(i)));
            if(Prime.isPrime(currentNumber)) {
                this.allPrimeNumbers += " " + currentNumber;
            }
        }
    }

    @Override
    public void handleOutput() {
        this.matrikelNummerOutput.setText(this.allPrimeNumbers);
    }
}
