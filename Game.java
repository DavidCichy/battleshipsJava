import java.util.Scanner;
import java.io.IOException;
public class Game { 
    Square[][] field1;
    Square[][] field2;
    Player player1;
    Player player2;
    
    public Game() throws IOException {
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

        playerRound(player1, player2);
        playerRound(player2, player1);
        playerRound(player1, player2);
        playerRound(player2, player1);
        playerRound(player1, player2);
        playerRound(player2, player1);
    }
    
    
    private void playerRound(Player player, Player oponent) throws IOException {
        Scanner scan = new Scanner(System.in);
        Display.clearScreen();
        System.out.println("Swap players and press any key to continue.");
        System.in.read();
        Display.clearScreen();
        player.showBoard(oponent);
        int[] shootAt = readShootingParameters();
        player.shotAtLocation(shootAt[0], shootAt[1], oponent);
        Display.clearScreen();
        player.showBoard(oponent);
        System.out.println("Press any key to continue");
        System.in.read();
    }



    private int convertXParameter(char x){
        return Character.getNumericValue(x)-10;
    }

    private int convertYParameter(int y){
        return y-1;
    }

    private int[] readShootingParameters(){
        Scanner scan = new Scanner(System.in);
        System.out.print("Column [A-J]: ");
        String col = scan.next().toLowerCase();
        System.out.print("Row 1-10:");
        int row = scan.nextInt();
        int x = convertXParameter(col.charAt(0));
        System.out.println(x);
        int y = convertYParameter(row);
        return new int[] {x,y};
    }

}
