package sample;

import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.awt.*;
import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.*;

public class Test extends Application implements Initializable {

    LinkedList <String> listQ =new LinkedList<>();

    public static LinkedList <Integer>  Ratio= new LinkedList <>();
    public static ArrayList<String> Valid= new ArrayList<>();
    public int nbrQ =1;

    public static String formation;
    public static String test;



    @FXML  private Label Qest1;
    @FXML  private Label Qest2;
    @FXML  private Label Qest3;
    @FXML  private Label Qest4;
    @FXML  private Label Qest5;
    @FXML  private Label Qest6;
    @FXML  private Label Qest7;
    @FXML  private Label Qest8;
    @FXML  private Label Qest9;
    @FXML  private Label Qest10;

    @FXML  private Pane Q1;
    @FXML  private TextField re1;
    @FXML  private TextField re2;
    @FXML  private TextField re3;
    @FXML  private TextField re4;
    @FXML  private TextField re5;
    @FXML  private TextField re6;
    @FXML  private TextField re7;
    @FXML  private TextField re8;
    @FXML  private TextField re9;
    @FXML  private TextField re10;

    @FXML  private RadioButton R1;

    @FXML  private Pane Q2;

    @FXML  private Pane Q3;

    @FXML  private Pane Q4;

    @FXML  private RadioButton R3;

    @FXML  private RadioButton R2;

    @FXML  private RadioButton R4;

    @FXML  private Pane Q5;

    @FXML  private Pane Q6;

    @FXML  private Pane Q7;

    @FXML  private RadioButton R5;

    @FXML  private RadioButton R6;

    @FXML  private RadioButton R7;


    @FXML  private Pane Q8;

    @FXML  private Pane Q9;

    @FXML  private Pane Q10;

    @FXML  private RadioButton R8;

    @FXML  private RadioButton R9;

    @FXML  private RadioButton R10;
    @FXML
    private FontAwesomeIcon Ad;

    @FXML
    private FontAwesomeIcon del;
    //TEST

    public static Stage primarystage=new Stage();


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ToggleGroup group = new ToggleGroup();
        R1.setToggleGroup(group);
        R2.setToggleGroup(group);
        R3.setToggleGroup(group);
        R4.setToggleGroup(group);
        R5.setToggleGroup(group);
        R6.setToggleGroup(group);
        R7.setToggleGroup(group);
        R8.setToggleGroup(group);
        R9.setToggleGroup(group);
        R10.setToggleGroup(group);

