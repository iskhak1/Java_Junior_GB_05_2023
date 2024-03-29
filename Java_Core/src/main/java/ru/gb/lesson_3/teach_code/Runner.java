package ru.gb.lesson_3.teach_code;

public interface Runner {

    int getMaxJump();

    int getMaxRun();

    String getName();

    default boolean jump(int height) {
        if (height <= getMaxJump()){
            System.out.printf("%s перепрыгнул через стену %d см\n", getName(), height);
            return true;
        }
        else {
            System.out.printf("%s не смог перепрыгнуть через стену %d см, остался на месте\n", getName(), height);
            return false;
        }
    }

    default boolean run(int length) {
        if (length <= getMaxRun()){
            System.out.printf("%s пробежал по беговой дорожке %d м\n", getName(), length);
            return true;
        }
        else {
            System.out.printf("%s не смог пробежать по беговой дорожке %d м, он смог пробежать только %d м\n",
                    getName(), length, getMaxRun());
            return false;
        }
    }

}
