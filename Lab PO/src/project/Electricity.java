package project;

public class Electricity extends Utility{
        boolean isCutOff, lights;

        public Electricity() {
                this.isCutOff = false;
                this.lights = true;
        }

        private void setCutOff(boolean cutOff) {
                isCutOff = cutOff;
        }

        private void setLights(boolean lights) {
                this.lights = lights;
        }

        public void CutOff(){
                if(isCutOff){
                        System.out.println("Wyłączyłeś prąd w budynku!\n");
                        setCutOff(false);
                        setLights(false);
                }else {
                        System.out.println("Włączyłeś prąd w budynku!\n");
                        setCutOff(true);
                }
        }
        public void Turn(){
                if(isCutOff){
                        System.out.println("Nie możesz włączyć światła, sieć jest wyłączona!");
                } else if (lights) {
                        System.out.println("Wyłączyeś światło!");
                        setLights(false);
                }else {
                        System.out.println("Włączyłeś światło!");
                        setLights(true);
                }
        }
}
