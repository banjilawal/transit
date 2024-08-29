package com.lawal.transit.globals;

import java.io.*;
import java.util.*;

public final class RandomWordProducer {
    private final String file;
    private final BufferedReader reader;

    private RandomWordProducer (Builder builder) {
        this.file = builder.file;
        this.reader = builder.reader;
    }

    public String word () throws Exception {
        int numberOfLines = getLineCount();
        if (numberOfLines == 0) {
            throw new Exception("The file is empty");
        }
        int counter = 0;
        int randomLineNumber = (new Random()).nextInt(numberOfLines);
        String line = reader.readLine();
        while (line != null) {
            if (counter == randomLineNumber)
                return line;
            line = reader.readLine();
            counter++;
        }
        return null;
    }

    private int getLineCount () throws IOException {
        int lineCount = 0;
        String line;
        while (reader.readLine() != null)
            lineCount++;
        return lineCount;
    }

    public static Builder builder () { return new Builder(); }

    public static class Builder {
        private String file;
        private BufferedReader reader;

        public Builder file (String file) {
            this.file = file;
            return this;
        }

        public RandomWordProducer build  () throws FileNotFoundException {
            this.reader = new BufferedReader(new FileReader(file));
            return new RandomWordProducer(this);
        }
    }
}
