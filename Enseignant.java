package sample;

import java.awt.*;
import java.util.Date;

public class Enseignant extends User{
    String Domaine;
    Enseignant(String nom, String prenom,String mail, String motDpass, String module, String langue, String heure, String image){
       super(nom,prenom,mail,motDpass,langue,image,heure);
        this.Domaine=module;
    }
    Enseignant(String nom, String prenom,String email, String module, String langue, String heure,String mdp){
        super(nom,prenom,email,langue,heure,mdp);
        this.Domaine=module;
    }

    Enseignant(String nom,String prenom,String adr,String mdp,String img,String domaine){
        super(nom,prenom,adr,mdp,"english",img,"GMT+1");
        Domaine=domaine;
    }
}
