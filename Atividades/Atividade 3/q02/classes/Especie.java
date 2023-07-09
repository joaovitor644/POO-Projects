package classes;

public class Especie{
  private String propiedades;
  public Especie(String propiedades){
    this.propiedades = propiedades;
  }
  public String Comportamento(){
    return "\n";
  }
  public String toString(){
    return this.propiedades +"\n"+ this.Comportamento();

  }
}
