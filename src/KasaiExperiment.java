import java.util.Random;
import java.util.Arrays;
public class KasaiExperiment {
    public static void main(String[] args){
        int[] sizes = {1000 , 5000 , 10000};
        Random random = new Random(42);

        for(int s = 0; s < sizes.length; s++){
            int n = sizes[s];
            StringBuilder sb = new StringBuilder();

            for(int i = 0; i < n; i++){
                sb.append((char)('A' + random.nextInt(26)));
            }
            String text = sb.toString();
            Integer[] positions = new Integer[n];

            for(int i = 0; i < n; i++){
                positions[i] = i;
            }
            Arrays.sort(positions , ( a , b) -> text.substring(a).compareTo(text.substring(b)));

            int[] sa = new int[n];

            for(int i =0; i < n; i++){
                sa[i] = positions[i];
            }
            long totalTime = 0;

            for(int i =0; i < 5; i++){
                long start = System.nanoTime();
                Kasai.lcp(text , sa);
                totalTime += System.nanoTime() - start;
            }
            System.out.println("Size: " + n);
            System.out.println("Kasai: " + totalTime / 5.0 / 1000000 + " ms");
            System.out.println();
        }

    }
}
