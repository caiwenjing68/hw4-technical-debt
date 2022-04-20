package edu.cmu.cs.cs323.scrabble.core.specialtile.defaults;

import edu.cmu.cs.cs323.scrabble.core.board.Board;
import edu.cmu.cs.cs323.scrabble.core.board.Position;
import edu.cmu.cs.cs323.scrabble.core.game.Player;
import edu.cmu.cs.cs323.scrabble.core.game.SWSGame;
import edu.cmu.cs.cs323.scrabble.core.game.SWSGameListener;
import edu.cmu.cs.cs323.scrabble.core.specialtile.SpecialTile;

import java.util.List;

/**
 * Special Tile that reverses the player order.
 */
final class SkipTurnSpecialTile implements SpecialTile {

  private Player owner;

  SkipTurnSpecialTile(Player owner) {
    this.owner = owner;
  }

  public static String identifier() {
    return "Skip Turn";
  }

  /**
   * Causes the player who triggered the tile to lose their next turn.
   *
   * @param game
   *          Instance of the current SWS game.
   * @param board
   *          Game board.
   * @param position
   *          Position the special tile was in when triggered.
   * @param listeners
   *          SWSGameListeners associated with the current game.
   */
  @Override
  public void performAction(SWSGame game, Board board, Position position,
                            List<SWSGameListener> listeners) {
    game.skipTurn(game.currentPlayer());
  }

  @Override
  public Player owner() {
    return owner;
  }

  @Override
  public String toString() {
    return identifier();
  }
}