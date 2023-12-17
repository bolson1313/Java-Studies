package Part2_structures_sort.ObjArrayDyn;

import java.util.Arrays;

public class DynArray {
    private Integer [] mainArray; //referencja :)
    private int nElem; //aktualna liczba elementow

    //konstruktor tablicy
    public DynArray(int maxSize) {
        mainArray = new Integer[maxSize]; //tworzenie tablicy
        nElem = 0; // 0 bo nie mamy poki co elementow w tablicy
    }

    //metoda do wstawiania elementow do tablicy
    public void add(Integer value){
        //sprawdznie czy element moze zmiescic sie w tablicy
        if(nElem >= mainArray.length) {
            Integer[] localArray = new Integer[mainArray.length + 2];
            //kopiowanie tablicy za pomoca system.arraycopy
            System.arraycopy(mainArray, 0, localArray, 0, mainArray.length);
        }

        mainArray[nElem] = value;
        nElem++;
    }

    //metoda do pozyskania danego elementu tablicy
    public Integer get(int index) {
        return mainArray[index];
    }

    //metoda do pozyskania rozmiaru tablicy
    public int size(){
        return nElem;
    }

    //metoda do usuwania elementu o danym indeksie
    public boolean remove(int index){
        //sprawdzenie czy mozna usunac dany element
        if(nElem == 0 || index >= nElem || index < 0){
            return false;
        }
        //petla do przesuniecia elementow tablicy w lewo
        for(int j = index; j < nElem - 1; j++) {
            mainArray[j] = mainArray[j + 1];
        }
        //zmiejszamy licznik ilosci elementow
        nElem--;
        return true;
    }

    //metoda do szukania danego elementu
    public int find(Integer searchElement) {
        for(int j = 0; j < nElem; j++){
            //petla przechodzi przez wszystkie elementy tablicy i szuka indeksu o danej wartosci
            if(mainArray[j].intValue() == searchElement.intValue()){
                //indeks szukanego elementu
                return j;
            }
        }
        return -1; //nie znaleziono elementu w tablicy
    }

    //metoda do wypisywania elementow calej tablicy za pomoca petli
    public void print(){
        for (int i = 0; i < nElem; i++){
            System.out.print(get(i).toString()+"  ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        DynArray array = new DynArray(5);

        array.add(3);
        array.add(6);
        array.add(1);
        System.out.println(array.get(1));
        array.remove(1);
        System.out.println(array.get(1));
        array.add(8);
        array.add(9);
        array.add(11);
        array.print();
        System.out.println(array.find(9));
        array.remove(3);
        array.print();
        System.out.println(array.size());
    }
}