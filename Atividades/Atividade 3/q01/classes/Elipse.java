package classes;

public class Elipse extends Figura{
    private float r1;
    private float r2;
    public Elipse(double r1,double r2,double cx,double cy){
      super(cx,cy);
      this.r1 = (float) r1;
      this.r2 = (float) r2;
    }
    public float area(){
        return (float) (Math.PI * this.r1 * this.r2);
    }
}
