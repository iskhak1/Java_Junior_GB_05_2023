package ru.gb.lesson_2;

public class Main {
    public static void main(String[] args) {
        int [][] arr = new int[3][3];
        for (int i = 0; i <arr.length ; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if(i==j){
                    arr[i][j]=1;
                }if(arr.length-i==arr[0].length-i && i!=1&&j!=1){
                    arr[i][j]=1;
                }
                if(arr.length!=arr[0].length){
                    if((arr.length-i)==(arr[0].length-j)){
                        arr[i][j]=1;
                    }
                    if((arr.length-i-2)==(arr[0].length-j-2)){
                        arr[i][j]=1;
                    }
                }
                System.out.print(arr[i][j]);
            }
            System.out.println();
        }
    }
}