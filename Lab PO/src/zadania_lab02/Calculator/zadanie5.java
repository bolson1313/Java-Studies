package zadania_lab02.Calculator;

public class zadanie5 {
    public static void main(String[] args) {
        count();
    }

    public static void count() {
        int i;
        for(i=0 ; i<=20 ; i++){
            if(i==2 || i==6 || i==9 || i==15 || i==19 ){
                continue;
            }
            System.out.println(i);
        }
    }
}
