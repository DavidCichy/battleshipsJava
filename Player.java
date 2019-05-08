public class Player { 
    private Ocean playerOcean;
    private Fleet playerFleet;
    private String playerName;
    private boolean lost;

        public Player(String playerName, Ocean playerOcean, Fleet playerFleet){
            this.playerName = playerName;
            this.playerOcean = playerOcean;
            this.playerFleet = playerFleet;
            this.lost = false;
        }

        public void shotAtLocation(int x, int y, Player opponent){
            opponent.recieveHit(x, y);
        }

        public void recieveHit(int x, int y){
            if(playerFleet.tryToHitLocation(x, y)){
                this.updateState();
            } else {playerOcean.markSquare(x, y);}
        }

        public void showBoard(Player opponent){
            Display.showBoards(this.playerOcean, opponent.getOcean  ());
        }

        private void updateState(){
            this.lost = this.playerFleet.isDestroyed;
        }


        public boolean checkIfLost(){
            return this.lost;
        }

        public Ocean getOcean(){
            return this.playerOcean;
        }

        public String getName(){
            return this.playerName;
        }
}