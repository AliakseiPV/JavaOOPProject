package chars;

import java.util.Arrays;
import java.util.List;

public abstract class Base implements IAction {
    private static int idCounter;
    private int attack;
    private int protection;
    protected int shoot;
    private int[] damage;
    private final double  maxHealth;
    private double currentHealth;
    private int speed;
    private boolean delivery;
    private boolean magic;
    private String name;
    protected String status;
    private int playerID;
    protected List<Base> gang;
    protected Vector2 position;

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
        this.status = "stand";
        playerID = idCounter++;
    }

    public Vector2 getPosition() {return position;}
    public String getName() {return name;}
    public String getStatus(){return status;}

    protected int getSpeed(){return speed;}
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

    protected double Damage(Base npc){
        double totalDamage = 0.0;
        double damage = this.attack - npc.protection;

        if(damage == 0)
        {
            totalDamage = (this.damage[0] + this.damage[1])/2;
        }
        else if(damage > 0){totalDamage = this.damage[1];}
        else if(damage < 0){totalDamage = this.damage[0];}

        return totalDamage;
    }

    protected double nearestDistance(Base hero)
    {
        return Math.sqrt((hero.getPosition().x - this.getPosition().x)^2
                + (hero.getPosition().y - this.getPosition().y)^2);
    }

    @Override
    public String toString() {
        return  name +
                " - attack=" + attack +
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