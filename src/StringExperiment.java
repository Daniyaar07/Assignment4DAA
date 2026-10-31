import java.util.Random;

public class StringExperiment {
    public static void main(String[] args) {
        int[] sizes = {10000, 50000, 100000};
        Random random = new Random(42);
        for (int k = 0; k < sizes.length; k++) {
            int n = sizes[k];

            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < n; i++) {
                sb.append((char) ('A' + random.nextInt(26)));
            }
            String text = sb.toString();
            String[] patterns = {text.substring(100, 105), "12345"};

            for (int p = 0; p < patterns.length; p++) {
                String pattern = patterns[p];

                long naiveTime = 0;
                long kmpTime = 0;
                long rabinTime = 0;

                for (int i = 0; i < 5; i++) {
                    long start = System.nanoTime();
                    NaiveSearch.search(text, pattern);
                    naiveTime += System.nanoTime() - start;

                    start = System.nanoTime();
                    KMP.search(text, pattern);
                    kmpTime += System.nanoTime() - start;

                    start = System.nanoTime();
                    RabinKarp.search(text, pattern);
                    rabinTime += System.nanoTime() - start;
                }

                if(p == 0){
                    System.out.println("Present Pattern");
                }
                else{
                    System.out.println("Absent Pattern");
                }
                System.out.println("Size: " + n);
                System.out.println("Naive: " + naiveTime / 5.0 / 1000000);
                System.out.println("KMP: " + kmpTime / 5.0 / 1000000);
                System.out.println("Rabin-Karp: " + rabinTime / 5.0 / 1000000);
                System.out.println();
            }
        }
    }
}
