import java.util.ArrayList;
import java.util.NoSuchElementException;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ScoresTest {
    /*
     * Constructor tests using numScores() and get()
     */
    @Test public void OneNumInputTest() { //Tests a string with only an integer
        String stuff = "1";
        Scores scores = new Scores(stuff);
        assertEquals(1, scores.getNumScores());
    }
    @Test public void HeadingWhitespaceInputTest() { //Tests a string with only whitespace and an integer
        String stuff = " 1";
        Scores scores = new Scores(stuff);
        assertEquals(1, scores.getNumScores());
    }
    @Test public void TrailingWhitespaceInputTest() { //Tests a string with only an integer followed by whitespace
        String stuff = "1 ";
        Scores scores = new Scores(stuff);
        assertEquals(1, scores.getNumScores());
    }
    @Test public void SurroundingWhitespaceInputTest() { //Tests a string with only an integer followed by whitespace
        String stuff = " 1 ";
        Scores scores = new Scores(stuff);
        assertEquals(1, scores.getNumScores());
    }
    @Test public void AscendingOrderInputTest() { //Tests a string with whitespace, some Integers
        String stuff = "0 1 23 322311";
        Scores scores = new Scores(stuff);
        assertEquals(4, scores.getNumScores());
    }
    @Test public void NoOrderInputTest() { //Tests a string with whitespace, some Integers
        String stuff = "1 27 23 322311 0";
        Scores scores = new Scores(stuff);
        assertEquals(5, scores.getNumScores());
    }
    @Test public void HeadingWhitespaceInputTestDigits() { //Tests a string with whitespace, some more Integers
        String stuff = " 14 92 12312 2123 12999 322311";
        Scores scores = new Scores(stuff);
        assertEquals(6, scores.getNumScores());
    }
    @Test public void TrailingWhitespaceInputTestDigits() { //Tests a string with whitespace, some more Integers
        String stuff = "14 92 12312 2123 12999 322311 ";
        Scores scores = new Scores(stuff);
        assertEquals(6, scores.getNumScores());
    }
    @Test public void SurroundingWhitespaceInputTestDigits() { //Tests a string with whitespace, some more Integers
        String stuff = " 14 92 12312 2123 12999 322311 ";
        Scores scores = new Scores(stuff);
        assertEquals(6, scores.getNumScores());
    }
    @Test public void NewLineInputTest() { //Tests a string with whitespace, some Integers, and a new lines
        String stuff = "14 92 12312 212 12999 322311 \n32 \n32321 1";
        Scores scores = new Scores(stuff);
        assertEquals(9, scores.getNumScores());
    }
    @Test public void HeadingNewLineInputTest() { //Tests a string with only whitespace and an integer
        String stuff = "\n1";
        Scores scores = new Scores(stuff);
        assertEquals(1, scores.getNumScores());
    }
    @Test public void TrailingNewLineInputTest() { //Tests a string with only an integer followed by whitespace
        String stuff = "1\n";
        Scores scores = new Scores(stuff);
        assertEquals(1, scores.getNumScores());
    }
    @Test public void SurroundingNewLineInputTest() { //Tests a string with only an integer followed by whitespace
        String stuff = "\n1\n";
        Scores scores = new Scores(stuff);
        assertEquals(1, scores.getNumScores());
    }

    @Test public void LongWhitespaceInputTest() { //Tests a string with whitespace, some Integers, and a new lines
        String stuff = "   14   92        12312   212    12999     322311     \n 32           \n 32321 1";
        Scores scores = new Scores(stuff);
        assertEquals(9, scores.getNumScores());
    }
    @Test public void LongNewLineInputTest() { //Tests a string with whitespace, some Integers, and a new lines
        String stuff = "   14   92        12312   212    12999     322311   \n  \n 32           \n 32321 1";
        Scores scores = new Scores(stuff);
        assertEquals(9, scores.getNumScores());
    }

    @Test public void IllegalCharactersTest() { //Tests a string with Integers and doubles(periods between Integers)
        String weirdNumbers = "//2.0p2+3.6 []992-21"; //Should throw illegal argument because characters are not whitespace or integers
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

    @Test public void EnsureOrderTest() { //Tests a string with whitespace, some Integers
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

    @Test public void EmptyStringTest() { //Tests an empty string
        String whitespace = "";
        Scores scores = new Scores(whitespace);
        assertEquals(0, scores.getNumScores());
    }

    @Test public void OnlyWhitespaceTest() { //Tests a string with only whitespace
        String whitespace = "     ";
        Scores scores = new Scores(whitespace);
        assertEquals(0, scores.getNumScores());
    }
    @Test public void OnlyNewLineTest() { //Tests a string with only whitespace
        String whitespace = "\n";
        Scores scores = new Scores(whitespace);
        assertEquals(0, scores.getNumScores());
    }

    @Test public void NumWhiteNewLineOrderTest() { //Tests a string with whitespace, some Integers, and a new line
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

    @Test public void PosMaxTest() { //Tests a string with positive numbers
        String biggest = "27 29 31 32";
        Scores scores = new Scores(biggest);
        assertEquals(32, scores.getMax());
    }

    @Test public void MixedMaxTest() { //Tests a string with positive and negative numbers
        String biggest = "27 -29 31 -32";
        Scores scores = new Scores(biggest);
        assertEquals(31, scores.getMax());
    }

    @Test public void NegMaxTest() { //Tests a string with all negative numbers
        String biggest = "-2 -29 -31 -32";
        Scores scores = new Scores(biggest);
        assertEquals(-2, scores.getMax());
    }
    @Test public void ZeroMaxTest() { //Tests a string with max being zero
        String biggest = "-29 -31 0 -32";
        Scores scores = new Scores(biggest);
        assertEquals(0, scores.getMax());
    }
}
