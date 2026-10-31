import java.util.Random;

public class Experiment {
    public static void main(String[] args){
        int[] sizes = {100 , 500 , 1000};
        Random random = new Random(42);
        for(int k = 0; k < sizes.length; k++){
            int n = sizes[k];

            String a = "";
            String b = "";

            for(int i = 0; i < n; i++){
                a+= (char) ('A' + random.nextInt(26));
                b+= (char) ('A' + random.nextInt(26));
            }
            long lcsTime = 0;
            long editTime = 0;

            for(int i = 0; i < 5; i++){
                long start = System.nanoTime();
                LCS.lcs(a , b);
                lcsTime+= System.nanoTime() - start;

                start = System.nanoTime();
                EditDistance.editDistance(a , b);
                editTime+= System.nanoTime() - start;
            }
            System.out.println("Size: " + n);
            System.out.println("LCS: " + lcsTime / 5.0 / 1000000 + " ms");
            System.out.println("Edit Distance: " + editTime / 5.0 / 1000000 + " ms");
            System.out.println();
        }
    }
}
