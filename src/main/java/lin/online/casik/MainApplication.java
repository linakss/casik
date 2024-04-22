package lin.online.casik;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

public class MainApplication extends Application {
    public static void main(String[] args) {
        launch();
    }

    private static FXMLLoader fxmlLoader;
    private static MainController mainController;

    @Override
    public void start(Stage stage) throws IOException {

        fxmlLoader = new FXMLLoader(MainApplication.class.getResource("main-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 660, 530);
        stage.setTitle("Игра");
        stage.setResizable(false);
        stage.setScene(scene);
        mainController = fxmlLoader.getController();
        stage.show();

    }


    public static void showWin(Stage stage) throws IOException {
        fxmlLoader = new FXMLLoader(MainApplication.class.getResource("win-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 660, 530);
        stage.setTitle("Счастливая семёрка!");
        stage.setResizable(false);
        stage.setScene(scene);
        mainController = fxmlLoader.getController();
        stage.show();
    }
}