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
                        System.out.println("Wyłączyłeś prąd w budynku!\n\n");
                        setCutOff(false);
                        setLights(false);
                }else {
                        System.out.println("Włączyłeś prąd w budynku!\n\n");
                        setCutOff(true);
                }
        }
        public void Turn(){
                if(isCutOff){
                        System.out.println("Nie możesz włączyć światła, sieć jest wyłączona!\n\n");
                } else if (lights) {
                        System.out.println("Wyłączyeś światło!\n\n");
                        setLights(false);
                }else {
                        System.out.println("Włączyłeś światło!\n\n");
                        setLights(true);
                }
        }
}
