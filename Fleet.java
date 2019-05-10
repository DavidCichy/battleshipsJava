import java.util.List;
import java.util.LinkedList;
import java.util.Random;
import java.util.Arrays;
import java.util.concurrent.LinkedBlockingDeque;

public class Fleet {
    Ship[] fleet;
    Square[][] field; 
    boolean isDestroyed;

    public Fleet(Square[][] field){
        this.field = field;
        this.isDestroyed = false;
        // Ship carrier = makeCarrier();
        // Ship battleship =  makeBattleship();
        // Ship cruiser =  makeCruiser();
        // Ship submarine =  makeSubmarine();
        // Ship destroyer =  makeDestroyer();
        this.fleet = new Ship[5];// {carrier, battleship,cruiser, submarine,destroyer};
        // Ship battleship = new Ship(new Square[] {this.field[0][0], this.field[1][0], this.field[2][0], 
        //     this.field[3][0]});
        // this.fleet = new Ship[] {battleship};
        makeRandomFleet();
    }


    private void makeRandomFleet(){
        makeCarrier();
        makeBattleship();
        makeCruiser();
        makeSubmarine();
        makeDestroyer();
        // makeNeighbors();

    }

    // private void makeNeighbors(){
    //     for (Ship s: this.fleet){
    //         addNeighbors(s);
    //     }
    // }

    private int generateRandomInt(){
        Random random = new Random();
        return random.nextInt(10);
    }



    private int checkDistanceOnOcean(Square location1, Square location2){
        int L1X = location1.getXY()[0];
        int L1Y = location1.getXY()[1];
        int L2X = location2.getXY()[0];
        int L2Y = location2.getXY()[1];
        int yDistance = Math.abs(L1Y-L2Y);
        int xDistance = Math.abs(L1X-L2X);
        int distance = yDistance + xDistance;
        if (yDistance == xDistance){
            distance--;
        }
        return distance;
    }

    public boolean checkIfSquareIsNeightbor(Square location1, Square location2){
        return (checkDistanceOnOcean(location1, location2)==1);
    }

    private LinkedList<Square> findNeighbor(Ship ship){
        LinkedList<Square> shipNeightbor = new LinkedList<Square>();
        Square[] shipPosition = ship.getPosition();
        for (Square s: shipPosition){
            for (Square[] g: this.field){
                for (Square f: g){
                if (checkIfSquareIsNeightbor(f, s) && !Arrays.asList(shipPosition).contains(f) && !shipNeightbor.contains(f)){
                    shipNeightbor.add(f);
            }}
        }
    }
    return shipNeightbor;
    }

    private void addNeighbors(Ship ship){
        LinkedList<Square> shipNeightbor = findNeighbor(ship);
        ship.addNeighbors(shipNeightbor);
    };

    private Ship[] makeCarrier() {
        int axisX;
        int axisY;
        Ship carrier;
        boolean isWorking = true;

        while (isWorking) {
            axisX = generateRandomInt();
            axisY = generateRandomInt();

            if (axisX+4 <10 && axisY%2!=0) {
                carrier = new Ship(new Square[] {this.field[axisX][axisY], this.field[axisX+1][axisY], this.field[axisX+2][axisY], 
                                                      this.field[axisX+3][axisY], this.field[axisX+4][axisY]});                                          
                this.fleet[0]=carrier;
                isWorking =false;
                addNeighbors(carrier);
            } else if (axisY+4 <10 && axisX%2!=0) {
                carrier = new Ship(new Square[] {this.field[axisX][axisY], this.field[axisX][axisY+1], this.field[axisX][axisY+2], 
                    this.field[axisX][axisY+3], this.field[axisX][axisY+4]});
                addNeighbors(carrier);
                    this.fleet[0]=carrier;
                    isWorking =false;
                }  
            }
            return this.fleet;
        }
        
    public boolean tryToHitLocation(int x, int y){
        Square location = field[y][x];
        for (Ship s: this.fleet){
            if (s.tryToHitLocation(location)){
                this.updateState();
                return true;
            }
        }
        return false;
    }
    
    private void updateState(){
        this.isDestroyed = true;
        for (int i = 0; i < fleet.length; i++){
            if (!fleet[i].isSunk()){
                this.isDestroyed = false;
            };}
        }
        
        public boolean isDestroyed(){
            return this.isDestroyed;
        }
        
