import java.util.HashSet;
import java.util.Set;

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
        checkInputValid(alphabetsA);
        checkInputValid(alphabetsB);
    }

    private static void checkInputValid(String alphabetsA) {
        for (char alphabet : alphabetsA.toCharArray()) {
            if(alphabet < 'A' || alphabet > 'Z') {
                throw new IllegalArgumentException();
            }
        }
    }

    public double calculateAlphabetScore(String alphabetsA, String alphabetsB) {
        assertIllegalArgument(alphabetsA, alphabetsB);

        Set<Character> usedAlphabetsASet = getUsedAlphabetsASet(alphabetsA);
        Set<Character> usedAlphabetsBSet = getUsedAlphabetsASet(alphabetsB);

        int sameCnt = calculateSameCnt(usedAlphabetsASet, usedAlphabetsBSet);
        int totalCnt = calculateTotalCnt(usedAlphabetsASet, usedAlphabetsBSet);

        return calculateAlphabetPartialScore(sameCnt, totalCnt);

    }

    private double calculateAlphabetPartialScore(int sameCnt, int totalCnt) {
        return (double) sameCnt / totalCnt * 40.0;
    }

    private int calculateTotalCnt(Set<Character> usedAlphabetsASet, Set<Character> usedAlphabetsBSet) {
        Set<Character> union = new HashSet<>(usedAlphabetsASet);
        union.addAll(usedAlphabetsBSet);
        return union.size();
    }

    private int calculateSameCnt(Set<Character> usedAlphabetsASet, Set<Character> usedAlphabetsBSet) {
        Set<Character> intersection = new HashSet<>(usedAlphabetsASet);
        intersection.retainAll(usedAlphabetsBSet);
        return intersection.size();
    }

    private Set<Character> getUsedAlphabetsASet(String alphabetsA) {
        Set<Character> usedAlphabetsASet = new HashSet<>();

        for (char c : alphabetsA.toCharArray()) usedAlphabetsASet.add(c);
        return usedAlphabetsASet;
    }
}
