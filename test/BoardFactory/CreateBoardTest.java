package BoardFactory;

import org.junit.Test;
import static org.junit.Assert.*;

public class CreateBoardTest {

    @Test
    public void testCreateBoard6() throws Exception{

        if(CreateBoard.createBoard(6) instanceof SixPlayerBoard)
            assertTrue(true);
        else assertTrue(false);
    }

    @Test
    public void testCreateBoard4() throws Exception{

        if(CreateBoard.createBoard(4) instanceof FourPlayerBoard)
            assertTrue(true);
        else assertTrue(false);
    }
    @Test
    public void testCreateBoard3() throws Exception{

        if(CreateBoard.createBoard(3) instanceof ThreePlayerBoard)
            assertTrue(true);
        else assertTrue(false);
    }
    @Test
    public void testCreateBoard2() throws Exception{

        if(CreateBoard.createBoard(2) instanceof TwoPlayerBoard)
            assertTrue(true);
        else assertTrue(false);
    }
}
