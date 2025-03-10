package projectTicTacToe.model;

import projectTicTacToe.exception.InvalidBotCountException;
import projectTicTacToe.exception.InvalidPlayerSizeException;
import projectTicTacToe.exception.InvalidSymbolSetUpException;
import projectTicTacToe.service.WinningStrategy;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Game {
   private Board currentBoard;
   private List<Player> players;
   private Player currentPlayer;
   private GameStatus gameStatus;
   private List<Move> moves;
   private List<Board> boardStates;
   private WinningStrategy winningStrategy;
   private int numberOfSymbols;

    private Game(Board currentBoard, List<Player> players, WinningStrategy winningStrategy) {
        this.currentBoard = currentBoard;
        this.players = players;
        this.currentPlayer = null;
        this.gameStatus = GameStatus.IN_PROGRESS;
        this.moves = new ArrayList<>();
        this.boardStates = new ArrayList<>();
        this.winningStrategy = winningStrategy;
        this.numberOfSymbols = players.size();
    }



    public static Builder builder(){
        return new Builder();
    }
    public Board getCurrentBoard() {
        return currentBoard;
    }
    public List<Player> getPlayers() {
        return players;
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    public GameStatus getGameStatus() {
        return gameStatus;
    }
    public List<Move> getMoves() {
        return moves;
    }
    public List<Board> getBoardStates() {
        return boardStates;
    }
    public WinningStrategy getWinningStrategy() {
        return winningStrategy;
    }
    public int getNumberOfSymbols() {
        return numberOfSymbols;
    }


    public void setCurrentBoard(Board currentBoard) {
        this.currentBoard = currentBoard;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }
    public void setCurrentPlayer(Player currentPlayer) {
        this.currentPlayer = currentPlayer;
    }


    public void setGameStatus(GameStatus gameStatus) {
        this.gameStatus = gameStatus;
    }


    public void setMoves(List<Move> moves) {
        this.moves = moves;
    }

    public void setBoardStates(List<Board> boardStates) {
        this.boardStates = boardStates;
    }

    public void setWinningStrategy(WinningStrategy winningStrategy) {
        this.winningStrategy = winningStrategy;
    }

    public void setNumberOfSymbols(int numberOfSymbols) {
        this.numberOfSymbols = numberOfSymbols;
    }

    public static class Builder{
        private int dimension;
        private Board currentBoard;
        private List<Player> players;
        private WinningStrategy winningStrategy;


        public Builder setDimension(int dimension) {
            this.dimension = dimension;
            return this;
        }

        public Builder setCurrentBoard(Board currentBoard) {
            this.currentBoard = currentBoard;
            return this;
        }

        public Builder setPlayers(List<Player> players) {
            this.players = players;
            return this;
        }
        public Builder setWinningStrategy(WinningStrategy winningStrategy) {
            this.winningStrategy = winningStrategy;
            return this;
        }


        private void validateNumberOfPlayers(){
            if(players.size() < dimension -2 ||players.size() >= dimension){
              throw new InvalidPlayerSizeException("Player size should be n-2 or N-1 as per the board");
            }
        }
        private  void validatePlayerSymbols(){
            HashSet<Character> symbols = new HashSet<>();
            for(Player player : players){
                symbols.add(player.getSymbol());
            }
            if(symbols.size() != players.size())
                throw new InvalidSymbolSetUpException("there should be unique symbol for player");
        }
        private void validateBotCount(){
         int botCount =0;
         for(Player player : players){
             if(player.getPlayerType().equals(PlayerType.BOT)){
                 botCount++;
             }
         }
         if(botCount > 1 || botCount < 0){
             throw new InvalidBotCountException("we can have one 1 maximum bot");
         }
        }

        private void validate(){
            validateBotCount();
            validateNumberOfPlayers();
            validatePlayerSymbols();
        }
        public Game build(){
            validate();
            return new Game(new Board(dimension),players,winningStrategy);

        }
    }
}
