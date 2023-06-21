package project;

public class Doors implements StatusEntrances{
    boolean locked=false, closed;
    public Doors() {
    }
    public boolean isLocked(){
        return locked;
    }
    public boolean isOpen(){
        return closed;
    }

    private void setClosed(boolean closed) {
        this.closed = closed;
    }

    private void setLocked(boolean locked) {
        this.locked = locked;
    }
    public void Lock(){
        if(locked){
            System.out.println("Odblokowałeś drzwi w bydnku!\n");
            setLocked(false);
        }else {
            System.out.println("Zablokowałes drzwi w bydnku!\n");
            setLocked(true);
            setClosed(true);
        }
    }
    public void Open(){
        if(locked){
            System.out.println("Nie możesz otworzyć drzwi!\n");
        } else if (isOpen()) {
            System.out.println("Otworzyłeś drzwi w budynku!\n");
            setClosed(false);
        } else {
            System.out.println("Zamknąłeś drzwi w budynku!\n");
            setClosed(true);
        }
    }

    private String message(){
        if(this.isLocked()){
            return "Zablokowane";
        }else {
            return "Nie zablkowowane";
        }
    }

    @Override
    public String toString() {
        return "Drzwi są "+message();
    }
}
