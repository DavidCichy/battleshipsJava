import java.util.Arrays;

public class Ship {
    Square[] shipPosition;
    // LinkedList<Square> shipNeighbor;
    boolean sunk;

    public Ship(Square[] shipPosition){
        this.sunk = false;
        this.shipPosition = shipPosition;
        for (int i = 0; i < shipPosition.length; i++){
            shipPosition[i].makeShip();
        }
    }

    public void updateState(){
        this.sunk = true;
        for (Square s: this.shipPosition){
            if (s.isShip()){
                this.sunk = false;
            }
        }
        if (this.sunk){
            for (int j = 0; j < shipPosition.length; j++){
                shipPosition[j].makeSunk();
            }
        };
    }

    public boolean isSunk(){
        return this.sunk;
    }

    public boolean checkIfLocationIsPartoOfShip(Square location){
        return Arrays.asList(this.shipPosition).contains(location);
    }

    public boolean tryToHitLocation(Square location){
        boolean isHit = checkIfLocationIsPartoOfShip(location);
        if (isHit){
            location.makeHit();
            this.updateState();
        }
        return isHit;
    }

    // public Square[] squareList(){
    //     return shipPosition;
    // }
}