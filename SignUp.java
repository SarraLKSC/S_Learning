package sample;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.image.ImageView;
import javafx.scene.image.Image;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.sql.*;


public class SignUp extends Application implements Initializable {

    @FXML
    ImageView Picture;
    @FXML
    private TextField Lastname;

    @FXML
    private TextField Matricule;

    @FXML
    private PasswordField passs;

    @FXML
    private  PasswordField pass;

    @FXML
    private TextField Firstname;

    @FXML
    private ChoiceBox Time;

    @FXML
    private  ChoiceBox Language;
    @FXML
    private Pane pane1;

    @FXML
    private Pane jesaispas;

    @FXML
    private ChoiceBox nomdutruc;

    @FXML
    private Label email1;
    @FXML
    private Pane pane;

    @FXML
    private Label email;

    @FXML
    private ChoiceBox Major;

    @FXML
    private ChoiceBox Section;

    @FXML
    private RadioButton td;

    @FXML private ChoiceBox year;
    @FXML
    private Label Warning;
    @FXML
    private RadioButton std;
    @FXML
    private Pane STUDENT;
    private boolean b=false;
    private boolean c=false;
    private boolean a=false;
    private boolean y=false;
    public static String nom,sp,sec,mat,mdp,d,annee;
    public static String prenom;
    public static boolean student;
    public String ima;

