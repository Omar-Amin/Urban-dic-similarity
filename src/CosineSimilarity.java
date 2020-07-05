import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class CosineSimilarity {

    CosineSimilarity() {
    }

    float findSimilarity(String s1, String s2){
        Vector a,b;
        VectorPair vectors = calculateVector(s1,s2);
        a = vectors.getA();
        b = vectors.getB();
        int dot = dotProduct(a,b);
        return (float) ((float) dot/(a.getSize()*b.getSize()));
    }

    private int dotProduct(Vector a, Vector b){
        int[] a1,b1;
        a1 = a.getVector();
        b1 = b.getVector();
        // vectors can be of different size
        int size = Math.min(a.length(),b.length());
        int dot = 0;

        for (int i = 0; i < size; i++) {
            dot += a1[i]*b1[i];
        }

        return dot;
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
        Vector a = new Vector(new int[s1Split.length]);
        Vector b = new Vector(new int[s2Split.length]);

        Thread t1 = new Thread(() -> fillVectors(s1Split, a));
        Thread t2 = new Thread(() -> fillVectors(s2Split, b));
        try {
            t1.start();
            t2.start();
            t1.join();
            t2.join();
        } catch (InterruptedException ignored) {}

        return new VectorPair(a, b);
    }

    /**
     * Fills vectors with values based on the splitted words.
     * */
    private void fillVectors(String[] split, Vector v) {
        int counter = 0;
        int[] vec = v.getVector();
        double size = 0;
        for (String s : split) {
            int sum = 0;
            for (int i = 0; i < s.length(); i++) {
                sum += s.charAt(i);
            }
            vec[counter++] = sum;
            size += sum*sum;
        }
        size = Math.sqrt(size);
        v.setSize(size);
        v.setVector(vec);
    }


}
