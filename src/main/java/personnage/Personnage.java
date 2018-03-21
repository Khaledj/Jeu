package personnage;
import java.util.Scanner;

public class Personnage {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Type de personnage : guerrier ou magicien");
		System.out.println("Veuiller choisir un type de personnage :");
		String choix = sc.nextLine();
		System.out.println("type du personnage: " + choix);

		while(!choix.equals("guerrier") && !choix.equals("magicien")) {
			System.out.println("Veuiller choisir un type de personnage :");
			choix=sc.nextLine();
			System.out.println("type du personnage: " + choix);	
		}
		if(choix.equals("guerrier")) {
			Guerrier guerrier1 = new Guerrier();
			guerrier1.creation();
			System.out.println("Le personnage est créé que voulez-vous faire?: afficher,modifier,attaquer ou ajouter arme");
			String faire = sc.nextLine();
           
			if(faire.equals("afficher")) {
             System.out.println(guerrier1);
			} 
		    else if(faire.equals("modifier")) {
			System.out.println("Veuiller donner un nom au personnage :");
			guerrier1.setNom(sc.nextLine());

			System.out.println("Veuiller donner une image au personnage :");
			guerrier1.setImage(sc.nextLine());

			System.out.println("Veuiller donner un niveau_de_vie du personnage :");
			guerrier1.setVie(sc.nextInt());

			System.out.println("Veuiller donner une force attaque :");
			guerrier1.setForce(sc.nextInt());

			sc.nextLine();

			System.out.println("Veuiller ecrire une arme :");
			guerrier1.setArme(sc.nextLine());


			System.out.println("Veuiller donner une valeur du bouclier :");
			guerrier1.setBouclier(sc.nextInt());
            System.out.println(guerrier1);

		 }
		}else {
			Magicien magicien1 = new Magicien();
			magicien1.creation();

			System.out.println("Le personnage est créé que voulez-vous faire?: afficher,modifier,attaquer ou ajouter sort");
			String faire = sc.nextLine();

			if(faire.equals("afficher")) {
             System.out.println(magicien1);
			}
			else if(faire.equals("modifier")) {
			System.out.println("Veuiller donner un nom au personnage :");
			magicien1.setNom(sc.nextLine());

			System.out.println("Veuiller donner une image au personnage :");
			magicien1.setImage(sc.nextLine());

			System.out.println("Veuiller donner un niveau_de_vie du personnage :");
			magicien1.setVie(sc.nextInt());

			System.out.println("Veuiller donner une force attaque :");
			magicien1.setForce(sc.nextInt());

			sc.nextLine();

			System.out.println("Veuiller ecrire un sort :");
			magicien1.setSort(sc.nextLine());

			System.out.println("Veuiller donner une valeur du bouclier :");
			magicien1.setPhiltre(sc.nextInt());
            System.out.println(magicien1);

		 }

		}

	}
	
			

}