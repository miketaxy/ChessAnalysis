package org.miketaxy.chessanalysis.ChessAnalysis.services;

import com.github.bhlangonijr.chesslib.Board;
import com.rahul.stockfish.Stockfish;
import org.miketaxy.chessanalysis.ChessAnalysis.chess.PGN;
import org.miketaxy.chessanalysis.ChessAnalysis.entity.Game;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

@Service
public class GameServiceImpl implements GameService {
    public Game submitGame(@RequestParam("pgn") String pgn){
        Game game = new Game();
        game.setPgn(PGN.parse(pgn));
        Board board = new Board();
        PGN moves = game.getPgn();
        PGN.Node node = moves.getNode();
        Stockfish stockfish = new Stockfish();
        try {
            if(!stockfish.startEngine()){
                return null;
            }
            while (node != null) {
                String bestMove = stockfish.getBestMove(board.getFen(), 1000);
                board.doMove(node.getUci());
                float eval = stockfish.getEvalScore(board.getFen(), 1000);
                node.setAnnotation("Eval: " + eval);
                if(bestMove != node.getUci()) {
                    board.undoMove();
                    board.doMove(bestMove);
                    float bestEval = stockfish.getEvalScore(board.getFen(),1000);
                    if(Math.abs(bestEval - eval) > 0.5){
                        node.addSideLine(bestMove,bestEval);
                    }
                    board.undoMove();
                    board.doMove(node.getUci());
                }
                node = node.getMainLine();
            }
        }
        finally {
            stockfish.stopEngine();
        }
        return game; //TODO: enqueue game in processing queue
    }
}
