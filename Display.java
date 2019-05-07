public class Display{


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