package personnage;
import java.util.Scanner;
import java.util.*;

public class Magicien extends Personnage {
	Scanner sc = new Scanner(System.in);
	ArrayList<String> sort = new ArrayList<String>();
	int philtre;

	public void equipement() {
		System.out.println("Veuiller écrire un sort :");
		String newSort = sc.nextLine();
		sort.add(newSort);
		while(newSort.equals("")) {
			System.out.println("Veuiller écrire un sort :");
			newSort = sc.nextLine();
			sort.add(newSort);		
		}
		ajoutsort();
		System.out.println("Veuiller donner une valeur au philtre entre 0 et 100 :");
		philtre = sc.nextInt();
		while(philtre <0 || philtre >100) {
			System.out.println("Veuiller donner une valeur au philtre entre 0 et 100 :");
			philtre=sc.nextInt();
		}
	}

	public String toString() {
		return "Nom: " + nom + "\nImage: " + image + "\nniveau_de_vie: " + niveau_de_vie 
		+ "\nforce_attaque: " + force_attaque + "\nsort: " + sort
		+ "\nphiltre: " + philtre;
	}

	public void affichesort() {
		for(int i=0; i<sort.size();i++){
			System.out.println(sort.get(i)+ "  -  "+ i);
		}	
	}
	
	public int getPhiltre() {
		return philtre;
	} 

	public void setPhiltre(int philtre2) {
		while(philtre2 <0 || philtre2>100) {
			System.out.println("Veuiller modifier la valeur du philtre entre 0 et 100 :" + getPhiltre());
			philtre2 =sc.nextInt();
		}
		philtre = philtre2;
	} 

	public void ajoutsort() {
		String validation;
		System.out.println("Ajouter un sort :" + "\noui" + "\nnon");
		validation = sc.nextLine();

		while(validation.equals("oui")) {
			System.out.println("Veuiller écrire un sort :");
			String newSort = sc.nextLine();
			sort.add(newSort);
			System.out.println("Ajouter un sort :" + "\noui" + "\nnon");
			validation = sc.nextLine();
		}
	}	
}