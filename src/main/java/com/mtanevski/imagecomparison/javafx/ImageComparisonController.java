package com.mtanevski.imagecomparison.javafx;

import com.mtanevski.imagecomparison.lib.ICV2CheckPixels;
import com.mtanevski.imagecomparison.lib.recording.ScreenRecorder;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import static com.mtanevski.imagecomparison.lib.ICV3CompareJavaFXImages.compareJavaFxLoadedImages;

public class ImageComparisonController {

    @FXML
    public Label statusLbl;
    @FXML
    public ImageView image1View;
    @FXML
    public ImageView image2View;


    private ScreenRecorder screenRecorder;

    public void initialize() {
        screenRecorder = new ScreenRecorder();
    }

    public void selectImage1(ActionEvent actionEvent) {
        File file = waitChooseFileDialog();
        image1View.setImage(new Image(file.toURI().toString()));
    }

    public void selectImage2(ActionEvent actionEvent) {
        File file = waitChooseFileDialog();
        image2View.setImage(new Image(file.toURI().toString()));

    }

    public void compare(ActionEvent actionEvent) throws IOException, URISyntaxException {
        Image image1 = image1View.getImage();
        String url1 = image1.getUrl();
        Image image2 = image2View.getImage();
        String url2 = image2.getUrl();
        boolean check2 = ICV2CheckPixels.check(new File(new URI(url1)), new File(new URI(url2)));
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(check2 ? "ICV2: Images match": "ICV2: Images do not match");
        stringBuilder.append(" | ");
        boolean check3 = compareJavaFxLoadedImages(image1, image2);
        stringBuilder.append((check3 ? "ICV3: Images match": "ICV3: Images do not match"));
        statusLbl.setText(stringBuilder.toString());
        screenRecorder.takeScrenshot();
        // screenRecorder.takeMultipleScrenshots();
    }

    private File waitChooseFileDialog() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open Image File");
        fileChooser.setInitialDirectory(
                new File(System.getProperty("user.home"))
        );
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("JPG", "*.jpg"),
                new FileChooser.ExtensionFilter("JPEG", "*.jpeg"),
                new FileChooser.ExtensionFilter("PNG", "*.png")
        );
        return fileChooser.showOpenDialog(image1View.getScene().getWindow());
    }
}
