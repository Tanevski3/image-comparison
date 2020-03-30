package com.mtanevski.imagecomparison.lib;

import javafx.scene.image.Image;

public class ICV3CompareJavaFXImages {

    public static boolean compareJavaFxLoadedImages(Image image1, Image image2) {
        double image1Width = image1.getWidth();
        double image1Height = image1.getHeight();
        for (int i = 0; i < image1Width; i++) {
            for (int j = 0; j < image1Height; j++) {
                try {
                    if (image2.getPixelReader().getArgb(i, j) != image1.getPixelReader().getArgb(i, j)) {
                        return false;
                    }
                }catch (IndexOutOfBoundsException exc) {

                    return false;
                }

            }
        }
        return true;
    }
}
