package project;

public class Windows implements StatusEntrances{
    boolean locked=false, closed;
    public Windows() {
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
            System.out.println("Odblokowałeś okna w bydnku!\n");
            setLocked(false);
        }else {
            System.out.println("Zablokowałes okna w bydnku!\n");
            setLocked(true);
            setClosed(true);
        }
    }
    public void Open(){
        if(locked){
            System.out.println("Nie możesz otworzyć okien!\n");
        } else if (isOpen()) {
            System.out.println("Otworzyłeś okna w budynku!\n");
            setClosed(false);
        } else {
            System.out.println("Zamknąłeś okna w budynku!\n");
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
        return "Okna są "+message();
    }
}
