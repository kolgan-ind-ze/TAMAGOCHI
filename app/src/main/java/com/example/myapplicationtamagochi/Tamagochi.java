package com.example.myapplicationtamagochi;

import java.io.Serializable;

public class Tamagochi implements Serializable {
    public static int hunger = 100;//голод
    public static int fatigue = 100;//усталость
    public static int boredom = 100;//скука
    public static int happiness = 100;//счастье
    public static int day = 0; // прожито дней
    public static boolean alive = true;

    public Tamagochi(int hunger, int fatigue, int boredom, int happiness, int day, boolean alive) {
        Tamagochi.hunger = hunger;
        Tamagochi.fatigue = fatigue;
        Tamagochi.boredom = boredom;
        Tamagochi.happiness = happiness;
        Tamagochi.day = day;
        Tamagochi.alive = alive;
    }
}
