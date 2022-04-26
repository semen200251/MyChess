import static java.lang.Math.abs;

public class Bishop extends ChessPiece{

    public Bishop(String color){
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
        if(toColumn==column){
            return false;
        }
        if(line==toLine){
            return false;
        }
        if(abs(line-toLine)!=abs(column-toColumn)) {
            return false;
        }
        int j=column+1;
        if(line<toLine&&column<toColumn){
            for(int i=line+1;i<=toLine;i++){
                if(chessBoard.board[i][j]!=null&&chessBoard.board[i][j].color.equals(color)){
                    return false;
                }
                j++;
            }
        }
        if(line>toLine&&column<toColumn){
            for(int i=line-1;i>=toLine;i--){
                if(chessBoard.board[i][j]!=null&&chessBoard.board[i][j].color.equals(color)){
                    return false;
                }
                j++;
            }
        }
        if(line<toLine&&column>toColumn){
            for(int i=line+1;i<=toLine;i++){
                if(chessBoard.board[i][j]!=null&&chessBoard.board[i][j].color.equals(color)){
                    return false;
                }
                j--;
            }
        }
        if(line>toLine&&column>toColumn){
            for(int i=line-1;i>=toLine;i--){
                if(chessBoard.board[i][j]!=null&&chessBoard.board[i][j].color.equals(color)){
                    return false;
                }
                j--;
            }
        }
        return true;
    }

    @Override
    public String getSymbol() {
        return "B";
    }
}
