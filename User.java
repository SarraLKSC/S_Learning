package sample;

import java.awt.*;
import java.util.Date;

public class User {
    String nom,prenom,motDpass,langue,heure,email,image;
   User(String nom, String prenom,String email, String motDpass, String langue, String image,String heure){
        this.prenom=prenom;
        this.nom=nom;
        this.motDpass=motDpass;
        this.langue=langue;
        this.image=image;
        this.heure=heure;
        this.email=email;
    }
    User(String nom, String prenom,String email, String langue,String heure,String mdp){
        this.prenom=prenom;
        this.nom=nom;
        this.langue=langue;
        this.heure=heure;
        this.email=email;
        motDpass=mdp;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
