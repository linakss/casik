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
    public Text txtAmountPobed;

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
    double game = 0; //kol-vo igr
    double winGame = 0;
    double procentWin = 0;
    int max = 9, min = 0;
    String win = "7";
    @FXML
    private Text gamesAllPobed;

    @FXML private void initialize (){
        try {
            String winGames = Files.readString(Paths.get("procentWins.txt"));
            String wining = Files.readString(Paths.get("allWinGames.txt"));
            String gamesAllStr = Files.readString(Paths.get("gamesAll.txt"));
            procentWin = Double.parseDouble(winGames); //процент из файла
            winGame = Double.parseDouble(wining); //кол-во побед из файла
            game = Double.parseDouble(gamesAllStr); //кол-во круток из файла
            txtAmountGame.setVisible(false);
            txtProcentWin.setVisible(false);
            amountProcent.setVisible(false);
            amountGame.setVisible(false); //kol-vo pobed
            txtAmountPobed.setVisible(false);
            gamesAllPobed.setVisible(false);
            gamesAllPobed.setText(String.valueOf(game));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @FXML
    void btnPlay(ActionEvent event) throws IOException {
        Random rand = new Random();
        game++;

        numberOne.setText(String.valueOf(rand.nextInt(max - min + 1) - min));
        numberTwo.setText(String.valueOf(rand.nextInt(max - min + 1) - min));
        numberThree.setText(String.valueOf(rand.nextInt(max - min + 1) - min));


        if (numberOne.getText().equals(win) || numberTwo.getText().equals(win) || numberThree.getText().equals(win)) {
            winGame++;
            MainApplication.showDialog("win-view.fxml","Счастливая семёрка!");
        }

        gamesAllPobed.setText(String.valueOf(Math.round(winGame)));
        amountGame.setText(String.valueOf(Math.round(game)));
        procentWin = Math.round(winGame / game * 100);
        amountProcent.setText(String.valueOf(Math.round(procentWin)));
        
        PrintWriter fw1 = null;
        PrintWriter fw2 = null;
        PrintWriter fw3 = null;
        try {
            fw1 = new PrintWriter("procentWins.txt");
            fw2 = new PrintWriter("allWinGames.txt");
            fw3 = new PrintWriter("gamesAll.txt");
            BufferedWriter bw1 = new BufferedWriter(fw1);
            BufferedWriter bw2 = new BufferedWriter(fw2);
            BufferedWriter bw3 = new BufferedWriter(fw3);
            bw1.write(amountGame.getText());
            bw2.write(amountProcent.getText());
            bw3.write(gamesAllPobed.getText());
            bw1.close();
            fw1.close();
            bw2.close();
            fw2.close();
            bw3.close();
            fw3.close();
        } catch (IOException e) {
            e.printStackTrace();
            fw1.close();
            fw2.close();
            fw3.close();
        }
    }

    @FXML
    void btnStatick(ActionEvent event) {
        txtAmountGame.setVisible(true);
        txtProcentWin.setVisible(true);
        amountProcent.setVisible(true);
        amountGame.setVisible(true);
        txtAmountPobed.setVisible(true);
        gamesAllPobed.setVisible(true);
    }
    @FXML
    void btnCancel(ActionEvent event) {
        System.exit(0);
    }

}


/*
сколько всего нажатий, процент побед - сохранять эти данные
победное окно - открыть, закрыть по нажатию на кнопку
 */
