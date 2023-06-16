package archGrafos;

public class islaArmeria extends constIsla{
    
    public int cordX;
    public int cordY;
    public int orient;

    islaArmeria(int tempX,int tempY){
        this.cordX = tempX;
        this.cordY = tempY;
        this.contTiempo = 0;
        this.tipo = "armeria";
    }
}
