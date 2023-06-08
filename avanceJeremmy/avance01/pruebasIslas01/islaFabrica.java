public class islaFabrica  extends constIsla{
    
    public int cordX;
    public int cordY;

    islaFabrica(int tempX,int tempY,int tempCont){
        this.cordX = tempX;
        this.cordY = tempY;
        this.contTiempo = tempCont;
        this.tipo = "fabrica";
    }
}
