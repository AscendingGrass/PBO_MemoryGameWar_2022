package mgw.gameplay;

import java.util.ArrayList;
import mgw.main.Account;

public class Player {
    public final ArrayList<StatusEffect> status = new ArrayList();
    public final int maxHP = 100;
    public final Account user;
    public final Skill[] deck;
    
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
        SP = (SP-amount < 0) ? 0 : SP-amount;
    }
    
    public void addSP(int amount) // don forgor💀 to implement checking for sinking status effect!! (done)
    {
        for(StatusEffect se : status)
        {
            if (se instanceof Sinking) {
                amount /= 2;
                break;
            }
        }
        SP += amount;
    }
    
    public int getHP()
    {
        return HP;
    }
    
    public void setHP(int value)
    {
        HP = value;
    }
    
    public void removeHP(int amount)
    {
        if(amount < 0) amount = 0;
        for(StatusEffect se : status)
        {
            if (se instanceof TankingHits th) {
                th.tank(amount);
            }
        }
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
    
    public void nextTurn()
    {
        for(StatusEffect s : new ArrayList<>(status))
            if(s instanceof IMultiTurn mt) mt.nextTurn();
        
    }
    
    public boolean isDead()
    {
        return HP == 0;
    }

    @Override
    public String toString() {
        String str = user.username + " = {" + "HP=" + HP + ", SP=" + SP + '}';
        for (StatusEffect se : status){
            str += "\n *" + se.name;
        }
        return str;
    }

}
