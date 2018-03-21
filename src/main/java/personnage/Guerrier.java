package personnage;
import java.util.Scanner;


public class Guerrier extends Personnage {
    Scanner sc = new Scanner(System.in);
	String nom;
	String image;
	int niveau_de_vie;
	int force_attaque;
	String arme;
	int bouclier;

	public void creation() {
		
		System.out.println("Veuiller donner un nom au personnage :");
		nom = sc.nextLine();
		while(nom.equals("")) {
		System.out.println("Veuiller donner un nom au personnage :");
		nom=sc.nextLine();		
		}
		
		System.out.println("Veuiller donner une image au personnage :");
		image = sc.nextLine();
		while(image.equals("")) {
		System.out.println("Veuiller donner une image au personnage :");
		image=sc.nextLine();		
		}

		System.out.println("Veuiller donner un niveau_de_vie du personnage :");
		niveau_de_vie = sc.nextInt();
		while(niveau_de_vie<0 || niveau_de_vie >100) {
		System.out.println("Veuiller donner un niveau_de_vie du personnage :");
		niveau_de_vie =sc.nextInt();
		}

		System.out.println("Veuiller donner une force attaque :");
		force_attaque = sc.nextInt();
		while(force_attaque <0 || force_attaque>100 ) {
		System.out.println("Veuiller donner une force attaque :");
		force_attaque =sc.nextInt();
		}

        sc.nextLine();

		System.out.println("Veuiller écrire une arme :");
		arme = sc.nextLine();
		while(arme.equals("")) {
		System.out.println("Veuiller écrire une arme :");
		arme=sc.nextLine();		
		}

		System.out.println("Veuiller donner une valeur au bouclier :");
		bouclier = sc.nextInt();
	    while(bouclier <0 || bouclier >100) {
		System.out.println("Veuiller donner une valeur au bouclier :");
		bouclier =sc.nextInt();
		}
	}

	public String toString() {
		return "Nom: " + nom + "\nImage: " + image + "\nniveau_de_vie: " + niveau_de_vie 
		+ "\nforce_attaque: " + force_attaque + "\narme: " + arme
		+ "\nbouclier: " + bouclier;
	}
    public String getNom() {
        return nom;
	} 

	public String getImage() {
         return image;
	} 

	public int getVie() {
         return niveau_de_vie;
	} 

	public int getForce() {
         return force_attaque;
	} 

	public String getArme() {
         return arme;
	} 

	public int getBouclier() {
         return bouclier;
	} 

	public void setNom(String nom2) {
         nom = nom2;
	} 

	public void setImage(String image2) {
         image = image2;
	} 

	public void setVie(int vie) {
         niveau_de_vie = vie;
	} 

	public void setForce(int force ) {
         force_attaque = force;
	} 

	public void setArme(String arme2) {
         arme = arme2;
	} 

	public void setBouclier(int bouclier2) {
         bouclier = bouclier2;
	} 

	public void attaque() {
		int niveau_attaque;
		System.out.println("Veuiller attaquer avec un niveau d'attaque choisi : maximum" + force_attaque);
		niveau_attaque = sc.nextInt();
		force_attaque = (force_attaque - niveau_attaque);
        System.out.println("Il vous reste" + force_attaque + "force attaque");
	}

}