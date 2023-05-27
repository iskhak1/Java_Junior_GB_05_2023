package ru.gb.lesson_2;

import java.util.Random;
import java.util.Scanner;

public class Program {
    private static final int WIN_COUNT = 4;
    private static final char DOT_HUMAN = 'X';
    private static final char DOT_AI = '0';
    private static final char DOT_EMPTY = ' ';

    private static final Scanner SCANNER = new Scanner(System.in);
    private static char[][] field;
    private static final Random random = new Random();
    private static int fieldSizeX;
    private static int fieldSizeY;

    public static void main(String[] args) {
        while(true) {
            initialize();
            printField();
            while (true) {
                humanTurn();
                printField();
                if (gameCheck(DOT_HUMAN, "Вы победили!")) break;
                //TODO: Проверка на завершение игры
                aiTurn();
                printField();
                //TODO: Проверка на победу
                if (gameCheck(DOT_AI, "Компьтер победили!")) break;

            }
            System.out.println("Желаете сыграть еще раз? (Y-Да)");
            if(!SCANNER.next().equalsIgnoreCase("Y")) break;
        }
    }

    private static void initialize(){

        fieldSizeX = 3;
        fieldSizeY = 3;

        field = new char[fieldSizeX][fieldSizeY];

        for (int x = 0; x < fieldSizeX; x++) {
            for (int y = 0; y < fieldSizeY ; y++) {
                field[y][x] = DOT_EMPTY;
            }
        }


    }

    /**
     * ||TODO: Попроваить отрисовку игрового поля
     */
    private static void printField(){
        System.out.print("+");
        for (int i = 0; i < fieldSizeX*2+1; i++) {
            System.out.print((i%2==0)?"-": i / 2 + 1);
        }
        System.out.println();
        for (int i = 0; i < fieldSizeX; i++) {
            System.out.print(i+1 + "|");

            for (int j = 0; j < fieldSizeY; j++) {
                System.out.print(field[i][j]+"|");
            }

            System.out.println();
        }
        System.out.println();
        for (int i = 0; i < fieldSizeX*2+2; i++) {
            System.out.print("-");
        }
        System.out.println();
    }

    private static void humanTurn(){
        int x, y;
        do{
            System.out.print("введите координаты от " + 1 + " до "+fieldSizeY + " >>> ");
            x = SCANNER.nextInt()-1;
            y = SCANNER.nextInt()-1;
        }while(!isCellEmpty(x,y) || !isCellValid(x,y));
        field[x][y] = DOT_HUMAN;
    }

    static boolean isCellEmpty(int x, int y){
        return field[x][y] == DOT_EMPTY;
    }

    static boolean isCellValid(int x,int y){
        return x>=0 && x < fieldSizeX && y>= 0 && y< fieldSizeY;
    }

    private static void aiTurn(){
        int x, y ;
        do {
            x = random.nextInt(fieldSizeX);
            y = random.nextInt(fieldSizeY);
        }
        while(!isCellValid(x,y) || !isCellEmpty(x,y));
            field[x][y] = DOT_AI;


    }

    //TODO: Переработать метод в домашнем заданий
     static boolean checkWin(char c){
         // Проверка по трем горизонталям
         if (field[0][0] == c && field[0][1] == c && field[0][2] == c) return true;
         if (field[1][0] == c && field[1][1] == c && field[1][2] == c) return true;
         if (field[2][0] == c && field[2][1] == c && field[2][2] == c) return true;

         // Проверка по диагоналям
         if (field[0][0] == c && field[1][1] == c && field[2][2] == c) return true;
         if (field[0][2] == c && field[1][1] == c && field[2][0] == c) return true;

         // Проверка по трем вертикалям
         if (field[0][0] == c && field[1][0] == c && field[2][0] == c) return true;
         if (field[0][1] == c && field[1][1] == c && field[2][1] == c) return true;
         if (field[0][2] == c && field[1][2] == c && field[2][2] == c) return true;
        return false;
    }
     //TODO: Переработать метод в домашнем заданий
    static boolean checkDraw(){
        for (int x = 0; x < fieldSizeX; x++){
            for (int y = 0 ; y < fieldSizeY; y++){
                if(isCellEmpty(x,y)) return false;
            }
        }
        return true;
    }

    static boolean gameCheck(char c, String str){
        if(checkWin(c)){
            System.out.println(str);
            return true;
        }
        if(checkDraw()){
            System.out.println("Ничья!");
            return true;
        }
        return false;
    }

}
