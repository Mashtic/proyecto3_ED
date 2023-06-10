public class islaTemploBruja extends constIsla{
    
    public int cordX;
    public int cordY;
    public int orient;

    islaTemploBruja(int tempX,int tempY,int tempOrient){
        this.cordX = tempX;
        this.cordY = tempY;
        this.contTiempo = 0;
        this.orient = tempOrient;
        this.tipo = "templo de bruja";
    }
}
