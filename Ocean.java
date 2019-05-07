public class Ocean {
    public Square[][] ocean;
    Ship[] fleet;
   // Display display = new 

    public Ocean() {
        this.ocean = new Square[10][10];
        for (int x = 0; x<10; x++){
            for (int y = 0; y<10; y++){
                this.ocean[x][y] = new Square(x, y);
            }
        }
        makeFleet();
        //printOcean();
    }
    
    private void makeFleet(){
        Ship ship1 = new Ship(new Square[] {this.ocean[0][0], this.ocean[0][1], this.ocean[0][2]});
        Ship ship2 = new Ship(new Square[] {this.ocean[0][8], this.ocean[0][9]});
        Ship ship3 = new Ship(new Square[] {this.ocean[1][5], this.ocean[1][6]});
        Ship ship4 = new Ship(new Square[] {this.ocean[2][1], this.ocean[3][9]});
        Ship ship5 = new Ship(new Square[] {this.ocean[3][3], this.ocean[3][4], this.ocean[3][5], this.ocean[3][6]});
        Ship ship6 = new Ship(new Square[] {this.ocean[4][9]});
        Ship ship7 = new Ship(new Square[] {this.ocean[5][3], this.ocean[6][3], this.ocean[7][3], this.ocean[8][3]});
        Ship ship8 = new Ship(new Square[] {this.ocean[7][0]});
        Ship ship9 = new Ship(new Square[] {this.ocean[9][5]});
        Ship ship0 = new Ship(new Square[] {this.ocean[7][8], this.ocean[8][8]});

    }
    
    //private void printOcean(){
    //   String abc = String.format("%45s","     A   B   C   D   E   F   G   H   I   J            A   B   C   D   E   F   G   H   I   J  \n");
    //   System.out.printf(abc);
//
    //   String line1 = String.format("%45s","   ┌───┬───┬───┬───┬───┬───┬───┬───┬───┬───┐        ┌───┬───┬───┬───┬───┬───┬───┬───┬───┬───┐\n");
    //   System.out.printf(line1);
//
    //   for (int x = 0; x<10; x++){
    //       String numb = String.valueOf(x+1);
    //       String line2a = String.format("%2s", numb);
    //       System.out.printf(line2a + " │ ");
//
    //       for (int y = 0; y<10; y++){
    //           System.out.print(this.ocean[x][y].showStatusToOwner());
    //           System.out.print(" │ ");
    //       }
//
    //       String line2b = String.format("%6s", numb);
    //       System.out.printf(line2b + " │ ");
//
    //       for (int y = 0; y<10; y++){
    //           System.out.print(this.ocean[x][y].showStatusToOponent());
    //           System.out.print(" │ ");
    //       }
    //       
    //       System.out.println("");
    //       if (x<9) {
    //           String line3 = String.format("%45s","   ├───┼───┼───┼───┼───┼───┼───┼───┼───┼───┤        ├───┼───┼───┼───┼───┼───┼───┼───┼───┼───┤\n");
    //           System.out.printf(line3);}
    //                       
    //   }
    //   String line4 = String.format("%45s","   └───┴───┴───┴───┴───┴───┴───┴───┴───┴───┘        └───┴───┴───┴───┴───┴───┴───┴───┴───┴───┘\n");
    //   System.out.printf(line4);
    //
    //
    
    public static void main(String[] args) {

        Ocean newOcean = new Ocean();
        //String ownerOcean  = this.ocean[x][y].showStatusToOponent();
        //String oponentOcean = this.ocean[x][y].showStatusToOponent();
        Display.showBoards(newOcean, newOcean);
     
    }

}