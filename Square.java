public class Square {
    private String state;
    //(ship, ocean, miss, hit, neighbor, sank)
    public Square(int x, int y){
        this.state = "ocean";
    }
    
    public void makeShip(){
        if (this.state.equals("ocean")){
            this.state = "ship";
        }
    }
    
    public void makeNeighbor(){
        if (this.state.equals("ocean")){
            this.state = "neighbor";
        }
    }
    
    public void makeHit(){
        if (this.state.equals("ship")){
            this.state = "hit";
        } else if (this.state.equals("ocean") || this.state.equals("neighbor")) {
            this.state = "miss";
        }
    }
    
    public void makeSunk(){
        if (this.state.equals("hit")){
            this.state = "sunk";
        }
    }

    public boolean isHit(){
        return this.state.equals("hit");
    }

    public String getState(){
        return this.state;
    }
    
    
    public String showStatusToOwner() {
        //(ship,hit,sank, ocean, miss,  neighbor, )
        if (this.state.equals("ship")){
            return "■";
        } else if (this.state.equals("hit")){
            return "×";
        }else if (this.state.equals("miss")){
            return "·";
        }
        else {
            return " ";
         
        }
    }

    public String showStatusToOponent() {
        //(ship,hit,sunk, ocean, miss,  neighbor, )
        if (this.state.equals("sunk")){
            return "■";
        } else if (this.state.equals("hit")){
            return "×";
        }else if (this.state.equals("miss")){
            return "·";
        }
        else {
            return " ";
         
        }
    }
}