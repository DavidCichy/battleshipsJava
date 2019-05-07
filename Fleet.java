public class Fleet { 
    Ship[] fleet;
    Square[][] field; 

    public Fleet(Square[][] field){
        this.field = field;
        Ship ship1 = new Ship(new Square[] {this.field[0][0], this.field[0][1], this.field[0][2]});
        Ship ship2 = new Ship(new Square[] {this.field[0][8], this.field[0][9]});
        Ship ship3 = new Ship(new Square[] {this.field[1][5], this.field[1][6]});
    }


    // private void makeFleet(){
    //     Ship ship4 = new Ship(new Square[] {this.field[2][1], this.field[3][1]});
    //     Ship ship5 = new Ship(new Square[] {this.field[3][3], this.field[3][4], this.field[3][5], this.field[3][6]});
    //     Ship ship6 = new Ship(new Square[] {this.field[4][9]});
    //     Ship ship7 = new Ship(new Square[] {this.field[5][3], this.field[6][3], this.field[7][3], this.field[8][3]});
    //     Ship ship8 = new Ship(new Square[] {this.field[7][0]});
    //     Ship ship9 = new Ship(new Square[] {this.field[9][5]});
    //     Ship ship0 = new Ship(new Square[] {this.field[7][8], this.field[8][8]});
}
