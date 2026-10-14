package services;

import java.util.random.RandomGenerator;

public class Utilities {
    private static RandomGenerator rand = RandomGenerator.getDefault();

    public static final int DEFAULT_ZOMBIE_HEALTH = 3;
    public static final int DEFAULT_PERSON_HEALTH = 5;

    public static final int DEFAULT_GUN_DMG = 2;
    public static final int DEFAULT_ZOMBIE_DMG = 1;
    public static final int DEFAULT_MELEE_DMG = 1;

    public static final int GUN_HIT_PROB = 5;
    public static final int GUN_CRIT_PROB = 3;
    public static final int MELEE_HIT_PROB = 3;
    public static final int MELEE_CRIT_PROB = 10;

    // int hitOnVal = 3;
    // if(randomInRange(0, GUN_HIT_PROB) == hitOnVal){
    //     its a hit!
    // }

    public static int randomInRange(int lowerBound, int upperBound){
        // you need to validate input
        return rand.nextInt(lowerBound, upperBound);
    }
}
