/*
	Autor: João Vitor Santos 
*/



import java.util.Scanner;
import java.util.Arrays;

public class Main{
	//OBS:Essa função so funciona se as entradas forem APENAS STRINGS DE 2 CARACTERES
	public static void PossiblePasswds(String passwd){
		char lower[] = new char[2];
		char upper[] = new char[2];
		int numbers[] = {-1,-1};

		String passwdUpper = passwd.toUpperCase();
		String passwdLower = passwd.toLowerCase();

		for(int i = 0;i < 2;i++){
			switch(passwdUpper.charAt(i)){
				case 'A':
					upper[i] = passwdUpper.charAt(i);
					lower[i] = passwdLower.charAt(i);
					numbers[i] = 4;
					break;
				case 'E':
					upper[i] = passwdUpper.charAt(i);
					lower[i] = passwdLower.charAt(i);
					numbers[i] = 3;
					break;
				case 'I':
					upper[i] = passwdUpper.charAt(i);
					lower[i] = passwdLower.charAt(i);
					numbers[i] = 1;
					break;
				case 'O':
					upper[i] = passwdUpper.charAt(i);
					lower[i] = passwdLower.charAt(i);
					numbers[i] = 0;
					break;
				case 'S':
					upper[i] = passwdUpper.charAt(i);
					lower[i] = passwdLower.charAt(i);
					numbers[i] = 5;
					break;
				default:
					upper[i] = passwdUpper.charAt(i);
					lower[i] = passwdLower.charAt(i);
					break;
			}
		}
		
		String Results[] = new String[9];
		Results[0] = new String(lower);
		Results[1] = String.valueOf(lower[0]) + String.valueOf(upper[1]);
		Results[2] = String.valueOf(upper[0]) + String.valueOf(lower[1]);
		Results[3] = new String(upper);

		char temp[] = new char[2];
		int quantNum = 0;
		for(int i = 0; i < 2;i++){
			if(numbers[i] != -1) {
				quantNum++; 
			}
		}
		if(quantNum == 1 && numbers[0] != -1){
			Results[4] = String.valueOf(numbers[0]) + String.valueOf(lower[1]);
			Results[5] = String.valueOf(numbers[0]) + String.valueOf(upper[1]);
		}
		if(quantNum == 1 && numbers[1] != -1){
			Results[4] = String.valueOf(lower[0]) + String.valueOf(numbers[1]);
			Results[5] = String.valueOf(upper[0]) + String.valueOf(numbers[1]);
		}
		if(quantNum == 2){
			Results[4] = String.valueOf(numbers[0]) + String.valueOf(lower[1]);
			Results[5] = String.valueOf(numbers[0]) + String.valueOf(upper[1]);
			Results[6] = String.valueOf(lower[0]) + String.valueOf(numbers[1]);
			Results[7] = String.valueOf(upper[0]) + String.valueOf(numbers[1]);
			Results[8] = String.valueOf(numbers[0]) + String.valueOf(numbers[1]);
		}

		Arrays.sort(Results, (s1, s2) -> {
		    if (s1 == null && s2 == null) {
		        return 0;
		    } else if (s1 == null) {
		        return 1;
		    } else if (s2 == null) {
		        return -1;
		    } else {
		        return s2.compareTo(s1);
		    }
		});

		for(int i = 0; i< 9;i++){
			if(Results[i] != null){
				System.out.printf("%s\n",Results[i]);
			}
		}
	}

	public static void main(String args[]){
		String temp = new String();
		int quant_test;
		Scanner input = new Scanner(System.in);
		
		quant_test = input.nextInt();
		String tests[] = new String[quant_test];
		input.nextLine();
		for(int i = 0;i < quant_test;i++){
			tests[i] = input.nextLine();
		}
		for(int i = 0;i <  quant_test;i++){
			System.out.println("");
			PossiblePasswds(tests[i]);
		}
	}
}