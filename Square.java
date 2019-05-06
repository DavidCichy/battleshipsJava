public class Square {
    private int x;
    private int y;
    boolean isShipPart;

    // isPartOfShip(Ship[] fleet){
    //     for (int i = 0; i < fleet.length; i++){
    //         fleet[i].
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
            return "~";
         
        }
    }

    public void setPartOfShip(){
        this.isShipPart = true;
    }
}