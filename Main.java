package sample;

import javafx.application.Application;
import javafx.stage.Stage;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Random;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

public class Main extends Application {

    public static String correctstring(String summary){
        if(summary.contains("'")){
            String str_=summary.substring(0,summary.indexOf("'"));
            String str__=summary.substring(summary.indexOf("'")+1);
            return (str_+str__);
        }
        return summary;
    }

    public static int getRandomNumberInRange(int min, int max) {

        if (min >= max) {
            throw new IllegalArgumentException("max must be greater than min");
        }

        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;
    }
@Override
    public void start(Stage stage) throws Exception {

    }
}

/*

    public static String correctstring(String summary){
        if(summary.contains("'")){
            String str_=summary.substring(0,summary.indexOf("'"));
            String str__=summary.substring(summary.indexOf("'")+1);
            return (str_+str__);
        }
        return summary;
    }

    public static int getRandomNumberInRange(int min, int max) {

        if (min >= max) {
            throw new IllegalArgumentException("max must be greater than min");
        }

        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;
    }



  /*  public static void main(String[] args) throws IOException {
        SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat formatter1= new SimpleDateFormat("HH:mm:ss ");

        // '#' HH:mm:ss  '#' z
        Date date = new Date(System.currentTimeMillis());
        System.out.println(formatter.format(date));
        System.out.println(formatter1.format(date));

        String str="#2#NI78E#5#chapitre1#5#chapitre2#3#NI78E#7#8451#4#";
        String[] cypher = new String[8];
        cypher[1]="  searcher for lesson n° ";
        cypher[2]="  entered lesson n° ";
        cypher[3]="  passed test for lesson n° ";
        cypher[4]=" then exited the section ";
        cypher[5]="  viewed ";
        cypher[6]="  then canceled ";
        cypher[7]="  and went through the questions with the following order : ";
        String result="";
        String tmp="";
        String tmp2="";


}*/
