package kz.colorsapp.sgq.colorsapp.ui.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomItems {
    private Random random;
    private int limit;
    private List<Boolean> listCheck;

    public RandomItems(int limit) {
        listCheck = new ArrayList<>();
        random = new Random(System.currentTimeMillis());
        this.limit = limit;
        initListCheck(limit);
    }

    public void resize(int size){
        limit = limit + size;
        initListCheck(size);
    }

    private void initListCheck(int size) {
        for (int i = 0; i < size; i++) {
            listCheck.add(true);
        }
    }

    private int getRandomNumber() {
        return random.nextInt(limit);
    }

    public int[] getNumbers() {
        int freeNum = 0;
        for (int i = 0; i < limit; i++) {
            if (listCheck.get(i))
                freeNum++;
        }
        if (freeNum >= 20) {
            return calc(20);
        } else {
            return calc(freeNum);
        }
    }

    private int[] calc(int num) {
        int[] number;
        if (num != 0) {
            number = new int[num];
            for (int i = 0; i < num; i++) {
                number[i] = refresh(getRandomNumber());
            }
        } else {
            number = new int[num];
        }
        return number;
    }

    private int refresh(int randNum) {
        if (listCheck.get(randNum)) {
            listCheck.set(randNum, false);
            return randNum;
        } else {
            if (randNum + 1 <= limit - 1) {
                return refresh(randNum + 1);
            } else {
                return refresh(0);
            }
        }
    }
}
