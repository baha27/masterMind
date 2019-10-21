import java.util.Random;

public class Combinaison {
	static final int N_POS=4; // la proposition est un nb de 4 chiffres
	static final int N_COLOR=8; // on a 8 couleurs 
	
	public int t[]= new int[N_POS];
	
	// constructeur de combinaison aléatoire entre 0000 et 7777
	public Combinaison() {
		Random rand= new Random();
		for(int i=0;i<t.length;i++)
	        t[i] = rand.nextInt(N_COLOR);	
	}
	
	// constructeur qui va servir à stocker une copie de combinaison en cas de besoin
	public Combinaison (Combinaison c) {
		for (int i=0 ; i<t.length; i++)
			this.t[i]=c.t[i];
	}
	

	// méthode qui incrémente la combinaison d'un pas ( combinaison ++)
	public void incrementer(){
	    t[N_POS-1]=t[N_POS-1]+1;
	    for (int i=N_POS-1;i>0;i--)
	        if(t[i]==N_COLOR)
	        {
	            t[i]=0 ;
	            t[i-1]=t[i-1]+1;
	        }
	    if (t[0]==N_COLOR)
	        t[0]=0;        
	}
	// methode qui transforme la combinasion en chaine de caractere (pas obligatoire)
	public String toString() {
		String str="";
		for (int i=0; i<t.length; i++)
			str+=String.valueOf(t[i]);
		return str;
	}
	// methode qui teste l'égalité de 2 combinaisons
	public boolean equals(Combinaison autreCombinaison) {
		return (this.toString().equals(autreCombinaison.toString()));
	}
	// simple methode d'affichage
	public void affiche () {
		System.out.println(toString());
	}
	
}
