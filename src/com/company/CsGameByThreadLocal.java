package com.company;

import java.util.concurrent.ThreadLocalRandom;

/**
 * @Description TODO
 * @Author zhouxinjian
 * @Date 2019-07-02 17:21
 **/

public class CsGameByThreadLocal {
    public static final Integer BULLET_NUMBER = 1500;
    public static final Integer KILLED_ENEMIES = 0;
    public static final Integer LIFE_VALUE = 10;
    public static final Integer TOTAL_PLAYERS = 10;
    public static final ThreadLocalRandom RANDOM = ThreadLocalRandom.current();
    public static final ThreadLocal<Integer> BULLET_NUMBER_THREADLOCAL = new ThreadLocal<Integer>() {
        @Override
        protected Integer initialValue() {
            return BULLET_NUMBER;
        }
    };
    public static final ThreadLocal<Integer> KILLED_ENEMIES_THREADLOCAL = new ThreadLocal<Integer>() {
        @Override
        protected Integer initialValue() {
            return KILLED_ENEMIES;
        }
    };
    public static final ThreadLocal<Integer> LIFE_VALUE_THREADLOCAL = new ThreadLocal<Integer>() {
        @Override
        protected Integer initialValue() {
            return LIFE_VALUE;
        }
    };
    private static class player extends Thread{
        @Override
        public void run() {
            Integer bullet = BULLET_NUMBER_THREADLOCAL.get() - RANDOM.nextInt(BULLET_NUMBER);
            Integer killEnemies= KILLED_ENEMIES_THREADLOCAL.get() + RANDOM.nextInt(TOTAL_PLAYERS/2);
            Integer lifeValue= LIFE_VALUE_THREADLOCAL.get() - RANDOM.nextInt(LIFE_VALUE);

            System.out.println(getName()+" Bullet_number is "+bullet);
            System.out.println(getName()+" killed enemies  is "+killEnemies);
            System.out.println(getName()+" life value is "+lifeValue);
            BULLET_NUMBER_THREADLOCAL.remove();
            KILLED_ENEMIES_THREADLOCAL.remove();
            LIFE_VALUE_THREADLOCAL.remove();
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i <50 ; i++) {
            new player().start();

        }
    }

}
