import java.util.*;
import java.io.*;

public class Ai extends Player{
  private String noShot = " ";
  private String miss = "-";
  private String neighbour = "n";
  private String hit = "x";
  private String sunk = "u";
  private static Scanner in;
  private int x;
  private int y; 
  private int xMemory = 0;
  private int yMemory = 0;  
  private int xBeforeLast = 0;
  private int yBeforeLast = 0; 
  public String[][] shotsTable;
  private int turn=1;

    public Ai(String name, Ocean playerOcean, Fleet playerFleet){
      super(name, playerOcean, playerFleet);
      this.shotsTable = new String[10][10];
      makeShootTable();
    }

public void valueOfShotBeforeLast (int x, int y){
  this.xBeforeLast = this.xMemory;
  this.yBeforeLast = this.yMemory; 
  this.xMemory =x;
  this.yMemory =y;  
  
}

    public void makeShootTable(){
      for (int x = 0; x<10; x++){
        for (int y = 0; y<10; y++){
          this.shotsTable[x][y] = noShot;
        }}
    }

    public void easyAiShot(Player opponent){
      int x = (int )(Math.random() * 10);
      int y = (int )(Math.random() * 10);
      easyShot(x,y,opponent);      
    }

    public void easyShot(int x, int y, Player opponent){
      while (opponent.getOcean().wasItShot(x, y)==true){
        x = (int )(Math.random() * 10);
        y = (int )(Math.random() * 10);
      }
      shotAtLocation(x, y, opponent);
    
      this.xMemory = x;
      this.yMemory= y;

    }


    private String showStatus(int xMemory, int yMemory) {
      String status = this.shotsTable[yMemory][xMemory];
      return status;
    }

    public void mediumAiShotRepeat(Player opponent){
      if (opponent.getOcean().stateOfSquare(xMemory,yMemory).equals("hit")){
      mediumAiShot(opponent);
    }}


    public void mediumAiShot(Player opponent){
      int a = this.xBeforeLast;
      int b = this.yBeforeLast;
      if (a >1 && a <8 && b>1 && b<8 && opponent.getOcean().stateOfSquare(a,b).equals("hit")){
            if (xMemory >1 && xMemory <8 && yMemory>1 && yMemory<8 && opponent.getOcean().stateOfSquare(xMemory,yMemory).equals("miss")){
            this.x = a;
            this.y = b;
            shootDownUpRightLeft(opponent, this.x, this.y);
        }   else if (xMemory >1 && xMemory <8 && yMemory>1 && yMemory<8 && opponent.getOcean().stateOfSquare(xMemory,yMemory).equals("hit")){
            this.x = this.xMemory;
            this.y = this.yMemory;
            shootDownUpRightLeft(opponent, this.x, this.y);
        }

      } else if (xMemory >1 && xMemory <8 && yMemory>1 && yMemory<8 && opponent.getOcean().stateOfSquare(xMemory,yMemory).equals("hit")){
        int x = this.xMemory;
        int y = this.yMemory;
        shootDownUpRightLeft(opponent, x, y);
      } else {
         int x = (int )(Math.random() * 10);
         int y = (int )(Math.random() * 10);
      while (opponent.getOcean().wasItShot(x, y)==true){
        x = (int )(Math.random() * 10);
        y = (int )(Math.random() * 10);
      }
        shotAtLocation(x, y, opponent);
        valueOfShotBeforeLast (x,y);
        markActionInShootTable(x,y,opponent);
    }
  }

    public void markActionInShootTable(int x, int y, Player opponent){
        markAsNotShootThere(opponent);
        markAsNeighborQuartersNearHit();
        shotToQuartersAfterHit(opponent);
        this.xMemory = x;
        this.yMemory = y;
    }

    public void hardAiShot(Player opponent){
      mediumAiShot(opponent);
      mediumAiShot(opponent);

}

    public void shootDownUpRightLeft(Player opponent, int x, int y){
      if (opponent.getOcean().wasItShot(x, y+1)==false){
        x += 0;
        y += 1; //w dół
        easyShot(x,y,opponent);
        valueOfShotBeforeLast (x,y);
        markActionInShootTable(x,y,opponent);
      } else if (opponent.getOcean().wasItShot(x, y-1)==false) {
        x += 0;
        y -= 1; //w góre
        easyShot(x,y,opponent);
        valueOfShotBeforeLast (x,y);
        markActionInShootTable(x,y,opponent);
      } else if (opponent.getOcean().wasItShot(x+1, y)==false) {
        x += 1;
        y += 0; //w prawo
        easyShot(x,y,opponent);
        valueOfShotBeforeLast (x,y);
        markActionInShootTable(x,y,opponent);
      } else if (opponent.getOcean().wasItShot(x-1, y)==false) {
        x -= 1; //w lewo
        y += 0;  
        easyShot(x,y,opponent);
        valueOfShotBeforeLast (x,y);
        markActionInShootTable(x,y,opponent);
      }
    }

