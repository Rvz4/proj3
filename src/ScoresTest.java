import java.util.ArrayList;
import java.util.NoSuchElementException;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ScoresTest {
    /*
     * Constructor tests using numScores() and get()
     */
    @Test public void GeneralInputTest() { //Tests a string with whitespace, some Integers
        String stuff = "1 23 322311 0";
        Scores scores = new Scores(stuff);
        assertEquals(4, scores.getNumScores());
    }

    @Test public void GeneralInputTestDigits() { //Tests a string with whitespace, some more Integers
        String stuff = "14 92 12312 2123 12999 322311";
        Scores scores = new Scores(stuff);
        assertEquals(6, scores.getNumScores());
    }

    @Test public void GeneralInputTestWhitespace() { //Tests a string with whitespace, some Integers, and a new lines
        String stuff = "   14   92        12312   212    12999     322311     \n 32           \n 32321 1";
        Scores scores = new Scores(stuff);
        assertEquals(9, scores.getNumScores());
    }

    @Test public void NotSpacesTest() { //Tests a string with Integers and doubles(periods between Integers)
        String weirdNumbers = "//2.0p2+3.6[]992-21"; //Should throw illegal argument because characters are not whitespace or integers
        assertThrows(IllegalArgumentException.class, () -> {
            new Scores(weirdNumbers);
        });
    }

    @Test public void DoublesTest() { //Tests a string with Integers and doubles(periods between Integers)
        String weirdNumbers = "2.0 2 3.6 992 21"; //Should throw illegal argument because characters are not whitespace or integers
        assertThrows(IllegalArgumentException.class, () -> {
            new Scores(weirdNumbers);
        });
    }

    @Test public void NegativeInputTest() { //Tests a string with whitespace, some Integers
        String stuff = "-1 777 -23 -322311 -0 777";
        Scores scores = new Scores(stuff);
        assertEquals(6, scores.getNumScores());
    }

    @Test public void InOrderTest() { //Tests a string with whitespace, some Integers
        String stuff = "9 7 8 -23 -12 322311";
        ArrayList<Integer> myNums = new ArrayList<>();
        myNums.add(9);
        myNums.add(7);
        myNums.add(8);
        myNums.add(-23);
        myNums.add(-12);
        myNums.add(322311);

        Scores scores = new Scores(stuff);
        for (int i = 0; i < myNums.size(); i++) {
            assertEquals(myNums.get(i), scores.get(i));
        }
    }

    @Test public void StringTest() { //Tests a string with whitespace and words
        String notNumbers = "Hello World"; //Should throw illegal argument because characters are not whitespace or integers
        assertThrows(IllegalArgumentException.class, () -> {
            new Scores(notNumbers);
        });
    }

    @Test public void EmptyStringTest() { //Tests a string with only whitespace
        String whitespace = "";
        Scores scores = new Scores(whitespace);
        assertEquals(0, scores.getNumScores());
    }

    @Test public void WhitespaceTest() { //Tests a string with only whitespace
        String whitespace = "     ";
        Scores scores = new Scores(whitespace);
        assertEquals(0, scores.getNumScores());
    }

    @Test public void DoesItWork() { //Tests a string with whitespace, some Integers, and a new line
        String stuff = " 1  2  323 -23 \n -12     322311";
        ArrayList<Integer> myNums = new ArrayList<>();
        myNums.add(1);
        myNums.add(2);
        myNums.add(323);
        myNums.add(-23);
        myNums.add(-12);
        myNums.add(322311);

        Scores scores = new Scores(stuff);
        for (int i = 0; i < myNums.size(); i++) {
            assertEquals(myNums.get(i), scores.get(i));
        }
    }
    /*
     * getMax() tests
     */
    @Test public void NoMaxTest() { //Tests a string with only whitespace
        String nothing = "";
        Scores scores = new Scores(nothing);
        assertThrows(NoSuchElementException.class, () -> {
            scores.getMax();
        });
    }

    @Test public void NegMaxTest() { //Tests a string with only whitespace
        String biggest = "27 -29 31 -32";
        Scores scores = new Scores(biggest);
        assertEquals(31, scores.getMax());
    }
}
