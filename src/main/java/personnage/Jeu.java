package personnage;
import java.util.Scanner;
import java.util.*;

/**
 * The type Jeu.
 */
public class Jeu {

	private static ArrayList<Personnage> personnage = new ArrayList<Personnage>();
	//private static Personnage tableauPerso[] = new Personnage[10];//tableau de perso
	private static Scanner sc = new Scanner(System.in);
	private static int nbperso;

	/**
	 * The entry point of application.
	 *
	 * @param args the input arguments
	 */
	public static void main(String[] args) {

		String choix;
		do {
			System.out.println("Que voulez-vous faire?:" +
					"\n1 : Créer un personnage" +
					"\n2 : afficher un personnage" +
					"\n3 : modifier un personnage" +
					"\n4: lancer une attaque" +
					"\n5 : sortir du jeu");
			choix = sc.nextLine();

			switch (choix) {
				case "1":
					createPerso();
					break;
				case "2":
					displayPerso();
					break;
				case "3":
					updatePerso();
					break;
				case "4":
					attack();
					break;
				case "5":
					;
					break;
				default:
					System.out.println("Erreur de saisie");
					break;
			}
		} while (!choix.equals("5"));


	}

	/**
	 * Create perso.
	 */
	public static void createPerso()
	{
		System.out.println("Type de personnage : guerrier ou magicien");
		System.out.println("Veuiller choisir un type de personnage :");
		String choix = sc.nextLine();

		while(!choix.equals("guerrier") && !choix.equals("magicien")) {
			System.out.println("Veuiller choisir un type de personnage :");
			choix=sc.nextLine();
		}

		if(choix.equals("guerrier")) {
			Guerrier guerrier = new Guerrier();
			guerrier.creation();
			guerrier.equipement();
			personnage.add(guerrier);
			//ajoute au tableau
			//tableauPerso[nbperso] = guerrier;
			//nbperso++;
		}else {
			Magicien magicien = new Magicien();
			magicien.creation();
			magicien.equipement();
			personnage.add(magicien);
			//ajoute au tableau
			//tableauPerso[nbperso] = magicien;
			//nbperso++;
		}
	}

	/**
	 * Display perso.
	 */
	public static void displayPerso(){
		System.out.println("veuillez saisir le numero du personnage (en commencant à 0");
		int i = sc.nextInt();
		sc.nextLine();
		System.out.println (personnage.get(i));
		//afficher le contenu du tableau
		//System.out.println(tableauPerso[i]);
	}

	/**
	 * Update perso.
	 */
	public static void updatePerso() {
		System.out.println("veuillez saisir le numero du personnage (en commencant à 0");
		int i = sc.nextInt();
		sc.nextLine();
		String modifier;
		do {
			System.out.println(" Que voulez-vous modifier?:" +
					"\nnom : nom du personnage" +
					"\nimage : image du personnage" +
					"\nvie: vie du personnage " +
					"\nforce : force du personnage" +
					"\nequipement : equipement du personnage" +
					"\nbouclier/philtre : bouclier/philtre du personnage" +
					"\nsortir : sortir des modifications");
			 modifier = sc.nextLine();

			if (modifier.equals("nom")) {
				System.out.println("Veuiller modifier le nom du personnage :" + personnage.get(i).getNom());
				personnage.get(i).setNom(sc.nextLine());

			} else if (modifier.equals("image")) {
				System.out.println("Veuiller modifier l'image du personnage :" + personnage.get(i).getImage());
				personnage.get(i).setImage(sc.nextLine());

			} else if (modifier.equals("vie")) {
				System.out.println("Veuiller modifier le niveau_de_vie du personnage entre 0 et 100 :" + personnage.get(i).getVie());
				personnage.get(i).setVie(sc.nextInt());

			} else if (modifier.equals("force")) {
				System.out.println("Veuiller modifier la force d'attaque entre 0 et 100:" + personnage.get(i).getForce());
				personnage.get(i).setForce(sc.nextInt());
				sc.nextLine();

			} else if (modifier.equals("equipement")) {
				int choisi;
				System.out.println("Quel arme voulez-vous modifier?");
				personnage.get(i).afficheEquipement();
				choisi = Integer.parseInt(sc.nextLine());
				System.out.println("Veuiller modifier l'equipement" + choisi);
				String modif;
				modif = sc.nextLine();
				if (personnage.get(i) instanceof Guerrier) {
					((Guerrier) personnage.get(i)).getArme().set(choisi, modif);
				} else {
					((Magicien) personnage.get(i)).getSort().set(choisi, modif);
				}

			} else if (modifier.equals("bouclier")) {
				if (personnage.get(i) instanceof Guerrier) {
					System.out.println("Veuiller modifier la valeur du bouclier entre 0 et 100 :" + ((Guerrier) personnage.get(i)).getBouclier());
					((Guerrier) personnage.get(i)).setBouclier(sc.nextInt());
				} else {
					System.out.println("Veuiller modifier la valeur du philtre entre 0 et 100 :" + ((Magicien) personnage.get(i)).getPhiltre());
					((Magicien) personnage.get(i)).setPhiltre(sc.nextInt());
				}
			}
		}while (!modifier.equals("sortir"));
	}


	/**
	 * Attack.
	 */
	public static void attack()
	{
		System.out.println("veuillez saisir le numero du personnage (en commencant à 0");
		int i = sc.nextInt();
		sc.nextLine();
		personnage.get(i).attaque();

	}
}

