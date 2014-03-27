import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Mladjan on 26.3.2014.
 */
public class NumbersInWordTest {

    NumbersInWord subject;

    @Before
    public void setUp() {
        subject = new NumbersInWord();
    }

    @Test
    public void returnONEDOLARfor1() throws Exception  {
        assertEquals("one dollar", subject.convert(1));
    }

    @Test
    public void returnTWODOLARfor1() throws Exception  {
        assertEquals("two dollar", subject.convert(2));
    }

    @Test
    public void returnELEVENfor11() throws Exception  {
        assertEquals("eleven dollar", subject.convert(11));
    }

    @Test
    public void returnTWENTYfor20() throws Exception  {
        assertEquals("twenty dollar", subject.convert(20));
    }

    @Test
    public void returnOneHUNDREDfor100() throws Exception {
        assertEquals("one hundred dollar", subject.convert(100));
    }

    @Test
    public void returnONEHUDREDTWENTYFIVEfor125() throws Exception {
        assertEquals("one hundred twenty five dollar", subject.convert(125));
    }

    @Test
    public void return1255for1255() throws Exception {
        assertEquals("one thousand two hundred fifty five dollar", subject.convert(1255));
    }

    @Test(expected = NumbersInWord.MoneyOutOfBoundException.class)
    public void mustThrowException() throws Exception {
        subject.convert(10000);
    }

}
