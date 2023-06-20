package project;

public class Windows implements StatusEntrances{
    boolean locked,closed;
    public Windows() {
        this.locked = false;
    }
    public boolean isLocked(){
        return locked;
    }
    public boolean isOpen(){
        return closed;
    }

    private void setLocked(boolean locked) {
        this.locked = locked;
    }

    private void setClosed(boolean closed) {
        this.closed = closed;
    }
    public void Lock(){
        if(locked){
            System.out.println("Odblokowałeś okna w bydnku!");
            setLocked(false);
        }else {
            System.out.println("Zablokowałes okna w bydnku!");
            setLocked(true);
        }
    }

    public void Open(){
        if(locked){
            System.out.println("Nie możesz otworzyć okien!");
        } else if (isOpen()) {
            System.out.println("Otworzyłeś okna w budynku!");
            setClosed(false);
        } else {
            System.out.println("Zamknąłeś okna w budynku!");
            setClosed(true);
        }
    }
}
