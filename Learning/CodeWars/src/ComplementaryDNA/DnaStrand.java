package ComplementaryDNA;
public class DnaStrand {
    public static String makeComplement(String dna) {
        String Result = "";
        for(int i = 0; dna.length() > i; i++){
            switch (dna.charAt(i)) {
                case 'A' -> Result = Result.concat("T");
                case 'T' -> Result = Result.concat("A");
                case 'G' -> Result = Result.concat("C");
                case 'C' -> Result = Result.concat("G");
            }
        }
        return Result;
    }
}