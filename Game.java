import java.util.Scanner;
import java.io.IOException;
public class Game { 
    Square[][] field1;
    Square[][] field2;
    Player player1;
    Player player2;
    boolean gameContinues;
    Ai ai1;
    Ai ai2;
    
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
        this.gameContinues = true;
        this.player1 = new Player("Player 1", ocean1, fleet1);
        this.player2 = new Player("Player 2", ocean2, fleet2);
        this.ai1 = new Ai("AI 1", ocean1, fleet1);
        this.ai2 = new Ai("AI 2", ocean2, fleet2);
        gameRun();
        
    }

    private void gamePvP() throws IOException {
        while (this.gameContinues){
            playerRound(this.player1, this.player2);
            updateState();
            if(this.gameContinues){
                playerRound(this.player2, this.player1);
                updateState();
            }
        }
    }

    private void gamePvAIEasy() throws IOException {
        while (this.gameContinues){
            playerRound(this.player1, this.player2);
            updateState();
            if(this.gameContinues){
                playerRound(this.player2, this.player1);
                updateState();
            }
        }
    }

    private void gameSimulation() throws IOException {
        while (this.gameContinues){
            aiRoundEasy(this.ai1, this.ai2);
            //aiRoundMedium(ai1, ai2);        
            //playerRound(player1, player2);
            updateState();
            if(this.gameContinues){
                aiRoundEasy(this.ai2, this.ai1);
                //aiRoundMedium(ai2, ai1);            
                //playerRound(player2, player1);
                updateState();
            }
        }
    }

    private void updateState(){
        if (this.player1.checkIfLost() || this.player2.checkIfLost()){
            this.gameContinues = false;
        } else if (this.ai1.checkIfLost() || this.ai2.checkIfLost()){
            this.gameContinues = false;
        }
    }
    
    // private void playerTurn(Player player, Player oponent) throws IOException {
    //     this.player1 = new Player(ocean1, fleet1);
    //     this.player2 = new Player(ocean2, fleet2);
    //     // this.ai1 = new Ai(ocean1, fleet1);
    //     // this.ai2 = new Ai(ocean2, fleet2);

    //     //aiRoundEasy(ai1,ai2);
    //     //aiRoundEasy(ai2,ai1);
    //     playerRound(player1, player2);
    //     playerRound(player2, player1);
    //     playerRound(player1, player2);
    //     playerRound(player2, player1);
    //     playerRound(player1, player2);
    //     playerRound(player2, player1);
    // }
    
    private void aiRoundEasy(Ai ai, Ai oponent) throws IOException {
        Display.clearScreen();
        System.out.println("Swap players and press any key to continue.");
        System.in.read();
        Display.clearScreen();
        ai.showBoard(oponent);
        ai.easyAiShot(oponent);
        Display.clearScreen();
        ai.showBoard(oponent);
        System.out.println("Press any key to continue");
        System.in.read();

    }

    private void aiRoundMedium(Ai ai, Ai oponent) throws IOException {
        Display.clearScreen();
        System.out.println("Swap players and press any key to continue.");
        System.in.read();
        Display.clearScreen();
        ai.showBoard(oponent);
        ai.mediumAiShot(oponent);
        ai.showAiShotsTable(ai.shotsTable, oponent.shotsTable);
        Display.clearScreen();
        ai.showBoard(oponent);
        ai.showAiShotsTable(ai.shotsTable, oponent.shotsTable);
        System.out.println("Press any key to continue");
        System.in.read();

    }

    private void aiRoundHard(Ai ai, Ai oponent) throws IOException {

    }

    private void playerRound(Player player, Player oponent) throws IOException {
        Scanner scan = new Scanner(System.in);
        Display.clearScreen();
        System.out.println(player.getName() + " round. Press any key to continue.");
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

    private void gameRun() throws IOException {
        Scanner scan = new Scanner(System.in);

        boolean isRunning = true;
       

        while (isRunning) {
                Display.clearScreen();
                Display.showMenu().forEach(System.out::println);
                
                System.out.println("Choose an option");

                
                switch (scan.nextInt()) {
                case 1: {
                    gamePvP();
                    break;
                }
                case 2: {
                    gameSimulation();
                    break;
                }
                case 3: {
                    
                    break;
                }
                case 4: {
                    
                    break;
                }
                case 5: {
                    
                    break;
                }
                case 6: {
                
                    break;
                }
                case 7: {
                    
                    break;
                }
                case 8: {
                    
                    break;
                }

                case 9: {
                    
                    break;
                }
                case 10: {

                    break;
                }

                case 0: {
                
                    isRunning = false;
                    break;
                }
                default: {
                    
                    Display.clearScreen();
            }
            }
        }
    }
    }




