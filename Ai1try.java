import java.util.Random;

public class Ai1try extends Player {



    public Ai1try(String name, Ocean playerOcean, Fleet playerFleet){
        super(name, playerOcean, playerFleet);

    }
    
    private int generateRandomInt(){
        Random random = new Random();
        return random.nextInt(10);
    }
    
    public void easyAiShot(Player opponent){

        int x = generateRandomInt();
        int y = generateRandomInt();
        easyShot(x,y,opponent);      
    }


    public void easyShot(int x, int y, Player opponent){

        while (opponent.getOcean().wasItShot(x, y)==true){
          x = generateRandomInt();
          y = generateRandomInt();
        }
        shotAtLocation(x, y, opponent);
    }
}