public class Player { 
    private Ocean playerOcean;
    private Fleet playerFleet;

        public Player(Ocean playerOcean, Fleet playerFleet){
            this.playerOcean = playerOcean;
            this.playerFleet = playerFleet;
        }

        public shotAtLocation(int x, int y, Player opponent){
            opponent.recieveHit(x, y);
        }

        public void recieveHit(int x, int y){
            if(!playerFleet.tryToHitLocation(x, y)){
                playerOcean.markSquare(x, y);
            };
        }
}