package wireworld;

import java.util.*;

public class Wireworld {

    static int wys = 5;
    static int szer = 14; 
    
    public static void dioda_oblicz (Integer [][] obiekt, int i, int j) {
        int licznik=0;
        while (licznik<14) {
            if (obiekt[i-1][j+licznik]==2)
                obiekt[i-1][j+licznik]=3;
            if (obiekt[i][j+licznik]==2)
                obiekt[i][j+licznik]=3;
            if (obiekt[i+1][j+licznik]==2)
                obiekt[i+1][j+licznik]=3;
            licznik++;
        }
        licznik=0;
        while (licznik<14) {
            if(obiekt[i-1][j+licznik]==1 || obiekt[i][j+licznik]==1 || obiekt[i+1][j+licznik]==1) {
                if(obiekt[i-1][j+licznik] != 0)
                    obiekt[i-1][j+licznik] =2;
                if(obiekt[i][j+licznik] != 0)
                    obiekt[i][j+licznik] =2;
                if(obiekt[i+1][j+licznik] != 0)
                    obiekt[i+1][j+licznik] =2;
                if(licznik<13)
                    licznik++;
                
                if(obiekt[i-1][j+licznik] != 0)
                    obiekt[i-1][j+licznik] =1;
                if(obiekt[i][j+licznik] != 0)
                    obiekt[i][j+licznik] =1;
                if(obiekt[i+1][j+licznik] != 0)
                    obiekt[i+1][j+licznik] =1;
                break;
            }
            else
                licznik++;
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
            dioda_oblicz(plansza, 2, 0);
            wypisz(plansza);
            System.out.print("\n");
            petla_test++;
        }

    }

}