    private void markAsNotShootThere(Player opponent){
      for (Integer x = 0; x<10; x++){
          for (Integer y = 0; y<10; y++){
            if (opponent.getOcean().stateOfSquare(x,y).equals("hit")){
              this.shotsTable[y][x] = hit;
            }else if(opponent.getOcean().stateOfSquare(x,y).equals("miss")){
              this.shotsTable[y][x] = miss;
          } else if(opponent.getOcean().stateOfSquare(x,y).equals("sunk")){
            this.shotsTable[y][x]=hit;
          }
        }
      }
    }

    private void shotToQuartersAfterHit(Player opponent){
      for (Integer x = 0; x<10; x++){
        for (Integer y = 0; y<10; y++){
          if(this.shotsTable[y][x].equals(this.neighbour)){
          opponent.getOcean().markSquare(x, y);
        } 
    }
  }
}


    private void markAsNeighborQuartersNearHit(){
      for (Integer x = 0; x<10; x++){
        for (Integer y = 0; y<10; y++){
      if (y>=1 && y<=8 && x>=1 && x<=8) {
        if (
         this.shotsTable[x+1][y-1].equals(this.hit)||
         this.shotsTable[x-1][y-1].equals(this.hit)||
         this.shotsTable[x-1][y+1].equals(this.hit)||
         this.shotsTable[x+1][y+1].equals(this.hit)) // rogi statku bez lini brzegowej
        {
            this.shotsTable[x][y]=this.neighbour;}
        }
    if (y>=1 && y<=8 && x>=0 && x<=8) {
        if (
         this.shotsTable[x+1][y-1].equals(this.hit)||
         this.shotsTable[x+1][y+1].equals(this.hit)) // rogi statku na lini brzegowej
        {
            this.shotsTable[x][y]=this.neighbour;}
        }
    if (y>=0 && y<=8 && x>=1 && x<=8) {
        if (
         this.shotsTable[x-1][y+1].equals(this.hit)||
         this.shotsTable[x+1][y+1].equals(this.hit)) // rogi statku na lini brzegowej
        {
            this.shotsTable[x][y]=this.neighbour;}
        }
    if (y>=1 && y<=8 && x>=1 && x<=9) {
        if (
         this.shotsTable[x-1][y+1].equals(this.hit)||
         this.shotsTable[x-1][y-1].equals(this.hit)) // rogi statku na lini brzegowej
        {
            this.shotsTable[x][y]=this.neighbour;}
        }
    if (y>=1 && y<=9 && x>=1 && x<=8) {
        if (
         this.shotsTable[x+1][y-1].equals(this.hit)||
         this.shotsTable[x-1][y-1].equals(this.hit)) // rogi statku na lini brzegowej
        {
            this.shotsTable[x][y]=this.neighbour;}
        }
      }}
    }
      
public void showAiShotsTable(String[][] shotsTable, String[][] shotsTablee){
        String abc = String.format("%45s","     A   B   C   D   E   F   G   H   I   J            A   B   C   D   E   F   G   H   I   J  \n");
        System.out.printf(abc);

        String line1 = String.format("%45s","   ┌───┬───┬───┬───┬───┬───┬───┬───┬───┬───┐        ┌───┬───┬───┬───┬───┬───┬───┬───┬───┬───┐\n");
        System.out.printf(line1);

        for (int x = 0; x<10; x++){
            String numb = String.valueOf(x+1);
            String line2a = String.format("%2s", numb);
            System.out.printf(line2a + " │ ");

            for (int y = 0; y<10; y++){
                System.out.print(shotsTable[x][y]);
                System.out.print(" │ ");
            }

            String line2b = String.format("%6s", numb);
            System.out.printf(line2b + " │ ");

            for (int y = 0; y<10; y++){
                System.out.print(shotsTablee[x][y]);
                System.out.print(" │ ");
            }
            
            System.out.println("");
            if (x<9) {
                String line3 = String.format("%45s","   ├───┼───┼───┼───┼───┼───┼───┼───┼───┼───┤        ├───┼───┼───┼───┼───┼───┼───┼───┼───┼───┤\n");
                System.out.printf(line3);}
                            
        }
        String line4 = String.format("%45s","   └───┴───┴───┴───┴───┴───┴───┴───┴───┴───┘        └───┴───┴───┴───┴───┴───┴───┴───┴───┴───┘\n");
        System.out.printf(line4);
        System.out.println("Last "+xMemory+" "+yMemory);
        System.out.println("BeforeLast "+this.xBeforeLast+" "+this.yBeforeLast);
        turn +=1;
        System.out.println("Tura "+turn);

}

}
