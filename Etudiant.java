package sample;

import java.awt.*;
import java.util.Date;

public class Etudiant extends User{
    String matricule;
    String Specialite;
    String section;
    String annee;

    Etudiant(String sp,String sec,String nom,String email, String prenom, String matricule, String motDpass, String langue, String image,String heure){
       super(nom,prenom,email,motDpass,langue,image,heure);
        this.matricule=matricule; Specialite=sp; section=sec;
    }
    Etudiant(String sp,String sec,String nom,String email, String prenom, String matricule, String langue,String heure,String mdp){
        super(nom,prenom,email,langue,heure,mdp);
        this.matricule=matricule; Specialite=sp; section=sec;
    }

    Etudiant (String mat,String nom,String prenom,String sp,String sc,String img,String adr,String mdp,String annee,int a){
        super(nom,prenom,adr,mdp,"englsh",img,"GMT+1");
        this.annee=annee; Specialite=sp; section=sc; matricule=mat;
    }
}
