public class SimilarityChecker {
    public double calculateLengthScore(String alphabetsA, String alphabetsB) {
        assertIllegalArgument(alphabetsA, alphabetsB);

        if(isLengthDiffTwiceOrMore(alphabetsA, alphabetsB)) {
            return 0;
        }

        int lengthDiff = calculateLengthDiff(alphabetsA, alphabetsB);

        return calculatePartialScore(alphabetsA, alphabetsB, lengthDiff);
    }

    private int calculatePartialScore(String alphabetsA, String alphabetsB, int lengthDiff) {
        return 60 - lengthDiff * 60 / Math.min(alphabetsA.length(), alphabetsB.length());
    }

    private static int calculateLengthDiff(String alphabetsA, String alphabetsB) {
        return Math.abs(alphabetsA.length() - alphabetsB.length());
    }

    private boolean isLengthDiffTwiceOrMore(String alphabetsA, String alphabetsB) {
        return alphabetsA.length() * 2 <= alphabetsB.length()
                || alphabetsB.length() * 2 <= alphabetsA.length();
    }

    private void assertIllegalArgument(String alphabetsA, String alphabetsB) {
        for (char alphabet : alphabetsA.toCharArray()) {
            if(alphabet < 'A' || alphabet > 'Z') {
                throw new IllegalArgumentException();
            }
        }
        for (char alphabet : alphabetsB.toCharArray()) {
            if(alphabet < 'A' || alphabet > 'Z') {
                throw new IllegalArgumentException();
            }
        }
    }
}
