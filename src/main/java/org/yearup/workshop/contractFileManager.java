package org.yearup.workshop;

import java.io.FileWriter;
import java.io.IOException;

public class contractFileManager {

    public static void saveContract(Contract c){
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter("contracts.csv", true);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try {
            fileWriter.write(c.getPersistenceString());
            fileWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
