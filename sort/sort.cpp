#include <iostream>
#include <cstdlib>
#include <ctime>
#include <algorithm>
#include <functional>

using namespace std;

class Klasa {
public:
    int krotnosc;
    double pomiar;
    Klasa(){};
    Klasa(int krotnosc, double pomiar) {
    this -> krotnosc = krotnosc;
    this -> pomiar = pomiar;
    }
    int getKrotnosc() {
        return krotnosc;
        }
    double getPomiar() {
        return pomiar;
        }
    bool operator < (Klasa klasa) {
        if ((this -> pomiar < klasa.pomiar ) || (( this -> pomiar == klasa.pomiar ) && ( this -> krotnosc > klasa.krotnosc ))) {
            return true;
        } else {
            return false;
        }
    }
    bool operator > (Klasa klasa) {
        if ( (this -> pomiar > klasa.pomiar) || ( (this -> pomiar == klasa.pomiar) && (this -> krotnosc < klasa.krotnosc) ) ) {
            return true;
        } else {
            return false;
        }
    }
};

void insertSort(Klasa tab[], int n) {
    for (int i = 1, j; i  < n; i++) {
        Klasa tmp(tab[i].krotnosc, tab[i].pomiar);
        double tmp2 = tab[i].pomiar;
        for (j = i; j > 0 && tmp < tab[j-1] ; j--) {
            tab[j].pomiar = tab[j-1].pomiar;
            tab[j].krotnosc = tab[j-1].krotnosc;
        }
        tab[j].pomiar = tmp.pomiar;
        tab[j].krotnosc = tmp.krotnosc;
    }
}

int podzial(Klasa tab[], int lewa, int prawa) {
    int i = lewa, j = prawa+1;
    Klasa pv (tab[lewa].krotnosc,tab[lewa].pomiar);
    while (true) {
        while (tab[++i] < pv) {
            if(i == prawa) {
                break;
            } //do lewej
        }
        while (tab[--j] > pv) {
            if(j == lewa) {
                break;
            } //do prawej
        }
        if (i >= j) {
            break;
        }
        swap (tab[i].pomiar, tab[j].pomiar);
        swap (tab[i].krotnosc, tab[j].krotnosc);
    }
    swap (tab[lewa].pomiar, tab[j].pomiar);
    swap (tab[lewa].krotnosc, tab[j].krotnosc);
    return j;
}

void quickSort(Klasa tab[], int lewa, int prawa) {
    if (lewa >= prawa) {
        return;
    }
    int j = podzial(tab, lewa, prawa);
    quickSort(tab,lewa,j-1);
    quickSort(tab, j+1, prawa);
}

bool odNajmniejszego(Klasa obiekt1, Klasa obiekt2) {
    return obiekt1 < obiekt2;
}

void wypiszTablice(Klasa tab[],int n) {
	for (int i = 0; i < n; i++) {
            cout<<tab[i].pomiar<<" : "<<tab[i].krotnosc<<endl;
	}
}

int main() {
    int rozmiar=100000;
    Klasa tablica[rozmiar];
    for ( int i = 0; i < rozmiar; i++) {
        tablica[i].krotnosc = (rand()%101)+0;
        tablica[i].pomiar =rand()%2001*0.5;
    }
    insertSort(tablica,rozmiar);
    //quickSort(tablica,0,rozmiar-1);
    //sort(tablica, tablica + rozmiar, odNajmniejszego);
    //wypiszTablice(tablica,rozmiar);
}
