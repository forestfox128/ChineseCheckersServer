package BoardFactory;

public abstract class GeneralBoard {

    public int [][] newBoardArray = new int[17][25];

    public abstract void createNewBoard();

    public abstract void givePawnstoPlayers();

    public String possibleMoves(int x, int y){

        String possMove = null;

        if (newBoardArray[x-1][y-1] == 0){
            possMove = Integer.toString(x-1) +":"+Integer.toString(y-1);
            System.out.println("OKKKKK");
        }
        else if (newBoardArray[x-1][y-1] == 1){
            int tempX = x;
            int tempY = y;
            while(newBoardArray[tempX-2][tempY-2] == 0 && newBoardArray[tempX-1][tempY-1] == 1) {
                possMove = possMove + ":" + Integer.toString(tempX - 2) + ":" + Integer.toString(tempY - 2);
                tempX = tempX -2;
                tempY = tempY -2;
            }
        }

        if (newBoardArray[x+1][y-1] == 0) {
            possMove = possMove +":"+ Integer.toString(x+1) +":"+Integer.toString(y-1);

        }
        else if (newBoardArray[x+1][y-1] == 1){
            int tempX = x;
            int tempY = y;
            while(newBoardArray[tempX+2][tempY-2] == 0 && newBoardArray[tempX+1][tempY-1] == 1) {
                possMove = possMove + ":" + Integer.toString(tempX + 2) + ":" + Integer.toString(tempY - 2);
                tempX = tempX +2;
                tempY = tempY -2;
            }
        }
        if (newBoardArray[x-1][y+1] == 0) {
            possMove = possMove +":"+ Integer.toString(x-1) +":"+Integer.toString(y+1);

        }
        else if (newBoardArray[x-1][y+1] == 1){
            int tempX = x;
            int tempY = y;
            while(newBoardArray[tempX-2][tempY+2] == 0 && newBoardArray[tempX-1][tempY+1] == 1) {
                possMove = possMove + ":" + Integer.toString(tempX - 2) + ":" + Integer.toString(tempY + 2);
                tempX = tempX -2;
                tempY = tempY +2;
            }
        }
        if (newBoardArray[x+1][y+1] == 0) {
            possMove = possMove +":"+ Integer.toString(x+1) +":"+Integer.toString(y+1);

        }
        else if (newBoardArray[x+1][y+1] == 1){
            int tempX = x;
            int tempY = y;
            while(newBoardArray[tempX+2][tempY+2] == 0 && newBoardArray[tempX+1][tempY+1] == 1) {
                possMove = possMove + ":" + Integer.toString(tempX + 2) + ":" + Integer.toString(tempY + 2);
                tempX = tempX +2;
                tempY = tempY +2;
            }
        }
        if (newBoardArray[x][y+2] == 0) {
            possMove = possMove +":"+ Integer.toString(x) +":"+Integer.toString(y+2);

        }
        else if (newBoardArray[x][y+2] == 1){
            int tempY = y;
            while(newBoardArray[x][tempY+4] == 0 && newBoardArray[x][tempY+2] == 1) {
                possMove = possMove + ":" + Integer.toString(x) + ":" + Integer.toString(tempY + 4);
                tempY = tempY +4;
            }
        }
        if (newBoardArray[x][y-2] == 0) {
            possMove = possMove +":"+ Integer.toString(x) +":"+Integer.toString(y-2);

        }
        else if (newBoardArray[x][y-2] == 1){
            int tempY = y;
            while(newBoardArray[x][tempY-4] == 0 && newBoardArray[x][tempY-2] == 1) {
                possMove = possMove + ":" + Integer.toString(x) + ":" + Integer.toString(tempY - 4);
                tempY = tempY -4;
            }
        }

        return possMove;

    }
}
