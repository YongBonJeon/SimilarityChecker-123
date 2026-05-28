public class SimilarityChecker {
    public int calculateLengthScore(String alphabets) {

        for (char alphabet : alphabets.toCharArray()) {
            if(alphabet < 'A' || alphabet > 'Z') {
                throw new IllegalArgumentException();

            }
        }
        return 0;
    }
}