        private Ship[] makeBattleship() {
            int axisX;
            int axisY;
            
            boolean isWorking = true;
            
            while (isWorking) {
                axisX = generateRandomInt();
                axisY = generateRandomInt();
                
                if (axisX+3 <10 && axisY%2!=0) {
                    
                    if (!this.field[axisX][axisY].isShip() && !this.field[axisX][axisY].isNeigbor() &&
                    !this.field[axisX+1][axisY].isShip() && !this.field[axisX+1][axisY].isNeigbor() &&
                    !this.field[axisX+2][axisY].isShip() && !this.field[axisX+2][axisY].isNeigbor() &&
                    !this.field[axisX+3][axisY].isShip() && !this.field[axisX+3][axisY].isNeigbor() ) {
                        
                        Ship battleship = new Ship(new Square[] {this.field[axisX][axisY], this.field[axisX+1][axisY], this.field[axisX+2][axisY], 
                            this.field[axisX+3][axisY]});
                            // addNeighbors(battleship);
                            // markAsNeighbor();
                            addNeighbors(battleship);
                            this.fleet[1]=battleship;
                            isWorking =false;
                            //return battleship;
                        } 
                    }
                    else if (axisY+3 <10 && axisX%2!=0) {
                        
                        if (
                            !this.field[axisX][axisY+1].isShip() && !this.field[axisX][axisY+1].isNeigbor() &&
                            !this.field[axisX][axisY+2].isShip() && !this.field[axisX][axisY+2].isNeigbor() &&
                            !this.field[axisX][axisY+3].isShip() && !this.field[axisX][axisY+3].isNeigbor() ) {
                                
                                Ship battleship = new Ship(new Square[] {this.field[axisX][axisY], this.field[axisX][axisY+1], this.field[axisX][axisY+2], 
                                    this.field[axisX][axisY+3]});
                                    // addNeighbors(battleship);
                                    // markAsNeighbor();
                            addNeighbors(battleship);
                this.fleet[1]=battleship;
                isWorking =false;
                // return battleship;
            }  
        }
    } return this.fleet;
    }
        
    private Ship[] makeCruiser() {
        int axisX;
        int axisY;

        boolean isWorking = true;

        while (isWorking) {
            axisX = generateRandomInt();
            axisY = generateRandomInt();

            if (axisX+3 <10 && axisY%2!=0) {

                if (!this.field[axisX][axisY].isShip() && !this.field[axisX][axisY].isNeigbor() &&
                !this.field[axisX+1][axisY].isShip() && !this.field[axisX+1][axisY].isNeigbor() &&
                !this.field[axisX+2][axisY].isShip() && !this.field[axisX+2][axisY].isNeigbor() ) {

                Ship cruiser = new Ship(new Square[] {this.field[axisX][axisY], this.field[axisX+1][axisY], this.field[axisX+2][axisY]});
                // markAsNeighbor();
                            addNeighbors(cruiser);
                this.fleet[2]=cruiser;
                isWorking =false;
                // return cruiser;
            } 
            }
            else if (axisY+3 <10 && axisX%2!=0) {

                if (
                !this.field[axisX][axisY+1].isShip() && !this.field[axisX][axisY+1].isNeigbor() &&
                !this.field[axisX][axisY+2].isShip() && !this.field[axisX][axisY+2].isNeigbor() ) {

                Ship cruiser = new Ship(new Square[] {this.field[axisX][axisY], this.field[axisX][axisY+1], this.field[axisX][axisY+2]});
                // markAsNeighbor();
                            addNeighbors(cruiser);
                this.fleet[2]=cruiser;
                isWorking =false;
                // return cruiser;
            }  
        }
        } return this.fleet;
    }

    private Ship[] makeSubmarine() {
        int axisX;
        int axisY;

        boolean isWorking = true;

        while (isWorking) {
            axisX = generateRandomInt();
            axisY = generateRandomInt();

            if (axisX+3 <10 && axisY%2!=0) {

                if (!this.field[axisX][axisY].isShip() && !this.field[axisX][axisY].isNeigbor() &&
                !this.field[axisX+1][axisY].isShip() && !this.field[axisX+1][axisY].isNeigbor() &&
                !this.field[axisX+2][axisY].isShip() && !this.field[axisX+2][axisY].isNeigbor() ) {

                Ship submarine = new Ship(new Square[] {this.field[axisX][axisY], this.field[axisX+1][axisY], this.field[axisX+2][axisY]});
                // markAsNeighbor();
                            addNeighbors(submarine);
                this.fleet[3]=submarine;
                isWorking =false;
                // return submarine;
            } 
            }
            else if (axisY+3 <10 && axisX%2!=0) {

                if (
                !this.field[axisX][axisY+1].isShip() && !this.field[axisX][axisY+1].isNeigbor() &&
                !this.field[axisX][axisY+2].isShip() && !this.field[axisX][axisY+2].isNeigbor() ) {

                Ship submarine = new Ship(new Square[] {this.field[axisX][axisY], this.field[axisX][axisY+1], this.field[axisX][axisY+2]});
                // markAsNeighbor();
                            addNeighbors(submarine);
                this.fleet[3]=submarine;
                isWorking =false;
                // return submarine;
            }  
        }
        }return this.fleet;
    }

