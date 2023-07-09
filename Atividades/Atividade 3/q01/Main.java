import java.util.Random;
import classes.*;
public class Main {
    public static void main(String[] args) {
        Random random = new Random();
        int N = random.nextInt(9) + 2;
        // Foi Feito um array de Elipse ao invés de um array de Figuras devido
        // A um erro relacionado ao método area() não está definido na classe Figura
        Elipse[] figuras = new Elipse[N];
        double maiorDistancia = 0;
        double maiorArea = 0;

        for (int i = 0; i < N; i++) {
            int tipoFigura = random.nextInt(2);
            double cx = random.nextDouble() * 10;
            double cy = random.nextDouble() * 10;
            switch(tipoFigura){
              case 0:
                double r1 = random.nextDouble() * 10;
                double r2 = random.nextDouble() * 10;
                figuras[i] = new Elipse(r1, r2, cx, cy);
                break;
              case 1:
                double raio = random.nextDouble() * 10;
                figuras[i] = new Circulo(raio, cx, cy);
                break;
            }
            for (int j = 0; j < i; j++) {
                double distancia = figuras[i].distancia(figuras[j]);
                if (distancia > maiorDistancia) {
                    maiorDistancia = distancia;
                }
            }
            float area = figuras[i].area();
            if (area > maiorArea) {
                maiorArea = area;
            }
        }
        System.out.printf("Maior distância: %.2f\n",(float) maiorDistancia);
        System.out.printf("Maior área: %.2f \n",(float) maiorArea);
    }
}
