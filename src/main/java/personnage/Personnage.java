package personnage;
import java.util.Scanner;

public class Personnage {
	Scanner sc = new Scanner(System.in);
	String nom;
	String image;
	int niveau_de_vie;
	int force_attaque;
	
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

		System.out.println("Veuiller donner un niveau_de_vie du personnage entre 0 et 100 :");
		niveau_de_vie = sc.nextInt();
		while(niveau_de_vie<0 || niveau_de_vie >100) {
			System.out.println("Veuiller donner un niveau_de_vie du personnage entre 0 et 100 :");
			niveau_de_vie =sc.nextInt();
		}

		System.out.println("Veuiller donner une force attaque entre 0 et 100 :");
		force_attaque = sc.nextInt();
		while(force_attaque <0 || force_attaque>100 ) {
			System.out.println("Veuiller donner une force attaque entre 0 et 100 :");
			force_attaque =sc.nextInt();
		}
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

	public void setNom(String nom2) {
		if(nom2.equals("")) {
			nom2=nom;
		}
		nom = nom2;
	} 

	public void setImage(String image2) {
		if(image2.equals("")) {
			image2=image;
		}
		image = image2;
	} 

	public void setVie(int vie) {
		while(vie <0 || vie>100) {
			System.out.println("Veuiller modifier le niveau_de_vie du personnage entre 0 et 100 :" + getVie());
			vie =sc.nextInt();
		}
		niveau_de_vie = vie;
	} 

	public void setForce(int force ) {
		while(force <0 || force>100) {
			System.out.println("Veuiller modifier la force d'attaque entre 0 et 100 :" + getForce());
			force =sc.nextInt();
		}
		force_attaque = force;
	} 

	public void attaque() {
		int niveau_attaque;
		System.out.println("Veuiller attaquer avec un niveau d'attaque choisi : maximum" + force_attaque);
		niveau_attaque = sc.nextInt();
		force_attaque = (force_attaque - niveau_attaque);
		System.out.println("Il vous reste" + force_attaque + "force attaque");
	}
}