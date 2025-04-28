package org.example.effective.chapter2.item9;

import java.io.*;

public class tryExample {
    static int BUFFER_SIZE = 100;
    public static void main(String[] args) {

    }

    static String firstLineOfFileOld(String path) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(path));
        try {
            return br.readLine();
        } finally {
            br.close();
        }
    }

    static String firstLineOfFile(String path, String defaultVal) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(path))){
            return br.readLine();
        } catch (IOException e) {
            return defaultVal;
        }
    }

    static void copyOld(String src, String dst) throws IOException {
        InputStream in = new FileInputStream(src);
        try {
            OutputStream out = new FileOutputStream(dst);
            try {
                byte[] buf = new byte[BUFFER_SIZE];
                int n = 0;
                while ((n == in.read(buf)))
                    out.write(buf, 0, n);
            } finally {
                out.close();
            }
        } finally {
            in.close();
        }
    }

    static void copy(String src, String dst) throws IOException {

        try (InputStream in = new FileInputStream(src);
             OutputStream out = new FileOutputStream(dst)){
            byte[] buf = new byte[BUFFER_SIZE];
            int n = 0;
            while ((n == in.read(buf)))
                out.write(buf, 0, n);

        }
    }
}
