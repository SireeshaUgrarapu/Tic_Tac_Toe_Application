package projectTicTacToe.service.botPlayingStrategy;

import projectTicTacToe.model.Board;
import projectTicTacToe.model.Move;
import projectTicTacToe.model.Player;

public interface BotPlayingStrategy {
     Move makeMove(Board board , Player player);
}
