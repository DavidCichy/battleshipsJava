import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Display {



    
    private Scanner prompt = new Scanner(System.in);
    private String playerInput;
    private String view;


    public static List<String> showMenu() {

        List<String> lines = new ArrayList<String>();

        try{
            File file = new File("filesToPrint/menu.txt");

            Scanner input = new Scanner(file);

            while (input.hasNextLine()){

                lines.add(input.nextLine());
            }
            input.close();
            }   catch (Exception ex){
            ex.printStackTrace();
            }
            
            return lines;
    }




   public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }


    public static void showBoards(Ocean ownerOcean, Ocean oponentOcean){
        String abc = String.format("%45s","     A   B   C   D   E   F   G   H   I   J            A   B   C   D   E   F   G   H   I   J  \n");
        System.out.printf(abc);

        String line1 = String.format("%45s","   ┌───┬───┬───┬───┬───┬───┬───┬───┬───┬───┐        ┌───┬───┬───┬───┬───┬───┬───┬───┬───┬───┐\n");
        System.out.printf(line1);

        for (int x = 0; x<10; x++){
            String numb = String.valueOf(x+1);
            String line2a = String.format("%2s", numb);
            System.out.printf(line2a + " │ ");

            for (int y = 0; y<10; y++){
                System.out.print(ownerOcean.field[x][y].showStatusToOwner());
                System.out.print(" │ ");
            }

            String line2b = String.format("%6s", numb);
            System.out.printf(line2b + " │ ");

            for (int y = 0; y<10; y++){
                System.out.print(oponentOcean.field[x][y].showStatusToOponent());
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
}