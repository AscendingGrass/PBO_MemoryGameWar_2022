/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mgw.gameplay;

import java.util.ArrayList;
import mgw.main.GameUI;

/**
 *
 * @author mejap
 */


public abstract class StatusEffect {
//    public static StatusEffect[] list = {
//        
//    };
    
    public final String name;
    public final Player caster, affected;
    public final Object source;

    public StatusEffect(String name, Object source,  Player caster, Player affected) {
        this.name = name;
        this.caster = caster;
        this.affected = affected;
        this.source = source;
    }
    
    public void remove()
    {
        affected.status.remove(this);
    }
    
    
}

abstract class MultiTurnEffect extends StatusEffect implements IMultiTurn
{
    protected int turnsLeft;
    
    public MultiTurnEffect(String name, Object source, Player caster, Player affected, int turns) {
        super(name, source,  caster, affected);
        turnsLeft = turns;
        if(caster.equals(affected) && source instanceof Skill) turnsLeft++;
    }
    
    @Override
    public int remainingTurns() {
        return turnsLeft;
    }

    @Override
    public void nextTurn() {
        if(--turnsLeft <= 0) remove();
    }
}

class Singed extends MultiTurnEffect implements IDebuff, IDamageModifier //After getting hit with fireball (reduces next damage from the affected by 5)
{
    public Singed(Object source, Player caster, Player affected) {
        super("Singed", source,  caster, affected, 1);
        GameUI.activeGameUI.log(affected.user.username + " became singed");
    }
    
    @Override
    public int modify(int damage) {
        remove();
        return (damage-5 < 0) ? 0 : damage-5; 
    }
    
}

class Elusive extends StatusEffect implements IBuff //After using dodge (evades opponents next attack)
{
    public Elusive(Object source, Player caster, Player affected) {
        super("Elusive", source, caster, affected);
        GameUI.activeGameUI.log(affected.user.username + " became elusive");
    }
    
    //don't forget to call remove() later to remove the buff after it is used up (done)
}

class TankingHits extends MultiTurnEffect implements IBuff, IDamaging //After using Revenge Counter
{
    public final Player target;
    private int collectedDamage = 0;

    public TankingHits(Object source, Player caster, Player affected, Player target) {
        super("Tanking Hits", source, caster, affected, 2);
        this.target = target;
        GameUI.activeGameUI.log(affected.user.username + " started to tank hits and store damage against " + target.user.username);
    }

    @Override
    public void nextTurn() {
        if(--turnsLeft <= 0) 
        {
            
            dealDamage(affected, target);
            remove();
        }
        else if(turnsLeft == 1)
        {
            affected.status.add(new Tired(this, affected, affected, 1));
        }
        
    }
    
    public void tank(int amount)
    {
        collectedDamage += amount;
    }
    
    @Override
    public int getDamage() {
        return collectedDamage * 2;
    }

    @Override
    public void dealDamage(Player user, Player target) {
        int modifiedDmg = getDamage();
        for (StatusEffect se : new ArrayList<>(user.status))
        {
            if (se instanceof IDamageModifier dm) 
            {
                modifiedDmg = dm.modify(modifiedDmg);
            }
        }
        System.out.println(affected.user.username + " took revenge for all the damage it took and dealt " + modifiedDmg + " damage to " + target.user.username);
        target.removeHP(modifiedDmg);
    }
    
}

class Sinking extends MultiTurnEffect implements IDebuff //After getting hit by quicksand (halves the affected's SP gain)
{
    public Sinking(Object source, Player caster, Player affected) {
        super("Sinking", source, caster, affected, 1);
        GameUI.activeGameUI.log(affected.user.username + " started sinking");
    }
    
}

class Trapped extends MultiTurnEffect implements IDebuff //After getting hit by trap hole (prevents the affected from using non-offensive skills)
{
    public Trapped(Object source, Player caster, Player affected) {
        super("Trapped", source, caster, affected, 1);
        GameUI.activeGameUI.log(affected.user.username + " became trapped");
    }
}

class Boosted extends StatusEffect implements IBuff //mirror image buff
{
    private int effect = 2;

    public Boosted(Object source, Player caster, Player affected) {
        super("Boosted", source,  caster, affected);
        GameUI.activeGameUI.log(affected.user.username + " is boosted");
    }
    
    public boolean check()
    {
        if(effect-- > 0) return true;
        affected.status.add(new Tired(this, caster, affected, 1));
        remove();
        return false;
    }
}

class Tired extends MultiTurnEffect implements IDebuff //The next turn after using mirror image
{
    public Tired(Object source, Player caster, Player affected, int turns) {
        super("Tired", source, caster, affected, turns);
        GameUI.activeGameUI.log(affected.user.username + " can't move for " + turns + " turn(s)");
    }
    
}