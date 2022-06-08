
package mgw.gameplay;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;
import javax.swing.Icon;
import mgw.main.GameUI;
import mgw.util.UtilArsa;

public abstract class Skill implements Serializable
{
    public static Skill[] list = {
        new Fireball(),
        new IceBlast(),
        new MeteorStorm(),
        new ChainLightning(),
        new QuickSlash(),
        new Absorb(),
        new DoubleEdge(),
        new ClownGaze(),
        new Dodge(),
        new RevengeCounter(),
        new Recover(),
        new QuickSand(),
        new TrapHole(),
        new MirrorImage()
    };

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + Objects.hashCode(this.name);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Skill other = (Skill) obj;
        return Objects.equals(this.name, other.name);
    }


    public final String name, description;
    public final int skillPoint;
    public final Icon img;
    public final Icon back;
    @Override
    public String toString() {
        String [] temp = description.split(" ");
        
        return "Description : \n" + cacahKata(temp);
    }
    
    public String cacahKata(String [] temp){
        int counter = 1;
        String x = "";
        for(String i : temp){
            if(counter > 5){
                x+= "\n";
                counter = 1;
            }
            x += i + " ";
            counter++;
            
        }
        return x;
    }
    
    public Skill(String name, String description, int skillPoint)
    {
        this.name = name;
        this.description = description;
	this.skillPoint = skillPoint;
        img = new javax.swing.ImageIcon(getClass().getResource("/mgw/main/imgdeck/" + this.name + ".png"));
        back = new javax.swing.ImageIcon(getClass().getResource("/mgw/main/imgdeck/" + this.name + " Dark.png"));
    }
    
    void use(Player user, Player target)
    {
        GameUI.activeGameUI.log(user.user.username + " used " + name);
        
        if (this instanceof IDamaging d) 
        {
            StatusEffect temp = target.getStatusOfType("Elusive");
            if (temp == null) 
            { 
                d.dealDamage(user, target);
                if (this instanceof ISpecialEffect se) 
                    se.cast(user, target);
            }
            else
            {
                temp.remove();
                GameUI.activeGameUI.log(target.user.username + " evaded the attack");
            }
        }
        else if (this instanceof ISpecialEffect se) 
            se.cast(user, target);
    }
}

abstract class DamagingSkill extends Skill implements IDamaging
{
    private final int damage;

    public DamagingSkill(String name, String description, int skillPoint, int damage) {
        super(name, description, skillPoint);
        this.damage = damage;
    }
    
    @Override
    public int getDamage() {
        return damage;
    }

    @Override
    public void dealDamage(Player user, Player target) {

        int modifiedDmg = damage;
        for (StatusEffect se : new ArrayList<>(user.status))
        {
            if (se instanceof IDamageModifier dm) 
            {
                modifiedDmg = dm.modify(modifiedDmg);
            }
        }
        GameUI.activeGameUI.log(user.user.username + " dealt " + modifiedDmg + " damage to " + target.user.username);
        target.removeHP(modifiedDmg);

    }
    
}

class Fireball extends DamagingSkill implements ISpecialEffect
{
    
    public Fireball() {
        super("Fireball", "The user deals 15% damage to the opponent, and reduce total damage received by 5% for the next turn.", 8, 15);
    }

    @Override
    public void cast(Player user, Player target) {
        target.status.add(new Singed(this, user, target));
    }

}


class IceBlast extends DamagingSkill implements ISpecialEffect
{
    
    public IceBlast(){
	super("Ice Blast", "The user deals 5% damage to the opponent and reduce opponent's skill point by 1.", 3, 5);
    }

     @Override
    public void cast(Player user, Player target) {
        target.removeSP(1);
        GameUI.activeGameUI.log(target.user.username + "'s SP is reduced by 1");
    }
}

class MeteorStorm extends DamagingSkill
{
    public MeteorStorm(){
	super("Meteor Storm", "The user deals 20% damage to the opponent.", 8, 20);
    }
}

class ChainLightning extends DamagingSkill
{
    public final int procChance = 55;
    
    public ChainLightning(){
	super("Chain Lightning", "The user deals 10% damage to the opponent 1-3 times.", 7, 10);
    }
    
    @Override
    void use(Player user, Player target) {
        GameUI.activeGameUI.log(user.user.username + " used " + name);
        int hits = UtilArsa.nextRandom(1, 4);
        
        for (int i = 0; i < hits; i++) 
        {
            StatusEffect temp = target.getStatusOfType("Elusive");
            if (temp == null) 
                dealDamage(user, target);
            else
            {
                temp.remove();
                GameUI.activeGameUI.log(target.user.username + " evaded the attack");
            }
        }
        
        GameUI.activeGameUI.log("hit " + hits + " time(s)");
    }
}

class QuickSlash extends DamagingSkill
{
    
    public QuickSlash(){
	super("Quick Slash", "The user deals 5% damage to the opponent 2-7 times.", 7, 5);
    }
    
