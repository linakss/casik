package lin.online.casik;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.*;
import javafx.scene.text.TextFlow;

public class MainController {
    @FXML
    private void initialize(){
        Font font = Font.loadFont(getClass().getResourceAsStream("BeroldRegular.otf"), 50);
        welcomeText.setFont(font);
    }



    @FXML
    private AnchorPane backfon;

    @FXML
    private Button btnCancel;

    @FXML
    private Button btnPlay;

    @FXML
    private Button btnStatic;

    @FXML
    private TextFlow numberOne;

    @FXML
    private TextFlow numberThree;

    @FXML
    private TextFlow numberTwo;

    @FXML
    private Text txtChislNajatiy;

    @FXML
    private Text txtChislProcent;

    @FXML
    private Text txtNajatiy;

    @FXML
    private Text txtProcent;

    @FXML
    private Label welcomeText;

    @FXML
    void btnCancel(ActionEvent event) {
        System.exit(0);
    }

    @FXML
    void btnPlay(ActionEvent event) {


    }

    @FXML
    void btnStatic(ActionEvent event) {

    }

}

/*
сколько всего нажатий
сколько всего побед
процент побед
3 случайных числа
данные должны изначально быть спрятаны
когда нажмут на кнопку - показаться

 */


/*
    * Шаг 1: Скачайте и сохраните нужный вам шрифт на вашем компьютере. Обычно шрифты поставляются в формате .ttf или .otf

Шаг 2: Создайте папку «resources» в корневой директории вашего проекта, если она еще не создана

Шаг 3: Переместите файл шрифта в созданную папку «resources»

Шаг 4: В вашем Java-коде достаньте шрифт из папки ресурсов и установите его для нужных элементов пользовательского интерфейса. Например, если вы хотите использовать
шрифт для надписи, используйте следующий код:

Font font = Font.loadFont(getClass().getResourceAsStream("/resources/font.ttf"), 12);

label.setFont(font);

Здесь «/resources/font.ttf» — это путь к файлу шрифта в папке ресурсов, а «label» — это элемент пользовательского интерфейса, для которого вы хотите установить шрифт.

Шаг 5: Запустите ваше приложение и проверьте, что шрифт успешно применяется к нужным элементам интерфейса.
Источник: https://uchet-jkh.ru/i/javafx-kak-ustanovit-srift*/
