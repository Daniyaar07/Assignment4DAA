import java.util.Arrays;
public class Main {
    public static void main(String[] args){
        System.out.println("LCS:");
        System.out.println(LCS.lcs("ABC" , "ABC"));
        System.out.println(LCS.lcs("ABC" , "XYZ"));
        System.out.println(LCS.lcs("ABC" , ""));

        System.out.println("Edit Distance:");
        System.out.println(EditDistance.editDistance("cat" , "cat"));
        System.out.println(EditDistance.editDistance("cat" , ""));
        System.out.println(EditDistance.editDistance("cat" , "cut"));
        System.out.println(EditDistance.editDistance("cat" , "cats"));
        System.out.println(EditDistance.editDistance("cats" , "cat"));

        String text = "ABABABA";
        String pattern = "ABA";

        System.out.println("Naive: " + NaiveSearch.search(text , pattern));
        System.out.println("KMP: " + KMP.search(text , pattern));
        System.out.println("Rabin-Karp: " + RabinKarp.search(text , pattern));

        int[] sa = {5 , 3  , 1 ,0 , 4 , 2};
        System.out.println("Kasai: " + Arrays.toString(Kasai.lcp("banana" , sa)));
    }
}
