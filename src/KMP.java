import java.util.ArrayList;

public class KMP {
    public static ArrayList<Integer> search(String text , String pattern){
        ArrayList<Integer> result = new ArrayList<>();

        int n = text.length();
        int m = pattern.length();

        if(m == 0){
            for(int k = 0; k <=n; k++){
                result.add(k);
            }
            return result;
        }
        int[] lps = new int[m];
        int len = 0;
        int i = 1;

        while(i < m){
            if(pattern.charAt(i) == pattern.charAt(len)){
                len++;
                lps[i] = len;
                i++;
            }
            else{
                if(len!=0){
                    len = lps[len - 1];
                }
                else{
                    lps[i] = 0;
                    i++;
                }
            }
        }
        i = 0;
        int j =0;
        while(i < n){
            if(text.charAt(i) == pattern.charAt(j)){
                i++;
                j++;
            }
            if(j == m){
                result.add(i - j);
                j = lps[j - 1];
            }
            else if(i < n && text.charAt(i) != pattern.charAt(j)){
                if(j!= 0){
                    j = lps[j - 1];
                }
                else{
                    i++;
                }
            }
        }
        return result;
    }
}
