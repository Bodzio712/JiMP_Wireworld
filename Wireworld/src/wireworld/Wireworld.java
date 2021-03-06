package wireworld;

import javax.swing.JPanel;
import java.awt.*;
import java.util.*;

public class Wireworld {

    static int wys = 10;
    static int szer = 14;
    static Integer [][] plansza = new Integer[wys][szer];
    
    //Od tej zmiennej zalezy ilość obiegów
    int ilosc_obiegow =14;



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
    
    public static void wstaw_bramke_or (Integer [][] obiekt, int i, int j) {
        int licznik=0;
        while(licznik<5) {
            obiekt[i][j+licznik]=3;
            obiekt[i+2][j+licznik]=3;
            licznik++;
        }
        while(licznik<7) {
            obiekt[i-1][j+licznik]=3;
            obiekt[i+3][j+licznik]=3;
            licznik++;
        }
        obiekt[i-1][j-1+licznik]=3;
        obiekt[i][j+licznik]=3;
        obiekt[i-1][j+licznik]=3;
        obiekt[i-2][j+licznik]=3;
        licznik++;
        while(licznik<14) {
            obiekt[i-1][j+licznik]=3;
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
    
    public static void wstaw_obiekty () {
                //W tym miejscu wstawiamy na plansze obiekty
        wstaw_diode(plansza, 2, 0);
        wstaw_diode_odwrotnie (plansza, 7, 0);
        
        wstaw_glowka(plansza, 2, 0);
        wstaw_glowka(plansza, 7, 0);
    }
    
    

    public static void main(String[] args) {
        

        Integer [][] sasiedzi = new Integer[wys][szer];
     
        wyzeruj(plansza);
        wyzeruj(sasiedzi);

        wstaw_obiekty();
        
        System.out.println("Plansza wejsciowa");
        wypisz(plansza);
        System.out.print("\n");
        

        
        System.out.println("Prosze podac ilosc krokow jaka ma wykonac program");
        
        Scanner scan = new Scanner(System.in);
        int ilosc_obiegow = scan.nextInt();
        
        new MyFrame();
         
        int petla_test=0;
        int ilosc_wyk_obiegow=0;
        
        while (petla_test<ilosc_obiegow) {
            if(ilosc_wyk_obiegow>=szer) {
                wstaw_obiekty();
                ilosc_wyk_obiegow-=szer;
            }

            ile_sasiadow(plansza, sasiedzi, wys, szer);
            zeruj_ogon(plansza, wys, szer);
            glowa_na_ogon(plansza, wys, szer);
            dodaj_glowa(plansza, sasiedzi, wys, szer);
            wyzeruj(sasiedzi);

            try {
            Thread.sleep(1000);
        } catch (InterruptedException e)
        {
            System.out.println("Scanning...");
        }
            petla_test++;
            ilosc_wyk_obiegow++;
        }
       
        System.out.println("Plansza wyjsciowa");
        wypisz(plansza);
    }
}
