package personnage;
import java.util.Scanner;
import java.util.*;

/**
 * The type Guerrier.
 */
public class Guerrier extends Personnage {
	private Scanner sc = new Scanner(System.in);
	private ArrayList<String> arme = new ArrayList<String>();

	public String getNewArme() {
		return newArme;
	}

	private String newArme;

	/**
	 * Gets sc.
	 *
	 * @return the sc
	 */
	public Scanner getSc() {
		return sc;
	}

	/**
	 * Sets sc.
	 *
	 * @param sc the sc
	 */
	public void setSc(Scanner sc) {
		this.sc = sc;
	}

	/**
	 * Gets arme.
	 *
	 * @return the arme
	 */
	public ArrayList<String> getArme() {
		return arme;
	}

	/**
	 * Sets arme.
	 *
	 * @param arme the arme
	 */
	public void setArme(ArrayList<String> arme) {
		this.arme = arme;
	}

	 /**
	 * The Bouclier.
	 */
	int bouclier;

	public void afficheEquipement() {
		for(int i=0; i<arme.size();i++){
			System.out.println(arme.get(i)+ "  -  "+ i);
		}
	}

	/**
	 * Gets bouclier.
	 *
	 * @return the bouclier
	 */
	public int getBouclier() {
		return bouclier;
	}

	/**
	 * Sets bouclier.
	 *
	 * @param bouclier2 the bouclier 2
	 */
	public void setBouclier(int bouclier2) {
		while(bouclier2 <0 || bouclier2>100) {
			System.out.println("Veuiller modifier la valeur du bouclier entre 0 et 100 :" + getBouclier());
			bouclier2 =sc.nextInt();
		}
		bouclier = bouclier2;
	}

	/**
	 * Ajoutarme.
	 */
	public void ajoutarme() {
		String validation;
		System.out.println("Ajouter une arme :" + "\noui" + "\nnon");
		validation = sc.nextLine();

		while(validation.equals("oui")) {
			System.out.println("Veuiller écrire une arme :");
			String newArme = sc.nextLine();
			arme.add(newArme);
			System.out.println("Ajouter une arme :" + "\noui" + "\nnon");
			validation = sc.nextLine();
		}
	}

	public void equipement() {
		System.out.println("Veuiller écrire une arme :");
		 newArme = sc.nextLine();
		arme.add(newArme);
		while(newArme.equals("")) {
			System.out.println("Veuiller écrire une arme :");
			newArme = sc.nextLine();
			arme.add(newArme);		
		}
		ajoutarme();

		System.out.println("Veuiller donner une valeur au bouclier entre 0 et 100 :");
		bouclier = sc.nextInt();
		while(bouclier <0 || bouclier >100) {
			System.out.println("Veuiller donner une valeur au bouclier entre 0 et 100 :");
			bouclier =sc.nextInt();
		}
		
	}

	public String toString() {
		return "Nom: " + nom + "\nImage: " + image + "\nniveau_de_vie: " + niveau_de_vie 
		+ "\nforce_attaque: " + force_attaque + "\narme: " + arme
		+ "\nbouclier: " + bouclier;
	}


}