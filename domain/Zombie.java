package domain;

import java.util.Objects;

public class Zombie {

    private String zombieType;
    private int health;

    public Zombie(String zombieType) {
        this.zombieType = zombieType;
        this.health = 2;
    }

    public Zombie(String zombieType, int health, boolean isLiving) {
        this.zombieType = zombieType;
        this.health = health;
    }

    public String getZombieType() {
        return zombieType;
    }

    public void setZombieType(String zombieType) {
        this.zombieType = zombieType;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public boolean isLiving() {
        return getHealth() > 0;
    }

    @Override
    public String toString() {
        return "Zombie{zombieType='" + zombieType + "', health=" + health + ", isLiving=" + isLiving() + "}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Zombie other = (Zombie) o;
        return health == other.health && isLiving() == other.isLiving()
                && Objects.equals(zombieType, other.zombieType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(zombieType, health, isLiving());
    }
}
