public class Queen extends ChessPiece{

    public Queen(String color) {
        super(color);
    }

    @Override
    public String getColor() {
        return color;
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        Rook rook=new Rook(color);
        Bishop bishop=new Bishop(color);
        if(!(rook.canMoveToPosition(chessBoard,line,column,toLine,toColumn)||bishop.canMoveToPosition(chessBoard,line,column,toLine,toColumn))){
            return false;
        }
        return true;
    }

    @Override
    public String getSymbol() {
        return "Q";
    }
}
