package com.techelevator;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Log {
    private String file = "log.txt";
    // will delete log.txt file if it already exists each time the vending machine runs
    private boolean deleteFile = new File(file).delete();
    private File logFile = new File(file);

    public Log() throws IOException {
        logFile.createNewFile();
    }

    private void createNewFile() {
        try {
            logFile.createNewFile();
        } catch (IOException e) {
        }
    }
    private String getCurrentTime() {
        String date = new SimpleDateFormat("MM/dd/yyyy hh:mm:ss a").format(new Date());
        return date;
    }

    public String logEvent(String event, String balanceBeforeTransaction, String afterTransaction) throws IOException {
        // will add transaction to log.txt
        String logString = String.format("%-24s %-22s %-14s %-14s", getCurrentTime(), event, balanceBeforeTransaction,
                afterTransaction); // add spaces between entry items

        try (Writer fileWriter = new FileWriter(logFile, true);
        BufferedWriter buffered = new BufferedWriter(fileWriter)) {
            buffered.write(logString + "\n");
        } catch (IOException e) {
        }
        return logString;
    }
}
