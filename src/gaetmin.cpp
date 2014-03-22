//============================================================================
// Name        : gaetmin.cpp
// Author      : yves Mercadier
// Version     :
// Copyright   : Your copyright notice
// Description : générateur aléatoire à partir d'une horloge Ansi-style
//============================================================================
#include <iostream>
#include <string>
#include <fstream>
#include <sys/time.h>
#include <math.h>

using namespace std;
int nb=1000;

int graine() {
	struct timeval temps;
    gettimeofday(&temps,NULL);
	int bit=(int(double(temps.tv_usec)*M_PI))%2;
	return bit;
	}

double esperance(int tab[]){
	int j=0;
	for(int i=0;i<nb;i++){
			 if(tab[i]==1){j++;}
		 }
	double espe=(double)j/nb;
	return espe;
	}
	
double variance(int tab[]){
	int j=0;
	for(int i=0;i<nb;i++){
			 if(tab[i]==1){j++;}
		 }
	double vari=j*(1-esperance(tab))*(1-esperance(tab))/nb;
	return vari;
	}
	
int main()
{
	cout << "Début du programme."<< endl;
	cout << "Génération de "<<nb<<" bits aléatoires."<< endl;

	struct timeval debut,fin;
    int tab [nb];
    gettimeofday(&debut,NULL);
	for(int i=0;i<nb;i++){
		tab[i]=graine();
	}
	gettimeofday(&fin,NULL);
	double duree=fin.tv_usec-debut.tv_usec;
	cout << "Temps de génération :"<<duree<<" microsecondes"<< endl;
	cout << "Espérance(True) :"<<esperance(tab)<< endl;
	cout << "Variance(True) :"<<variance(tab)<< endl;

	for(int i=0;i<nb;i++){
		cout << tab[i]<< " ";
	}
    cout << endl;
    cout << "Fin du programme."<< endl;
}
