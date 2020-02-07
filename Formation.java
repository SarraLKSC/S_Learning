package sample;

import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.LinkedList;
import java.util.ResourceBundle;

public class Formation extends Application implements Initializable {
    public Label grandtitre;
    public Label grandcode;
    public static String title;
    public String url;
    public static String code;
    public static int modif;
    public Label grandurl;
    public Hyperlink chap2;
    public Hyperlink chap3;
    public Hyperlink chap4;
    public Hyperlink chap5;
    public Hyperlink chap6;
    public Hyperlink chap7;
    public Pane ajoutpane;
    public TextField mail;
    public TextField pass;
    public FontAwesomeIcon newTest;
    public FontAwesomeIcon newChap;
    public Hyperlink testlink;
    public Pane response;
    public TextField studentnumber;
    public Label rep1;
    public Label rep2;
    public Label rep3;
    public Label rep4;
    public Label rep5;
    public Label rep6;
    public Label rep7;
    public Label rep8;
    public Label rep9;
    public Label rep10;
    public Label name;




    public static void main(String[] args) {
        launch(args);

        System.out.println(Formation.CountChapters(code));
    }
    @Override

    public void start(Stage primarystage) throws Exception {
       Parent root = FXMLLoader.load(getClass().getResource("Formation.fxml"));
        primarystage.setTitle("Learning Space");
        primarystage.setScene(new Scene(root));
        primarystage.show();
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        if(modif==1){newChap.setVisible(false); newTest.setVisible(false);}
        chap2.setVisible(false);chap3.setVisible(false);chap4.setVisible(false);chap5.setVisible(false);chap6.setVisible(false);chap7.setVisible(false);

        ajoutpane.setVisible(false);

        switch(Formation.CountChapters(code)){
            case 2: chap2.setVisible(true);break;
            case 3:chap2.setVisible(true);chap3.setVisible(true); break;
            case 4:chap2.setVisible(true);chap3.setVisible(true);chap4.setVisible(true); break;
            case 5:chap2.setVisible(true);chap3.setVisible(true);chap4.setVisible(true);chap5.setVisible(true); break;
            case 6:chap2.setVisible(true);chap3.setVisible(true);chap4.setVisible(true);chap5.setVisible(true);chap6.setVisible(true); break;
            case 7:chap2.setVisible(true);chap3.setVisible(true);chap4.setVisible(true);chap5.setVisible(true);chap6.setVisible(true);chap7.setVisible(true); break;
        }

        try {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            String path = "C:\\Users\\user\\IdeaProjects\\S-Learning\\src\\sample\\Database11.accdb";
            String url_ = "jdbc:ucanaccess://" + path;
            Connection con = DriverManager.getConnection(url_);
            Statement stt = con.createStatement();
            ResultSet rs = stt.executeQuery("Select * from Formation");

                    while (rs.next()) {
                        if(rs.getString("code").equals(code))  {
                            grandtitre.setText(rs.getString("titre"));
                            grandcode.setText(code);
                        }
                        }

            ResultSet rss=stt.executeQuery("SELECT * from Test");
            boolean b= false;
                while(rss.next()&&(!b)){
                    if(rss.getString("formation").equals(code)){  testlink.setVisible(true); b=true;    }
                }

        } catch (ClassNotFoundException e1) {
            e1.printStackTrace();
            System.out.println(" erreur ");
        } catch (SQLException e1) {
            e1.printStackTrace();      System.out.println(" erreur 2");

        }

    }

    public void chapter1(MouseEvent mouseEvent) {

        try {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            String path = "C:\\Users\\user\\IdeaProjects\\S-Learning\\src\\sample\\Database11.accdb";
            String url_ = "jdbc:ucanaccess://" + path;
            Connection con = DriverManager.getConnection(url_);
            Statement stt = con.createStatement();

            ResultSet rs=stt.executeQuery("SELECT * from Chapitre");
            while(rs.next()){
                if(rs.getString("Formation").equals(code)&&rs.getString("titre").equals("Chapitre1")){
                    grandurl.setText(rs.getString("url"));
                    File file = new File(rightpath(rs.getString("url")));

                    //first check if Desktop is supported by Platform or not
                    if(!Desktop.isDesktopSupported()){
                        System.out.println("Desktop is not supported");
                        return;
                    }

                    Desktop desktop = Desktop.getDesktop();
                    if(file.exists()) desktop.open(file);

                    //let's try to open PDF file
                    file = new File("/Users/pankaj/java.pdf");
                    if(file.exists()) desktop.open(file);
                }
            }

        } catch (ClassNotFoundException e1) {
            e1.printStackTrace();
            System.out.println(" erreur ");
        } catch (SQLException e1) {
            e1.printStackTrace();      System.out.println(" erreur 2");

        } //catch (IOException e) {
        catch (IOException e) {
            e.printStackTrace();
        }

       if(SignIn.droit==2){ Formation_Accueil.suivit.add("viewed Chapitre1");}
        //  e.printStackTrace();       }
    }

