package Part1_algorithms.ShortestWayProblem;

public class ShortestWayGA {
    static int[][] ways = {
            {0  ,300,402,356,  0,  0,  0,  0,  0},
            {300,  0,  0,  0,440,474,  0,  0,  0},
            {402,  0,  0,  0,  0,330,  0,  0,  0},
            {356,  0,  0,  0,  0,  0,823,  0,  0},
            {  0,440,  0,  0,  0,  0,  0,430,  0},
            {  0,474,330,  0,  0,  0,813,365,774},
            {  0,  0,  0,823,  0,813,  0,  0,403},
            {  0,  0,  0,  0,430,365,  0,  0,768},
            {  0,  0,  0,  0,  0,774,403,768,  0}
    };

    static String[] cities = {"Warszawa", "Katowice", "Zakopane", "Lwów", "Wiedeń", "Budapeszt", "Bukareszt", "Zagrzeb"};

    //Waw - Kat 300
    //Kat - Wied 440
    //Wied - Zag 430
    //Zag - Sof 768
    //1938 km

    public static void shortest_way(int start, int destination){
        String city_order = "";
        int distance = 0;
        int index = 0;
        int current = start;
        int min = Integer.MAX_VALUE;
        while(current != destination) {
            city_order += cities[current] + ", ";
            if(ways[current][destination] != 0) {
                distance += ways[current][destination];
                System.out.println("KONIEC TRASA = "+distance+ "\nPrzystanki: "+city_order);
                break;
            } else {
                for (int i = 0; i < ways.length; i++) {
                    if(min > ways[current][i] && ways[current][i] > 0 && i > current) {
                        min = ways[current][i];
                        index = i;
                    }
                }
                current = index;
                distance += min;
                min = Integer.MAX_VALUE;
            }
        }
    }
    public static void main(String[] args) {
        shortest_way(0, 8);
    }
}
