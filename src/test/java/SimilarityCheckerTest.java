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
        assertIllegalArgument("123", "AAB");
        assertIllegalArgument("aAB", "AAA");
    }

    private void assertIllegalArgument(String alphabetsA, String alphabetsB) {
        assertThrows(
                IllegalArgumentException.class,
                () -> similarityChecker.calculateLengthScore(alphabetsA, alphabetsB)
        );
    }


    @Test
    void calculateLengthScoreTest_ASD_DSA() {
        double lengthScore = similarityChecker.calculateLengthScore("ASD", "DSA");

        assertThat(lengthScore).isEqualTo(60);
    }

    @Test
    void calculateLengthScoreTest_A_BB() {
        double lengthScore = similarityChecker.calculateLengthScore("A", "BB");

        assertThat(lengthScore).isEqualTo(0);
    }

    @Test
    void calculateLengthScoreTest_AAABB_BAA() {
        double lengthScore = similarityChecker.calculateLengthScore("AAABB", "BAA");

        assertThat(lengthScore).isEqualTo(20);
    }

    @Test
    void calculateLengthScoreTest_AA_AAE() {
        double lengthScore = similarityChecker.calculateLengthScore("AA", "AAE");

        assertThat(lengthScore).isEqualTo(30);
    }
}