    public void chapter2(MouseEvent mouseEvent) {
        try {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            String path = "C:\\Users\\user\\IdeaProjects\\S-Learning\\src\\sample\\Database11.accdb";
            String url_ = "jdbc:ucanaccess://" + path;
            Connection con = DriverManager.getConnection(url_);
            Statement stt = con.createStatement();

            ResultSet rs=stt.executeQuery("SELECT * from Chapitre");
            while(rs.next()){
                if(rs.getString("Formation").equals(code)&&rs.getString("titre").equals("Chapitre2")){
                    grandurl.setText(rs.getString("url"));
                    File file = new File(rightpath(rs.getString("url")));

                    if(!Desktop.isDesktopSupported()){
                        System.out.println("Desktop is not supportedd");
                        return;
                    }

                    Desktop desktop = Desktop.getDesktop();
                    if(file.exists()) desktop.open(file);

                    //let's try to open PDF file
                    file = new File("/Users/pankaj/java.pdf");
                    if(file.exists()) desktop.open(file);
                }
            }
        } catch (ClassNotFoundException e1) {
            e1.printStackTrace();
            System.out.println(" erreur ");
        } catch (SQLException e1) {
            e1.printStackTrace();      System.out.println(" erreur 2");

        } catch (IOException e) {
            e.printStackTrace();
        }
        if(SignIn.droit==2){Formation_Accueil.suivit.add("Viewed Chapitre2");}

    }

    public void chapter3(MouseEvent mouseEvent) {
        try {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            String path = "C:\\Users\\user\\IdeaProjects\\S-Learning\\src\\sample\\Database11.accdb";
            String url_ = "jdbc:ucanaccess://" + path;
            Connection con = DriverManager.getConnection(url_);
            Statement stt = con.createStatement();

            ResultSet rs=stt.executeQuery("SELECT * from Chapitre");
            while(rs.next()){
                if(rs.getString("Formation").equals(code)&&rs.getString("titre").equals("Chapitre3")){
                    grandurl.setText(rs.getString("url"));
                    File file = new File(rightpath(rs.getString("url")));

                    //first check if Desktop is supported by Platform or not
                    if(!Desktop.isDesktopSupported()){
                        System.out.println("Desktop is not supportedddd");
                        return;
                    }

                    Desktop desktop = Desktop.getDesktop();
                    if(file.exists()) desktop.open(file);

                    //let's try to open PDF file
                    file = new File("/Users/pankaj/java.pdf");
                    if(file.exists()) desktop.open(file);
                }
            }
        } catch (ClassNotFoundException e1) {
            e1.printStackTrace();
            System.out.println(" erreur ");
        } catch (SQLException e1) {
            e1.printStackTrace();      System.out.println(" erreur 2");

        } catch (IOException e) {
            e.printStackTrace();
        }
        if(SignIn.droit==2){    Formation_Accueil.suivit.add(" Viewed Chapitre3 ");}

    }

    public void chapter4(MouseEvent mouseEvent) {
        try {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            String path = "C:\\Users\\user\\IdeaProjects\\S-Learning\\src\\sample\\Database11.accdb";
            String url_ = "jdbc:ucanaccess://" + path;
            Connection con = DriverManager.getConnection(url_);
            Statement stt = con.createStatement();

            ResultSet rs=stt.executeQuery("SELECT * from Chapitre");
            while(rs.next()){
                if(rs.getString("Formation").equals(code)&&rs.getString("titre").equals("Chapitre4")){
                    grandurl.setText(rs.getString("url"));
                    File file = new File(rightpath(rs.getString("url")));

                    //first check if Desktop is supported by Platform or not
                    if(!Desktop.isDesktopSupported()){
                        System.out.println("Desktop is not supportedddd");
                        return;
                    }
                    System.out.println("");
                    Desktop desktop = Desktop.getDesktop();
                    if(file.exists()) desktop.open(file);

                    //let's try to open PDF file
                    file = new File("/Users/pankaj/java.pdf");
                    if(file.exists()) desktop.open(file);
                }
            }
        } catch (ClassNotFoundException e1) {
            e1.printStackTrace();
            System.out.println(" erreur ");
        } catch (SQLException e1) {
            e1.printStackTrace();      System.out.println(" erreur 2");

        } catch (IOException e) {
            e.printStackTrace();
        }
        if(SignIn.droit==2){    Formation_Accueil.suivit.add(" Viewed Chapitre4  ");}

    }

