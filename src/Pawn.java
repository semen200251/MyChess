public class Pawn extends ChessPiece{

    public Pawn(String color){
        super(color);
    }
    @Override
    public String getColor() {
        return color;
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        if(toColumn>7||toLine>7||toLine<0||toColumn<0){
            return false;
        }
        if(color.equals("White")) {
            if (toLine - line <= 0) {
                return false;
            }
            if (column != toColumn) {
                return false;
            }
            if (line == 1 ){
                if(toLine-line>2) {
                    return false;
                }
            }
            if(line!=1&&toLine-line!=1){
                return false;
            }
        }else{
            if (line - toLine <= 0) {
                return false;
            }
            if (column != toColumn) {
                return false;
            }
            if (line == 6){
                if(line-toLine>2) {
                    return false;
                }
            }
            if(line!=6&&line-toLine!=1){
                return false;
            }
        }

        if(line<toLine){
            for(int i=line+1;i<=toLine;i++){
                if(chessBoard.board[i][column]!=null&&chessBoard.board[i][column].color.equals(color)){
                    return false;
                }
            }
        }else{
            for(int i=toLine;i<line;i++){
                if(chessBoard.board[i][column]!=null&&chessBoard.board[i][column].color.equals(color)){
                    return false;
                }
            }
        }
        return true;
    }

    @Override
    public String getSymbol() {
        return "P";
    }
}
