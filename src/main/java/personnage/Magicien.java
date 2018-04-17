package personnage;
import java.util.Scanner;
import java.util.*;

/**
 * The type Magicien.
 */
public class Magicien extends Personnage {
	/**
	 * The Sc.
	 */
	Scanner sc = new Scanner(System.in);
	private ArrayList<String> sort = new ArrayList<String>();
	private int philtre;
	private String newSort;

	public String getNewSort() {
		return newSort;
	}

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
	 * Gets sort.
	 *
	 * @return the sort
	 */
	public ArrayList<String> getSort() {
		return sort;
	}

	/**
	 * Sets sort.
	 *
	 * @param sort the sort
	 */
	public void setSort(ArrayList<String> sort) {
		this.sort = sort;
	}

	public void afficheEquipement() {
		for(int i=0; i<sort.size();i++){
			System.out.println(sort.get(i)+ "  -  "+ i);
		}
	}

	/**
	 * Gets philtre.
	 *
	 * @return the philtre
	 */
	public int getPhiltre() {
		return philtre;
	}

	/**
	 * Sets philtre.
	 *
	 * @param philtre2 the philtre 2
	 */
	public void setPhiltre(int philtre2) {
		while(philtre2 <0 || philtre2>100) {
			System.out.println("Veuiller modifier la valeur du philtre entre 0 et 100 :" + getPhiltre());
			philtre2 =sc.nextInt();
		}
		philtre = philtre2;
	}

	/**
	 * Ajoutsort.
	 */
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

	public void equipement() {
		System.out.println("Veuiller écrire un sort :");
		 newSort = sc.nextLine();
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


}