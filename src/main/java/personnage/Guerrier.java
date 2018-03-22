package personnage;
import java.util.Scanner;
import java.util.*;

public class Guerrier extends Personnage {
	Scanner sc = new Scanner(System.in);
	ArrayList<String> arme = new ArrayList<String>();
	int bouclier;

	public void equipement() {
		
		System.out.println("Veuiller écrire une arme :");
		String newArme = sc.nextLine();
		arme.add(newArme);
		 while(newArme.equals("")) {
		 	System.out.println("Veuiller écrire une arme :");
		 	newArme = sc.nextLine();
		 	arme.add(newArme);		
		 }

		
		ajoutarme();

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

	   public void affichearme() {

	   	for(int i=0; i<arme.size();i++){
	   		System.out.println(arme.get(i)+ "  -  "+ i);
	   	}	
	   }
       
       

	public int getBouclier() {
		return bouclier;
	} 
	
	public void setBouclier(int bouclier2) {
		while(bouclier2 <0 || bouclier2>100) {
			System.out.println("Veuiller modifier la valeur du bouclier entre 0 et 100 :" + getBouclier());
			bouclier2 =sc.nextInt();
		}
		bouclier = bouclier2;
	} 
    public void ajoutarme() {
     	    String validation;
    	    System.out.println("Ajouter une arme :" + "\noui" + "\nnon");
			validation = sc.nextLine();
    		
			 while(validation.equals("oui")) {
               System.out.println("Veuiller écrire une arme :");
               String newArme = sc.nextLine();
			   arme.add(newArme);
			   System.out.println("Ajouter une arme :" + "\noui" + "\nnon");
			   validation = sc.nextLine();
            }
			
           
    }	    
    
	

}