        if(SignIn.droit==2){
            Ad.setVisible(false); del.setVisible(false);
             try {
                Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
                String path = "C:\\Users\\user\\IdeaProjects\\S-Learning\\src\\sample\\Database11.accdb";
                String url_ = "jdbc:ucanaccess://" + path;
                Connection con = DriverManager.getConnection(url_);
                Statement stt = con.createStatement();
                System.out.println("rak f'Base de donnee");

                ResultSet rs=stt.executeQuery("SELECT * from Test");
                boolean b= false;
                while (!b) {
                    while (rs.next()) {
                        if (rs.getString("formation").equals(formation)) {
                                test=rs.getString("code");
                              for (int i = 3; i <= 12; i++) {
                                  listQ.add(rs.getString(i));
                                }

                           b = true;
                         }
                     }

                 }
              } catch (ClassNotFoundException e1) {
                    e1.printStackTrace();
                    System.out.println(" erreur ");
              } catch (SQLException e1) {
                   e1.printStackTrace();
                   System.out.println(" erreur 2");

              }
              Qest1.setText(listQ.get(0));

            switch (getNbrQ(listQ)) {
                  case 2: R2.setVisible(true); Qest2.setText(listQ.get(1)); break;

                  case 3: R2.setVisible(true);Qest2.setText(listQ.get(1)); R3.setVisible(true); Qest3.setText(listQ.get(2)); break;

                  case 4: R2.setVisible(true);Qest2.setText(listQ.get(1)); R3.setVisible(true); Qest3.setText(listQ.get(2));
                          R4.setVisible(true); Qest4.setText(listQ.get(3)); break;

                  case 5: R2.setVisible(true);Qest2.setText(listQ.get(1)); R3.setVisible(true); Qest3.setText(listQ.get(2));
                      R4.setVisible(true); Qest4.setText(listQ.get(3)); R5.setVisible(true); Qest5.setText(listQ.get(4)); break;

                  case 6: R2.setVisible(true);Qest2.setText(listQ.get(1)); R3.setVisible(true); Qest3.setText(listQ.get(2));
                      R4.setVisible(true); Qest4.setText(listQ.get(3)); R5.setVisible(true); Qest5.setText(listQ.get(4));
                      R6.setVisible(true); Qest6.setText(listQ.get(5)); break;

                  case 7:  R2.setVisible(true);Qest2.setText(listQ.get(1)); R3.setVisible(true); Qest3.setText(listQ.get(2));
                      R4.setVisible(true); Qest4.setText(listQ.get(3)); R5.setVisible(true); Qest5.setText(listQ.get(4));
                      R6.setVisible(true); Qest6.setText(listQ.get(5)); R7.setVisible(true); Qest7.setText(listQ.get(6)); break;


                  case 8:  R2.setVisible(true);Qest2.setText(listQ.get(1)); R3.setVisible(true); Qest3.setText(listQ.get(2));
                      R4.setVisible(true); Qest4.setText(listQ.get(3)); R5.setVisible(true); Qest5.setText(listQ.get(4));
                      R6.setVisible(true); Qest6.setText(listQ.get(5)); R7.setVisible(true); Qest7.setText(listQ.get(6));
                      R8.setVisible(true); Qest8.setText(listQ.get(7)); break;


                  case 9: R2.setVisible(true);Qest2.setText(listQ.get(1)); R3.setVisible(true); Qest3.setText(listQ.get(2));
                      R4.setVisible(true); Qest4.setText(listQ.get(3)); R5.setVisible(true); Qest5.setText(listQ.get(4));
                      R6.setVisible(true); Qest6.setText(listQ.get(5)); R7.setVisible(true); Qest7.setText(listQ.get(6));
                      R8.setVisible(true); Qest8.setText(listQ.get(7)); R9.setVisible(true); Qest9.setText(listQ.get(8)); break;


                  case 10: R2.setVisible(true);Qest2.setText(listQ.get(1)); R3.setVisible(true); Qest3.setText(listQ.get(2));
                      R4.setVisible(true); Qest4.setText(listQ.get(3)); R5.setVisible(true); Qest5.setText(listQ.get(4));
                      R6.setVisible(true); Qest6.setText(listQ.get(5)); R7.setVisible(true); Qest7.setText(listQ.get(6));
                      R8.setVisible(true); Qest8.setText(listQ.get(7)); R9.setVisible(true); Qest9.setText(listQ.get(8));
                      R10.setVisible(true); Qest10.setText(listQ.get(9)); break;

              }
             //SWITCH CASE POUR LA VISIBILITE DES RATIO
        }



    }

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("Test.fxml"));
        primarystage.initStyle(StageStyle.UNDECORATED);
        primarystage.setTitle("Hello World");
        primarystage.setScene(new Scene(root));
        primarystage.show();

    }
    // GESTION DE M'APPARiTION DES PANES PAR RATIO BUTTON
    public void R1(MouseEvent mouseEvent) { Ratio.addLast(1);
       Q1.setVisible(true); Q2.setVisible(false);Q3.setVisible(false); Q4.setVisible(false); Q5.setVisible(false);
       Q6.setVisible(false); Q7.setVisible(false); Q8.setVisible(false); Q9.setVisible(false); Q10.setVisible(false); }

    public void R2(MouseEvent mouseEvent) {Ratio.addLast(2);
        Q2.setVisible(true); Q1.setVisible(false);Q3.setVisible(false); Q4.setVisible(false); Q5.setVisible(false);
        Q6.setVisible(false); Q7.setVisible(false); Q8.setVisible(false); Q9.setVisible(false); Q10.setVisible(false); }

    public void R3(MouseEvent mouseEvent) {Ratio.addLast(3);
        Q3.setVisible(true); Q1.setVisible(false);Q2.setVisible(false); Q4.setVisible(false); Q5.setVisible(false);
        Q6.setVisible(false); Q7.setVisible(false); Q8.setVisible(false); Q9.setVisible(false); Q10.setVisible(false); }

    public void R4(MouseEvent mouseEvent) {Ratio.addLast(4);
        Q4.setVisible(true); Q1.setVisible(false);Q2.setVisible(false); Q3.setVisible(false); Q5.setVisible(false);
        Q6.setVisible(false); Q7.setVisible(false); Q8.setVisible(false); Q9.setVisible(false); Q10.setVisible(false); }

    public void R5(MouseEvent mouseEvent) {Ratio.addLast(5);
        Q5.setVisible(true); Q1.setVisible(false);Q2.setVisible(false); Q4.setVisible(false); Q3.setVisible(false);
        Q6.setVisible(false); Q7.setVisible(false); Q8.setVisible(false); Q9.setVisible(false); Q10.setVisible(false); }

    public void R6(MouseEvent mouseEvent) {Ratio.addLast(6);
        Q6.setVisible(true); Q1.setVisible(false);Q2.setVisible(false); Q4.setVisible(false); Q5.setVisible(false);
        Q3.setVisible(false); Q7.setVisible(false); Q8.setVisible(false); Q9.setVisible(false); Q10.setVisible(false); }

    public void R7(MouseEvent mouseEvent) {Ratio.addLast(7);
        Q7.setVisible(true);  Q1.setVisible(false);Q2.setVisible(false); Q4.setVisible(false); Q5.setVisible(false);
        Q6.setVisible(false); Q3.setVisible(false); Q8.setVisible(false); Q9.setVisible(false); Q10.setVisible(false);}

    public void R8(MouseEvent mouseEvent) {Ratio.addLast(8);
        Q8.setVisible(true);  Q1.setVisible(false);Q2.setVisible(false); Q4.setVisible(false); Q5.setVisible(false);
        Q6.setVisible(false); Q7.setVisible(false); Q3.setVisible(false); Q9.setVisible(false); Q10.setVisible(false);}
    public void R9(MouseEvent mouseEvent) {Ratio.addLast(9);
        Q9.setVisible(true);  Q1.setVisible(false);Q2.setVisible(false); Q4.setVisible(false); Q5.setVisible(false);
        Q6.setVisible(false); Q7.setVisible(false); Q8.setVisible(false); Q3.setVisible(false); Q10.setVisible(false);}
    public void R10(MouseEvent mouseEvent) {Ratio.addLast(10);
        Q10.setVisible(true); Q1.setVisible(false);Q2.setVisible(false); Q4.setVisible(false); Q5.setVisible(false);
        Q6.setVisible(false); Q7.setVisible(false); Q8.setVisible(false); Q9.setVisible(false); Q3.setVisible(false); }

   //SAUVEGARDE DES REPONSE
    public void V1(MouseEvent mouseEvent) {  if(SignIn.droit==2)  Valid.add(re1.getText()); else {Qest1.setText(re1.getText()); re1.clear(); listQ.addLast(Qest1.getText()); } }
    public void V2(MouseEvent mouseEvent) {  if(SignIn.droit==2)  Valid.add(re2.getText()); else {Qest2.setText(re2.getText()); re2.clear(); listQ.addLast(Qest2.getText());}}
    public void V3(MouseEvent mouseEvent) {  if(SignIn.droit==2)  Valid.add(re3.getText()); else {Qest3.setText(re3.getText()); re3.clear(); listQ.addLast(Qest3.getText());}}
    public void V4(MouseEvent mouseEvent) {  if(SignIn.droit==2)  Valid.add(re4.getText()); else {Qest4.setText(re4.getText()); re4.clear(); listQ.addLast(Qest4.getText());}}
    public void V5(MouseEvent mouseEvent) {  if(SignIn.droit==2)  Valid.add(re5.getText()); else {Qest5.setText(re5.getText()); re5.clear(); listQ.addLast(Qest5.getText());}}
    public void V6(MouseEvent mouseEvent) {  if(SignIn.droit==2)  Valid.add(re6.getText()); else {Qest6.setText(re6.getText()); re6.clear(); listQ.addLast(Qest6.getText());}}
    public void V7(MouseEvent mouseEvent) {  if(SignIn.droit==2)  Valid.add(re7.getText()); else {Qest7.setText(re7.getText()); re7.clear(); listQ.addLast(Qest7.getText());}}
    public void V8(MouseEvent mouseEvent) {  if(SignIn.droit==2)  Valid.add(re8.getText()); else {Qest8.setText(re8.getText()); re8.clear(); listQ.addLast(Qest8.getText());}}
    public void V9(MouseEvent mouseEvent) {  if(SignIn.droit==2)  Valid.add(re9.getText()); else {Qest9.setText(re9.getText()); re9.clear(); listQ.addLast(Qest9.getText());}}
    public void V10(MouseEvent mouseEvent){  if(SignIn.droit==2)  Valid.add(re10.getText()); else {Qest10.setText(re10.getText()); re10.clear(); listQ.addLast(Qest10.getText());}}



    public static void main(String[] args) {    launch(args);   }

    public void send(MouseEvent mouseEvent) throws IOException {
        if(SignIn.droit==2){Formation_Accueil.suivit.add(" and went through the question with the following order");}
        for(int i:Ratio){    System.out.println("  "+i);
                         if(SignIn.droit==2){Formation_Accueil.suivit.add(String.valueOf(i));}}

        for(int i=0;i<Valid.size();i++){
            System.out.println(" rep n°"+i+" "+Valid.get(i));
        }
         if(SignIn.droit==1){
             try {
                 Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
                 String path = "C:\\Users\\user\\IdeaProjects\\S-Learning\\src\\sample\\Database11.accdb";
                 String url_ = "jdbc:ucanaccess://" + path;
                 Connection con = DriverManager.getConnection(url_);
                 String code=formation+Main.getRandomNumberInRange(1,99);
                 switch(listQ.size()){
                     case 1: PreparedStatement pstmt1 = (PreparedStatement) con.prepareStatement
                             ("insert into Test " +
                                     " values('"+code+"','"+formation+"','"+listQ.get(0)+"','','','','','','','','','')");
                         pstmt1.executeUpdate();
                         pstmt1.close();
                         break;
                     case 2:  PreparedStatement pstmt2 = (PreparedStatement) con.prepareStatement
                             ("insert into Test " +
                                     " values('"+code+"','"+formation+"','"+listQ.get(0)+"','"+listQ.get(1)+"','','','','','','','','')");
                         pstmt2.executeUpdate();
                         pstmt2.close();
                         break;
                     case 3: PreparedStatement pstmt3 = (PreparedStatement) con.prepareStatement
                             ("insert into Test " +
                                     " values('"+code+"','"+formation+"','"+listQ.get(0)+"','"+listQ.get(1)+"','"+listQ.get(2)+"','','','','','','','')");
                         pstmt3.executeUpdate();
                         pstmt3.close(); break;
                     case 4:PreparedStatement pstmt4 = (PreparedStatement) con.prepareStatement
                             ("insert into Test" +
                                     " values('"+code+"','"+formation+"','"+listQ.get(0)+"','"+listQ.get(1)+"','"+listQ.get(2)+"','"+listQ.get(3)+"','','','','','','')");
                         pstmt4.executeUpdate();
                         pstmt4.close();  break;
                     case 5:PreparedStatement pstmt5 = (PreparedStatement) con.prepareStatement
                             ("insert into Test " +
                                     " values('"+code+"','"+formation+"','"+listQ.get(0)+"','"+listQ.get(1)+"','"+listQ.get(2)+"','"+listQ.get(3)+"','"+listQ.get(4)+"','','','','','')");
                         pstmt5.executeUpdate();
                         pstmt5.close(); break;
                     case 6: PreparedStatement pstmt6 = (PreparedStatement) con.prepareStatement
                             ("insert into Test " +
                                     " values('"+code+"','"+formation+"','"+listQ.get(0)+"','"+listQ.get(1)+"','"+listQ.get(2)+"','"+listQ.get(3)+"','"+listQ.get(4)+"','"+listQ.get(5)+"','','','','')");
                         pstmt6.executeUpdate();
                         pstmt6.close();break;
                     case 7:PreparedStatement pstmt7 = (PreparedStatement) con.prepareStatement
                             ("insert into Test" +
                                     " values('"+code+"','"+formation+"','"+listQ.get(0)+"','"+listQ.get(1)+"','"+listQ.get(2)+"','"+
                                     listQ.get(3)+"','"+listQ.get(4)+"','"+listQ.get(5)+"','"+listQ.get(6)+"','','','')");
                         pstmt7.executeUpdate();
                         pstmt7.close(); break;
                     case 8:PreparedStatement pstmt8 = (PreparedStatement) con.prepareStatement
                             ("insert into Test" +
                                     " values('"+code+"','"+formation+"','"+listQ.get(0)+"','"+listQ.get(1)+"','"+listQ.get(2)+"','"+
                                     listQ.get(3)+"','"+listQ.get(4)+"','"+listQ.get(5)+"','"+listQ.get(6)+"','"+listQ.get(7)+"','','')");
                         pstmt8.executeUpdate();
                         pstmt8.close(); break;
                     case 9:PreparedStatement pstmt9 = (PreparedStatement) con.prepareStatement
                             ("insert into Test" +
                                     " values('"+code+"','"+formation+"','"+listQ.get(0)+"','"+listQ.get(1)+"','"+listQ.get(2)+"','"+
                                     listQ.get(3)+"','"+listQ.get(4)+"','"+listQ.get(5)+"','"+listQ.get(6)+"','"+listQ.get(7)+"','"+listQ.get(8)+"','')");
                         pstmt9.executeUpdate();
                         pstmt9.close(); break;
                     case 10:PreparedStatement pstmt10 = (PreparedStatement) con.prepareStatement
                             ("insert into Test" +
                                     " values('"+code+"','"+formation+"','"+listQ.get(0)+"','"+listQ.get(1)+"','"+listQ.get(2)+"','"+
                                     listQ.get(3)+"','"+listQ.get(4)+"','"+listQ.get(5)+"','"+listQ.get(6)+"','"+listQ.get(7)+"','"+listQ.get(8)+"','"+listQ.get(9)+"')");
                         pstmt10.executeUpdate();
                         pstmt10.close();  break;

                 }





             } catch (ClassNotFoundException e1) {
                 e1.printStackTrace();
                 System.out.println(" erreur ");
             } catch (SQLException e1) {
                 e1.printStackTrace();      System.out.println(" erreur 2");

             }
        for(String s:listQ){
            System.out.println(" Question "+s);
        }}

        if(SignIn.droit==2){

            try {
                Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
                String path = "C:\\Users\\user\\IdeaProjects\\S-Learning\\src\\sample\\Database11.accdb";
                String url_ = "jdbc:ucanaccess://" + path;
                Connection con = DriverManager.getConnection(url_);
                String code=SignIn.adr;
                switch(getNbrQ(listQ)){
                    case 1: PreparedStatement pstmt1 = (PreparedStatement) con.prepareStatement
                            ("insert into Reponses " +
                                    " values('"+code+"','"+test+"','"+Valid.get(0)+"','','','','','','','','','')");
                        pstmt1.executeUpdate();
                        pstmt1.close();
                        break;
                    case 2:  PreparedStatement pstmt2 = (PreparedStatement) con.prepareStatement
                            ("insert into Reponses " +
                                    " values('"+code+"','"+test+"','"+Valid.get(0)+"','"+Valid.get(1)+"','','','','','','','','')");
                        pstmt2.executeUpdate();
                        pstmt2.close();
                        break;
                    case 3: PreparedStatement pstmt3 = (PreparedStatement) con.prepareStatement
                            ("insert into Reponses " +
                                    " values('"+code+"','"+test+"','"+Valid.get(0)+"','"+Valid.get(1)+"','"+Valid.get(2)+"','','','','','','','')");
                        pstmt3.executeUpdate();
                        pstmt3.close(); break;
                    case 4:PreparedStatement pstmt4 = (PreparedStatement) con.prepareStatement
                            ("insert into Reponses" +
                                    " values('"+code+"','"+test+"','"+Valid.get(0)+"','"+Valid.get(1)+"','"+Valid.get(2)+"','"+Valid.get(3)+"','','','','','','')");
                        pstmt4.executeUpdate();
                        pstmt4.close();  break;
                    case 5:PreparedStatement pstmt5 = (PreparedStatement) con.prepareStatement
                            ("insert into Reponses " +
                                    " values('"+code+"','"+test+"','"+Valid.get(0)+"','"+Valid.get(1)+"','"+Valid.get(2)+"','"+Valid.get(3)+"','"+Valid.get(4)+"','','','','','')");
                        pstmt5.executeUpdate();
                        pstmt5.close(); break;
                    case 6: PreparedStatement pstmt6 = (PreparedStatement) con.prepareStatement
                            ("insert into Reponses " +
                                    " values('"+code+"','"+test+"','"+Valid.get(0)+"','"+Valid.get(1)+"','"+Valid.get(2)+"','"+Valid.get(3)+"','"+Valid.get(4)+"','"+Valid.get(5)+"','','','','')");
                        pstmt6.executeUpdate();
                        pstmt6.close();break;
                    case 7:PreparedStatement pstmt7 = (PreparedStatement) con.prepareStatement
                            ("insert into Reponses" +
                                    " values('"+code+"','"+test+"','"+Valid.get(0)+"','"+Valid.get(1)+"','"+Valid.get(2)+"','"+
                                    Valid.get(3)+"','"+Valid.get(4)+"','"+Valid.get(5)+"','"+Valid.get(6)+"','','','')");
                        pstmt7.executeUpdate();
                        pstmt7.close(); break;
                    case 8:PreparedStatement pstmt8 = (PreparedStatement) con.prepareStatement
                            ("insert into Reponses" +
                                    " values('"+code+"','"+test+"','"+Valid.get(0)+"','"+Valid.get(1)+"','"+Valid.get(2)+"','"+
                                    Valid.get(3)+"','"+Valid.get(4)+"','"+Valid.get(5)+"','"+Valid.get(6)+"','"+Valid.get(7)+"','','')");
                        pstmt8.executeUpdate();
                        pstmt8.close(); break;
                    case 9:PreparedStatement pstmt9 = (PreparedStatement) con.prepareStatement
                            ("insert into Reponses" +
                                    " values('"+code+"','"+test+"','"+Valid.get(0)+"','"+Valid.get(1)+"','"+Valid.get(2)+"','"+
                                    Valid.get(3)+"','"+Valid.get(4)+"','"+Valid.get(5)+"','"+Valid.get(6)+"','"+Valid.get(7)+"','"+Valid.get(8)+"','')");
                        pstmt9.executeUpdate();
                        pstmt9.close(); break;
                    case 10:PreparedStatement pstmt10 = (PreparedStatement) con.prepareStatement
                            ("insert into Reponses" +
                                    " values('"+code+"','"+test+"','"+Valid.get(0)+"','"+Valid.get(1)+"','"+Valid.get(2)+"','"+
                                    listQ.get(3)+"','"+Valid.get(4)+"','"+Valid.get(5)+"','"+Valid.get(6)+"','"+Valid.get(7)+"','"+Valid.get(8)+"','"+Valid.get(9)+"')");
                        pstmt10.executeUpdate();
                        pstmt10.close();  break;

                }





            } catch (ClassNotFoundException e1) {
                e1.printStackTrace();
                System.out.println(" erreur ");
            } catch (SQLException e1) {
                e1.printStackTrace();      System.out.println(" erreur 2");

            }

        }

          primarystage.close();
    }

    public void Cancel(MouseEvent mouseEvent) { if(SignIn.droit==2){Formation_Accueil.suivit.add(" then canceled ");} primarystage.close(); }

    public void Add(MouseEvent mouseEvent) {
        switch (nbrQ){
            case 1: R2.setVisible(true); nbrQ++; break;
            case 2: R3.setVisible(true); nbrQ++; break;
            case 3: R4.setVisible(true); nbrQ++; break;
            case 4: R5.setVisible(true); nbrQ++; break;
            case 5: R6.setVisible(true); nbrQ++; break;
            case 6: R7.setVisible(true); nbrQ++; break;
            case 7: R8.setVisible(true); nbrQ++; break;
            case 8: R9.setVisible(true); nbrQ++; break;
            case 9: R10.setVisible(true); nbrQ++; break;
        }
    }

    public void Delete(MouseEvent mouseEvent) {
        switch (nbrQ){
            case 2: R2.setVisible(false); nbrQ--; break;
            case 3: R3.setVisible(false); nbrQ--; break;
            case 4: R4.setVisible(false); nbrQ--; break;
            case 5: R5.setVisible(false); nbrQ--; break;
            case 6: R6.setVisible(false); nbrQ--; break;
            case 7: R7.setVisible(false); nbrQ--; break;
            case 8: R8.setVisible(false); nbrQ--; break;
            case 9: R9.setVisible(false); nbrQ--; break;
            case 10: R10.setVisible(false); nbrQ--; break;
        }
        listQ.remove(nbrQ);
    }

    public static int getNbrQ(LinkedList<String> liste){
        int a=0;
                while(!liste.get(a).equals("")){a++;}
        return a;
    }

}
