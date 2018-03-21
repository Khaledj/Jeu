package personnage;
import java.util.Scanner;


public class Guerrier extends Personnage {
	Scanner sc = new Scanner(System.in);
	String arme;
	int bouclier;

	public void equipement() {
		
		System.out.println("Veuiller écrire une arme :");
		arme = sc.nextLine();
		while(arme.equals("")) {
			System.out.println("Veuiller écrire une arme :");
			arme=sc.nextLine();		
		}

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

	public String getArme() {
		return arme;
	} 

	public int getBouclier() {
		return bouclier;
	} 

	public void setArme(String arme2) {
		if(arme2.equals("")) {
			arme2=arme;
		}
		arme = arme2;
	} 

	public void setBouclier(int bouclier2) {
		while(bouclier2 <0 || bouclier2>100) {
			System.out.println("Veuiller modifier la valeur du bouclier entre 0 et 100 :" + getBouclier());
			bouclier2 =sc.nextInt();
		}
		bouclier = bouclier2;
	} 

}