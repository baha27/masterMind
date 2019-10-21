import java.util.ArrayList;
import java.util.Scanner;



public class MasterMind {

	
	
	public static void main(String[] args) {

		FenetreMind f = new FenetreMind();
		f.setVisible(true);

		
			

	ArrayList<String> Reponses=new ArrayList<String>(); // liste vide qui va stocker les reponses
	ArrayList<Combinaison> Propositions=new ArrayList<Combinaison>(); // de meme pour les propositions

	
	System.out.println("Choisisez une combinaison (entre 0000 et 7777)");
	Combinaison c= new Combinaison(); //on cr�e une combinaison al�atoire 
	Combinaison cDepart = new Combinaison(c); // on la stocke comme combinaison de d�part
	
	
	int i=0; // on initialise le nombre d'essais � zero
	System.out.println("je vous propose:");
	cDepart.affiche(); // on afiiche la combinaison de d�part qui sera la 1ere proposition
	Propositions.add(new Combinaison(cDepart)); // on l'ajoute � la liste des propositions
	Mind.saisieReponse(Reponses); // on saisie la 1ere r�ponse de l'utilisateur
	c.incrementer(); // on incr�mente la combinaison 
	
	
	
	while ( !(c.equals(cDepart)) ) { // tant que la combinaisson n'a pas revenue � Comb du depart
		
		if (Mind.conditionChoix(i, c, Propositions, Reponses)==true) { // si le test est vrai 
			Propositions.add(new Combinaison(c)); // on cr�e une copie de la combinaison 
			System.out.println("je vous propose "); // et on l'ajoute � la liste des propositions
			c.affiche(); // on affiche la proposition
			Mind.saisieReponse(Reponses); // on saisie la reponse de l'utilisateur
			i++;
		}
		c.incrementer(); // on incr�mente
	
	}	
		if (Reponses.get(Reponses.size()-1).equals("40")) {
			int j=i+1;
			System.out.println("nombre trouv� apr�s ("+j+ ") propositions");
		}
		else if (c.equals(cDepart))
			System.out.println("v�rifiez vos r�ponses , il y a une erreur '-' :");
	
	

	System.out.println("Mes propositions:");

	for (i=0 ; i<Propositions.size() ; i++)
		System.out.print(Propositions.get(i).toString()+"|");
	System.out.println("\n-----------------------------");
	
	System.out.println("Vos r�ponses N|B");
	for (i=0 ; i<Reponses.size() ; i++)
		System.out.print(" "+Reponses.get(i)+"| ");
	
	}
	

}
