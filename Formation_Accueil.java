package sample;

import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.ResourceBundle;


public class Formation_Accueil  extends Application implements Initializable {

    ArrayList<String> date_=new ArrayList<>();
    ArrayList<String> heure=new ArrayList<>();
    ArrayList<String> cypher=new ArrayList<>();
    static Stage primarystage=new Stage();
    public static boolean b=false;
    public TextField quelquechose;
    public FontAwesomeIcon activite;
    public Pane activitypane;
    public Hyperlink link1;
    public Hyperlink link2;
    public Hyperlink link3;
    public Hyperlink link4;
    public TextField research;
    public TextArea canvas;
    String url;
    public TextField validatemail;
    public PasswordField validatepass;
    public TextField title;
    public TextField summary;
    public Pane newformation;
    public Label codeformation;
    public Button modifbutton0;
    public FontAwesomeIcon newlesson;
    public Button modifbutton1;
    public Button modifbutton2;
    public Button modifbutton3;
    public Label idferror;
    @FXML   private Pane pane0;

    @FXML   private Label titre0;

    @FXML   private Label resume0;

    @FXML   private Label test0;

    @FXML   private Pane pane1;

    @FXML   private Label titre1;

    @FXML   private Label resume1;

    @FXML   private Label test1;

    @FXML   private Pane pane2;

    @FXML   private Label titre2;

    @FXML   private Label resume2;

    @FXML   private Label test2;

    @FXML   private Pane pane3;

    @FXML   private Label titre3;

    @FXML   private Label resume3;

    @FXML   private Label test3;

    @FXML
    private ChoiceBox<String> sp;

    public static int cpt;

    @FXML    private Pane paneinvisible;

