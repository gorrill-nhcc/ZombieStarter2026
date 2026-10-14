package services;

import domain.Person;
import domain.Zombie;

/*
Rules:
o A gun has a 1 in 5 chance of hitting a zombie
o If the hit is successful, there is a 1 in 3 chance of instantly killing the zombie
o If the hit is not critical, it does 2 damage
o It takes 2 non-critical hits or 1 critical hit to kill a zombie
o If the hit misses, there is a 1 in 2 chance the zombie instantly kills the person
o If the zombie hit is not critical, it does 1 damage
o Each shot uses one round of ammo

*/

public class BattleService {

    // int hitOnVal = 3;
    // if(randomInRange(0, GUN_HIT_PROB) == hitOnVal){
    // its a hit!
    // }
    public boolean gunBattle(Person p, Zombie z) {
        // check for hit
        while (p.isLiving() && z.isLiving() && p.getAmmo() > 0) {
            if (Utilities.randomInRange(0, Utilities.GUN_HIT_PROB) == 0) {
                if (Utilities.randomInRange(0, Utilities.GUN_CRIT_PROB) == 0) {
                    // zombie takes damage
                    z.takeDamage(z.getHealth());
                } else {
                    z.takeDamage(Utilities.DEFAULT_GUN_DMG);
                }
            } else { // miss clause
                if (Utilities.randomInRange(0, Utilities.GUN_CRIT_PROB) == 0) { // create constant for crit miss
                    p.takeDamage(p.getHealth());
                } else {
                    p.takeDamage(Utilities.DEFAULT_ZOMBIE_DMG);
                }
            }
        }
        if (p.getAmmo() < 1) { // what bug do I have? Is there something I failed to check for?
            return meleeBattle(p, z);
        }
        return p.isLiving();
    }

    /*
     * Method: boolean meleeBattle(Person p, Zombie z)
     * • Returns true if the person kills the zombie, false if the person dies
     * • Rules:
     * o Melee attack has a 1 in 3 chance of hitting a zombie
     * o If the hit is successful, there is a 1 in 10 chance of instantly killing
     * the zombie
     * o If the hit is not critical, it does 1 damage
     * o The person dies if the attack misses
     */
    public boolean meleeBattle(Person p, Zombie z) {
        while (p.isLiving() && z.isLiving()) {
            if (Utilities.randomInRange(0, Utilities.MELEE_HIT_PROB) == 0) {
                if (Utilities.randomInRange(0, Utilities.MELEE_CRIT_PROB) == 0) {
                    z.takeDamage(z.getHealth());
                } else {
                    z.takeDamage(Utilities.DEFAULT_MELEE_DMG);
                }
            } else {
                p.takeDamage(p.getHealth()); // person dies on a miss
            }
        }
        return p.isLiving();   
    }
}
