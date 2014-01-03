import  java.util.concurrent.TimeUnit;
import java.util.*;

public class gaetmin {
	
	public static boolean graine() {
		boolean bit;
		long bite=System.nanoTime() % 2;
		if(bite==1) bit=true;
		else bit=false;
		return bit;
	}
	
	public static boolean rand() {
		boolean bit;
		//long bite = Math.round(Math.random());
	    Random rand = new Random();
	    long bite =rand.nextInt(2);
		if(bite==1)bit=true;
		else bit=false;
		return bit;
	}
	
	public static double esperance(boolean t[]) {
		int j=0;
		 for(int i=0;i<t.length;i++){
			 if(t[i]){j++;}
		 }
		double espe=(double)j/t.length;
		return espe;
	}
	
	public static double variance(boolean t[]) {
		int j=0;
		 for(int i=0;i<t.length;i++){
			 if(t[i]){j++;}
		 }
		double vari=j*(1-esperance(t))*(1-esperance(t))/t.length;
		return vari;
	}
	
	 public static void main(String[] args)
		{System.out.println("Début du programme");
		System.out.println();
		int nb=1000;
		System.out.println("Génération de "+nb+" bits aléatoires");
		System.out.println();

		System.out.println("Méthode gaetmin : ");
		System.out.println();

		long debut=System.nanoTime();
		boolean[] tab=new boolean[nb];
		 for(int i=0;i<nb;i++){
			 tab[i]=graine();
		 }
		 long duree=System.nanoTime()-debut;
		 duree=TimeUnit.MICROSECONDS.convert(duree, TimeUnit.NANOSECONDS);
		 for(int i=0;i<nb;i++){
			 System.out.print(tab[i]+" ");

		 }
		 System.out.println();
		 System.out.println();
		 System.out.println("Temps de génération :"+duree+" microsecondes");
		 System.out.println("Espérance(True) :"+esperance(tab));
		 System.out.println("Variance(True) :"+variance(tab));
		 System.out.println();
		 System.out.println("Méthode classique : ");
		 System.out.println();

		 debut=System.nanoTime();
		 for(int i=0;i<nb;i++){
				 tab[i]=rand();
			 }
		 duree=System.nanoTime()-debut;
		 duree=TimeUnit.MICROSECONDS.convert(System.nanoTime()-debut, TimeUnit.NANOSECONDS);
		 for(int i=0;i<nb;i++){
				 System.out.print(tab[i]+" ");
			 }
		 System.out.println();
		 System.out.println();
		 System.out.println("Temps de génération :"+duree+" microsecondes");
		 System.out.println("Espérance(True) :"+esperance(tab));
		 System.out.println("Variance(True) :"+variance(tab));
		 System.out.println();
			 
		 System.out.println("Fin du programme");
		}
}
