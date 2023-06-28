package XO;

public class XO {
    public static boolean getXO (String str) {
        int x = 0, o = 0;
        for(int i = 0; str.length() > i; i++){
            if(str.charAt(i) == 'X' || str.charAt(i) == 'x') x++;
            else if (str.charAt(i) == 'O' || str.charAt(i) == 'o') o++;
        }
        return x == o;
    }
}