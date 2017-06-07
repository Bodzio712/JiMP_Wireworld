package wireworld;

import javax.swing.*;
import java.awt.*;
import java.util.*;

public class Wireworld {

    static int wys = 5;
    static int szer = 14;
    static Integer [][] plansza = new Integer[wys][szer];
    
    //Od tej zmiennej zalezy ilość obiegów
    static int ilosc_obiegow =9;



    public static void zeruj_ogon (Integer [][] obiekt, int i, int j) {
        int liczniki=0;
        int licznikj=0;
        while (liczniki<i) {
            while (licznikj<j) {
                if (obiekt[liczniki][licznikj]==2)
                    obiekt[liczniki][licznikj]=3;
                licznikj++;
            }
            liczniki++;
            licznikj=0;
        }
        
    }
    
    public static void ile_sasiadow (Integer [][] obiekt, Integer[][] sasiedztwo, int i, int j) {
        int liczniki=0;
        int licznikj=0;
        while (liczniki<i) {
            while (licznikj<j) {
                    if (obiekt[liczniki][licznikj]==3) {
                    //Tutaj liczenie sasiadów
                    int temp_i=liczniki-1;
                    int temp_j=licznikj-1;
                    int suma=0;
                    while(temp_i<=liczniki+1) {
                        while(temp_j<=licznikj+1) {
                            if (temp_i >=0 && temp_i<i) {
                                if (temp_j >=0 && temp_j<j) {
                                    if (obiekt[temp_i][temp_j]==1)
                                        suma++;
                                }
                            }
                            temp_j++;
                        }
                        temp_j=licznikj-1;
                        temp_i++;
                    }
                    sasiedztwo[liczniki][licznikj] = suma;
                }
                licznikj++;
            }
            liczniki++;
            licznikj=0;
        }
    }
    
    public static void glowa_na_ogon (Integer [][] obiekt, int i, int j) {
        int liczniki=0;
        int licznikj=0;
        while (liczniki<i) {
            while (licznikj<j) {
                if (obiekt[liczniki][licznikj]==1)
                    obiekt[liczniki][licznikj]=2;
                licznikj++;
            }
            liczniki++;
            licznikj=0;
        }
    }
    
    public static void dodaj_glowa (Integer [][] obiekt, Integer [][] sasiedztwo, int i, int j) {
        int liczniki=0;
        int licznikj=0;
        while (liczniki<i) {
            while (licznikj<j) {
                if (sasiedztwo[liczniki][licznikj]==1 || sasiedztwo[liczniki][licznikj]==2)
                    obiekt[liczniki][licznikj]=1;
                licznikj++;
            }
            liczniki++;
            licznikj=0;
        }
    }
    
    public static void wypisz (Integer[][] obiekt) {
        for(int i=0; i<wys; i++) {
            for(int j=0; j<szer; j++)
                System.out.print(obiekt[i][j]);
            System.out.print("\n");
        }
    }
    
    public static void wyzeruj (Integer [][] obiekt) {
        for(int i=0; i<wys; i++) {
            for(int j=0; j<szer; j++) 
                    obiekt[i][j]=0;
        }
    }
    
    //Wstawianie obiektow
    
    public static void wstaw_diode (Integer [][] obiekt, int i, int j) {
        int licznik=0;
        while (licznik<6) {
            obiekt[i][j+licznik]=3;
            licznik++;
        }
        obiekt[i-1][j+licznik]=3;
        obiekt[i][j+licznik]=3;
        obiekt[i+1][j+licznik]=3;
        licznik++;
        obiekt[i-1][j+licznik]=3;
        obiekt[i+1][j+licznik]=3;
        licznik++;
        while (licznik<14) {
            obiekt[i][j+licznik]=3;
            licznik++;
        }
    }
    
    public static void wstaw_diode_odwrotnie (Integer [][] obiekt, int i, int j) {
        int licznik=0;
        while (licznik<6) {
            obiekt[i][j+licznik]=3;
            licznik++;
        }
        obiekt[i-1][j+licznik]=3;
        obiekt[i+1][j+licznik]=3;
        licznik++;
        obiekt[i-1][j+licznik]=3;
        obiekt[i][j+licznik]=3;
        obiekt[i+1][j+licznik]=3;
        licznik++;
        while (licznik<14) {
            obiekt[i][j+licznik]=3;
            licznik++;
        }
    }
    
    
    //Wstawianie stanu
    public static void wstaw_kabel (Integer [][] obiekt, int i, int j) {
        obiekt[i][j] = 3;
    }
    
    public static void wstaw_glowka (Integer [][] obiekt, int i, int j) {
        obiekt[i][j] = 1;
    }
    
    public static void wstaw_ogon (Integer [][] obiekt, int i, int j) {
        obiekt[i][j] = 2;
    }
    
    

    public static void main(String[] args) {
        

        Integer [][] sasiedzi = new Integer[wys][szer];
     
        wyzeruj(plansza);
        wyzeruj(sasiedzi);
        
        //W tym miejscu wstawiamy na plansze obiekty
        wstaw_diode(plansza, 2, 0);
        
        System.out.println("Plansza wejsciowa");
        wypisz(plansza);
        System.out.print("\n");
        
        wstaw_glowka(plansza, 2, 0);
        
        int petla_test=0;
        while (petla_test<ilosc_obiegow) {
            
            ile_sasiadow(plansza, sasiedzi, wys, szer);
            zeruj_ogon(plansza, wys, szer);
            glowa_na_ogon(plansza, wys, szer);
            dodaj_glowa(plansza, sasiedzi, wys, szer);
            wyzeruj(sasiedzi);
            new MyFrame();
            //Thread.sleep(2000);
            petla_test++;
        }
       
        System.out.println("Plansza wyjsciowa");
        wypisz(plansza);
    }
}
