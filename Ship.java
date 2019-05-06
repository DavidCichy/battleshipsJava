public class Ship {
    Square[] shipPosition;

    public Ship(Square[] shipPosition){
        this.shipPosition = shipPosition;
        for (int i = 0; i < shipPosition.length; i++){
            shipPosition[i].setPartOfShip();
        }

    }
}