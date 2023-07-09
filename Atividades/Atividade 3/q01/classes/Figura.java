
package classes;

public class Figura{
  private float cx;
  private float cy;
  public Figura(double cx , double cy){
      this.cx = (float) cx;
      this.cy = (float) cy;
  }
  public float distancia(Figura f){
      return (float) Math.sqrt((this.cx - f.cx)*(this.cx - f.cx) + (this.cy - f.cy)*(this.cy - f.cy));
  }
}
