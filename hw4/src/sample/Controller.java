package sample;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class Controller {
    @FXML
    public TextArea TextArea;

    @FXML
    public TextField TextField;

    @FXML
    public void clickExit(ActionEvent actionEvent) {
        Platform.runLater(() ->{
            Stage stage = (Stage) TextArea.getScene().getWindow();
            stage.close();
        });
    }

    @FXML
    public void ClickBtn(ActionEvent actionEvent) {
        TextArea.appendText(TextField.getText() + "\n");
        TextField.clear();
        TextField.requestFocus();
    }


}
