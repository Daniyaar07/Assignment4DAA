import java.util.ArrayList;

public class RabinKarp {
    public static ArrayList<Integer> search(String text , String pattern ){
        ArrayList<Integer> result = new ArrayList<>();

        int n = text.length();
        int m = pattern.length();

        if(m == 0){
            for(int i = 0; i<=n; i++){
                result.add(i);
            }
            return result;
        }
        if(m > n){
            return result;
        }
        int base = 256;
        int mod = 101;
        int patternHash = 0;
        int textHash = 0;
        int h = 1;

        for(int i = 0; i< m - 1; i++){
            h = (h * base) % mod;
        }
        for(int i = 0; i <m; i++){
            patternHash = (base * patternHash + pattern.charAt(i)) % mod;
            textHash = (base * textHash + text.charAt(i)) % mod;
        }
        for(int i =0; i <= n - m; i++){
            if(patternHash == textHash){
                int j = 0;
                while(j < m && text.charAt(i + j) == pattern.charAt(j)){
                    j++;
                }
                if(j == m){
                    result.add(i);
                }
            }
            if(i < n - m){
                textHash = (base * (textHash - text.charAt(i) * h) + text.charAt(i + m)) % mod;

                if(textHash < 0){
                    textHash += mod;
                }
            }
        }
        return result;
    }
}
