package EnumDemo;

public enum lightcolour {
    red, //0
    yellow, //1
    green; //2

    public lightcolour changecolor(){
        if(this == red){
            return yellow;
        }
        if(this == yellow){
            return green;
        }
        else
            return red;
    }
}


