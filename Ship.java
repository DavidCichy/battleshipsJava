import java.util.LinkedList;
import java.util.List;



public class Ship {
    Square[] shipPosition;
    //List <Square> shipNeighbor;

    public Ship(Square[] shipPosition){
        //this.shipNeighbor = new LinkedList<>();
        this.shipPosition = shipPosition;
        for (int i = 0; i < shipPosition.length; i++){
            shipPosition[i].makeShip();
        }
    }

    // public Square[] squareList(){
    //     return shipPosition;
    // }
}