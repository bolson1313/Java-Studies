package DisemvowelTrolls;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Troll {
    public static String disemvowel(String str) {
        String[] strSplit = str.split("");
        ArrayList<String> StrArray = new ArrayList<>(Arrays.asList(strSplit));
        ArrayList<String> VomelsArray = new ArrayList<>(List.of("a","e","i","o","u","A","E","I","O","U"));
        StrArray.removeAll(VomelsArray);
        String Result = "";
        for (String element : StrArray){
            Result += element;
        }
        System.out.println(Result);
        return Result;
    }
}