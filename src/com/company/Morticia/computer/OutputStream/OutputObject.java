package com.company.Morticia.computer.OutputStream;

/**
 * This class serves as a container for output stream data
 *
 * @author Morticia
 * @version 1.0
 * @since 6/15/21
 */
public class OutputObject {
    public final String data;
    public final OutputOption outputOption;

    public OutputObject(String data, OutputOption outputOption) {
        this.data = data;
        this.outputOption = outputOption;
    }
}
