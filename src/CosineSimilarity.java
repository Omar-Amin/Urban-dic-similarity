import java.util.Arrays;

public class CosineSimilarity {

    CosineSimilarity() {
    }

    float findSimilarity(String s1, String s2){
        calculateVector(s1,s2);
        return 0;
    }

    /**
     * Calculates vectors in order to find similarity between them. 
     * */
    private VectorPair calculateVector(String s1, String s2) {
        // each word should be equal
        // a uppercase letter tend to have smaller ASCII value
        s1 = s1.toLowerCase();
        s2 = s2.toLowerCase();
        // split on everything that is not a character
        String[] s1Split = s1.split("[^a-zA-Z]+");
        String[] s2Split = s2.split("[^a-zA-Z]+");

        int[] aVector = new int[s1Split.length];
        int[] bVector = new int[s2Split.length];

        Thread t1 = new Thread(() -> fillVectors(s1Split, aVector));
        Thread t2 = new Thread(() -> fillVectors(s2Split, bVector));
        try {
            t1.start();
            t2.start();
            t1.join();
            t2.join();
        } catch (InterruptedException ignored) {}

        return new VectorPair(aVector, bVector);
    }

    /**
     * Fills vectors with values based on the splitted words.
     * */
    private void fillVectors(String[] split, int[] vec) {
        int counter = 0;
        for (String s : split) {
            int sum = 0;
            for (int i = 0; i < s.length(); i++) {
                sum += s.charAt(i);
            }
            vec[counter] = sum;
        }

    }


}
