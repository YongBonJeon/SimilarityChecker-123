public class SimilarityChecker {
    public double calculateLengthScore(String alphabetsA, String alphabetsB) {
        assertIllegalArgument(alphabetsA, alphabetsB);

        if(alphabetsA.length() * 2 <= alphabetsB.length()
        || alphabetsB.length() * 2 <= alphabetsA.length()) {
            return 0;
        }
        int diffLength = Math.abs(alphabetsA.length() - alphabetsB.length());

        return 60 - diffLength * 60 / Math.min(alphabetsA.length(), alphabetsB.length());
    }

    private static void assertIllegalArgument(String alphabetsA, String alphabetsB) {
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
