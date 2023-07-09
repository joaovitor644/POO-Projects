import java.util.Scanner;
import classes.*;

public class Main{
  public static void main(String args[]){
    Scanner input = new Scanner(System.in);

    System.out.printf("Forneça a inicia do tipo do animal: ");
    String res = input.next();

    switch(res.toUpperCase().charAt(0)){
      case 'S':
        Sapo s = new Sapo("Possuo corpo sem revestimento");
        System.out.println(s);
        break;
      case 'H':
        Homem h = new Homem("Possuo corpo sem revestimento");
        System.out.println(h);
        break;
      case 'L':
        Lobo l = new Lobo("Corpo revestido por pêlos");
        System.out.println(l);
        break;
      case 'C':
        Coruja c = new Coruja("Corpo revestido por penas");
        System.out.println(c);
        break;
      case 'G':
        Galo g = new Galo("Corpo revestido por penas");
        System.out.println(g);
        break;

    }
  }
}
