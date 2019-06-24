package com.hjl.utils;

import javax.swing.*;
import java.io.*;

/**
 * 腾讯视频里的面板图片轮播
 * @author 黄敬理
 * 2019.04.27
 */
public class Carousel implements Runnable {
    private String[] images = {"E:/java-study-file/image/13.png","E:/java-study-file/image/14.png","E:/java-study-file/image/15.png","E:/java-study-file/image/16.png"};
    private JLabel imagesLabel;

    public void setImagesLabel(JLabel imagesLabel) {
        this.imagesLabel = imagesLabel;
    }

    @Override
    public void run() {
        int i = 0;
        int len = images.length;
        while (true){
            File file = new File(images[i]);
            InputStream in = null;
            try {
                in = new FileInputStream(file);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            byte[] bytes = new byte[(int) file.length()];
            try {
                in.read(bytes);
            } catch (IOException e) {
                e.printStackTrace();
            }
            Icon icon = new ImageIcon(bytes);
            imagesLabel.setIcon(icon);
            i++;
            if (i == len){
                i = 0;
            }
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
