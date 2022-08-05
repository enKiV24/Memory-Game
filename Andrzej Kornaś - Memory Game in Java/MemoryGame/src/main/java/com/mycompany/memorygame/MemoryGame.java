package com.mycompany.memorygame;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Random;

public class MemoryGame {

    public static void main(String[] args) throws FileNotFoundException {

        boolean endGame = false;
        while(endGame == false){
            Scanner scanner = new Scanner(System.in);
            System.out.println(">>>MEMORY GAME<<<");
            System.out.println("Main Menu:");
            System.out.println("1. Play Game (easy)");
            System.out.println("2. Play Game (hard)");
            System.out.println("3. Play Game (exit)");

            int menuGuess = scanner.nextInt();


            //Reading Words.txt
            String word[] = new String[100];
            int x = 0;
            Scanner fileScanner = new Scanner(new File("C:\\Users\\Admin\\Desktop\\Andrzej Kornaś - Motorola - recruitment task Java\\MemoryGame\\src\\main\\java\\com\\mycompany\\memorygame\\Words.txt"));
            while(fileScanner.hasNext()){
                word[x] = fileScanner.nextLine();

                x++;
            }

            //Random 8 Words form Words.txt
            Random random = new Random();

            int[] randomWord = new int[8];

            int k = 1;
            for(int i =0; i < 8; i++){
                int randomNumber = random.nextInt(99);
                randomWord[i] = randomNumber;
                //Sprawdzenie powtórzeń
                for(int j = 1; j < k;){
                    if(randomWord[i] == randomWord[i-j]){
                        i--;
                        k--;
                    }
                j++;
                }
                k++;
            }

            // Alphabet A-D
            String[] letters = {"A","B","C","D"};







            //GAME EASY

            if(menuGuess == 1){

                int m = 0;
                String[] gameWord = new String[8];
                for (int i = 0; i < 4; i++) {
                    for (int j = 0; j < 2; j++) {
                        gameWord[m] = word[randomWord[i]];
                        m = m+1;
                    }
                }

                // Gameslot random
                int[] wordSlot = new int[8];
                k = 1;
                for(int i =0; i < 8; i++){
                    int randomNumber = random.nextInt(8);
                    wordSlot[i] = randomNumber;
                    //Sprawdzenie powtórzeń
                    for(int j = 1; j < k;){
                        if(wordSlot[i] == wordSlot[i-j]){
                            i--;
                            k--;
                        }
                    j++;
                    }
                    k++;
                }

                //wordSlot -> gameSlot
                String[] gameRandomWord = new String[8];
                for (int i = 0; i < 8; i++) {
                    gameRandomWord[i] = gameWord[wordSlot[i]];
                }

                String[] gameSlot = new String[8];
                for (int i = 0; i < 8; i++) {
                    gameSlot[i] = "X";
                }

                //Win?
                int points = 0;
                boolean win = false;
                int guessChances = 6;

                while(win == false){

                    // Player Guess
                    String[] rightGuess = new String[2];
                    int[] compareGuess = new int[2];
                    boolean wrongAnswear = false;


                    for(int i = 0;i<2;i++){

                        if(wrongAnswear == false){
                            rightGuess[1] = rightGuess[0];
                            compareGuess[1] = compareGuess[0];
                        }

                        String playerGuess = scanner.nextLine();


                        wrongAnswear = false;
                        if(playerGuess.equals("A1") || playerGuess.equals("a1")){
                            gameSlot[0] = gameRandomWord[0];
                            rightGuess[0] = gameRandomWord[0];
                            compareGuess[0] = 0;
                        }else if(playerGuess.equals("A2") || playerGuess.equals("a2")){
                            gameSlot[1] = gameRandomWord[1];
                            rightGuess[0] = gameRandomWord[1];
                            compareGuess[0] = 1;
                        }else if(playerGuess.equals("A3") || playerGuess.equals("a3")){
                            gameSlot[2] = gameRandomWord[2];
                            rightGuess[0] = gameRandomWord[2];
                            compareGuess[0] = 2;
                        }else if(playerGuess.equals("A4") || playerGuess.equals("a4")){
                            gameSlot[3] = gameRandomWord[3];
                            rightGuess[0] = gameRandomWord[3];
                            compareGuess[0] = 3;
                        }else if(playerGuess.equals("B1") || playerGuess.equals("b1")){
                            gameSlot[4] = gameRandomWord[4];
                            rightGuess[0] = gameRandomWord[4];
                            compareGuess[0] = 4;
                        }else if(playerGuess.equals("B2") || playerGuess.equals("b2")){
                            gameSlot[5] = gameRandomWord[5];
                            rightGuess[0] = gameRandomWord[5];
                            compareGuess[0] = 5;
                        }else if(playerGuess.equals("B3") || playerGuess.equals("b3")){
                            gameSlot[6] = gameRandomWord[6];
                            rightGuess[0] = gameRandomWord[6];
                            compareGuess[0] = 6;
                        }else if(playerGuess.equals("B4") || playerGuess.equals("b4")){
                            gameSlot[7] = gameRandomWord[7];
                            rightGuess[0] = gameRandomWord[7];
                            compareGuess[0] = 7;
                        }else{
                            System.out.println("----------------------------");
                            System.out.println("To select a word, type:: \nA1,A2,A3,A4,\nB1,B2,B3,B4");
                            rightGuess[0] = null;
                            i--;
                            wrongAnswear = true;
                        }

                        //Tab Print
                            k=0;
                            System.out.println("----------------------------");
                            System.out.println("level: Easy");
                            System.out.println("Guess chances: " + guessChances + "\n");
                            System.out.print("   |       1       |       2       |       3       |       4       |");
                            for (int j = 0; j < 2; j++) {
                                System.out.println("\n---+---------------+---------------+---------------+---------------+");
                                System.out.print(" " + letters[j] + " |");
                                for (int n = 0; n < 4; n++) {

                                    ////Centering text in cells
                                    int space = 15 - gameSlot[k].length();
                                    for (int l = 0; l < space/2; l++) {
                                        System.out.print(" ");
                                    }
                                    System.out.print(gameSlot[k]);
                                    k++;
                                    for (int l = 0; l < space/2+space%2; l++) {
                                        System.out.print(" ");
                                    }
                                    System.out.print("|");
                                    }

                            }
                            System.out.println("\n---+---------------+---------------+---------------+---------------+");

                        }
                    // Right Check
                    if(rightGuess[0].equals(rightGuess[1])){
                        System.out.println("You found the words!");
                        points++;
                    }else{
                        gameSlot[compareGuess[0]] = "X";
                        gameSlot[compareGuess[1]] = "X";
                        System.out.println("You did not find the word! Try again!");
                        guessChances--;
                    }
                    if(points == 4){
                        System.out.println("Congratulations! You win the game! :)");
                        win = true;
                    }
                    if(guessChances == 0){
                        System.out.println("You lost all your chances. You lose the game! :(");
                        win = true;
                    }

                }
            }

            //GAME HARD-----------------------------------------------------------------------------------------------------------

            if(menuGuess == 2){

                int m = 0;
                String[] gameWord = new String[16];
                for (int i = 0; i < 8; i++) {
                    for (int j = 0; j < 2; j++) {
                        gameWord[m] = word[randomWord[i]];
                        m = m+1;
                    }
                }

                // Gameslot random
                int[] wordSlot = new int[16];
                k = 1;
                for(int i =0; i < 16; i++){
                    int randomNumber = random.nextInt(16);
                    wordSlot[i] = randomNumber;
                    //Sprawdzenie powtórzeń
                    for(int j = 1; j < k;){
                        if(wordSlot[i] == wordSlot[i-j]){
                            i--;
                            k--;
                        }
                    j++;
                    }
                    k++;
                }

                //wordSlot -> gameSlot
                String[] gameRandomWord = new String[16];
                for (int i = 0; i < 16; i++) {
                    gameRandomWord[i] = gameWord[wordSlot[i]];
                }

                String[] gameSlot = new String[16];
                for (int i = 0; i < 16; i++) {
                    gameSlot[i] = "X";
                }

                //win?
                int points = 0;
                boolean win = false;
                int guessChances = 10;

                while(win == false){

                    // Player Guess
                    String[] rightGuess = new String[2];
                    int[] compareGuess = new int[2];
                    boolean wrongAnswear = false;


                    for(int i = 0;i<2;i++){

                        if(wrongAnswear == false){
                            rightGuess[1] = rightGuess[0];
                            compareGuess[1] = compareGuess[0];
                        }

                        String playerGuess = scanner.nextLine();


                        wrongAnswear = false;
                        if(playerGuess.equals("A1") || playerGuess.equals("a1")){
                            gameSlot[0] = gameRandomWord[0];
                            rightGuess[0] = gameRandomWord[0];
                            compareGuess[0] = 0;
                        }else if(playerGuess.equals("A2") || playerGuess.equals("a2")){
                            gameSlot[1] = gameRandomWord[1];
                            rightGuess[0] = gameRandomWord[1];
                            compareGuess[0] = 1;
                        }else if(playerGuess.equals("A3") || playerGuess.equals("a3")){
                            gameSlot[2] = gameRandomWord[2];
                            rightGuess[0] = gameRandomWord[2];
                            compareGuess[0] = 2;
                        }else if(playerGuess.equals("A4") || playerGuess.equals("a4")){
                            gameSlot[3] = gameRandomWord[3];
                            rightGuess[0] = gameRandomWord[3];
                            compareGuess[0] = 3;
                        }else if(playerGuess.equals("B1") || playerGuess.equals("b1")){
                            gameSlot[4] = gameRandomWord[4];
                            rightGuess[0] = gameRandomWord[4];
                            compareGuess[0] = 4;
                        }else if(playerGuess.equals("B2") || playerGuess.equals("b2")){
                            gameSlot[5] = gameRandomWord[5];
                            rightGuess[0] = gameRandomWord[5];
                            compareGuess[0] = 5;
                        }else if(playerGuess.equals("B3") || playerGuess.equals("b3")){
                            gameSlot[6] = gameRandomWord[6];
                            rightGuess[0] = gameRandomWord[6];
                            compareGuess[0] = 6;
                        }else if(playerGuess.equals("B4") || playerGuess.equals("b4")){
                            gameSlot[7] = gameRandomWord[7];
                            rightGuess[0] = gameRandomWord[7];
                            compareGuess[0] = 7;
                        }else if(playerGuess.equals("C1") || playerGuess.equals("c1")){
                            gameSlot[8] = gameRandomWord[8];
                            rightGuess[0] = gameRandomWord[8];
                            compareGuess[0] = 8;
                        }else if(playerGuess.equals("C2") || playerGuess.equals("c2")){
                            gameSlot[9] = gameRandomWord[9];
                            rightGuess[0] = gameRandomWord[9];
                            compareGuess[0] = 9;
                        }else if(playerGuess.equals("C3") || playerGuess.equals("c3")){
                            gameSlot[10] = gameRandomWord[10];
                            rightGuess[0] = gameRandomWord[10];
                            compareGuess[0] = 10;
                        }else if(playerGuess.equals("C4") || playerGuess.equals("c4")){
                            gameSlot[11] = gameRandomWord[11];
                            rightGuess[0] = gameRandomWord[11];
                            compareGuess[0] = 11;
                        }else if(playerGuess.equals("D1") || playerGuess.equals("d1")){
                            gameSlot[12] = gameRandomWord[12];
                            rightGuess[0] = gameRandomWord[12];
                            compareGuess[0] = 12;
                        }else if(playerGuess.equals("D2") || playerGuess.equals("d2")){
                            gameSlot[13] = gameRandomWord[13];
                            rightGuess[0] = gameRandomWord[13];
                            compareGuess[0] = 13;
                        }else if(playerGuess.equals("D3") || playerGuess.equals("d3")){
                            gameSlot[14] = gameRandomWord[14];
                            rightGuess[0] = gameRandomWord[14];
                            compareGuess[0] = 14;
                        }else if(playerGuess.equals("D4") || playerGuess.equals("d4")){
                            gameSlot[15] = gameRandomWord[15];
                            rightGuess[0] = gameRandomWord[15];
                            compareGuess[0] = 15;
                        }else{
                            System.out.println("----------------------------");
                            System.out.println("To select a word, type::\nA1,A2,A3,A4,\nB1,B2,B3,B4,\nC1,C2,C3,C4\nD1,D2,D3,D4");
                            rightGuess[0] = null;
                            i--;
                            wrongAnswear = true;
                        }

                        //Tab Print
                            k=0;
                            System.out.println("----------------------------");
                            System.out.println("level: Hard");
                            System.out.println("Guess chances: " + guessChances + "\n");
                            System.out.print("   |       1       |       2       |       3       |       4       |");
                            for (int j = 0; j < 4; j++) {
                                System.out.println("\n---+---------------+---------------+---------------+---------------+");
                                System.out.print(" " + letters[j] + " |");
                                for (int n = 0; n < 4; n++) {

                                    //Centering text in cells
                                    int space = 15 - gameSlot[k].length();
                                    for (int l = 0; l < space/2; l++) {
                                        System.out.print(" ");
                                    }
                                    System.out.print(gameSlot[k]);
                                    k++;
                                    for (int l = 0; l < space/2+space%2; l++) {
                                        System.out.print(" ");
                                    }
                                    System.out.print("|");
                                    }

                            }
                            System.out.println("\n---+---------------+---------------+---------------+---------------+");

                        }
                    // Right Check
                    if(rightGuess[0].equals(rightGuess[1])){
                        System.out.println("You found the words!");
                        points++;
                    }else{
                        gameSlot[compareGuess[0]] = "X";
                        gameSlot[compareGuess[1]] = "X";
                        System.out.println("You did not find the word! Try again!");
                        guessChances--;
                    }
                    if(points == 8){
                        System.out.println("Congratulations! You win! :)");
                        win = true;
                    }
                    if(guessChances == 0){
                        System.out.println("You lost all your chances. You lose the game! :(");
                        win = true;
                    }
                }
            }
            
            
            //3. Exit
            if(menuGuess == 3){
                System.out.println("Bye!");
                endGame = true;
            }
            else{
                System.out.println("Type a number: 1, 2 or 3 and press enter");
            }
        }
    }
}
