package SquareEveryDigit;
public class SquareDigit {

    public int squareDigits(int n) {
        String number = String.valueOf(n);
        int tmp;
        String StringResult = "";
        int i;
        for (i = 0; number.length() > i; i++){
            tmp = Integer.parseInt(String.valueOf(number.charAt(i)));
            StringResult = StringResult.concat(String.valueOf((int)Math.pow(tmp,2)));
        }
        int IntResult;
        IntResult = Integer.parseInt(StringResult);
        return IntResult;
    }
}