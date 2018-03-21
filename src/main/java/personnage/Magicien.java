package personnage;
import java.util.Scanner;


public class Magicien extends Personnage {
	Scanner sc = new Scanner(System.in);
	String sort;
	int philtre;

	public void equipement() {

		System.out.println("Veuiller ecrire un sort :");
		sort = sc.nextLine();
		while(sort.equals("")) {
			System.out.println("Veuiller écrire un sort :");
			sort=sc.nextLine();		
		}

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

	public String getSort() {
		return sort;
	} 

	public int getPhiltre() {
		return philtre;
	} 

	public void setSort(String sort2) {
		if(sort2.equals("")) {
			sort2=sort;
		}
		sort = sort2;
	} 

	public void setPhiltre(int philtre2) {
		while(philtre2 <0 || philtre2>100) {
			System.out.println("Veuiller modifier la valeur du philtre entre 0 et 100 :" + getPhiltre());
			philtre2 =sc.nextInt();
		}
		philtre = philtre2;
	} 



}