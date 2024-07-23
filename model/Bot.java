package projectTicTacToe.model;

import projectTicTacToe.service.botPlayingStrategy.BotPlayingStrategyFactory;


public class Bot extends Player{
    private BotDifficultyLevel botDifficultyLevel;



    public Bot(int id,char symbol,BotDifficultyLevel botDifficultyLevel) {
        super(id, "CHITTI", symbol, PlayerType.BOT);
        this.botDifficultyLevel = botDifficultyLevel;
    }
    public Move makeMove(Board board){
        return BotPlayingStrategyFactory.getBotPlayingStrategy().makeMove(board,this);
    }
}
