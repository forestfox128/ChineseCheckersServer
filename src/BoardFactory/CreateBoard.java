package BoardFactory;

import com.company.Board;

public class CreateBoard {

    //protected int playersNumber;

    public static GeneralBoard createBoard(int playersNumber) {
        GeneralBoard product = null;

        if (playersNumber == 6) {
            product = new SixPlayerBoard(playersNumber);
        }
        else if (playersNumber == 4) {
            product = new FourPlayerBoard(playersNumber);
        }
        else if (playersNumber == 3) {
            product = new ThreePlayerBoard(playersNumber);
        }
        else if (playersNumber == 2) {
            product = new TwoPlayerBoard(playersNumber);
        }

        return product;
    }


}
