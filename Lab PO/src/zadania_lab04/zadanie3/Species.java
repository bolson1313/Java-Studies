package zadania_lab04.zadanie3;

public class Species implements Cloneable{
     String genusName;
     String speciesName;
     int numberOfChromosomes2n;
     int numberOfChromosomesX;

    String description;

    public Species(String genusName, String speciesName, int numberOfChromosomes2n, int numberOfChromosomesX, String description) {
        this.genusName = genusName;
        this.speciesName = speciesName;
        this.numberOfChromosomes2n = numberOfChromosomes2n;
        this.numberOfChromosomesX = numberOfChromosomesX;
        this.description = description;
    }


    public String fullName(String genusName, String speciesName){
        return genusName+ " " +speciesName;
    }

    public String haploidalChromosomes(int numberOfChromosomes2n){
        return "Chaploidalna liczba chromosomów N: "+numberOfChromosomes2n/2;
    }

    public void output(){
        System.out.println("Gatunek: "+this.genusName+ "\nRodzaj: " +this.speciesName+ "\nPełna nazwa: " +fullName(this.genusName, this.speciesName)+ "\nLiczba chromosomów 2n: "+this.numberOfChromosomes2n+
                "\nLiczba chromosomów X: " +this.numberOfChromosomesX+ "\nOpis: " +this.description+
            "\n" +haploidalChromosomes(this.numberOfChromosomes2n));
    }
    @Override
    public Object clone() throws CloneNotSupportedException{
        return super.clone();
    }
}
