package com.example.chatfx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

import java.util.Random;

public class ChatController {
    @FXML
    private Button SendButton;

    @FXML
    private TextArea chatText;

    @FXML
    private VBox chats;

    @FXML
    private SplitPane first;

    @FXML
    private TextArea inputText;

    @FXML
    private SplitPane second;

    @FXML
    private SplitPane third;

    @FXML
    private ScrollPane ChtContainer;


    @FXML
    void onClick(ActionEvent event) {
        first.setDividerPositions(0.25);
        second.setDividerPositions(0.85);
        third.setDividerPositions(0.8);
        first.setResizableWithParent(chats,Boolean.FALSE);
        second.setResizableWithParent(third,Boolean.FALSE);
        third.setResizableWithParent(SendButton,Boolean.FALSE);

        Random random = new Random();
        int numberOfLabels = random.nextInt(15,30) + 1; // generate a random number between 1 and 10
        int num = 1;

        chats=new VBox();

        for (int i = 0; i < numberOfLabels; i++) {
            if (num==5){
                num=1;
            }
            Image img = new Image(String.valueOf(ChatApplication.class.getResource("img/" + String.valueOf(num) + ".png")));
            ImageView view = new ImageView(img);
            view.setFitHeight(33);
            view.setPreserveRatio(true);
            Label label = new Label("Contact" + i, view);
            chats.getChildren().add(label);
            num++;
        }

        ChtContainer.setContent(chats);

        chatText.appendText(inputText.getText() + System.lineSeparator());
        inputText.clear();
    }

}
