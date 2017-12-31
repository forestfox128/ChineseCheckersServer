package BoardFactory;

public abstract class GeneralBoard {

    public int [][] newBoardArray = new int[17][25];

    public abstract void createNewBoard();

    public abstract void givePawnsToPlayers();

    private String appendMoves(String possMove, int x, int y)
    {
        possMove += Integer.toString(x) + ":" + Integer.toString(y) + ",";
        System.out.println("dodano pole");
        return possMove;
    }

    public int getPlayer(int x, int y)
    {
        return newBoardArray[x][y];
    }

    private boolean isValidField(int x, int y)
    {
        if(x < 0 || x > 16)
            return false;
        if(y < 0 || y > 34)
            return false;
        return true;
    }

    public String possibleMoves(int x, int y){

        String possMove = "";


        if (isValidField(x - 1, y - 1) && newBoardArray[x-1][y-1] == 0){
//            possMove = Integer.toString(x-1) +":"+Integer.toString(y-1);
            possMove = appendMoves(possMove, x - 1, y - 1);
        }
        else if (isValidField(x - 1,y - 1) && newBoardArray[x-1][y-1] == 1){
            int tempX = x;
            int tempY = y;
            while(isValidField(tempX - 2, tempY - 2) && newBoardArray[tempX-2][tempY-2] == 0 && newBoardArray[tempX-1][tempY-1] == 1) {
//                possMove = possMove + "," + Integer.toString(tempX - 2) + ":" + Integer.toString(tempY - 2);
                possMove = appendMoves(possMove, tempX - 2, tempY - 2);
                tempX = tempX -2;
                tempY = tempY -2;
            }
        }

        if (isValidField(x + 1, y - 1) && newBoardArray[x+1][y-1] == 0) {
//            possMove = possMove +","+ Integer.toString(x+1) +":"+Integer.toString(y-1);
            possMove = appendMoves(possMove, x + 1, y - 1);
        }
        else if (isValidField(x + 1, y - 1) && newBoardArray[x+1][y-1] == 1){
            int tempX = x;
            int tempY = y;
            while(isValidField(tempX + 2, tempY - 2) && newBoardArray[tempX+2][tempY-2] == 0 && newBoardArray[tempX+1][tempY-1] == 1) {
//                possMove = possMove + "," + Integer.toString(tempX + 2) + ":" + Integer.toString(tempY - 2);
                possMove = appendMoves(possMove, tempX + 2, tempY - 2);
                tempX = tempX +2;
                tempY = tempY -2;
            }
        }
        if (isValidField(x - 1, y + 1) && newBoardArray[x-1][y+1] == 0) {
//            possMove = possMove +","+ Integer.toString(x-1) +":"+Integer.toString(y+1);
            possMove = appendMoves(possMove, x - 1, y + 1);
        }
        else if (isValidField(x - 1, y + 1) && newBoardArray[x-1][y+1] == 1){
            int tempX = x;
            int tempY = y;
            while(isValidField(tempX - 2, tempY + 2) && newBoardArray[tempX-2][tempY+2] == 0 && newBoardArray[tempX-1][tempY+1] == 1) {
//                possMove = possMove + "," + Integer.toString(tempX - 2) + ":" + Integer.toString(tempY + 2);
                possMove = appendMoves(possMove, tempX - 2, tempY + 2);
                tempX = tempX -2;
                tempY = tempY +2;
            }
        }
        if (isValidField(x + 1, y + 1) && newBoardArray[x+1][y+1] == 0) {
//            possMove = possMove +":"+ Integer.toString(x+1) +":"+Integer.toString(y+1);
            possMove = appendMoves(possMove, x + 1, y + 1);
        }
        else if (isValidField(x + 1, y + 1) && newBoardArray[x+1][y+1] == 1){
            int tempX = x;
            int tempY = y;
            while(isValidField(tempX + 2, tempY + 2) && newBoardArray[tempX+2][tempY+2] == 0 && newBoardArray[tempX+1][tempY+1] == 1) {
//                possMove = possMove + ":" + Integer.toString(tempX + 2) + ":" + Integer.toString(tempY + 2);
                possMove = appendMoves(possMove, tempX + 2, tempY + 2);
                tempX = tempX +2;
                tempY = tempY +2;
            }
        }
        if (isValidField(x, y + 2) && newBoardArray[x][y+2] == 0) {
//            possMove = possMove +":"+ Integer.toString(x) +":"+Integer.toString(y+2);
            possMove = appendMoves(possMove, x, y + 2);
        }
        else if (isValidField(x, y + 2) && newBoardArray[x][y+2] == 1){
            int tempY = y;
            while(isValidField(x, tempY + 4) && newBoardArray[x][tempY+4] == 0 && newBoardArray[x][tempY+2] == 1) {
//                possMove = possMove + ":" + Integer.toString(x) + ":" + Integer.toString(tempY + 4);
                possMove = appendMoves(possMove, x, tempY + 4);
                tempY = tempY +4;
            }
        }
        if (isValidField(x, y - 2) && newBoardArray[x][y-2] == 0) {
//            possMove = possMove +":"+ Integer.toString(x) +":"+Integer.toString(y-2);
            possMove = appendMoves(possMove, x, y - 2);
        }
        else if (isValidField(x, y - 2) && newBoardArray[x][y-2] == 1){
            int tempY = y;
            while(isValidField(x, tempY - 4) && newBoardArray[x][tempY-4] == 0 && newBoardArray[x][tempY-2] == 1) {
//                possMove = possMove + ":" + Integer.toString(x) + ":" + Integer.toString(tempY - 4);
                possMove = appendMoves(possMove, x, tempY - 4);
                tempY = tempY -4;
            }
        }

        return possMove;

    }
}
