import java.util.ArrayList;

public class NaiveSearch {
    public static ArrayList<Integer> search(String text , String pattern){
        ArrayList<Integer> result = new ArrayList<>();

        int n = text.length();
        int m = pattern.length();

        for(int i = 0; i<= n -m; i++){
            int j =0;

            while(j < m && text.charAt(i + j) == pattern.charAt(j)){
                j++;
            }
            if(j == m){
                result.add(i);
            }
        }
        return result;
    }
}
