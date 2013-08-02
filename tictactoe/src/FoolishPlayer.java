
public class FoolishPlayer implements TicTacToePlayer{
	TicTacToeGame game;

	@Override
	public Move getMove() {
	
		for(int x = 0 ; x < 3 ; x++) {
			for (int y = 0 ; y < 3 ; y++) {
				if(game.canPlacePieceAt(x, y)) {
					return new Move(x, y);
				}
			}
		}
		return null;
	}

	@Override
	public void setGame(TicTacToeGame game) {
		this.game = game;
		
	}

}