    @FXML    private FontAwesomeIcon nextbutton;
    public static Stage stage= new Stage();
    static LinkedList<String> suivit =new LinkedList();



    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage primarystage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("Formation_Accueil.fxml"));
        stage.setTitle("Learning Space");
        stage.setScene(new Scene(root));
        stage.show();
    }

    @Override public void initialize(URL url, ResourceBundle resourceBundle) {
        if(SignIn.droit==2){
            modifbutton0.setVisible(false);
            modifbutton1.setVisible(false);
            modifbutton2.setVisible(false);
            modifbutton3.setVisible(false);
            newlesson.setVisible(false);
            activite.setVisible(false);

        }
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

    public void validate2(MouseEvent mouseEvent) {
        idferror.setVisible(false);
        if(validatemail.getText().equals(SignIn.adr)&& validatepass.getText().equals(SignIn.mdp)){
            String code;

            try{
                Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
                String path = "C:\\Users\\user\\IdeaProjects\\S-Learning\\src\\sample\\Database11.accdb";
                String url_ = "jdbc:ucanaccess://" + path;
                Connection con = DriverManager.getConnection(url_);
                 Statement st = con.createStatement();
                 int i=Main.getRandomNumberInRange(1,98);

                code= title.getText().substring(0,2).toUpperCase()+i+summary.getText().substring(0,2).toUpperCase();

            if(title.getText().length()>3 && summary.getText().length()>2){
                 code= title.getText().substring(2,4).toUpperCase()+i+summary.getText().substring(1,2).toUpperCase();}


                 String summary_=summary.getText();
                 String title_=title.getText();
                 if(summary.getText().contains("'")){
                     String str_=summary.getText().substring(0,summary.getText().indexOf("'"));
                     String str__=summary.getText().substring(summary.getText().indexOf("'")+1);
                     summary_=str_+str__;
                 }
                 if(title.getText().contains("'")){
                     String str_=title.getText().substring(0,title.getText().indexOf("'"));
                     String str__=title.getText().substring(title.getText().indexOf("'")+1);
                     title_=str_+str__;
                 }
                PreparedStatement pstmt = (PreparedStatement) con.prepareStatement
                        ("insert into Formation" +
                          " values('"+code+"','"+title_+"','"+summary_+"','"+sp.getSelectionModel().getSelectedItem()+"','"+SignIn.adr+"')");
                PreparedStatement pstmt2 = (PreparedStatement) con.prepareStatement
                        ("insert into Chapitre" +
                                " values('"+url+"','Chapitre1','"+code+"')");

                //same for all statement
                 pstmt.executeUpdate();
                 pstmt.close();
                pstmt2.executeUpdate();
                pstmt2.close();

                codeformation.setText(code);
                newformation.setVisible(true);

               }catch (ClassNotFoundException e1) {
                    e1.printStackTrace();
                    System.out.println(" erreur ajout");
               }catch (SQLException e1) {
                    e1.printStackTrace();
                    System.out.println(" erreur ajout 2");
            }



         }
         else{ idferror.setVisible(true); validatepass.clear(); validatemail.clear();}

    }

    public void validate1(MouseEvent mouseEvent) {  paneinvisible.setVisible(true);   }

    public void next(MouseEvent mouseEvent) { nextbutton.setVisible(false);
        try {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            String path = "C:\\Users\\user\\IdeaProjects\\S-Learning\\src\\sample\\Database11.accdb";
            String url_ = "jdbc:ucanaccess://" + path;
            Connection con = DriverManager.getConnection(url_);
            Statement stt = con.createStatement();
            ResultSet rs = stt.executeQuery("Select * from Formation");

            if(SignIn.droit==2){
                while (rs.next()) {
                    System.out.println(rs.getString("sp"));
                    System.out.println(SignIn.etd.Specialite);
                    if(rs.getString("sp").equals(SignIn.etd.Specialite))
                    { if(cpt>7){nextbutton.setVisible(true);}
                        switch (cpt%4){
                            case 0: titre0.setText(rs.getString("titre"));  test0.setText(rs.getString("code")); resume0.setText(rs.getString("resume")); break;
                            case 1: titre1.setText(rs.getString("titre"));  test1.setText(rs.getString("code")); resume1.setText(rs.getString("resume")); break;
                            case 2: titre2.setText(rs.getString("titre"));  test2.setText(rs.getString("code")); resume2.setText(rs.getString("resume")); break;
                            case 3: titre3.setText(rs.getString("titre"));  test3.setText(rs.getString("code")); resume3.setText(rs.getString("resume")); break;

                        }cpt++;}
                }
            }else{
                while (rs.next()) {
                    if(cpt>7){nextbutton.setVisible(true);}
                    switch (cpt%4){
                        case 0: titre0.setText(rs.getString("titre"));  test0.setText(rs.getString("code")); resume0.setText(rs.getString("resume")); break;
                        case 1: titre1.setText(rs.getString("titre"));  test1.setText(rs.getString("code")); resume1.setText(rs.getString("resume")); break;
                        case 2: titre2.setText(rs.getString("titre"));  test2.setText(rs.getString("code")); resume2.setText(rs.getString("resume")); break;
                        case 3: titre3.setText(rs.getString("titre"));  test3.setText(rs.getString("code")); resume3.setText(rs.getString("resume")); break;

                    }cpt++;
                }}


        } catch (ClassNotFoundException e1) {
            e1.printStackTrace();
            System.out.println(" erreur ");
        } catch (SQLException e1) {
            e1.printStackTrace();      System.out.println(" erreur 2");

        }
    }

    public void search(MouseEvent mouseEvent) {
        try {
            pane0.setVisible(false); pane1.setVisible(false); pane2.setVisible(false); pane3.setVisible(false);
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            String path = "C:\\Users\\user\\IdeaProjects\\S-Learning\\src\\sample\\Database11.accdb";
            String url_ = "jdbc:ucanaccess://" + path;
            Connection con = DriverManager.getConnection(url_);
            Statement stt = con.createStatement();
            ResultSet rs = stt.executeQuery("Select * from Formation");

            while (rs.next()) {
              if(rs.getString("code").equals(quelquechose.getText().toUpperCase())){
                    pane0.setVisible(true);
                    titre0.setText(rs.getString("titre"));
                    test0.setText(rs.getString("code"));
                    resume0.setText(rs.getString("resume"));
              }
            }

        } catch (ClassNotFoundException e1) {
            e1.printStackTrace();
            System.out.println(" erreur ");
        } catch (SQLException e1) {
            e1.printStackTrace();      System.out.println(" erreur 2");

        }
        if(SignIn.droit==2) {suivit.add("  searched for lesson "+quelquechose.getText());} ////
    }

    public void add(MouseEvent mouseEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Formation_Ajout.fxml"));
        primarystage.setTitle("Learning Space");
        primarystage.setScene(new Scene(root));
        primarystage.show();

    }

    public void refresh(MouseEvent mouseEvent) {
        quelquechose.clear();
        cpt=0;
        try {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            String path = "C:\\Users\\user\\IdeaProjects\\S-Learning\\src\\sample\\Database11.accdb";
            String url_ = "jdbc:ucanaccess://" + path;
            Connection con = DriverManager.getConnection(url_);
            Statement stt = con.createStatement();
            ResultSet rs = stt.executeQuery("Select * from Formation");

            switch(SignIn.droit){
                case 2:
                       while (rs.next()) {
                          System.out.println(SignIn.etd.Specialite);
                          if(rs.getString("sp").equals(SignIn.etd.Specialite))
                              { if(cpt>3){nextbutton.setVisible(true); }
                              switch (cpt){
                                     case 0: pane0.setVisible(true); titre0.setText(rs.getString("titre"));  test0.setText(rs.getString("code")); resume0.setText(rs.getString("resume")); break;
                                     case 1: pane1.setVisible(true);titre1.setText(rs.getString("titre"));  test1.setText(rs.getString("code")); resume1.setText(rs.getString("resume")); break;
                                     case 2: pane2.setVisible(true);titre2.setText(rs.getString("titre"));  test2.setText(rs.getString("code")); resume2.setText(rs.getString("resume")); break;
                                     case 3: pane3.setVisible(true); titre3.setText(rs.getString("titre"));  test3.setText(rs.getString("code")); resume3.setText(rs.getString("resume")); break;

                                  }cpt++;}
                          } break;
                case 1:
                    while (rs.next()) {
                        if(rs.getString("enseignant").equals(SignIn.ens.email))
                        { if(cpt>3){nextbutton.setVisible(true); }
                            switch (cpt){
                                case 0: pane0.setVisible(true); titre0.setText(rs.getString("titre"));  test0.setText(rs.getString("code")); resume0.setText(rs.getString("resume")); break;
                                case 1: pane1.setVisible(true);titre1.setText(rs.getString("titre"));  test1.setText(rs.getString("code")); resume1.setText(rs.getString("resume")); break;
                                case 2: pane2.setVisible(true);titre2.setText(rs.getString("titre"));  test2.setText(rs.getString("code")); resume2.setText(rs.getString("resume")); break;
                                case 3: pane3.setVisible(true); titre3.setText(rs.getString("titre"));  test3.setText(rs.getString("code")); resume3.setText(rs.getString("resume")); break;

                            }cpt=cpt+1;}
                    } break;
                case 3:
                       while (rs.next()) {
                           if(cpt>3){nextbutton.setVisible(true); }
                              switch (cpt){
                                    case 0: pane0.setVisible(true); titre0.setText(rs.getString("titre"));  test0.setText(rs.getString("code")); resume0.setText(rs.getString("resume")); break;
                                    case 1: pane1.setVisible(true);titre1.setText(rs.getString("titre"));  test1.setText(rs.getString("code")); resume1.setText(rs.getString("resume")); break;
                                    case 2: pane2.setVisible(true);titre2.setText(rs.getString("titre"));  test2.setText(rs.getString("code")); resume2.setText(rs.getString("resume")); break;
                                    case 3: pane3.setVisible(true); titre3.setText(rs.getString("titre"));  test3.setText(rs.getString("code")); resume3.setText(rs.getString("resume")); break;

                                 }cpt++;
                          } break;
            }

        } catch (ClassNotFoundException e1) {
            e1.printStackTrace();
            System.out.println(" erreur ");
        } catch (SQLException e1) {
            e1.printStackTrace();      System.out.println(" erreur 2");

        }

    }


    public void load(MouseEvent mouseEvent) {
        if(!b) {
            sp.getItems().addAll("ISIL", "ACAD", "GTR", "MIV", "SII", "SSI");
            b=true;
        }
    }

    public void Viewit2(MouseEvent mouseEvent) throws IOException {
        Formation.code=test2.getText();
        Formation.title=titre2.getText();
        Formation.modif=1;

        Parent root = FXMLLoader.load(getClass().getResource("Formation.fxml"));
        stage.setTitle("Learning Space");
        stage.setScene(new Scene(root));
        stage.show();


        if(SignIn.droit==2){suivit.add(" entered lesson :"+test2.getText());}
        System.out.println("fvdc");
    }

    public void Viewit3(MouseEvent mouseEvent) throws IOException {
        Formation.modif=1;
        Formation.title=titre3.getText();
        Formation.code=test3.getText();
        Parent root = FXMLLoader.load(getClass().getResource("Formation.fxml"));
        stage.setTitle("Learning Space");
        stage.setScene(new Scene(root));

        stage.show();
        if(SignIn.droit==2){suivit.add("  entered lesson :"+test3.getText());}

        boolean b;
    }

    public void Viewit1(MouseEvent mouseEvent) throws IOException {
        System.out.println("******");

        Formation.modif=1;
        System.out.println("1");
        Formation.title=titre1.getText();
        System.out.println("2");
        Formation.code=test1.getText();
        System.out.println("3");
        Parent root = FXMLLoader.load(getClass().getResource("Formation.fxml"));
        System.out.println("4");
        stage.setTitle("Learning Space");
        stage.setScene(new Scene(root));

        stage.show();
        if(SignIn.droit==2){suivit.add(" entered lesson :"+test1.getText());}

    }

    public void Viewit0(MouseEvent mouseEvent) throws IOException {
        Formation.title=titre0.getText();
        Formation.code=test0.getText();
        Formation.modif=1;
        Parent root = FXMLLoader.load(getClass().getResource("Formation.fxml"));
        stage.setTitle("Learning Space");
        stage.setScene(new Scene(root));

        stage.show();
        if(SignIn.droit==2){suivit.add(" entered lesson :"+test0.getText());}

    }

    public void viewlesson(MouseEvent mouseEvent) throws IOException {
        primarystage.close();
        Parent root = FXMLLoader.load(getClass().getResource("Formation.fxml"));
        stage.setTitle("Learning Space");
        stage.setScene(new Scene(root));
        Formation.code=codeformation.getText();
        Formation.modif=1;
        stage.show();
        int a;
    }

    public void close(MouseEvent mouseEvent) { primarystage.close();}

    public void modifit0(MouseEvent mouseEvent) throws IOException {
        System.out.println();
        Parent root = FXMLLoader.load(getClass().getResource("Formation.fxml"));
        stage.setTitle("Learning Space");
        stage.setScene(new Scene(root));
        Formation.title=titre0.getText();
        Formation.modif=0;
        Formation.code=test0.getText();
        Formation.title=titre0.getText();
        stage.show();
    }

    public void modifit1(MouseEvent mouseEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Formation.fxml"));
        stage.setTitle("Learning Space");
        stage.setScene(new Scene(root));
        Formation.title=titre1.getText();
        Formation.code=test1.getText();
        Formation.modif=0;

        stage.show();
        System.out.println();
    }

    public void modifit2(MouseEvent mouseEvent) throws IOException {
        Formation.code=test2.getText();
        Formation.title=titre2.getText();
        Formation.modif=0;
        Parent root = FXMLLoader.load(getClass().getResource("Formation.fxml"));
        stage.setTitle("Learning Space");
        stage.setScene(new Scene(root));
        stage.show();
        System.out.println("fvc");

    }

    public void modifit3(MouseEvent mouseEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Formation.fxml"));
        stage.setTitle("Learning Space");
        stage.setScene(new Scene(root));
        Formation.title=titre3.getText();
        Formation.modif=0;
        Formation.code=test3.getText();
        stage.show();
        char b;
    }




    public void exit(MouseEvent mouseEvent) {
        SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat formatter1= new SimpleDateFormat("HH:mm:ss ");

        Date date = new Date(System.currentTimeMillis());
        System.out.println(formatter.format(date));
        System.out.println(formatter1.format(date));
        if(SignIn.droit==2){
        try {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            String path = "C:\\Users\\user\\IdeaProjects\\S-Learning\\src\\sample\\Database11.accdb";
            String url_ = "jdbc:ucanaccess://" + path;
            Connection con = DriverManager.getConnection(url_);
            String str=suivit.get(0);
            System.out.println(" yo "+suivit.size());
            for(int i=1;i<suivit.size();i++){str=str+suivit.get(i);}


            PreparedStatement pstmt2 = (PreparedStatement) con.prepareStatement
                    ("insert into Suivit" +
                            " values('"+SignIn.adr+"','"+formatter.format(date)+"','"+formatter1.format(date)+"','"+str+"')");
                  //etudiant, date_,heure_,suivit
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
    }}

    public void suivit(MouseEvent mouseEvent) { activitypane.setVisible(true); link4.setVisible(false); link3.setVisible(false);
                                                    link2.setVisible(false); link1.setVisible(false);}

    public void leaveactivity(MouseEvent mouseEvent) {activitypane.setVisible(false); }

    public void SearchActivity(MouseEvent mouseEvent) {
        String adr="";



        try {
            String test;

            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            String path = "C:\\Users\\user\\IdeaProjects\\S-Learning\\src\\sample\\Database11.accdb";
            String url_ = "jdbc:ucanaccess://" + path;
            Connection con = DriverManager.getConnection(url_);
            Statement stt = con.createStatement();

            ResultSet rs=stt.executeQuery("SELECT * from Etudiant");
            boolean found_student=false;
            while(rs.next()){
                if(rs.getString("Matricule").equals(research.getText())){
                    adr=rs.getNString("adresse");
                    found_student=true;
                    System.out.println(adr);

                    ResultSet rss=stt.executeQuery("SELECT * from Suivit");
                      int i=0;
                    while(rss.next()){
                        if(rss.getString("etudiant").equals(adr)){ i++;
                            date_.add(rss.getString("date_"));
                            System.out.println(rss.getString("date_"));
                            heure.add(rss.getString("heure_"));
                            System.out.println(rss.getString("heure_"));
                            cypher.add(rss.getString("suivit"));
                            System.out.println(rss.getString("suivit"));
                        }
                    }

                    switch (i){
                        case 1: link1.setText(date_.get(0)); link1.setVisible(true);;break;

                        case 2: link1.setText(date_.get(0));link2.setText(date_.get(1));
                            link1.setVisible(true); link2.setVisible(true);break;

                        case 3: link1.setText(date_.get(0));link2.setText(date_.get(1));link3.setText(date_.get(2));
                            link1.setVisible(true); link2.setVisible(true); link3.setVisible(true);break;

                        case 4: link1.setText(date_.get(0));link2.setText(date_.get(1));link3.setText(date_.get(2));link4.setText(date_.get(3));
                            link1.setVisible(true); link2.setVisible(true); link3.setVisible(true); link4.setVisible(true);break;

                    }


                }
            }
            if(!found_student){link1.setVisible(false); link2.setVisible(false); link3.setVisible(false); link4.setVisible(false);
                       canvas.setText("no activity for student :"+adr); }


        } catch (ClassNotFoundException e1) {
            e1.printStackTrace();
            System.out.println(" erreur ");
        } catch (SQLException e1) {
            e1.printStackTrace();      System.out.println(" erreur 2");

        }
    }

    public void date1(MouseEvent mouseEvent) {
        canvas.setText(" on "+date_.get(0)+" at "+heure.get(0)+" "+cypher.get(0));
    }

    public void date2(MouseEvent mouseEvent) {
        canvas.setText(" on "+date_.get(1)+" at "+heure.get(1)+" "+cypher.get(1));
    }

    public void date3(MouseEvent mouseEvent) {
        canvas.setText(" on "+date_.get(2)+" at "+heure.get(2)+" "+cypher.get(3));
    }

    public void date4(MouseEvent mouseEvent) {
        canvas.setText(" on "+date_.get(3)+" at "+heure.get(3)+" "+cypher.get(3));
    }
}