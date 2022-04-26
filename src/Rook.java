import static java.lang.Math.abs;

public class Rook extends ChessPiece{

    public Rook(String color){
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
        if(line-toLine==0&&column-toColumn==0){
            return false;
        }
        if(abs(line-toLine)!=0&&abs(column-toColumn)!=0){
            return false;
        }

        if(line-toLine!=0){
            if(line>toLine){
                for(int i=toLine;i<line;i++){
                    if(chessBoard.board[i][column]!=null&&chessBoard.board[i][column].color.equals(color)){
                        return false;
                    }
                }
            }else{
                for(int i=line+1;i<=toLine;i++){
                    if(chessBoard.board[i][column]!=null&&chessBoard.board[i][column].color.equals(color)){
                        return false;
                    }
                }
            }
        }else{
            if(column>toColumn){
                for(int i=toColumn;i<column;i++){
                    if(chessBoard.board[line][i]!=null&&chessBoard.board[line][i].color.equals(color)){
                        return false;
                    }
                }
            }else{
                for(int i=column+1;i<=toColumn;i++){
                    if(chessBoard.board[line][i]!=null&&chessBoard.board[line][i].color.equals(color)){
                        return false;
                    }
                }
            }
        }
        return true;
    }

    @Override
    public String getSymbol() {
        return "R";
    }
}
