package projectTicTacToe.service;

import projectTicTacToe.model.Board;
import projectTicTacToe.model.Move;
import projectTicTacToe.model.Player;

public interface WinningStrategy {
    Player checkWinner(Board board, Move lastMove);
}
