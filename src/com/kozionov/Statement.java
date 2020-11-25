package com.kozionov;

import java.io.*;

public class Statement {
    public static void main(String [] args) throws IOException {
        String in = "/Users/curloid/Downloads/June_9105.txt";

        File f = new File(in);
        FileInputStream fileInputStream = new FileInputStream(f);
        BufferedReader buf = new BufferedReader(new InputStreamReader(fileInputStream));

        String line = buf.readLine();
        StringBuilder sb = new StringBuilder();

        while(line != null){
            String [] parts = line.split(" ");
            for (int i = 0; i < parts.length; i++) {
                sb.append(parts[i]);
                if (i == 0 || i == 1 || (i + 2) == parts.length) {
                    sb.append(",");
                }

                sb.append(" ");

            }

            sb.append("\n");
            line = buf.readLine();
        }

        System.out.println(sb);
    }
}
