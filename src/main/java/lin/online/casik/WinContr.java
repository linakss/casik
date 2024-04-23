package lin.online.casik;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.stage.Stage;

import java.util.ResourceBundle;

public class WinContr {
    @FXML
    private Button btnGoHome;
    @FXML
    void btnGoHome(ActionEvent event) {

        Stage stage = (Stage) btnGoHome.getScene().getWindow();
        stage.close();
    }

}
