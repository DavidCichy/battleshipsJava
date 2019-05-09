import java.util.*;
import java.io.*;

public class Ai extends Player{
  private String noShot = " ";
  private String miss = "-";
  private String neighbour = "n";
  private String hit = "x";
  private String sunk = "u";
  private static Scanner in;
  private int xMemory = 0;
  private int yMemory = 0;  
  public String[][] shotsTable;
  int[][] lastFiveShots = new int[1][5];

    public Ai(String name, Ocean playerOcean, Fleet playerFleet){
      super(name, playerOcean, playerFleet);
      this.shotsTable = new String[10][10];
      makeShootTable();
      
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
      //UNDER TESTS OF PRINTING AI MARKS
      //for (int k = 0; k<10; k++){                     
      //  for (int l = 0; l<10; l++){
      //    this.shotsTable[k][l] = noShot;
      //  }}
      //showAiShotsTable(shotsTable,shotsTable);
      //in = new Scanner(System.in);
      //in.nextLine();
      
    }

    private String showStatus(int xMemory, int yMemory) {
      String status = shotsTable[xMemory][yMemory];
      return status;
    }

    private void makeSunk (Ai opponent) {
      for (int x = 0; x<10; x++){
        for (int y = 0; y<10; y++){
          if (opponent.getOcean().stateOfSquare(x,y).equals("sunk")){
          this.shotsTable[x][y] = this.sunk;}
        }}
    }

    public void partOfMediumAi(int x, int y, Ai opponent){
      if (opponent.getOcean().stateOfSquare(x,y).equals("hit")){
        this.shotsTable[x][y] = hit;}
      else if(opponent.getOcean().stateOfSquare(x,y).equals("miss")){
        this.shotsTable[x][y] = miss;}
        markAsNeighborQuartersNearHit();
        makeSunk(opponent);
        markAsNeighborIfSunk();
        this.xMemory = x;
        this.yMemory = y;
    }

    public void mediumAiShot(Ai opponent){
//      if (showStatus(xMemory,yMemory).equals(hit)){
//        if(xMemory >0 && xMemory <9 && yMemory>0 && yMemory<9) {
//            int x = xMemory;
//            int y = yMemory;
//          if (opponent.getOcean().wasItShot(x, y+1)==false){
//            x += 0;
//            y += 1; //w prawo
//            shotAtLocation(x, y, opponent);
//            partOfMediumAi(x,y,opponent);
//          } else if (opponent.getOcean().wasItShot(x, y-1)==false) {
//            x += 0;
//            y -= 1; //w lewo
//            shotAtLocation(x, y, opponent);
//            partOfMediumAi(x,y,opponent);
//          } else if (opponent.getOcean().wasItShot(x+1, y)==false) {
//            x += 1;
//            y += 0; //w dół
//            shotAtLocation(x, y, opponent);
//            partOfMediumAi(x,y,opponent);
//          } else if (opponent.getOcean().wasItShot(x-1, y)==false) {
//            x -= 1; //w górę
//            y += 0;  
//            shotAtLocation(x, y, opponent);
//            partOfMediumAi(x,y,opponent);
//          }
//        }
//
//      } else {



        int x = (int )(Math.random() * 10);
        int y = (int )(Math.random() * 10);
      while (!this.shotsTable[x][y].equals(noShot)){
        x = (int )(Math.random() * 10);
        y = (int )(Math.random() * 10);
      }
        shotAtLocation(x, y, opponent);
        if (opponent.getOcean().stateOfSquare(x,y).equals("hit")){
          this.shotsTable[x][y] = hit;}
        else if(opponent.getOcean().stateOfSquare(x,y).equals("miss")){
          this.shotsTable[x][y] = miss;}
          markAsNeighborQuartersNearHit();
          makeSunk(opponent);
          markAsNeighborIfSunk();
          this.xMemory = x;
          this.yMemory = y;

//        }
    }


    public void hardAiShot(Ai opponent){

    }

