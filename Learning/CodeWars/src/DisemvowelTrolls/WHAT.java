package DisemvowelTrolls;



public class WHAT {
    public static String disemvowel2(String Z) {
        return Z.replaceAll("(?i)[aeiou]", "");
    }
}