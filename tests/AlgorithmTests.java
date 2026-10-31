import java.sql.SQLOutput;
import java.util.Arrays;

public class AlgorithmTests {
    public static void main(String[] args){
        if(LCS.lcs("ABC" ,"ABC") == 3 && LCS.lcs("ABC" , "XYZ") == 0 && LCS.lcs("ABC" , "") == 0){
            System.out.println("LCS: PASS");
        }
        else{
            System.out.println("LCS: FAIL");
        }
        if(EditDistance.editDistance("cat" , "cat")== 0 && EditDistance.editDistance("cat" , "cut") == 1 && EditDistance.editDistance("cat" , "") == 3 && EditDistance.editDistance("cat" , "cats") == 1 && EditDistance.editDistance("cats" , "cat") == 1){
            System.out.println("Edit Distance: PASS");
        }
        else{
            System.out.println("Edit Distance: FAIL");
        }
        String[][] tests = {
            {"ABCABC" , "ABC"},
            {"ABCD" , "BC"},
            {"ABCDE" , "DE"},
            {"AAAA" , "AA"},
            {"ABCDE" , "XYZ"},
            {"ABC" , "ABCDE"},
            {"ABC" , ""}
        };
        for(int i = 0; i < tests.length; i++){
            String text = tests[i][0];
            String pattern = tests[i][1];

            if(NaiveSearch.search(text , pattern).equals(KMP.search(text , pattern)) && KMP.search(text , pattern).equals(RabinKarp.search(text , pattern))){
                System.out.println("String Matching " + (i + 1) + ": PASS");
            }
            else{
                System.out.println("String Matching " + (i + 1) + ": FAIL");
            }
        }
        int[] sa = {5 , 3, 1 , 0 , 4 ,2};
        int[] expected = {0 , 1 , 3, 0 , 0 ,2};

        if(Arrays.equals(Kasai.lcp("banana" , sa) , expected)){
            System.out.println("Kasai: PASS");
        }
        else{
            System.out.println("Kasai: FAIL");
        }
    }
}
