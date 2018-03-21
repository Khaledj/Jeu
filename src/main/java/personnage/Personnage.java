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
			System.out.println("Le personnage est créé que voulez-vous faire?:" +
				"\nafficher : afficher un personnage" +
				"\nmodifier : modifier un personnage" +
				"\nattaquer: voulez-vous attaquer" +
				"\najouter : ajouter une arme");
			String faire = sc.nextLine();
           
			if(faire.equals("afficher")) {
             System.out.println(guerrier1);
			} 
		    else if(faire.equals("modifier")) {
			System.out.println("Veuiller modifier le nom du personnage :"+ guerrier1.getNom());
			guerrier1.setNom(sc.nextLine());
            
			System.out.println("Veuiller modifier l'image du personnage :" + guerrier1.getImage());
			guerrier1.setImage(sc.nextLine());

			System.out.println("Veuiller modifier le niveau_de_vie du personnage :" + guerrier1.getVie());
			guerrier1.setVie(sc.nextInt());

			System.out.println("Veuiller modifier la force d'attaque :" + guerrier1.getForce());
			guerrier1.setForce(sc.nextInt());

			sc.nextLine();

			System.out.println("Veuiller modifier votre arme :" + guerrier1.getArme());
			guerrier1.setArme(sc.nextLine());


			System.out.println("Veuiller modifier la valeur du bouclier :" + guerrier1.getBouclier());
			guerrier1.setBouclier(sc.nextInt());
            System.out.println(guerrier1);

		 }
		 else if(faire.equals("attaquer")) {
		 	guerrier1.attaque();
		 	System.out.println(guerrier1);
		 }

		}else {
			Magicien magicien1 = new Magicien();
			magicien1.creation();

			System.out.println("Le personnage est créé que voulez-vous faire?:" +
				"\nafficher : afficher un personnage" +
				"\nmodifier : modifier un personnage" +
				"\nattaquer: voulez-vous attaquer" +
				"\najouter : ajouter un sort");
			String faire = sc.nextLine();

			if(faire.equals("afficher")) {
             System.out.println(magicien1);
			}
			else if(faire.equals("modifier")) {
			System.out.println("Veuiller modifier le nom du personnage :" + magicien1.getNom());
			magicien1.setNom(sc.nextLine());

			System.out.println("Veuiller modifier l'image du personnage :" + magicien1.getImage());
			magicien1.setImage(sc.nextLine());

			System.out.println("Veuiller modifier le niveau_de_vie du personnage :" + magicien1.getVie());
			magicien1.setVie(sc.nextInt());

			System.out.println("Veuiller modifier la force d'attaque :" + magicien1.getForce());
			magicien1.setForce(sc.nextInt());

			sc.nextLine();

			System.out.println("Veuiller modifier votre sort :" + magicien1.getSort());
			magicien1.setSort(sc.nextLine());

			System.out.println("Veuiller modifier la valeur du philtre :" + magicien1.getPhiltre());
			magicien1.setPhiltre(sc.nextInt());
            System.out.println(magicien1);

		 }

		}

	}
	
			

}