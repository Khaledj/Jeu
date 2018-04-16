package personnage;
import java.util.Scanner;

/**
 * The type Personnage.
 */
public abstract class Personnage {
	/**
	 * The Sc.
	 */
	Scanner sc = new Scanner(System.in);
	/**
	 * The Nom.
	 */
	String nom;
	/**
	 * The Image.
	 */
	String image;
	/**
	 * The Niveau de vie.
	 */
	int niveau_de_vie;
	/**
	 * The Force attaque.
	 */
	int force_attaque;

	/**
	 * Gets nom.
	 *
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * Gets image.
	 *
	 * @return the image
	 */
	public String getImage() {
		return image;
	}

	/**
	 * Gets vie.
	 *
	 * @return the vie
	 */
	public int getVie() {
		return niveau_de_vie;
	}

	/**
	 * Gets force.
	 *
	 * @return the force
	 */
	public int getForce() {
		return force_attaque;
	}

	/**
	 * Sets nom.
	 *
	 * @param nom2 the nom 2
	 */
	public void setNom(String nom2) {
		if(nom2.equals("")) {
			nom2=nom;
		}
		nom = nom2;
	}

	/**
	 * Sets image.
	 *
	 * @param image2 the image 2
	 */
	public void setImage(String image2) {
		if(image2.equals("")) {
			image2=image;
		}
		image = image2;
	}

	/**
	 * Sets vie.
	 *
	 * @param vie the vie
	 */
	public void setVie(int vie) {
		while(vie <0 || vie>100) {
			System.out.println("Veuiller modifier le niveau_de_vie du personnage entre 0 et 100 :" + getVie());
			vie =sc.nextInt();
		}
		niveau_de_vie = vie;
	}

	/**
	 * Sets force.
	 *
	 * @param force the force
	 */
	public void setForce(int force ) {
		while(force <0 || force>100) {
			System.out.println("Veuiller modifier la force d'attaque entre 0 et 100 :" + getForce());
			force =sc.nextInt();
		}
		force_attaque = force;
	}

	/**
	 * Attaque.
	 */
	public void attaque() {
		int niveau_attaque;
		System.out.println("Veuiller attaquer avec un niveau d'attaque choisi : maximum" + force_attaque);
		niveau_attaque = sc.nextInt();
		force_attaque = (force_attaque - niveau_attaque);
		System.out.println("Il vous reste" + force_attaque + "force attaque");
	}

	/**
	 * Equipement.
	 */
	public void equipement()
	{}

	/**
	 * Affiche equipement.
	 */
	public void afficheEquipement()
	 {}

	/**
	 * Creation.
	 */
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


}