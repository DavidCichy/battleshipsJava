public class Ocean {
    Square[][] field;

    public Ocean(Square[][] field){
        this.field = field;
    }

    public void markSquare(int x, int y){
        Square location = field[y][x];
        location.makeHit();
    }

    public boolean wasItShot(int x, int y){
        Square location = field[y][x];
        return location.getState().equals("hit") || location.getState().equals("miss");
        //return location.getState().equals("hit") || location.getState().equals("miss") || location.getState().equals("neighbor") || location.getState().equals("sunk");



    }

    public String stateOfSquare(int x, int y){
        Square location = field[y][x];
        return location.getState();
    }

}