    public void chapter5(MouseEvent mouseEvent) {
        try {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            String path = "C:\\Users\\user\\IdeaProjects\\S-Learning\\src\\sample\\Database11.accdb";
            String url_ = "jdbc:ucanaccess://" + path;
            Connection con = DriverManager.getConnection(url_);
            Statement stt = con.createStatement();

            ResultSet rs=stt.executeQuery("SELECT * from Chapitre");
            while(rs.next()){
                if(rs.getString("Formation").equals(code)&&rs.getString("titre").equals("Chapitre5")){
                    grandurl.setText(rs.getString("url"));
                    File file = new File(rightpath(rs.getString("url")));
                       int mo;
                    //first check if Desktop is supported by Platform or not
                    if(!Desktop.isDesktopSupported()){
                        System.out.println("Desktop is not supportedddd");
                        return;
                    }

                    Desktop desktop = Desktop.getDesktop();
                    if(file.exists()) desktop.open(file);

                    //let's try to open PDF file
                    file = new File("/Users/pankaj/java.pdf");
                    if(file.exists()) desktop.open(file);
                }
            }
        } catch (ClassNotFoundException e1) {
            e1.printStackTrace();
            System.out.println(" erreur ");
        } catch (SQLException e1) {
            e1.printStackTrace();      System.out.println(" erreur 2");

        } catch (IOException e) {
            e.printStackTrace();
        }
        if(SignIn.droit==2){    Formation_Accueil.suivit.add("  viewed Chapitre5  ");}

    }

    public void chapter6(MouseEvent mouseEvent) {
        try {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            String path = "C:\\Users\\user\\IdeaProjects\\S-Learning\\src\\sample\\Database11.accdb";
            String url_ = "jdbc:ucanaccess://" + path;
            Connection con = DriverManager.getConnection(url_);
            Statement stt = con.createStatement();

            ResultSet rs=stt.executeQuery("SELECT * from Chapitre");
            while(rs.next()){
                if(rs.getString("Formation").equals(code)&&rs.getString("titre").equals("Chapitre6")){
                    grandurl.setText(rs.getString("url"));
                    File file = new File(rightpath(rs.getString("url")));

                    //first check if Desktop is supported by Platform or not
                    if(!Desktop.isDesktopSupported()){
                        System.out.println("Desktop is not supporte");
                        return;
                    }

                    Desktop desktop = Desktop.getDesktop();
                    if(file.exists()) desktop.open(file);

                    //let's try to open PDF file
                    file = new File("/Users/pankaj/java.pdf");
                    if(file.exists()) desktop.open(file);
                }
            }
        } catch (ClassNotFoundException e1) {
            e1.printStackTrace();
            System.out.println(" erreur ");
        } catch (SQLException e1) {
            e1.printStackTrace();      System.out.println(" erreur 2");

        } catch (IOException e) {
            e.printStackTrace();
        }
        if(SignIn.droit==2){    Formation_Accueil.suivit.add("  viewed Chapitre6  ");}

    }

    public void chapter7(MouseEvent mouseEvent) {
        try {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            String path = "C:\\Users\\user\\IdeaProjects\\S-Learning\\src\\sample\\Database11.accdb";
            String url_ = "jdbc:ucanaccess://" + path;
            Connection con = DriverManager.getConnection(url_);
            Statement stt = con.createStatement();

            ResultSet rs=stt.executeQuery("SELECT * from Chapitre");
            while(rs.next()){
                if(rs.getString("Formation").equals(code)&&rs.getString("titre").equals("Chapitre7")){
                    grandurl.setText(rs.getString("url"));
                    File file = new File(rightpath(rs.getString("url")));

                    //first check if Desktop is supported by Platform or not
                    if(!Desktop.isDesktopSupported()){
                        System.out.println("Desktop is not supported.");
                        return;
                    }

                    Desktop desktop = Desktop.getDesktop();
                    if(file.exists()) desktop.open(file);

                    //let's try to open PDF file
                    file = new File("/Users/pankaj/java.pdf");
                    if(file.exists()) desktop.open(file);
                }
            }
        } catch (ClassNotFoundException e1) {
            e1.printStackTrace();
            System.out.println(" erreur ");
        } catch (SQLException e1) {
            e1.printStackTrace();      System.out.println(" erreur 2");

        } catch (IOException e) {
            e.printStackTrace();
        }
        if(SignIn.droit==2){    Formation_Accueil.suivit.add("  viewed Chapitre7  ");}

    }

