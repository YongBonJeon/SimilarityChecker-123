public class SimilarityChecker {
    public int calculateLengthScore(String alphabets) {
        assertIllegalArgument(alphabets);

        return 0;
    }

    private static void assertIllegalArgument(String alphabets) {
        for (char alphabet : alphabets.toCharArray()) {
            if(alphabet < 'A' || alphabet > 'Z') {
                throw new IllegalArgumentException();
            }
        }
    }
}
