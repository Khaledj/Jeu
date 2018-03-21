package personnage;
import java.util.Scanner;

public class Jeu {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Personnage perso = null;

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
			guerrier1.equipement();
			
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
				String modifier ="";

				while(!modifier.equals("sortir")) {
					System.out.println(" Que voulez-vous modifier?:" +
						"\nnom : nom du personnage" +
						"\nimage : image du personnage" +
						"\nvie: vie du personnage " +
						"\nforce : force du personnage" +
						"\narme : arme du personnage" +
						"\nbouclier : bouclier du personnage" +
						"\nsortir : sortir des modifications");

					modifier = sc.nextLine();


					if(modifier.equals("nom")) {
						System.out.println("Veuiller modifier le nom du personnage :" + guerrier1.getNom());
						guerrier1.setNom(sc.nextLine());

					}else if(modifier.equals("image")){
						System.out.println("Veuiller modifier l'image du personnage :" + guerrier1.getImage());
						guerrier1.setImage(sc.nextLine());

					}else if(modifier.equals("vie")){
						System.out.println("Veuiller modifier le niveau_de_vie du personnage entre 0 et 100 :" + guerrier1.getVie());
						guerrier1.setVie(sc.nextInt());

					}else if(modifier.equals("force")){
						System.out.println("Veuiller modifier la force d'attaque entre 0 et 100:" + guerrier1.getForce());
						guerrier1.setForce(sc.nextInt());

						sc.nextLine();

					}else if(modifier.equals("arme")){
						System.out.println("Veuiller modifier l'arme :" + guerrier1.getArme());
						guerrier1.setArme(sc.nextLine());

					}else if(modifier.equals("bouclier")){
						System.out.println("Veuiller modifier la valeur du bouclier entre 0 et 100 :" + guerrier1.getBouclier());
						guerrier1.setBouclier(sc.nextInt());

					}
				}
				
				
			}else if(faire.equals("attaquer")) {
				guerrier1.attaque();
			}

		}else {
			Magicien magicien1 = new Magicien();
			magicien1.creation();
			magicien1.equipement();


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
				String modifier ="";

				while(!modifier.equals("sortir")) {
					System.out.println(" Que voulez-vous modifier?:" +
						"\nnom : nom du personnage" +
						"\nimage : image du personnage" +
						"\nvie: vie du personnage " +
						"\nforce : force du personnage" +
						"\nsort : sort du personnage" +
						"\nphiltre : philtre du personnage");

					 modifier = sc.nextLine();

					if(modifier.equals("nom")) {
						System.out.println("Veuiller modifier le nom du personnage :" + magicien1.getNom());
						magicien1.setNom(sc.nextLine());

					}else if(modifier.equals("image")){
						System.out.println("Veuiller modifier l'image du personnage :" + magicien1.getImage());
						magicien1.setImage(sc.nextLine());

					}else if(modifier.equals("vie")){
						System.out.println("Veuiller modifier le niveau_de_vie entre 0 et 100:" + magicien1.getVie());
						magicien1.setVie(sc.nextInt());

					}else if(modifier.equals("force")){
						System.out.println("Veuiller modifier la force d'attaque entre 0 et 100:" + magicien1.getForce());
						magicien1.setForce(sc.nextInt());
						sc.nextLine();
					}else if(modifier.equals("sort")){
						System.out.println("Veuiller modifier votre sort :" + magicien1.getSort());
						magicien1.setSort(sc.nextLine());
					}else if(modifier.equals("philtre")){
						System.out.println("Veuiller modifier la valeur du philtre entre 0 et 100 :" + magicien1.getPhiltre());
						magicien1.setPhiltre(sc.nextInt());
					}
				}
				

			}else if(faire.equals("attaquer")) {
				magicien1.attaque();
				

			}


			

		}

	}	
}	

