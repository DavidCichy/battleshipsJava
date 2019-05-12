import java.util.Random;

public class Ai1try extends Player {



    public Ai1try(String name, Ocean playerOcean, Fleet playerFleet){
        super(name, playerOcean, playerFleet);

    }
    
    private int generateRandomInt(){
        Random random = new Random();
        return random.nextInt(10);
    }
    
    public void newAi1tryShot(Player oponent){

        int x = generateRandomInt();
        int y = generateRandomInt();
        //ai1tryShotEasy(x,y,oponent);
        ai1tryShotHard(x, y, oponent);
    }


    public void ai1tryShotEasy(int x, int y, Player oponent){

        while (oponent.getOcean().wasItShot(x, y)==true){
          x = generateRandomInt();
          y = generateRandomInt();
        }
        shotAtLocation(x, y, oponent);
    }

    public void ai1tryShotHard(int x, int y, Player oponent){

        boolean isOpenHit = isHitedShipOnOcean(oponent);

        while (isOpenHit) {

            
            shotAtLocation(x, y, oponent);



            isOpenHit = false;
        }
        //ai1tryShotEasy(x, y, oponent);
    }













    private boolean isHitedShipOnOcean(Player oponent){

        boolean isFreeHit = false;

        for (Integer x = 0; x<10; x++){
            for (Integer y = 0; y<10; y++){
                if (oponent.getOcean().isShoted(x, y)) {
                    isFreeHit = true;
                }
            }
        }      
        return isFreeHit;
    }
    
}


/*
działanie hard AI

sprawdź czy jest trafienie na planszy:
    trafienie : strzał w g/d/l/p
    brak trafienia: 
    
                    sprawdź czy jest zatopiony
                            zatopiony : wykonaj strzał na rogu i pełzaj po siatce
                            brak zatopionego : 

                                                Strzał w randomowe miejsce - lub wybrać punkt ?? lub kilka ?? lub podzielić na 4 ćwiartki
                                                    jeżeli trafiony  - markuje ukośne punkty

Sprawdź czy pudło czy trafiony
    pudło : powtórz
    trafiony 



*/