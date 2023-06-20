package project;

public class Water extends Utility{
    double temperature;
    boolean isCutOff =false, running;

    public Water() {
        this.temperature = Math.random() * 10 + 20;
        this.running = false;
    }

    private void setCutOff(boolean cutOff) {
        isCutOff = cutOff;
    }

    private void setRunning(boolean running) {
        this.running = running;
    }

    public void CutOff(){
        if(isCutOff){
            System.out.println("Otworzyłeś zawory!\n");
            setCutOff(false);
            setRunning(false);
        }else {
            System.out.println("Zamknąłeś zawory!\n");
            setCutOff(true);
        }
    }
    public void RunWater(){
            if(isCutOff){
                System.out.println("Nie możesz włączyć wody, zawór jest zamknięty!\n");
            } else if (running) {
                System.out.println("Wyłączyeś wodę!\n");
                setRunning(false);
            }else {
                System.out.println("Włączyłeś wodę!\n");
                setRunning(true);
            }
    }
    private String message(){
        if(this.isCutOff){
            return "Jest odcięta\n";
        }else {
            return "Nie jest odcięta\n";
        }
    }

    @Override
    public String toString() {
        return "Temperatura wody: "+String.format("%.2f",this.temperature)+" Czy jest odcięta: "+message();
    }
}
