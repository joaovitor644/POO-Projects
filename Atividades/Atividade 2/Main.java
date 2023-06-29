import java.util.Scanner;

public class Main {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Bem-vindo ao Jogo da Velha!");

        System.out.println("Esses são os possíveis valores referentes as posições do tabuleiro:") ;
        System.out.println("");
        System.out.printf(" [1] | [2] | [3] \n");
        System.out.println("----------------");
        System.out.printf(" [4] | [5] | [6]  \n");
        System.out.println("----------------");
        System.out.printf(" [7] | [8] | [9]  \n");
        System.out.println("");
        System.out.print("Escolha 'X' ou 'O': ");
        char playerSymbol = getPlayerSymbol(scanner);
        char cpuSymbol = (playerSymbol == 'X') ? 'O' : 'X';

        Table table = new Table();
        TicTacToe ticTacToe = new TicTacToe(table);
        ticTacToe.setSymbols(playerSymbol, cpuSymbol);

        int gameStatus = -1;
        int chosenPosition;

        while (true) {
            clearConsole();
            
            System.out.println("Placar:");
            System.out.println("Jogador: " + ticTacToe.getWinsPlayer());
            System.out.println("CPU: " + ticTacToe.getWinsCPU());
            System.out.println("Empates: " + ticTacToe.getDraw());
            System.out.println();
            table.showTable();

            System.out.print("Escolha uma posição para jogar (1-9) ou -1 para sair: ");
            chosenPosition = scanner.nextInt();

            if (chosenPosition == -1) {
                break;
            }

            if (chosenPosition < 1 || chosenPosition > 9) {
                System.out.println("Posição inválida!");
                continue;
            }

            int status_cpu_play = table.play(chosenPosition, playerSymbol);
            gameStatus = ticTacToe.statusGame();

            if (gameStatus == -1 && status_cpu_play != -1) {
                ticTacToe.cpuPlay();
                gameStatus = ticTacToe.statusGame();
            }
            clearConsole();

        }

        


        scanner.close();
    }
    private static void clearConsole() {
        try {
            String operatingSystem = System.getProperty("os.name");

            if (operatingSystem.contains("Windows")) {
                ProcessBuilder processBuilder = new ProcessBuilder("cmd", "/c", "cls");
                processBuilder.inheritIO().start().waitFor();
            } else {
                new ProcessBuilder("clear").inheritIO().start().waitFor();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    private static char getPlayerSymbol(Scanner scanner) {
        while (true) {
            String input = scanner.next().toUpperCase();
            if (input.equals("X") || input.equals("O")) {
                return input.charAt(0);
            }
            System.out.print("Escolha inválida. Digite 'X' ou 'O': ");
        }
    }
}


class Table {
    private char[][] tableGame;
    private int[] playsLeft;

    public boolean isFull(){
        for (int i = 0; i < 9; i++) {
            if (this.playsLeft[i] != 0) {
                return false;
            }
        }
        return true;
    }
    public Table() {
        this.tableGame = new char[][] {
            {' ', ' ', ' '},
            {' ', ' ', ' '},
            {' ', ' ', ' '}
        };
        this.playsLeft = new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9};
    }
    public int[] getPlaysLeft(){
        return this.playsLeft;
    }
    public char[][] getTable(){
        return this.tableGame;
    }
    public int play(int n, char sy) {
        if (isOccuped(n)) {
            System.out.printf("A posição %d já está ocupada \n", n);
            return -1;
        } else {
            switch (n) {
                case 1:
                    this.tableGame[0][0] = sy;
                    this.playsLeft[n - 1] = 0;
                    break;
                case 2:
                    this.tableGame[0][1] = sy;
                    this.playsLeft[n - 1] = 0;
                    break;
                case 3:
                    this.tableGame[0][2] = sy;
                    this.playsLeft[n - 1] = 0;
                    break;
                case 4:
                    this.tableGame[1][0] = sy;
                    this.playsLeft[n - 1] = 0;
                    break;
                case 5:
                    this.tableGame[1][1] = sy;
                    this.playsLeft[n - 1] = 0;
                    break;
                case 6:
                    this.tableGame[1][2] = sy;
                    this.playsLeft[n - 1] = 0;
                    break;
                case 7:
                    this.tableGame[2][0] = sy;
                    this.playsLeft[n - 1] = 0;
                    break;
                case 8:
                    this.tableGame[2][1] = sy;
                    this.playsLeft[n - 1] = 0;
                    break;
                case 9:
                    this.tableGame[2][2] = sy;
                    this.playsLeft[n - 1] = 0;
                    break;
            }
        }
        return 1;
    }

    public void reset() {
        this.tableGame = new char[][] {
            {' ', ' ', ' '},
            {' ', ' ', ' '},
            {' ', ' ', ' '}
        };
        this.playsLeft = new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9};
    }

    public void showTable() {
        System.out.println("");
        System.out.printf(" %c | %c | %c \n", this.tableGame[0][0], this.tableGame[0][1], this.tableGame[0][2]);
        System.out.println("------------");
        System.out.printf(" %c | %c | %c  \n", this.tableGame[1][0], this.tableGame[1][1], this.tableGame[1][2]);
        System.out.println("----------");
        System.out.printf(" %c | %c | %c  \n", this.tableGame[2][0], this.tableGame[2][1], this.tableGame[2][2]);
        System.out.println("");
    }

    public boolean isOccuped(int n) {
        return this.playsLeft[n - 1] == 0;
    }
}

