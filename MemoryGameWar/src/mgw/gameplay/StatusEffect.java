/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mgw.gameplay;

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

    public StatusEffect(String name, Player caster, Player affected) {
        this.name = name;
        this.caster = caster;
        this.affected = affected;
    }
    
    public void remove()
    {
        affected.status.remove(this);
    }
}

abstract class MultiTurnEffect extends StatusEffect implements IMultiTurn
{
    protected int turnsLeft;
    
    public MultiTurnEffect(String name, Player caster, Player affected, int turns) {
        super(name, caster, affected);
        turnsLeft = turns;
        if(this instanceof IBuff) turnsLeft++;
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

class Singed extends MultiTurnEffect implements IDebuff, IDamageModifier //After getting hit with fireball (reduces next damage recieved by 5)
{
    public Singed(Player caster, Player affected) {
        super("Singed", caster, affected, 1);
    }
    
    @Override
    public int modify(int damage) {
        remove();
        return (damage-5 < 0) ? 0 : damage-5; 
    }
    
}

class Elusive extends StatusEffect implements IBuff //After using dodge (evades opponents next attack)
{
    public Elusive( Player caster, Player affected) {
        super("Elusive", caster, affected);
    }
    
    //don't forget to call remove() later to remove the buff after it is used up
}

class TankingHits extends MultiTurnEffect implements IBuff, IDamaging //After using Revenge Counter
{
    private int collectedDamage = 0;

    public TankingHits( Player caster, Player affected) {
        super("Tanking Hits", caster, affected, 2);
    }

    @Override
    public void nextTurn() {
        //if(--turnsLeft <= 0) remove();
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
        target.removeHP(getDamage());
    }
    
}

class Sinking extends MultiTurnEffect implements IDebuff //After getting hit by quicksand
{
    public Sinking(Player caster, Player affected) {
        super("Sinking", caster, affected, 1);
    }
    
}

class Trapped extends MultiTurnEffect implements IDebuff //After getting hit by trap hole
{
    public Trapped(Player caster, Player affected) {
        super("Trapped", caster, affected, 1);
    }
}

class Boosted extends StatusEffect implements IBuff //mirror image buff
{
    private int effect = 2;

    public Boosted(Player caster, Player affected) {
        super("Boosted", caster, affected);
    }
    
    public boolean check()
    {
        if(effect-- > 0) return true;
        remove();
        return false;
    }
}

class Tired extends MultiTurnEffect implements IDebuff //The next turn after using mirror image
{
    public Tired(Player caster, Player affected, int turns) {
        super("Tired", caster, affected, turns);
    }
    
}