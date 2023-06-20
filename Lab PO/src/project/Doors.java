package project;

public class Doors implements StatusEntrances{
    boolean locked, closed;

    public Doors() {
        this.locked = false;
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
            System.out.println("Odblokowałeś drzwi w bydnku!");
            setLocked(false);
        }else {
            System.out.println("Zablokowałes drzwi w bydnku!");
            setLocked(true);
        }
    }
    public void Open(){
        if(locked){
            System.out.println("Nie możesz otworzyć drzwi!");
        } else if (isOpen()) {
            System.out.println("Otworzyłeś drzwi w budynku!");
            setClosed(false);
        } else {
            System.out.println("Zamknąłeś drzwi w budynku!");
            setClosed(true);
        }
    }
}
