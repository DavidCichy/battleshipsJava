import java.awt.List;


public class Square {
    private int x;
    private int y;
    boolean isShipPart;

    // isPartOfShip(Ship[] fleet){
    //  List<Square> list = new List();
    //     for (int i = 0; i < fleet.length; i++){
        //      shipSize = listfleet[i].squareList().length();
        //      for 
    //          list += listfleet[i]
    //     }
    // }

    public Square(int x, int y){
        this.x = x;
        this.y = y;
        this.isShipPart = false;
    }

    public String printingX() {
        if (isShipPart){
            return "X";
        } else {
            return " ";
         
        }
    }

    public void setPartOfShip(){
        this.isShipPart = true;
    }
}