    public void easyShot(int x, int y, Player opponent){
      while (opponent.getOcean().wasItShot(x, y)==true){
        x = (int )(Math.random() * 10);
        y = (int )(Math.random() * 10);
      }
      shotAtLocation(x, y, opponent);
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
            this.shotsTable[x][y]=neighbour;}
        }
    if (y>=1 && y<=8 && x>=0 && x<=8) {
        if (
         this.shotsTable[x+1][y-1].equals(this.hit)||
         this.shotsTable[x+1][y+1].equals(this.hit)) // rogi statku na lini brzegowej
        {
            this.shotsTable[x][y]=neighbour;}
        }
    if (y>=0 && y<=8 && x>=1 && x<=8) {
        if (
         this.shotsTable[x-1][y+1].equals(this.hit)||
         this.shotsTable[x+1][y+1].equals(this.hit)) // rogi statku na lini brzegowej
        {
            this.shotsTable[x][y]=neighbour;}
        }
    if (y>=1 && y<=8 && x>=1 && x<=9) {
        if (
         this.shotsTable[x-1][y+1].equals(this.hit)||
         this.shotsTable[x-1][y-1].equals(this.hit)) // rogi statku na lini brzegowej
        {
            this.shotsTable[x][y]=neighbour;}
        }
    if (y>=1 && y<=9 && x>=1 && x<=8) {
        if (
         this.shotsTable[x+1][y-1].equals(this.hit)||
         this.shotsTable[x-1][y-1].equals(this.hit)) // rogi statku na lini brzegowej
        {
            this.shotsTable[x][y]=neighbour;}
        }
      }}
    }


    private void markAsNeighborIfSunk(){
      for (Integer x = 0; x<10; x++){
          for (Integer y = 0; y<10; y++){
              if (x==0 && y==0) {
                  if (this.shotsTable[x+1][y+1].equals(this.sunk) ) { // rog planszy
                      this.shotsTable[x][y]=neighbour;
                  }  
              }
              if (x==9 && y==9) {
                  if (this.shotsTable[x-1][y-1].equals(this.sunk) ) { // rog planszy
                      this.shotsTable[x][y]=neighbour;
                  }  
              }
              if (x==0 && y==9) {
                  if (this.shotsTable[x+1][y-1].equals(this.sunk) ) { // rog planszy
                      this.shotsTable[x][y]=neighbour;
                  }  
              }
              if (x==9 && y==0) {
                  if (this.shotsTable[x-1][y+1].equals(this.sunk) ) { // rog planszy
                      this.shotsTable[x][y]=neighbour;
                  }  
              }
              if (y>=0 && y<9) {
                  if (
                   this.shotsTable[x][y+1].equals(this.sunk)) //lewa strona kazdego
                  {
                      this.shotsTable[x][y]=neighbour;}
              } 
              if (y>0 && y<=9) {
                  if (   
                   this.shotsTable[x][y-1].equals(this.sunk)) // prawa strona kazdego
                  {
                      this.shotsTable[x][y]=neighbour;}
                  } 
              if (x>=0 && x<9) {
                  if (
                   this.shotsTable[x+1][y].equals(this.sunk)) // góra kazdego
                  {
                      this.shotsTable[x][y]=neighbour;}
              }
              if (x>0 && x<=9) {
                  if (
                   this.shotsTable[x-1][y].equals(this.sunk)) // dół kazdego
                  {
                      this.shotsTable[x][y]=neighbour;}
              }
              if (y>=1 && y<=8 && x>=1 && x<=8) {
                  if (
                   this.shotsTable[x+1][y-1].equals(this.sunk)||
                   this.shotsTable[x-1][y-1].equals(this.sunk)||
                   this.shotsTable[x-1][y+1].equals(this.sunk)||
                   this.shotsTable[x+1][y+1].equals(this.sunk)) // rogi statku bez lini brzegowej
                  {
                      this.shotsTable[x][y]=neighbour;}
                  }
              if (y>=1 && y<=8 && x>=0 && x<=8) {
                  if (
                   this.shotsTable[x+1][y-1].equals(this.sunk)||
                   this.shotsTable[x+1][y+1].equals(this.sunk)) // rogi statku na lini brzegowej
                  {
                      this.shotsTable[x][y]=neighbour;}
                  }
              if (y>=0 && y<=8 && x>=1 && x<=8) {
                  if (
                   this.shotsTable[x-1][y+1].equals(this.sunk)||
                   this.shotsTable[x+1][y+1].equals(this.sunk)) // rogi statku na lini brzegowej
                  {
                      this.shotsTable[x][y]=neighbour;}
                  }
              if (y>=1 && y<=8 && x>=1 && x<=9) {
                  if (
                   this.shotsTable[x-1][y+1].equals(this.sunk)||
                   this.shotsTable[x-1][y-1].equals(this.sunk)) // rogi statku na lini brzegowej
                  {
                      this.shotsTable[x][y]=neighbour;}
                  }
              if (y>=1 && y<=9 && x>=1 && x<=8) {
                  if (
                   this.shotsTable[x+1][y-1].equals(this.sunk)||
                   this.shotsTable[x-1][y-1].equals(this.sunk)) // rogi statku na lini brzegowej
                  {
                      this.shotsTable[x][y]=neighbour;}
                  }
  
              }
              }
              
          }
      
public static void showAiShotsTable(String[][] shotsTable, String[][] shotsTablee){
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
}

    private void markAsNeighborAfterHit(){
  }

//  public static String[] addNewShotToMemory (int[][] lastFiveShots, int character) {  
//    int[][] newList = new int[lastFiveShots.length + 1];
//    for(int i = 0; i < lastFiveShots.length; i++)
//    newList[i] = lastFiveShots[i];
//    newList[newList.length - 1] = character;
//    lastFiveShots = newList;
//    return lastFiveShots;
//
//}
}
