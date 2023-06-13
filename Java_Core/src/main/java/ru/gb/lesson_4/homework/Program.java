package ru.gb.lesson_4.homework;

import ru.gb.lesson_4.homework.exceptions.MyArrayDataException;
import ru.gb.lesson_4.homework.exceptions.MyArraySizeException;


public class Program {
    public void checkException(String [][] array) {
        int sum = 0;
        try{

           if(array.length!=4 && array[0].length!=4){
               throw new MyArraySizeException("Size Array must be equal 4X4");
           }
            for (int i = 0; i < array.length; i++) {
                for (int j = 0; j < array[0].length; j++) {
                    if(array[i][j].matches("-?\\d+")){
                        sum += Integer.parseInt(array[i][j]);
                    }
                    else{
                        throw new MyArrayDataException("array["+i+"]["+j+"] is not int");
                    }

                }
            }

        }catch(MyArraySizeException ex){
            System.err.println(ex.getMessage());
        }catch(MyArrayDataException ex){
            System.err.println(ex.getMessage());
        }finally {
            System.out.println("SUM -> "+sum);
        }
    }
}
