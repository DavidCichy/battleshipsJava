public class Game { 
    Square[][] field1;
    Square[][] field2;
    Player player1;
    Player player2;

    public Game(){
        this.field1= new Square[10][10];
        this.field2= new Square[10][10];
        for (int x = 0; x<10; x++){
            for (int y = 0; y<10; y++){
                this.field1[x][y] = new Square(x, y);
                this.field2[x][y] = new Square(x, y);
            }
        }
        Ocean ocean1 = new Ocean(field1);
        Ocean ocean2 = new Ocean(field2);
        Fleet fleet1 = new Fleet(field1);
        Fleet fleet2 = new Fleet(field2);
        this.player1 = new Player(ocean1, fleet1);
        this.player2 = new Player(ocean2, fleet2);

        Display.showBoards(ocean1, ocean2);
        player1.shotAtLocation(1, 0, player2);
        player1.shotAtLocation(1, 5, player2);
        player2.shotAtLocation(0, 0, player1);
        player2.shotAtLocation(7, 7, player1);
        // fleet1.tryToHitLocation(field1[0][1]); 
        // Square hit = field1[5][6];
        // if(!fleet1.tryToHitLocation(hit)){
        //     ocean1.markSquare(hit);
        // }; 
        Display.showBoards(ocean1, ocean1);
        Display.showBoards(ocean2, ocean2);



    }
}
