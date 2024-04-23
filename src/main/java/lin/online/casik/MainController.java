package lin.online.casik;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import java.io.*;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Random;

import javafx.scene.control.Button;
import javafx.stage.Stage;

public class MainController {

    @FXML
    private Text amountGame;

    @FXML
    private Text amountProcent;

    @FXML
    private Text numberOne;

    @FXML
    private Text numberThree;

    @FXML
    private Text numberTwo;

   @FXML
    private Text txtAmountGame;

    @FXML
    private Text txtProcentWin;
    double game = 0;
    double winGame = 0;
    double procentWin = 0;
    int max = 9, min = 0;
    String win = "7";

    @FXML private void initialize (){
        try {
            String winGames = Files.readString(Paths.get("procentWins.txt"));
            String wining = Files.readString(Paths.get("winGames.txt"));

            //procentWin = Double.parseDouble(winGames);
            //winGame = Double.parseDouble(wining);

            txtAmountGame.setVisible(false);
            txtProcentWin.setVisible(false);
            amountProcent.setVisible(false);
            amountGame.setVisible(false);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @FXML
    void btnPlay(ActionEvent event) throws IOException {
        game++;
        Random rand = new Random();

        numberOne.setText(String.valueOf(rand.nextInt(max - min + 1) - min));
        numberTwo.setText(String.valueOf(rand.nextInt(max - min + 1) - min));
        numberThree.setText(String.valueOf(rand.nextInt(max - min + 1) - min));


        if (numberOne.getText().equals(win) || numberTwo.getText().equals(win) || numberThree.getText().equals(win)) {
            winGame++;
            MainApplication.showDialog("win-view.fxml","Счастливая семёрка!");
        } 

        amountGame.setText(String.valueOf(Math.round(game)));
        procentWin = Math.round(winGame / game * 100);
        amountProcent.setText(String.valueOf(Math.round(procentWin)));
        
        PrintWriter fw1 = null;
        PrintWriter fw2 = null;
        BufferedWriter bw1 = new BufferedWriter(fw1);
        BufferedWriter bw2 = new BufferedWriter(fw2);
        try {
            fw1 = new PrintWriter("procentWins.txt");
            fw2 = new PrintWriter("winGames.txt");
            bw1.write(amountGame.getText());
            //bw2.write(procentWin.getText()); //не робит
            //bw2.write(win.getText()); //не робит
            bw1.close();
            fw1.close();
            bw2.close();
            fw2.close();

        } catch (IOException e) {
            e.printStackTrace();
            fw1.close();
            fw2.close();
        }
    }

    @FXML
    void btnStatick(ActionEvent event) {
        txtAmountGame.setVisible(true);
        txtProcentWin.setVisible(true);
        amountProcent.setVisible(true);
        amountGame.setVisible(true);
    }
    @FXML
    void btnCancel(ActionEvent event) {
        System.exit(0);
    }

}


/*
сколько всего нажатий
сколько всего побед
процент побед
3 случайных числа
данные должны изначально быть спрятаны
когда нажмут на кнопку - показаться статистика

 */
