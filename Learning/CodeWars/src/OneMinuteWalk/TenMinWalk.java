package OneMinuteWalk;

public class TenMinWalk {
    public static boolean isValid(char[] walk) {
        if(walk.length==10){
            int x=0, y=0;
            int i;
            for(i = 0;i < walk.length; i++){
                if(walk[i]=='n'){
                    y++;
                } else if(walk[i]=='s'){
                    y--;
                } else if(walk[i]=='w'){
                    x++;
                } else if(walk[i]=='e'){
                    x--;
                }
            }
            if(x==0 && y==0){
                return true;
            } else {
                return false;
            }
        }else {
            return false;
        }
    }
}