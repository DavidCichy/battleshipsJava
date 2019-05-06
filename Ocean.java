public class Ocean {
    Square[][] ocean;
    Ship[] fleet;

    public Ocean() {
        this.ocean = new Square[10][10];
        for (int x = 0; x<10; x++){
            for (int y = 0; y<10; y++){
                this.ocean[x][y] = new Square(x, y);
            }
        }
        makeFleet();
        printOcean();
    }
    
    private void makeFleet(){
        Ship ship1 = new Ship(new Square[] {this.ocean[0][0], this.ocean[0][1], this.ocean[0][2]});
        Ship ship2 = new Ship(new Square[] {this.ocean[0][8], this.ocean[0][9]});
        Ship ship3 = new Ship(new Square[] {this.ocean[1][5], this.ocean[1][6]});
        Ship ship4 = new Ship(new Square[] {this.ocean[2][1], this.ocean[3][1]});
        Ship ship5 = new Ship(new Square[] {this.ocean[3][3], this.ocean[3][4], this.ocean[3][5], this.ocean[3][6]});
        Ship ship6 = new Ship(new Square[] {this.ocean[4][9]});
        Ship ship7 = new Ship(new Square[] {this.ocean[5][3], this.ocean[6][3], this.ocean[7][3], this.ocean[8][3]});
        Ship ship8 = new Ship(new Square[] {this.ocean[7][0]});
        Ship ship9 = new Ship(new Square[] {this.ocean[9][5]});
        Ship ship0 = new Ship(new Square[] {this.ocean[7][8], this.ocean[8][8]});

    }
    
    private void printOcean(){
        System.out.println("┌─┬─┬─┬─┬─┬─┬─┬─┬─┬─┐");
        for (int x = 0; x<10; x++){
            System.out.print("│");
            for (int y = 0; y<10; y++){
                System.out.print(this.ocean[x][y].printingX());
                System.out.print("│");;
            }
            System.out.println("");
            if (x<9) {
                            System.out.println("├─┼─┼─┼─┼─┼─┼─┼─┼─┼─┤");}
        }
        System.out.println("└─┴─┴─┴─┴─┴─┴─┴─┴─┴─┘");

    }
    public static void main(String[] args) {
        Ocean newOcean = new Ocean();
    }

}