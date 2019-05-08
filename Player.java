public class Player { 
    private Ocean playerOcean;
    private Fleet playerFleet;
    private boolean lost;

        public Player(Ocean playerOcean, Fleet playerFleet){
            this.playerOcean = playerOcean;
            this.playerFleet = playerFleet;
            this.lost = false;
        }

        public void shotAtLocation(int x, int y, Player opponent){
            opponent.recieveHit(x, y);
        }

        public void recieveHit(int x, int y){
            if(!playerFleet.tryToHitLocation(x, y)){
                playerOcean.markSquare(x, y);
            };
        }

        public void showBoard(Player opponent){
            Display.showBoards(this.playerOcean, opponent.passOcean());
        }

        public Ocean passOcean(){
            return this.playerOcean;
        }
}