package personnage;
import java.sql.*;
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
		try {
			Connection conn = Connect.Connect();

			PreparedStatement preparedStatement = conn.prepareStatement("INSERT INTO personnage (Id,Type,Nom,Image,NiveauVie,Attaque,EquipementOffensif,EquipementDefensif) VALUES (NULL,?,?,?,?,?,?,?)");

			System.out.println("Type de personnage : guerrier ou magicien");
			System.out.println("Veuiller choisir un type de personnage :");
			String choix = sc.nextLine();

			while (!choix.equals("guerrier") && !choix.equals("magicien")) {
				System.out.println("Veuiller choisir un type de personnage :");
				choix = sc.nextLine();
			}

			if (choix.equals("guerrier")) {
				Guerrier guerrier = new Guerrier();
				try {
					guerrier.creation();
				} catch (ChampVideException e) {
					guerrier.setNom("John Doe");
				}
				guerrier.equipement();

				preparedStatement.setString(1,choix);
				preparedStatement.setString(2,guerrier.getNom());
				preparedStatement.setString(3,guerrier.getImage());
				preparedStatement.setInt(4,guerrier.getVie());
				preparedStatement.setInt(5,guerrier.getForce());
				preparedStatement.setString(6,guerrier.getNewArme());
				preparedStatement.setInt(7,guerrier.getBouclier());

				int statut = preparedStatement.executeUpdate();

				preparedStatement.close();

				personnage.add(guerrier);
				//ajoute au tableau
				//tableauPerso[nbperso] = guerrier;
				//nbperso++;
			} else {
				Magicien magicien = new Magicien();
				try {
					magicien.creation();
				} catch (ChampVideException e) {
					magicien.setNom("John Doe");
				}
				magicien.equipement();
				preparedStatement.setString(1,choix);
				preparedStatement.setString(2,magicien.getNom());
				preparedStatement.setString(3,magicien.getImage());
				preparedStatement.setInt(4,magicien.getVie());
				preparedStatement.setInt(5,magicien.getForce());
				preparedStatement.setString(6,magicien.getNewSort());
				preparedStatement.setInt(7,magicien.getPhiltre());

				int statut = preparedStatement.executeUpdate();

				preparedStatement.close();
				personnage.add(magicien);
				//ajoute au tableau
				//tableauPerso[nbperso] = magicien;
				//nbperso++;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Display perso.
	 */
	public static void displayPerso(){

		//System.out.println("veuillez saisir le numero du personnage (en commencant à 0 pour tableau)");
		System.out.println("veuillez saisir le numero du personnage (en commencant à 1)");
		int i = sc.nextInt();
		sc.nextLine();
		try {
			Connection conn = Connect.Connect();

		Statement state = conn.createStatement();
		ResultSet result = state.executeQuery("SELECT * FROM personnage WHERE id=" +i);
		ResultSetMetaData resultMeta = result.getMetaData();
		System.out.println("\n*********************************************************************************************************");

		for(int j = 1; j <= resultMeta.getColumnCount(); j++)
			System.out.print("\t" + resultMeta.getColumnName(j).toUpperCase() + "\t *");
		System.out.println("\n*********************************************************************************************************");

		while(result.next()){
			for(int j = 1; j <= resultMeta.getColumnCount(); j++)
				System.out.print("\t" + result.getObject(j).toString() + "\t |");
			System.out.println("\n----------------------------------------------------------------------------------------------------");

		}

		result.close();
		state.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		//System.out.println (personnage.get(i));
		//afficher le contenu du tableau
		//System.out.println(tableauPerso[i]);
	}

	/**
	 * Update perso.
	 */
	public static void updatePerso() {
		//System.out.println("veuillez saisir le numero du personnage (en commencant à 0 pour tableau)");
		System.out.println("veuillez saisir le numero du personnage (en commencant à 1)");
		int i = sc.nextInt();
		sc.nextLine();
		try {
			Connection conn = Connect.Connect();
			Statement state1 = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
			ResultSet choix= state1.executeQuery("SELECT * FROM personnage WHERE id=" +i);
			choix.first();

		String modifier;
		do {
			System.out.println(" Que voulez-vous modifier?:" +
					"\nnom : nom du personnage" +
					"\nimage : image du personnage" +
					"\nvie: vie du personnage " +
					"\nforce : force du personnage" +
					"\nequipement : equipement du personnage" +
					"\ndefense : bouclier/philtre du personnage" +
					"\nsortir : sortir des modifications");
			 modifier = sc.nextLine();


			if (modifier.equals("nom")) {

				String name="";
				name = choix.getString("Nom");
				System.out.println("Veuiller modifier le nom du personnage :" + name);
				choix.updateString("Nom",sc.nextLine());
				choix.updateRow();

				//System.out.println("Veuiller modifier le nom du personnage :" + personnage.get(i).getNom());
				//personnage.get(i).setNom(sc.nextLine());

			}else if (modifier.equals("image")) {

				String picture="";
				picture = choix.getString("Image");
				System.out.println("Veuiller modifier le nom du personnage :" + picture);
				choix.updateString("Image",sc.nextLine());
				choix.updateRow();

				//System.out.println("Veuiller modifier l'image du personnage :" + personnage.get(i).getImage());
				//personnage.get(i).setImage(sc.nextLine());

			} else if (modifier.equals("vie")) {

				int life;
				life = choix.getInt("NiveauVie");
				System.out.println("Veuiller modifier le nom du personnage :" + life);
				choix.updateInt("NiveauVie",sc.nextInt());
				choix.updateRow();
				//System.out.println("Veuiller modifier le niveau_de_vie du personnage entre 0 et 100 :" + personnage.get(i).getVie());
				//personnage.get(i).setVie(sc.nextInt());

			} else if (modifier.equals("force")) {

				int power;
				 power= choix.getInt("Attaque");
				System.out.println("Veuiller modifier le nom du personnage :" + power);
				choix.updateInt("Attaque",sc.nextInt());
				choix.updateRow();

				//System.out.println("Veuiller modifier la force d'attaque entre 0 et 100:" + personnage.get(i).getForce());
				//personnage.get(i).setForce(sc.nextInt());
				sc.nextLine();

			} else if (modifier.equals("equipement")) {

				String offensif;
				offensif= choix.getString("EquipementOffensif");
				System.out.println("Veuiller modifier le nom du personnage :" + offensif);
				choix.updateString("EquipementOffensif",sc.nextLine());
				choix.updateRow();

				//int choisi;
				//System.out.println("Quel arme voulez-vous modifier?");
				//personnage.get(i).afficheEquipement();
				//choisi = Integer.parseInt(sc.nextLine());
				//System.out.println("Veuiller modifier l'equipement" + choisi);
				//String modif;
				//modif = sc.nextLine();
				//if (personnage.get(i) instanceof Guerrier) {
					//((Guerrier) personnage.get(i)).getArme().set(choisi, modif);
				//} else {
					//((Magicien) personnage.get(i)).getSort().set(choisi, modif);
				//}

			} else if (modifier.equals("defense")) {

				String defensif;
				defensif= choix.getString("EquipementDefensif");
				System.out.println("Veuiller modifier le nom du personnage :" + defensif);
				choix.updateString("EquipementDefensif",sc.nextLine());
				choix.updateRow();

//				if (personnage.get(i) instanceof Guerrier) {
//					System.out.println("Veuiller modifier la valeur du bouclier entre 0 et 100 :" + ((Guerrier) personnage.get(i)).getBouclier());
//					((Guerrier) personnage.get(i)).setBouclier(sc.nextInt());
//				} else {
//					System.out.println("Veuiller modifier la valeur du philtre entre 0 et 100 :" + ((Magicien) personnage.get(i)).getPhiltre());
//					((Magicien) personnage.get(i)).setPhiltre(sc.nextInt());
//				}
			}

		}while (!modifier.equals("sortir"));
			choix.close();
			state1.close();

			}catch(Exception e) {
				e.printStackTrace();
			}
	}


	/**
	 * Attack.
	 */
	public static void attack()
	{
		System.out.println("veuillez saisir le numero du personnage (en commencant à 0 pour tableau");
		int i = sc.nextInt();
		sc.nextLine();
		personnage.get(i).attaque();

	}
}

