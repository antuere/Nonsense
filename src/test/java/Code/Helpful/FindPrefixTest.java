package Code.Helpful;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FindPrefixTest {

    @Test
    void main() {
    }

    @Test
    void findPrefix() {
        String[] words = {"Antonsad", "Antona", "Antos", "Antrn"};


        String result = FindPrefix.findPrefix(words);

        String expected = "Ant";


        assertEquals(result, expected);
    }

    @Test
    void findPrefixNew() {
    }
}