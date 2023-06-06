package org.miketaxy.chessanalysis.ChessAnalysis.serialization;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import org.miketaxy.chessanalysis.ChessAnalysis.chess.PGN;

import java.io.IOException;

public class PGNSerializer extends StdSerializer<PGN> {
    public PGNSerializer() {
        this(null);
    }
    public PGNSerializer(Class<PGN> t) {
        super(t);
    }

    @Override
    public void serialize(PGN pgn, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
//        jsonGenerator.writeStartObject();
//        PGN.Node node = pgn.getNode();
//        jsonGenerator.writeStringField("uci", node.getUci());
//        jsonGenerator.writeObjectField("mainLine", node.getMainLine());
//        jsonGenerator.writeObjectField("sideLines", node.getSideLines());
//        jsonGenerator.writeStringField("annotation", node.getAnnotation());
//        jsonGenerator.writeEndObject();
        jsonGenerator.writeObject(pgn.getNode());
    }
}
