import java.util.ArrayList;
import java.util.Scanner;

public class Mind {
	
	// methode qui calcule la ressemblance entre 2 combinaisons 
	public static String ressemblance(Combinaison c1 , Combinaison c2) {
		Combinaison comb1= new Combinaison(c1); // je crée des copies pour ne 
		Combinaison comb2= new Combinaison(c2); // pas  modifier les combinaisons
		int Noir = 0, Blanc = 0;
	// on calcule les noirs	
		for (int i = 0; i <comb1.t.length ; i++) {
			if (comb1.t[i]==comb2.t[i]) {
				Noir++;
				comb1.t[i]='*'; // on écrase chaque noir trouvé 
				comb2.t[i]='*'; // pour ne le plus prendre en compte
			}
		}
		// on calcule les blancs
		for (int i = 0; i < comb1.t.length; i++) 
			for (int j = 0; j < comb2.t.length; j++)
				if ((comb1.t[i]==comb2.t[j]) && (comb1.t[i] != '*'))
				{
					Blanc++;
					comb1.t[i]='*'; // on écrase chaque blanc trouvé
					comb2.t[j]='*'; // pour ne le plus prendre en compte
				}	
		return String.valueOf(Noir) + String.valueOf(Blanc);
		// je retourne une chaine qui contient nb noirs et nb blancs
	}

	// methode reccurente qui fait le test pour qu'une combinaison sera prise comme prochaine proposition
	// n: nombre des essais (cad nb des propositions) 
	// c: combinaison variable qui va s'incrementer 
	// Propositions : liste dynamique qui stocke à fur et à mesure chaque proposition proposée
	// Reponses : liste dynamique qui stocke à fur et à mesure chaque reponse de l'utilisateur
	public static boolean conditionChoix(int n , Combinaison c , ArrayList<Combinaison> Propositions , ArrayList<String> Reponses) {
		boolean res=true;
		if (n==0)
			return ressemblance(c,Propositions.get(0)).equals(Reponses.get(0));
		else
			res=ressemblance(c,Propositions.get(n)).equals(Reponses.get(n));
		
		return res && conditionChoix (n-1,c,Propositions,Reponses); 
		//le retour de la fonction est une somme logique des conditions de choix précédentes                                                            
	}
	
	// simple methode qui saisie la réponse de l'utilisateur (nb des noirs et blancs)
	public static void saisieReponse(ArrayList<String> Reponses) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Noir?");
		int Noir = sc.nextInt();
		System.out.println("Blanc?");
		int Blanc = sc.nextInt();
		String rep = String.valueOf(Noir) + String.valueOf(Blanc);
		Reponses.add(rep);
	}
	
	
	
}
