package projectTicTacToe;



import projectTicTacToe.controller.GameController;
import projectTicTacToe.model.*;
import projectTicTacToe.service.winningStrategy.WinningStrategyName;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class TicTacToe {
    public static void main(String[] args) {
        GameController gameController = new GameController();
        int id = 1;
        List<Player> players = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to TicTacToe Game");
        System.out.println("Please enter the Dimensions of the board");
        int dimension = sc.nextInt();
        System.out.println("Kindly conform the Bot : Yes or No");
        String botAns = sc.next();
        if(botAns.equalsIgnoreCase("Y")){
            Player bot = new Bot(id++,'$',BotDifficultyLevel.HARD);
            players.add(bot);
        }
        while(id < dimension){
            System.out.println("Please Enter the Player Name");
            String PlayerName = sc.next();
            System.out.println("Please Enter the Player Symbol");
            char symbol = sc.next().charAt(0);
            Player newPlayer =new Player(id++,PlayerName,symbol, PlayerType.HUMAN);
            players.add(newPlayer);
        }
        Collections.shuffle(players);
        Game game = gameController.creategame(dimension,players, WinningStrategyName.ORDERONEWINNINGSTRATEGY);

        int playerIndex = -1;
        while(game.getGameStatus().equals(GameStatus.IN_PROGRESS)){
            System.out.println("Current Board Status");
  // TODO add the Undo logic dont ask for undo when board is empty and
//            dont ask for undo when the bot is player,who played last move
            gameController.displayBoard(game);
            playerIndex++;
            playerIndex = playerIndex % players.size();
            Move movePlayed = gameController.executeMove(game,players.get(playerIndex));
            game.getMoves().add(movePlayed);
            game.getBoardStates().add(game.getCurrentBoard());
            Player winner = gameController.checkWinner(game,movePlayed);
            if(winner != null){
                System.out.println("WINNER IS : " + winner.getName());
                break;
            }
            if(game.getMoves().size() == game.getCurrentBoard().getDimension() * game.getCurrentBoard().getDimension()){
                System.out.println("GAME IS DRAW");
                break;
            }
        }
        System.out.println("Final Board Status");
        gameController.displayBoard(game);
        System.out.println("Do You Want Play Again");
//       TODO make the loop to run again
    }
}
