package sample;

        import javafx.application.Application;
        import javafx.event.Event;
        import javafx.fxml.FXML;
        import javafx.fxml.FXMLLoader;
        import javafx.fxml.Initializable;
        import javafx.scene.Parent;
        import javafx.scene.Scene;
        import javafx.scene.control.Label;
        import javafx.scene.control.PasswordField;
        import javafx.scene.control.TextField;
        import javafx.scene.input.MouseEvent;
        import javafx.stage.Stage;
        import java.net.URL;
        import java.sql.Connection;
        import java.sql.DriverManager;
        import java.sql.ResultSet;
        import java.sql.Statement;
        import java.util.ResourceBundle;

public class SignIn extends Application implements Initializable {


    public static Stage stage=new Stage();
    public static Stage stage1=new Stage();
    public static String adr="1";
    public static String mdp="1";
    public static Etudiant etd;
    public static Enseignant ens;

    @FXML
    private Label label;
    @FXML
    private PasswordField pass;

    @FXML
    private TextField user;
    public static int droit; //1 ENSEIGNANT 2 ETUDIANT 3 ADMINISTRATEUR



    public void buttonpressed(Event evt) throws Exception {
         //ON EST SENSE PARCOURIR LA BASE DE DONNEES
        label.setText("");
        String mail=user.getText();
        String password=pass.getText();
        if (mail.contains("@csl.com") ) {
            System.out.println(" email");
            String type=mail.substring(0,3);
            System.out.println(type);
            if(mail.substring(0,3).equals("etd")) {
                droit = 2;
            }
              else{
                  if(mail.substring(0,3).equals("ens")){
                      droit=1;
                  }
                          else{
                      if(mail.substring(0,3).equals("adm"))     droit=3;
                          }
              }
              if(Verif(droit,mail,password)){
                  adr=user.getText();
                  mdp=pass.getText();
            Parent root = FXMLLoader.load(getClass().getResource("Formation_Accueil.fxml"));
            stage1.setTitle("Computer Science Learning");
            stage1.setScene(new Scene(root));
            stage1.show();}
            else{droit=-1; label.setText("Account does not exist"); }
        }
        else{label.setText("email format incorrect");}
    }

    public static boolean Verif(int droit, String mail, String password) throws Exception{
        //RECHERCHE
        boolean exist=false;

        if(droit==1){
        try{
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            String path="C:\\Users\\user\\IdeaProjects\\S-Learning\\src\\sample\\Database11.accdb";
            String url ="jdbc:ucanaccess://"+path;
            Connection con= DriverManager.getConnection(url);
            try{
                Statement st=con.createStatement();
                ResultSet rs=st.executeQuery("Select * from Enseignant");
                while (rs.next()){
                    if(( rs.getString("adresse").equals(mail))&&(rs.getString("motdepasse").equals(password)))
                    {exist=true;
                      ens=new Enseignant(rs.getString("nom"),rs.getString("prenom"),rs.getString("adresse")
                      ,rs.getString("motdepasse"),rs.getString("image"),rs.getString("domaine"));}  }
                    if(exist){
                        System.out.println("existe !"); //OUVRIR FENETRE
                    } else{
                        System.out.println("non makach");
                    }
            }catch (Exception e) {
                System.out.println("error occured " + e);
            }

        } catch (Exception ex) {
            System.out.println("error occured "+ex);
        }}


        if(droit==2){
            try{
                Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
                String path="C:\\Users\\user\\IdeaProjects\\S-Learning\\src\\sample\\Database11.accdb";
                String url ="jdbc:ucanaccess://"+path;
                Connection con= DriverManager.getConnection(url);
                try{
                    Statement st=con.createStatement();
                    ResultSet rs=st.executeQuery("Select * from Etudiant");
                    while (rs.next()){
                        if(( rs.getString("adresse").equals(mail))&&(rs.getString("motdepasse").equals(password)))
                        { exist=true;
                          etd=new Etudiant(rs.getString("Matricule"),rs.getString("nom"),rs.getString("prenom")
                          ,rs.getString("Specialité"),rs.getString("Section"),rs.getString("image")
                                  ,rs.getString("adresse"),rs.getString("motdepasse"),rs.getString("annee"),2);
                        }   }
                        if(exist){
                            System.out.println("existe"); //OUVRIRE FENETRE
                        }
                }catch (Exception e) {
                    System.out.println("error occured " + e);
                }

            } catch (Exception ex) {
                System.out.println("error occured "+ex);
            }}
        if(droit==3){
            try{
                Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
                String path="C:\\Users\\user\\IdeaProjects\\S-Learning\\src\\sample\\Database11.accdb";
                String url ="jdbc:ucanaccess://"+path;
                Connection con= DriverManager.getConnection(url);
                try{
                    Statement st=con.createStatement();
                    ResultSet rs=st.executeQuery("Select * from Administratur");
                    while (rs.next()){
                        if(( rs.getString("adress").equals(mail))&&(rs.getString("prenom").equals(password)))
                        {
                            exist=true; System.out.println("correct");
                        }
                        else System.out.println("erreur");

                    }
                }catch (Exception e) {
                    System.out.println("error occured " + e);
                }

            } catch (Exception ex) {
                System.out.println("error occured "+ex);
            }}
         return exist;
    }


    public void SignUp(MouseEvent mouseEvent) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("Sign_Up.fxml"));
        stage.setTitle("Computer Science Learning");
        stage.setScene(new Scene(root));
        stage.show();
    }



    @Override
    public void start(Stage stage) throws Exception {
         Parent root = FXMLLoader.load(getClass().getResource("SignIn.fxml"));
        stage1.setTitle("Hello World");
        stage1.setScene(new Scene(root));
        stage1.show();
    }



    public static void main(String[] args) {
        launch(args);
    }



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}