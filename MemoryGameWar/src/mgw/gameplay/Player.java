package mgw.gameplay;

import mgw.main.Account;

public class Player {
    public final int maxHP = 100;

    private Account user;
    private Skill[] deck;
    private int HP = 100;
    private int SP = 0;
    
    public Player(Account player) {
        user = player;
        deck = player.deck;
    }
    
    public int getSP()
    {
        return SP;
    }
    
    public void setSP(int value)
    {
        SP = value;
    }
    
    public void removeSP(int amount)
    {
        SP -= amount;
    }
    
    public void addSP(int amount)
    {
        SP += amount;
    }
    
    public int getSHP()
    {
        return HP;
    }
    
    public void setHP(int value)
    {
        HP = value;
    }
    
    public void removeHP(int amount)
    {
        HP = (HP-amount < 0) ? 0 : HP-amount;
    }
    
    public void addHP(int amount)
    {
        HP = (HP+amount > maxHP) ? maxHP : HP+amount;
    }
    
    public void useSkill(Player target, int skillIndex)
    {
        removeSP(deck[skillIndex].skillPoint);
        deck[skillIndex].use(this, target);
    }
    
    public boolean isDead()
    {
        return HP == 0;
    }
    
}
