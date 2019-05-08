import java.util.*;
import java.io.*;

public class Ai extends Player{
  private static Scanner in;


    public Ai(String name, Ocean playerOcean, Fleet playerFleet){
      super(name, playerOcean, playerFleet);

    }

    public void easyAiShot(Ai opponent){
      int x = (int )(Math.random() * 10);
      int y = (int )(Math.random() * 10);
       while (opponent.getOcean().wasItShot(x, y)==true){
        x = (int )(Math.random() * 10);
        y = (int )(Math.random() * 10);
      }
      shotAtLocation(x, y, opponent);
      //easyShot(x,y,opponent);
      
    }

    public void mediumAiShot(Player opponent){
      int x = (int )(Math.random() * 10);
      int y = (int )(Math.random() * 10);
      Integer xInteger = new Integer(x);
      Integer yInteger = new Integer(y);

    }


    public void hardAiShot(Player opponent){

    }

    public void easyShot(int x, int y, Player opponent){
      while (opponent.getOcean().wasItShot(x, y)==true){
        x = (int )(Math.random() * 10);
        y = (int )(Math.random() * 10);
      }
      shotAtLocation(x, y, opponent);
    }


    }
