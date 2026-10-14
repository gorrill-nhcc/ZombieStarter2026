package managers;

import java.util.random.RandomGenerator;
import domain.Person;
import domain.Zombie;

public class App {
    public static void main(String[] args) {

        RandomGenerator rand = RandomGenerator.getDefault();

        String[] names = {"Hank", "Gwen", "Pete", "Michone", 
        "Glen", "Adrienne", "Isabella", "Drew", "Peanut"};

        String[] zombieTypes = {"Grunt", "Runner", "Brute", "Exploder", "Cosmic Horror"};

        int zombieCount = rand.nextInt(15, 50);

        Person [] colony = new Person[names.length];
        Zombie [] horde =new Zombie[zombieCount];

        int i = 0;
        for(String n : names){
            colony[i] = new Person(n);
        }

        for(int j = 0; j < names.length; j++){
            colony[i] = new Person(names[i]);  
        }

        for(int j = 0; j < horde.length; j++){
            int choice = rand.nextInt(zombieTypes.length);
            horde[i] = new Zombie(zombieTypes[choice]);
        }


    }
}
