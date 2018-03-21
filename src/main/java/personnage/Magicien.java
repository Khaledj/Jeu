package personnage;
import java.util.Scanner;


public class Magicien extends Personnage {
	Scanner sc = new Scanner(System.in);
	String nom;
	String image;
	int niveau_de_vie;
	int force_attaque;
	String sort;
	int philtre;
    
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

			System.out.println("Veuiller ecrire un sort :");
			sort = sc.nextLine();
			while(sort.equals("")) {
			System.out.println("Veuiller écrire un sort :");
			sort=sc.nextLine();		
			}

			System.out.println("Veuiller donner une valeur au philtre :");
			philtre = sc.nextInt();
			 while(philtre <0 || philtre >100) {
			System.out.println("Veuiller donner une valeur au philtre :");
			philtre=sc.nextInt();
			}
		}

		public String toString() {
		return "Nom: " + nom + "\nImage: " + image + "\nniveau_de_vie: " + niveau_de_vie 
		+ "\nforce_attaque: " + force_attaque + "\nsort: " + sort
		+ "\nphiltre: " + philtre;
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

	public void setSort(String sort2) {
         sort = sort2;
	} 

	public void setPhiltre(int philtre2) {
         philtre = philtre2;
	} 

	}