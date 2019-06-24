package com.hjl.utils;

import java.io.*;

public class IOTest {
    public static void main(String[] args) {
        File file = new File("E:/IOTest.txt");
        if (!file.exists()) {
            try {
                file.createNewFile();
                InputStreamReader isr = new InputStreamReader(System.in);
                BufferedReader br = new BufferedReader(isr);
                System.out.println("请输入：");
                String str = br.readLine();
                System.out.println("你输入的内容：" + str);
                FileWriter fos = new FileWriter(file, true);
                BufferedWriter bw = new BufferedWriter(fos);
                bw.write(str);
                br.close();
                bw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
