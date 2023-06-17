/*
    Autor: João Vitor Santos 
*/



import java.util.Scanner;

public class Main {
    /*

    //Essa Função Serve apenas para testar os casos bases na função principal. Ignore

    public static void Testes(String mensagem,int valorEsp,int valorCalc){
        if(valorCalc == valorEsp){
            System.out.printf("%s: OK\n",mensagem );
        } else {
            System.out.printf("%s: ERRO - Valor Esperado: %d , Valor Recebido: %d\n",mensagem,valorEsp,valorCalc);
        }   
    }

    */
    public static int ProcessarCiclos(String rastro, int processos) {
        int sizeRastro = rastro.length();
        int tempProce = processos;
        int quantR = 0;
        int ciclos = 0;

        for (int i = 0; i < sizeRastro; i++) {
            if (rastro.charAt(i) == 'W') {
                if (tempProce != 0) {
                    ciclos++;
                    tempProce--;
                    quantR = 0;
                } else {
                    tempProce = processos - 1;
                    quantR = 0;
                }
            } else {
                if (tempProce > 0) {
                    if (quantR > 0 && quantR < tempProce || (quantR == tempProce && quantR != processos )) {
                        quantR++;
                        continue;
                    }
                    if(quantR == processos){
                        quantR = 0;
                        if(tempProce == processos){
                            ciclos++;
                        }
                        continue;
                    }
                        quantR++;
                        ciclos++;
                        tempProce--;

                } else {
                    quantR = 1;
                    ciclos++;
                    tempProce = processos;
                    continue;
                }
            }
        }

        return ciclos;
    }

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        String rastro = input.nextLine();
        int processos = input.nextInt();
        System.out.println(ProcessarCiclos(rastro, processos));

        /*Testes("Teste 1",30,ProcessarCiclos("RWRRWWRWRWRRRWWRRRRWRRWRRWRRRRRRRRRWRWRWRRRRWRRRRR",4));
        Testes("Teste 2",4,ProcessarCiclos("RWWRRR",3));
        Testes("Teste 3",5,ProcessarCiclos("RWWRRRR",3));
        Testes("Teste 4",3,ProcessarCiclos("RRRRRRRRRR",4));
        Testes("Teste 5",5,ProcessarCiclos("WWWWW",5));*/

    }
}
