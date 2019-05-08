import java.util.Arrays;

public class Ship {
    Square[] shipPosition;
    boolean sunk;

    public Ship(Square[] shipPosition){
        this.sunk = false;
        this.shipPosition = shipPosition;
        for (int i = 0; i < shipPosition.length; i++){
            shipPosition[i].makeShip();
        }
    }

    public boolean checkIfLocationIsPartoOfShip(Square location){
        return Arrays.asList(this.shipPosition).contains(location);
    }

    public boolean tryToHitLocation(Square location){
        boolean isHit = checkIfLocationIsPartoOfShip(location);
        if (isHit){
            location.makeHit();
        }
        return isHit;
    }

    // public Square[] squareList(){
    //     return shipPosition;
    // }
}