import static java.lang.Math.abs;

public class King extends ChessPiece{

    public King(String color) {
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

        if(abs(line-toLine)>1||abs(column-toColumn)>1){
            return false;
        }
        if(chessBoard.board[toLine][toColumn]!=null){
            return false;
        }
        return true;
    }

    @Override
    public String getSymbol() {
        return "K";
    }

    public boolean isUnderAttack(ChessBoard board, int line, int column){
        for(int i=0;i<8;i++){
            for(int j=0;j<8;j++){
                if(color.equals("White")){
                    if(board.board[i][j]!=null&&board.board[i][j].color.equals("Black")){
                        if(board.board[i][j].canMoveToPosition(board,i,j,line,column)) {
                            return true;
                        }
                    }
                }else{
                    if(board.board[i][j]!=null&&board.board[i][j].color.equals("White")){
                        if(board.board[i][j].canMoveToPosition(board,i,j,line,column)){
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }
}
