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
            System.out.println("Odblokowałeś okna w bydnku!\n\n");
            setLocked(false);
        }else {
            System.out.println("Zablokowałes okna w bydnku!\n\n");
            setLocked(true);
            setClosed(true);
        }
    }

    public void Open(){
        if(locked){
            System.out.println("Nie możesz otworzyć okien!\n\n");
        } else if (isOpen()) {
            System.out.println("Otworzyłeś okna w budynku!\n\n");
            setClosed(false);
        } else {
            System.out.println("Zamknąłeś okna w budynku!\n\n");
            setClosed(true);
        }
    }
}
