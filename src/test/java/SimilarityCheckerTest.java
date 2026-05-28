import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class SimilarityCheckerTest {

    private SimilarityChecker similarityChecker;

    @BeforeEach
    void setUp() {
        similarityChecker = new SimilarityChecker();
    }

    @Test
    void createSimilarityChecker() {

        assertThat(similarityChecker).isNotNull();
    }

    @Test
    void assertInvalidInput() {
        assertThrows(
                IllegalArgumentException.class,
                () -> similarityChecker.calculateLengthScore("123")
        );
        assertThrows(
                IllegalArgumentException.class,
                () -> similarityChecker.calculateLengthScore("aAB")
        );


    }

}