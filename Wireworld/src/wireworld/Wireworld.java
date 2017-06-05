package wireworld;

import java.util.*;

public class Wireworld {

    static int wys = 5;
    static int szer = 14; 
    
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
    
    public static void ile_sasiadow (Integer [][] obiekt, int i, int j) {
        
    }
    
    public static void glowa_na_ogon (Integer [][] obiekt, int i, int j) {
        
    }
    
    public static void dodaj_glowa (Integer [][] obiekt, int i, int j) {
        
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
    
    public static void glowka (Integer [][] obiekt, int i, int j) {
        obiekt[i][j] = 1;
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

    public static void main(String[] args) {
        
        Integer [][] plansza = new Integer[wys][szer];
     
        wyzeruj(plansza);
        wstaw_diode(plansza, 2, 0);
        wypisz(plansza);
        
        glowka(plansza, 2, 0);
        
        int petla_test=0;
        while (petla_test<14) {
            
            zeruj_ogon(plansza, wys, szer);
            System.out.println ("Przeszłem ogon");
            //ile_sasiadow(plansza, wys, szer);
            //glowa_na_ogon(plansza, wys, szer);
            //dodaj_glowa(plansza, wys, szer);
            
            System.out.print("\n");
            petla_test++;
        }
        wypisz(plansza);

    }

}
