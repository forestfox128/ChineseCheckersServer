package BoardFactory;

import com.company.Pawn;

public class TwoPlayerBoard extends GeneralBoard{

    Pawn pawn;


    public TwoPlayerBoard(int playerNumber){

    }

    @Override
    public void createNewBoard() {

        for (int i = 0; i < 17; i++)
            for (int j = 0; j < 25; j++)
                newBoardArray[i][j] = -1;

        for (int i = 0; i < 17; i++)
            for (int j = 0; j < 25; j++) {

                if ((i == 0 && j == 12) || (i == 1 && (j == 11 || j == 13)) || (i == 2 && (j == 10 || j == 12 || j == 14)) || (i == 3 && (j == 9 || j == 11 || j == 13 || j == 15))) {
                    newBoardArray[i][j] = 1;
                    playerArray[i][j] = 1;
                    pawnList.add(pawn = new Pawn(i, j, 1));
                }
                if ((i == 7 && j == 3) || (i == 6 && (j == 2 || j == 4)) || (i == 5 && (j == 1 || j == 3 || j == 5)) || (i == 4 && (j == 0 || j == 2 || j == 4 || j == 6))) {
                    newBoardArray[i][j] = 0;
                }
                if ((i == 9 && j == 3) || (i == 10 && (j == 2 || j == 4)) || (i == 11 && (j == 1 || j == 3 || j == 5)) || (i == 12 && (j == 0 || j == 2 || j == 4 || j == 6))) {
                    newBoardArray[i][j] = 0;
                }
                if ((i == 16 && j == 12) || (i == 15 && (j == 11 || j == 13)) || (i == 14 && (j == 10 || j == 12 || j == 14)) || (i == 13 && (j == 9 || j == 11 || j == 13 || j == 15))) {
                    newBoardArray[i][j] = 1;
                    playerArray[i][j] = 2;
                    pawnList.add(pawn = new Pawn(i, j, 4));
                }
                if ((i == 9 && j == 21) || (i == 10 && (j == 20 || j == 22)) || (i == 11 && (j == 19 || j == 21 || j == 23)) || (i == 12 && (j == 18 || j == 20 || j == 22 || j == 24))) {
                    newBoardArray[i][j] = 0;
                }
                if ((i == 7 && j == 21) || (i == 6 && (j == 20 || j == 22)) || (i == 5 && (j == 19 || j == 21 || j == 23)) || (i == 4 && (j == 18 || j == 20 || j == 22 || j == 24))) {
                    newBoardArray[i][j] = 0;
                }
                if (i == 8 && j == 12) {
                    newBoardArray[i][j] = 0;
                } else if ((i == 4 || i == 12) && j >= 8 && j <= 16 && j % 2 == 0)
                    newBoardArray[i][j] = 0;
                else if ((i == 5 || i == 11) && j >= 7 && j <= 17 && j % 2 != 0)
                    newBoardArray[i][j] = 0;
                else if ((i == 6 || i == 10) && j >= 6 && j <= 18 && j % 2 == 0)
                    newBoardArray[i][j] = 0;
                else if ((i == 7 || i == 9) && j >= 5 && j <= 19 && j % 2 != 0)
                    newBoardArray[i][j] = 0;
                else if (i == 8 && j >= 4 && j <= 20 && j % 2 == 0)
                    newBoardArray[i][j] = 0;
            }

//        for (int i = 0; i < 17; i++)
//            for (int j = 0; j < 25; j++)
//                System.out.println(playerArray[i][j]);
    }

}