    public void addchapter(MouseEvent mouseEvent) {ajoutpane.setVisible(true); }

    public void addtest(MouseEvent mouseEvent) throws IOException {
       Test.formation=code;
        Parent root = FXMLLoader.load(getClass().getResource("Test.fxml"));
        Test.primarystage.setTitle("Test");
        Test.primarystage.setScene(new Scene(root));
        Test.primarystage.show();
    }

    public void backback(MouseEvent mouseEvent) {
    }

    public static int CountChapters(String code){
        int cpt=0;
        try {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            String path = "C:\\Users\\user\\IdeaProjects\\S-Learning\\src\\sample\\Database11.accdb";
            String url_ = "jdbc:ucanaccess://" + path;
            Connection con = DriverManager.getConnection(url_);
            Statement stt = con.createStatement();

            ResultSet rs=stt.executeQuery("SELECT * from Chapitre");
            while(rs.next()){
                if(rs.getString("Formation").equals(code)){cpt++;}
            }
        } catch (ClassNotFoundException e1) {
            e1.printStackTrace();
            System.out.println(" erreur ");
        } catch (SQLException e1) {
            e1.printStackTrace();      System.out.println(" erreur 2");

        }
        return cpt;
    }


    public void browse(MouseEvent mouseEvent) {
        FileChooser fc=new FileChooser();
        fc.getExtensionFilters().add(new FileChooser.ExtensionFilter("PDF","*.pdf"));

        File f= fc.showOpenDialog(null);
        if(f!=null) {
            System.out.println("url    :  "+f.toURI().toString());
            url=f.toURI().toString();
        }
    }

    public void validate(MouseEvent mouseEvent) {
        //if (mail.getText().equals(SignIn.adr) && pass.getText().equals(SignIn.mdp)) {
            int cpt = Formation.CountChapters(code) + 1;
            try {
                Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
                String path = "C:\\Users\\user\\IdeaProjects\\S-Learning\\src\\sample\\Database11.accdb";
                String url_ = "jdbc:ucanaccess://" + path;
                Connection con = DriverManager.getConnection(url_);
                Statement stt = con.createStatement();

                PreparedStatement pstmt2 = (PreparedStatement) con.prepareStatement
                        ("insert into Chapitre" +
                                " values('" + url + "','Chapitre" + cpt + "','" + code + "')");

                //same for all statement

                pstmt2.executeUpdate();
                pstmt2.close();


            } catch (ClassNotFoundException e1) {
                e1.printStackTrace();
                System.out.println(" erreur ajout");
            } catch (SQLException e1) {
                e1.printStackTrace();
                System.out.println(" erreur ajout 2");
            }
        switch(Formation.CountChapters(code)){
            case 2: chap2.setVisible(true);break;
            case 3:chap3.setVisible(true); break;
            case 4:chap4.setVisible(true); break;
            case 5:chap5.setVisible(true); break;
            case 6:chap6.setVisible(true); break;
            case 7:chap7.setVisible(true); break;
        }
        ajoutpane.setVisible(false);
        }

    public void clicktest(MouseEvent mouseEvent) throws IOException {
           if(SignIn.droit==2){
            Test.formation=code;
            Parent root = FXMLLoader.load(getClass().getResource("Test.fxml"));
            Test.primarystage.setTitle("Test");
            Test.primarystage.setScene(new Scene(root));
            Test.primarystage.show();

            Formation_Accueil.suivit.add("  passed test for lesson : "+code);
           }
            if(SignIn.droit==1){response.setVisible(true);}

    }

    public String rightpath(String path){
        String str;

        str=path.substring(path.indexOf('C'));

        return str;
    }

