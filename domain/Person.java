package domain;

import java.util.Objects;

public class Person {

    private String name;
    private int health;
    private int food;
    private int ammo;

    public Person(String name) {
        this.name = name;
        this.health = 5;
        this.food = 8;
        this.ammo = 25;
    }

    public Person(String name, int health, int food, int ammo) {
        this.name = name;
        this.health = health;
        this.food = food;
        this.ammo = ammo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getFood() {
        return food;
    }

    public void setFood(int food) {
        this.food = food;
    }

    public int getAmmo() {
        return ammo;
    }

    public void setAmmo(int ammo) {
        this.ammo = ammo;
    }

    public boolean isLiving(){
        return getHealth() > 0;
    }

    @Override
    public String toString() {
        return "Person{name='" + name + "', health=" + health + ", food=" + food + ", ammo=" + ammo + "}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Person other = (Person) o;
        return health == other.health && food == other.food && ammo == other.ammo
                && Objects.equals(name, other.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, health, food, ammo);
    }
}