    @Override
    public void start(Stage primarystage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("Sign_Up_.fxml"));
        primarystage.setTitle("Hello World");
        primarystage.setScene(new Scene(root, 300, 275));
        primarystage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }



    public void Browse(MouseEvent mouseEvent) throws IOException {
        FileChooser fc=new FileChooser();
        fc.getExtensionFilters().add(new FileChooser.ExtensionFilter("Image PNG","*.png"));
        fc.getExtensionFilters().add(new FileChooser.ExtensionFilter("Image JPEG","*.jpeg"));

        File f= fc.showOpenDialog(null);
        if(f!=null) {
           Image im= new Image(f.toURI().toString());
           ima=f.toURI().toString();
           Picture.setImage(im);
        }
    }

    public void Student(MouseEvent mouseEvent) {
        jesaispas.setVisible(false);
        SignUp.student=true;
        ToggleGroup group = new ToggleGroup();
        td.setToggleGroup(group);
        std.setToggleGroup(group);
        std.setSelected(true);

        STUDENT.setVisible(true);

        if(!c){
            Major.getItems().addAll("ISIL","ACAD","GTR","MIV","SII","SSI");
            Section.getItems().addAll("A","B");
            c=true;        }
        if(!b){
        Language.getItems().addAll("Français","English");
        Time.getItems().addAll("GMT","GMT+1");
        b=true;}

        if(!y){
            year.getItems().addAll("L2","L3","M1","M2");
            y=true;        }

    }
    public void Teacher(MouseEvent mouseEvent) {
        SignUp.student=false;
        STUDENT.setVisible(false);
        if(!b){
        Language.getItems().addAll("Français","English");
        Time.getItems().addAll("GMT","GMT+1");
        b=true;}
        if(!a){
           nomdutruc.getItems().addAll("IA","IMG","SIBD","WEB","MOBILE");
           jesaispas.setVisible(true);
            a=true; }

    }

    public void Next(MouseEvent mouseEvent) throws IOException {

         nom=Lastname.getText();  prenom=Firstname.getText();
        System.out.println(nom+prenom);
         if(SignUp.student){
              SignUp.mat=Matricule.getText();
               SignUp.sec=Section.getSelectionModel().getSelectedItem().toString();
             System.out.println(SignUp.sec);
               SignUp.sp=Major.getSelectionModel().getSelectedItem().toString();
             System.out.println(SignUp.sp);
               SignUp.annee=year.getSelectionModel().getSelectedItem().toString();
         }
         else{ SignUp.d=nomdutruc.getSelectionModel().getSelectedItem().toString();}
        Parent root = FXMLLoader.load(getClass().getResource("Sign_Up_.fxml"));
        SignIn.stage.setTitle("Computer Science Learning");
        SignIn.stage.setScene(new Scene(root));
        SignIn.stage.show();


    }


    public void signup(MouseEvent mouseEvent) {
        Warning.setVisible(false);
        mdp=pass.getText();
        if(pass.getText().equals(passs.getText()))
        {
            if(SignUp.student) {
            Etudiant e = new Etudiant(sp, sec, nom, "etd." + nom + "." + prenom + "@csl.com", prenom, mat,
              //      Language.getSelectionModel().getSelectedItem().toString(), Time.getSelectionModel().getSelectedItem().toString(), pass.getText());
                    "","","");
                e.setImage(ima);
            try {
                String mail = "etd." + SignUp.nom + "." + SignUp.prenom + "@csl.com";
                Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
                String path = "C:\\Users\\user\\IdeaProjects\\S-Learning\\src\\sample\\Database11.accdb";
                String url = "jdbc:ucanaccess://" + path;
                Connection con = DriverManager.getConnection(url);
                Statement stt = con.createStatement();
                ResultSet rs = stt.executeQuery("Select * from Etudiant");
                boolean exist=false;
                while (rs.next()) {
                    if(rs.getString("adresse").equals(mail)){exist=true;}
                }
                if(exist){ pane1.setVisible(true); email1.setText("AN ACCOUNT ALREADY EXISTS");}
                    else{
                Ajout(2,e);
                pane.setVisible(true);
                email.setText(mail);}
            } catch (ClassNotFoundException e1) {
                e1.printStackTrace();
                System.out.println(" erreur ajout");
            } catch (SQLException e1) {
                e1.printStackTrace();      System.out.println(" erreur ajout 2");

            }
        }
            else {
                Enseignant e = new Enseignant( nom,  prenom,"","","", "", "", "");
                System.out.println(d);
                    e.setImage(ima);

                try {
                    String mail = "ens." + SignUp.nom + "." + SignUp.prenom + "@csl.com";
                    Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
                    String path = "C:\\Users\\user\\IdeaProjects\\S-Learning\\src\\sample\\Database11.accdb";
                    String url = "jdbc:ucanaccess://" + path;
                    Connection con = DriverManager.getConnection(url);
                    Statement stt = con.createStatement();
                    ResultSet rs = stt.executeQuery("Select * from Enseignant");
                    boolean exist=false;
                    while (rs.next()) {

                        if(rs.getString("adresse").equals(mail)){exist=true;}
                    }
                    if(exist){ pane1.setVisible(true); email1.setText("AN ACCOUNT ALREADY EXISTS ");}
                    else{
                    Ajout(1,e);
                    pane.setVisible(true);
                    email.setText("ens."+SignUp.nom+"."+SignUp.prenom+"@csl.com");}
                } catch (ClassNotFoundException e1) {
                    e1.printStackTrace();
                    System.out.println(" erreur ajout");
                } catch (SQLException e1) {
                    e1.printStackTrace();      System.out.println(" erreur ajout 2");

                }
        }

        }
        else Warning.setVisible(true);
    }

    private void Ajout(int i, User e) throws ClassNotFoundException, SQLException {
        Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
        String path = "C:\\Users\\user\\IdeaProjects\\S-Learning\\src\\sample\\Database11.accdb";
        String url = "jdbc:ucanaccess://" + path;
        Connection con = DriverManager.getConnection(url);
        Statement st = con.createStatement();
        if(i==2) {
            String mail = "etd." + SignUp.nom + "." + SignUp.prenom + "@csl.com";



             PreparedStatement pstmt = (PreparedStatement) con.prepareStatement
                    ("insert into Etudiant" +
                            " values("+mat+",'"+nom+"','"+prenom+"','"+SignUp.sp+"','"+SignUp.sec+"','"+ima+"','"+mail+"','"+pass.getText()+"','"+SignUp.annee+"')");


            //same for all statement
            pstmt.executeUpdate();
            pstmt.close();

            Statement stt = con.createStatement();
            ResultSet rs = stt.executeQuery("Select * from Etudiant");
            while (rs.next()) {
                while (rs.next()) {
                    System.out.println(rs.getString("nom"));
                    System.out.println("" + rs.getString("prenom"));

                }
            }
        }
        else if (i==1){
            String mail = "ens." + SignUp.nom + "." + SignUp.prenom + "@csl.com";

            PreparedStatement pstmt = (PreparedStatement) con.prepareStatement
                    ("insert into Enseignant" +
                            " values('"+nom+"','"+prenom+"','"+mail+"','"+pass.getText()+"','"+ima+"','"+SignUp.d+"')");


             pstmt.executeUpdate();
            pstmt.close();


        }

           }




    public void close(MouseEvent mouseEvent) {
        SignIn.stage.close();
    }
}



