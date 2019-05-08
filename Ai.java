import java.util.*;
import java.io.*;

public class Ai extends Player{
  private static Scanner in;
  private Map<Integer, Integer> shotAlready;
  //private List<int> listOfy;

    public Ai(String name, Ocean playerOcean, Fleet playerFleet){
      super(name, playerOcean, playerFleet);
      this.shotAlready = new HashMap<>();

    }

    public void easyAiShot(Ai opponent){
      int x = (int )(Math.random() * 10);
      int y = (int )(Math.random() * 10);
      while (opponent.getOcean().wasItShot(x, y)==true){
        x = (int )(Math.random() * 10);
        y = (int )(Math.random() * 10);
      }
      mediumShot(x,y,opponent);
      
    }

    public void mediumAiShot(Player opponent){
      int x = (int )(Math.random() * 10);
      int y = (int )(Math.random() * 10);
      Integer xInteger = new Integer(x);
      Integer yInteger = new Integer(y);
    //  if (!shotAlready.get(xInteger) == null){
    //    this.shotAlready.put(xInteger,yInteger);} 
    //  else {
    //    if(shotAlready.get(xInteger).contains(yInteger)){
    //    }
    //  }
    //    if (!listOfy.contains(yInteger)){
    //    shotAtLocation(x, y, opponent);
    //    }
    //  }
    //  this.listOfy.add(yInteger);
    //  this.shotAlready.put(xInteger,yInteger);
    //  shotAtLocation(x, y, opponent);
    }


    public void hardAiShot(Player opponent){

    }

    public void mediumShot(int x, int y, Player opponent){
      opponent.recieveHit(x, y);
      shotAtLocation(x, y, opponent);


    }
}