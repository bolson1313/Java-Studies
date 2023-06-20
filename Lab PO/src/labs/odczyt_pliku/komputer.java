package labs.odczyt_pliku;

public class komputer {
    String type;
    int ram;
    double cpu, hdd, price;

    public komputer(String type, int ram, double cpu, double hdd, double price) {
        this.type = type;
        this.ram = ram;
        this.cpu = cpu;
        this.hdd = hdd;
        this.price = price;
    }
}
