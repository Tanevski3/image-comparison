package com.mtanevski.imagecomparison.lib;

import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;

import javax.imageio.ImageIO;

public class ICV2CheckPixels {

    public static boolean check(File pic1, File pic2) throws IOException {

        if (Arrays.equals(returnPixelVal(pic1), returnPixelVal(pic2))) {
            System.out.println("Match");
            return true;
        } else {
            System.out.println("No match");
            return false;
        }

    }

    public static byte[] returnPixelVal(File in) {

        BufferedImage img = null;
        File f = null;
        byte[] pixels = null;
        // read image
        try {
            f = in;
            img = ImageIO.read(f);
            pixels = ((DataBufferByte) img.getRaster().getDataBuffer()).getData();
        } catch (IOException e) {
            System.out.println(e);
        }

        return pixels;

    }

}