    @Override
    void use(Player user, Player target) {
        GameUI.activeGameUI.log(user.user.username + " used " + name);
        int hits = UtilArsa.nextRandom(2, 8) ;
        
        for (int i = 0; i < hits; i++)
        {
            StatusEffect temp = target.getStatusOfType("Elusive");
            if (temp == null) 
                dealDamage(user, target);
            else
            {
                temp.remove();
                GameUI.activeGameUI.log(target.user.username + " evaded the attack");
            }
        }
        
        GameUI.activeGameUI.log("hit " + hits + " times");
    }
}

class Absorb extends DamagingSkill implements ISpecialEffect
{

    public Absorb(){
	super("Absorb", "The user deals 10% damage to the opponent and steals 2 skill point from your opponent.", 8, 10);
    }

    @Override
    public void cast(Player user, Player target) {
        int absorbedSP = target.getSP();
        absorbedSP = absorbedSP > 2? 2 : absorbedSP;
        target.removeSP(absorbedSP);
        GameUI.activeGameUI.log(user.user.username + " absorbed 2 SP from " + target.user.username);
        user.addSP(absorbedSP);
    }
    
}

class DoubleEdge extends DamagingSkill
{

    public DoubleEdge(){
	super("Double Edge", "The user deals 15% damage to the opponent, but the user receives 5% damage in recoil(Pierce Evasion).", 5, 15);
    }
    
    @Override
    void use(Player user, Player target) {
        GameUI.activeGameUI.log(user.user.username + " used " + name);
        dealDamage(user, target);
        user.removeHP(5);
        GameUI.activeGameUI.log(user.user.username + " got hit by recoil and lost 5 HP");
    }
}

class ClownGaze extends DamagingSkill
{
    public ClownGaze(){
	super("Clown Gaze", "The user deals 50% damage to the opponent, but the user HP will be reduced to 1%(Pierce Evasion).", 20, 50);
    }
    
    @Override
    void use(Player user, Player target) {
        GameUI.activeGameUI.log(user.user.username + " used " + name);
        dealDamage(user, target);
        user.removeHP(user.getHP()-1);
        GameUI.activeGameUI.log(user.user.username + " got hit by recoil and is left with 1 HP");
    }
}

class Dodge extends Skill implements ISpecialEffect
{
    public Dodge(){
	super("Dodge", "Evade the next opponent's attack (cannot stack).", 9);
    }
    
    @Override
    public void cast(Player user, Player target) {
        StatusEffect temp = user.getStatusOfType("Elusive");
        if(temp == null)
        {
            user.status.add(new Elusive(this, user, user));
        }
        else
        {
            GameUI.activeGameUI.log(user.user.username + " is already Elusive");
        }
    }
}

class RevengeCounter extends Skill implements ISpecialEffect
{
    public RevengeCounter(){
	super("Revenge Counter", "Stores energy for 2 turns. At the second turn unleash the stored energy, dealing twice the damage the user received.", 10);
    }
    
    @Override
    public void cast(Player user, Player target) {

        StatusEffect temp = user.getStatusOfType("Tanking Hits");
        if(temp == null)
        {
            user.status.add(new TankingHits(this, user, user, target));
        }
        else
        {
            GameUI.activeGameUI.log(user.user.username + " is already Tanking Hits");
        }
    }
}

class Recover extends Skill implements ISpecialEffect
{
    public Recover(){
	super("Recover", "The user restores 20% of the user max HP.", 8);
    }
    
    @Override
    public void cast(Player user, Player target) {
        user.addHP(20);
        GameUI.activeGameUI.log(user.user.username + " recovered 20 HP");
    }
}

class QuickSand extends Skill implements ISpecialEffect
{
    public QuickSand(){
	super("Quick Sand", "The skill points that the opponent gets on the next turn is halved.", 11);
    }
    
    @Override
    public void cast(Player user, Player target) {
        StatusEffect temp = target.getStatusOfType("Sinking");
        if(temp == null)
        {
            target.status.add(new Sinking(this, user, target));
        }
        else
        {
            GameUI.activeGameUI.log(target.user.username + " is already Sinking");
        }
    }
}

class TrapHole extends Skill implements ISpecialEffect
{
    public TrapHole(){
	super("Trap Hole", "The opponent cannot use any non-offensive skill for 2 turn(s).", 12);
    }
    
    @Override
    public void cast(Player user, Player target) {
        StatusEffect temp = target.getStatusOfType("Trapped");
        if(temp == null)
        {
            target.status.add(new Trapped(this, user, target));
        }
        else
        {
            GameUI.activeGameUI.log(target.user.username + " is already Trapped");
        }
    }
}

class MirrorImage extends Skill implements ISpecialEffect
{
    public MirrorImage(){
	super("Mirror Image", "The user can use skill twice this turn (not including this skill), but the user must recharge on the next turn.", 10);
    }
    
     @Override
    public void cast(Player user, Player target) {
        StatusEffect temp = user.getStatusOfType("Boosted");
        if(temp == null)
        {
            user.status.add(new Boosted(this, user, user));
        }
        else
        {
            GameUI.activeGameUI.log(user.user.username + " is already Boosted");
        }
    }
}