package lin.online.casik;

        import javafx.event.ActionEvent;
        import javafx.fxml.FXML;
        import javafx.scene.control.Button;
        import javafx.scene.image.ImageView;
        import javafx.stage.Stage;
        import javafx.scene.image.Image;

public class WinContr {
    @FXML
    public ImageView image;
    @FXML
    private Button btnGoHome;


    @FXML private void initialize (){

        Image img = new Image(String.valueOf(MainApplication.class.getResource("pobeda.jpg")));
        image.setImage(img);
        image.setVisible(true);
    }
    @FXML
    void btnGoHome(ActionEvent event) {
        Stage stage = (Stage) btnGoHome.getScene().getWindow();
        stage.close();
    }

}