    public void search(MouseEvent mouseEvent) {
        System.out.println(studentnumber.getText());
         try {
            String adr;
            String test;

            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            String path = "C:\\Users\\user\\IdeaProjects\\S-Learning\\src\\sample\\Database11.accdb";
            String url_ = "jdbc:ucanaccess://" + path;
            Connection con = DriverManager.getConnection(url_);
            Statement stt = con.createStatement();

            ResultSet rs=stt.executeQuery("SELECT * from Etudiant");
                boolean found_student=false;
            while(rs.next()){
                if(rs.getString("Matricule").equals(studentnumber.getText())){
                    adr=rs.getNString("adresse");
                    found_student=true;
                    System.out.println(adr);
                    name.setText(rs.getString("nom")+" "+rs.getString("prenom")+"'s answers :");


                    ResultSet rss=stt.executeQuery("SELECT * from Test");
                    boolean b=false;

                    while(!b){
                        while(rss.next()){
                            if(rss.getString("formation").equals(code)){
                                test=rss.getString("code");
                                System.out.println(test);
                               LinkedList<String> listQ=new LinkedList<>();
                                for (int i = 3; i <= 12; i++) { listQ.add(rss.getString(i));}
                                    switch (Test.getNbrQ(listQ)){
                                        case 1: rep2.setVisible(false);rep3.setVisible(false);rep4.setVisible(false);rep5.setVisible(false);
                                                rep6.setVisible(false);rep7.setVisible(false);rep8.setVisible(false);rep9.setVisible(false); rep10.setVisible(false);

                                        case 2:rep3.setVisible(false);rep4.setVisible(false);rep5.setVisible(false);
                                            rep6.setVisible(false);rep7.setVisible(false);rep8.setVisible(false);rep9.setVisible(false); rep10.setVisible(false);

                                        case 3: rep4.setVisible(false);rep5.setVisible(false);
                                            rep6.setVisible(false);rep7.setVisible(false);rep8.setVisible(false);rep9.setVisible(false); rep10.setVisible(false);

                                        case 4:rep5.setVisible(false);rep6.setVisible(false);rep7.setVisible(false);rep8.setVisible(false);rep9.setVisible(false);
                                        rep10.setVisible(false);

                                        case 5:rep6.setVisible(false);rep7.setVisible(false);rep8.setVisible(false);rep9.setVisible(false); rep10.setVisible(false);

                                        case 6:rep7.setVisible(false);rep8.setVisible(false);rep9.setVisible(false); rep10.setVisible(false);

                                        case 7:rep8.setVisible(false);rep9.setVisible(false); rep10.setVisible(false);

                                        case 8:rep9.setVisible(false); rep10.setVisible(false);

                                        case 9: rep10.setVisible(false);
                                    }


                                ResultSet rsss=stt.executeQuery("SELECT * from Reponses");
                                boolean a=false;

                                    while(rsss.next()&&(!a)){
                                        if(rsss.getString(1).equals(adr)){
                                            System.out.println(code);
                                            System.out.println(adr);
                                            rep1.setText("answer 1 :"+rsss.getString(3));
                                            rep2.setText("answer 2 :"+rsss.getString(4));
                                            rep3.setText("answer 3 :"+rsss.getString(5));
                                            rep4.setText("answer 4 :"+rsss.getString(6));
                                            rep5.setText("answer 5 :"+rsss.getString(7));
                                            rep6.setText("answer 6 :"+rsss.getString(8));
                                            rep7.setText("answer 7 :"+rsss.getString(9));
                                            rep8.setText("answer 8 :"+rsss.getString(10));
                                            rep9.setText("answer 9 :"+rsss.getString(11));
                                            rep10.setText("answer 10 :"+rsss.getString(12));

                                            System.out.println("  2   ");
                                            a=true;
                                        }}
                                        if(!a){rep1.setText("no answers found for student n°:"+studentnumber.getText());
                                            rep2.setVisible(false);rep3.setVisible(false);rep4.setVisible(false);rep5.setVisible(false);
                                            rep6.setVisible(false);rep7.setVisible(false);rep8.setVisible(false);rep9.setVisible(false); rep10.setVisible(false);}


                                b=true;
                            }
                        }}
                }
            }
          if(!found_student){name.setText("student not found "); rep1.setVisible(false); rep2.setVisible(false);rep3.setVisible(false);rep4.setVisible(false);
                         rep5.setVisible(false);rep6.setVisible(false);rep7.setVisible(false);rep8.setVisible(false);rep9.setVisible(false); rep10.setVisible(false);}


        } catch (ClassNotFoundException e1) {
            e1.printStackTrace();
            System.out.println(" erreur ");
        } catch (SQLException e1) {
            e1.printStackTrace();      System.out.println(" erreur 2");

        }
    }

    public void khebi(MouseEvent mouseEvent) {   response.setVisible(false); }


    //}
}
