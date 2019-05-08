import java.util.*;
import java.io.*;

public class Ai extends Player{
  private static Scanner in;

    public Ai(Ocean playerOcean, Fleet playerFleet){
      super(playerOcean, playerFleet);
    }

    public void easyAiShot(Player opponent){
      int x = (int )(Math.random() * 10);
      int y = (int )(Math.random() * 10);

      shotAtLocation(x, y, opponent);
    }

    public void mediumAiShot(Player opponent){
      int x = (int )(Math.random() * 10);
      int y = (int )(Math.random() * 10);
      mediumShot(x,y,opponent);

    }
    public void hardAiShot(Player opponent){

    }

    public void mediumShot(int x, int y, Player opponent){
      shotAtLocation(x, y, opponent);

    }
}