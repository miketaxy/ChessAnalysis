package org.miketaxy.chessanalysis.ChessAnalysis.chess;

import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.github.bhlangonijr.chesslib.move.Move;
import com.github.bhlangonijr.chesslib.move.MoveList;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.miketaxy.chessanalysis.ChessAnalysis.serialization.PGNSerializer;

import java.util.ArrayList;
import java.util.List;

@JsonSerialize(using = PGNSerializer.class)
@AllArgsConstructor
public class PGN {
    @Getter private Node node;
    public static PGN parse(String game) {
        MoveList list = new MoveList();
        list.loadFromSan(game);
        Node node = new Node();
        Node iter = node;
        node.setUci(list.get(0).toString());
        for(Move m : list.subList(1, list.size())) {
            Node next = new Node();
            iter.setMainLine(next);
            next.setUci(m.toString());
            iter = next;
        }
        return new PGN(node);
    }
    public static class Node {
        @Getter @Setter private String uci;
        @Getter @Setter private Node mainLine;
        @Getter @Setter private List<Node> sideLines = new ArrayList<>();
        @Getter @Setter private String annotation;
        public void addSideLine(String move, float eval){
            Node node = new Node();
            node.setUci(move);
            node.setAnnotation("Eval: " + eval);
            sideLines.add(node);
        }

    }
}