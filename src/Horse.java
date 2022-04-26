import static java.lang.Math.abs;

public class Horse extends ChessPiece{

    public Horse(String color){
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
        if((abs(line-toLine)==2&&abs(column-toColumn)==1)){
            if(chessBoard.board[toLine][toColumn]!=null&&chessBoard.board[toLine][toColumn].color.equals(color)){
                return false;
            }
            return true;
        }
        if(abs(line-toLine)==1&&abs(column-toColumn)==2){
            if(chessBoard.board[toLine][toColumn]!=null&&chessBoard.board[toLine][toColumn].color.equals(color)){
                return false;
            }
            return true;
        }
        return false;
    }

    @Override
    public String getSymbol() {
        return "H";
    }
}
