import java.util.Arrays;

public abstract class Base implements IAction {
    private static int idCounter;

    private int attack;
    private int protection;
    private int shoot;
    private int[] damage;
    private final double  maxHealth;
    private double currentHealth;
    private int speed;
    private boolean delivery;
    private boolean magic;
    private String name;
    private int playerID;

    public Base(int attack, int protection, int shoot, int[] damage,
                double maxHealth, double currentHealth, int speed, boolean delivery,
                boolean magic, String name)
    {
        this.attack = attack;
        this.protection = protection;
        this.shoot = shoot;
        this.damage = damage;
        this.maxHealth = maxHealth;
        this.currentHealth = currentHealth;
        this.speed = speed;
        this.delivery = delivery;
        this.magic = magic;
        this.name = name;
        playerID = idCounter++;
    }
    protected int[] getDamage(){
        return damage;
    }
    protected double getCurrentHealth() {
        return currentHealth;
    }
    protected void setCurrentHealth(double health) {
        currentHealth = health;
    }
    protected double getMaxHealth() {
        return maxHealth;
    }

    @Override
    public String toString() {
        return  "attack=" + attack +
                ", protection=" + protection +
                ", shoot=" + shoot +
                ", damage=" + Arrays.toString(damage) +
                ", maxHealth=" + maxHealth +
                ", currentHealth=" + currentHealth +
                ", speed=" + speed +
                ", delivery=" + delivery +
                ", magic=" + magic;
    }

}