    private Ship[] makeDestroyer() {
        int axisX;
        int axisY;

        boolean isWorking = true;

        while (isWorking) {
            axisX = generateRandomInt();
            axisY = generateRandomInt();

            if (axisX+3 <10 && axisY%2!=0) {

                if (!this.field[axisX][axisY].isShip() && !this.field[axisX][axisY].isNeigbor() &&
                !this.field[axisX+1][axisY].isShip() && !this.field[axisX+1][axisY].isNeigbor() ) {

                Ship destroyer = new Ship(new Square[] {this.field[axisX][axisY], this.field[axisX+1][axisY]});
                // markAsNeighbor();
                            addNeighbors(destroyer);
                this.fleet[4]=destroyer;
                isWorking =false;
                // return destroyer;
            } 
            }
            else if (axisY+3 <10 && axisX%2!=0) {

                if (
                !this.field[axisX][axisY+1].isShip() && !this.field[axisX][axisY+1].isNeigbor()) {

                Ship destroyer = new Ship(new Square[] {this.field[axisX][axisY], this.field[axisX][axisY+1]});
                // markAsNeighbor();
                            addNeighbors(destroyer);
                this.fleet[4]=destroyer;
                isWorking =false;
                // return destroyer;
            }  
        }
        } return this.fleet;
        
    }

    private void markAsNeighbor(){
        for (Integer x = 0; x<10; x++){
            for (Integer y = 0; y<10; y++){
                if (x==0 && y==0) {
                    if (this.field[x+1][y+1].isShip() ) { // rog planszy
                        this.field[x][y].makeNeighbor();
                    }  
                }
                if (x==9 && y==9) {
                    if (this.field[x-1][y-1].isShip() ) { // rog planszy
                        this.field[x][y].makeNeighbor();
                    }  
                }
                if (x==0 && y==9) {
                    if (this.field[x+1][y-1].isShip() ) { // rog planszy
                        this.field[x][y].makeNeighbor();
                    }  
                }
                if (x==9 && y==0) {
                    if (this.field[x-1][y+1].isShip() ) { // rog planszy
                        this.field[x][y].makeNeighbor();
                    }  
                }
                if (y>=0 && y<9) {
                    if (
                     this.field[x][y+1].isShip()) //lewa strona kazdego
                    {
                        this.field[x][y].makeNeighbor();}
                } 
                if (y>0 && y<=9) {
                    if (   
                     this.field[x][y-1].isShip()) // prawa strona kazdego
                    {
                        this.field[x][y].makeNeighbor();}
                    } 
                if (x>=0 && x<9) {
                    if (
                     this.field[x+1][y].isShip()) // góra kazdego
                    {
                        this.field[x][y].makeNeighbor();}
                }
                if (x>0 && x<=9) {
                    if (
                     this.field[x-1][y].isShip()) // dół kazdego
                    {
                        this.field[x][y].makeNeighbor();}
                }
                if (y>=1 && y<=8 && x>=1 && x<=8) {
                    if (
                     this.field[x+1][y-1].isShip()||
                     this.field[x-1][y-1].isShip()||
                     this.field[x-1][y+1].isShip()||
                     this.field[x+1][y+1].isShip()) // rogi statku bez lini brzegowej
                    {
                        this.field[x][y].makeNeighbor();}
                    }
                if (y>=1 && y<=8 && x>=0 && x<=8) {
                    if (
                     this.field[x+1][y-1].isShip()||
                     this.field[x+1][y+1].isShip()) // rogi statku na lini brzegowej
                    {
                        this.field[x][y].makeNeighbor();}
                    }
                if (y>=0 && y<=8 && x>=1 && x<=8) {
                    if (
                     this.field[x-1][y+1].isShip()||
                     this.field[x+1][y+1].isShip()) // rogi statku na lini brzegowej
                    {
                        this.field[x][y].makeNeighbor();}
                    }
                if (y>=1 && y<=8 && x>=1 && x<=9) {
                    if (
                     this.field[x-1][y+1].isShip()||
                     this.field[x-1][y-1].isShip()) // rogi statku na lini brzegowej
                    {
                        this.field[x][y].makeNeighbor();}
                    }
                if (y>=1 && y<=9 && x>=1 && x<=8) {
                    if (
                     this.field[x+1][y-1].isShip()||
                     this.field[x-1][y-1].isShip()) // rogi statku na lini brzegowej
                    {
                        this.field[x][y].makeNeighbor();}
                    }
    
                }
                }
                
            }
      
    }