class TicTacToe {
    private Table table;
    private int winsPlayer;
    private int winsCPU;
    private int countDraw;
    private char symbolPlayChoice;
    private char symbolCPUChoice;
    
    public int getDraw(){
        return this.countDraw;
    }
    public int getWinsPlayer(){
        return this.winsPlayer;
    }
    public int getWinsCPU(){
        return this.winsCPU;
    }
    public void setSymbols(char play,char CPU){
        this.symbolPlayChoice = play;
        this.symbolCPUChoice = CPU;
    }
    public TicTacToe(Table table) {
        this.table = table;
    }
    private int auxStatus(char sy){
        char table[][] = this.table.getTable();
        //Linhas
        if(table[0][0] == sy && table[0][1] == sy && table[0][2] == sy){
            return 1;
        }
        if(table[1][0] == sy && table[1][1] == sy && table[1][2] == sy){
            return 1;
        }
        if(table[2][0] == sy && table[2][1] == sy && table[2][2] == sy){
            return 1;
        }
        // Colunas
         if(table[1][0] == sy && table[2][0] == sy && table[0][0] == sy){
            return 1;
        }
        if(table[1][1] == sy && table[2][1] == sy && table[0][1] == sy){
            return 1;
        }
        if(table[1][2] == sy && table[2][2] == sy && table[0][2] == sy){
            return 1;
        }
        // Diagonais
        if(table[2][2] == sy && table[1][1] == sy && table[0][0] == sy){
            return 1;
        }
        if(table[1][2] == sy && table[1][1] == sy && table[0][2] == sy){
            return 1;
        }
        return 0;
        
    } 
    public int statusGame(){
        // status 1 -> Player Ganhou
        // status 2 -> CPU Ganhou
        // status 0 -> Empate
        // status -1 -> nenhum dos casos aconteceu
        
        if(this.auxStatus(this.symbolPlayChoice) == 1){
            this.table.reset();
            this.winsPlayer += 1;
            return 1;
        }
        if(this.auxStatus(this.symbolCPUChoice) == 1){
            this.table.reset();
            this.winsCPU += 1;
            return 2;
        }
        if(this.table.isFull()){
            this.table.reset();
            this.countDraw += 1;
            return 0;
        }

        return -1;
    }
    public void cpuPlay() {
        int[] plays = this.table.getPlaysLeft();
        for (int i = 0; i < 9; i++) {
            if (plays[i] != 0) {
                this.table.play(i + 1, this.symbolCPUChoice);
                break;
            }
        }
    } }

