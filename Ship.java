import java.util.Arrays;
import java.util.LinkedList;

public class Ship {
    Square[] shipPosition;
    LinkedList<Square> shipNeighbor;
    boolean sunk;

    public Ship(Square[] shipPosition){
        this.sunk = false;
        this.shipPosition = shipPosition;
        for (int i = 0; i < shipPosition.length; i++){
            shipPosition[i].makeShip();
        }
    }

    public Square[] getPosition(){
        return this.shipPosition;
    }

    public void addNeighbors(LinkedList<Square> neighbor){
        this.shipNeighbor = neighbor;
        for (int i = 0; i < this.shipNeighbor.size(); i++){
            shipNeighbor.get(i).makeNeighbor();
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
            for (int j = 0; j < this.shipPosition.length; j++){
                this.shipPosition[j].makeSunk();
            }
            for (int i = 0; i < this.shipNeighbor.size(); i++){
                this.shipNeighbor.get(i).makeMissFromNeighbor();
            }
    }}

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