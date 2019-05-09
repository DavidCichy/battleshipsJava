import java.util.Random;

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

    }

    private int generateRandomInt(){
        Random random = new Random();
        return random.nextInt(10);
    }

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
                markAsNeighbor();
                this.fleet[0]=carrier;
                isWorking =false;
                //return carrier;
            } else if (axisY+4 <10 && axisX%2!=0) {
                carrier = new Ship(new Square[] {this.field[axisX][axisY], this.field[axisX][axisY+1], this.field[axisX][axisY+2], 
                                                      this.field[axisX][axisY+3], this.field[axisX][axisY+4]});
                markAsNeighbor();
                this.fleet[0]=carrier;
                isWorking =false;
                //return carrier;
            }  
        }
        //this.isDestroyed = false;
        
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
                markAsNeighbor();
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
                markAsNeighbor();
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
                markAsNeighbor();
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
                markAsNeighbor();
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
                markAsNeighbor();
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
                markAsNeighbor();
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

                Ship destroyer = new Ship(new Square[] {this.field[axisX][axisY], this.field[axisX+1][axisY], this.field[axisX+2][axisY]});
                markAsNeighbor();
                this.fleet[4]=destroyer;
                isWorking =false;
                // return destroyer;
            } 
            }
            else if (axisY+3 <10 && axisX%2!=0) {

                if (
                !this.field[axisX][axisY+1].isShip() && !this.field[axisX][axisY+1].isNeigbor()) {

                Ship destroyer = new Ship(new Square[] {this.field[axisX][axisY], this.field[axisX][axisY+1], this.field[axisX][axisY+2]});
                markAsNeighbor();
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
