package zadania_lab09_ararys.zadanie3;

import java.util.Objects;

public class Participants {
    private static int count = 1;
    int age, ID;
    String name;

    public Participants(String name, int age) {
        this.ID = count ++;
        this.age = age;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Uczestnik "+ID+" [Imie= "+name+", Wiek= "+age+"]";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Participants that = (Participants) o;
        return age == that.age && ID == that.ID && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(age, ID, name);
    }

    public boolean ifUnderAge(){
        if(age<=18){
            return true;
        }else{
            return false;
        }
    }
}
