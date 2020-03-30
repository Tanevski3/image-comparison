package com.mtanevski.imagecomparison.lib.recording;

import javafx.embed.swing.SwingFXUtils;
import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.scene.robot.Robot;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class ScreenRecorder {


    private Robot robot = new Robot();

    public void takeScrenshot(){
        WritableImage writableImage = new WritableImage(1920, 1080);
        WritableImage screenCapture = robot.getScreenCapture(writableImage, new Rectangle2D(0, 0, 1920, 1080));

        this.saveFile(screenCapture, new File("C:\\Users\\Administrator\\OneDrive\\Desktop\\screenshot.png"));
    }


//    public List<Image> takeMultipleScrenshots(){
//        List<Image> images = new ArrayList<>();
//        new Timer().schedule(
//                new TimerTask() {
//
//                    @Override
//                    public void run() {
//                        WritableImage writableImage = new WritableImage(1920, 1080);
//                        images.add(robot.getScreenCapture(writableImage, new Rectangle2D(0, 0, 1920, 1080)));
//                    }
//                }, 0, 1000);
//        return images;
//    }

    private void saveFile(Image image, File file){
        try {
            BufferedImage bufferedImage = SwingFXUtils.fromFXImage(image, null);
            ImageIO.write(bufferedImage, "png", file);
        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }
}
