package com.company.Morticia.computer.OutputStream;

import java.util.ArrayList;

/**
 * This class is the output stream utilizes by the computer
 *
 * @author Morticia
 * @version 1.0
 * @since 6/15/21
 */
public class OStream {
    public ArrayList<OutputObject> outputObjects;

    public OStream() {
        outputObjects = new ArrayList<>();
    }

    public void addOutput(OutputObject output) {
        outputObjects.add(output);
    }

    public void addPrintOutput(String print) {
        outputObjects.add(new OutputObject(print, OutputOption.PRINT));
    }
}
