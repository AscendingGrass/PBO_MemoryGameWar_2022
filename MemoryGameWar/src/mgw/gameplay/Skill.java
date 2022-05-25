
package mgw.gameplay;

public abstract class Skill
{
    public static Skill[] list = {
        new Fireball(),
        new IceBlast(),
        new MeteorStorm(),
        new ChainLightning(),
        new QuickSlash(),
        new Absorb(),
        new DoubleEdge(),
        new VincentS(),
        new Dodge(),
        new RevengeCounter(),
        new Recover(),
        new QuickSand(),
        new TrapHole(),
        new MirrorImage()
    };
    
    public final String name, description;
    public final int skillPoint;

    @Override
    public String toString() {
        return "Skill name : " + name + "\nDescription : " + description;
    }
    
    public Skill(String name, String description, int skillPoint)
    {
        this.name = name;
        this.description = description;
	this.skillPoint = skillPoint;
    }
    
    void use(Player user, Player target)
    {
        if (this instanceof IDamaging d) 
            d.dealDamage(user, target);
        
        if (this instanceof ISpecialEffect se) 
            se.cast(user, target);
    }
}

abstract class DamagingSkill extends Skill implements IDamaging
{
    private int damage;

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
        target.removeHP(damage);
    }
    
}

class Fireball extends DamagingSkill implements ISpecialEffect
{
    
    public Fireball() {
        super("Fireball", "The user deals 15% damage to the opponent, and reduce total damage received by 5% for the next turn.", 8, 15);
    }

    @Override
    void use(Player user, Player target) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void cast(Player user, Player target) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}


class IceBlast extends DamagingSkill implements ISpecialEffect
{
    
    public IceBlast(){
	super("Ice Blast", "The user deals 5% damage to the opponent and reduce opponent's skill point by 1.", 3, 5);
    }
    
    @Override
    void use(Player user, Player target) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
     @Override
    public void cast(Player user, Player target) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}

class MeteorStorm extends DamagingSkill
{
    public MeteorStorm(){
	super("Meteor Storm", "The user deals 20% damage to the opponent.", 8, 20);
    }
    
    @Override
    void use(Player user, Player target) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}

class ChainLightning extends DamagingSkill
{
    public ChainLightning(){
	super("Chain Lightning", "The user deals 10% damage to the opponent 1-3 times.", 7, 10);
    }
    
    @Override
    void use(Player user, Player target) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}

class QuickSlash extends DamagingSkill
{
    
    public QuickSlash(){
	super("Quick Slash", "The user deals 5% damage to the opponent 2-7 times.", 7, 5);
    }
    
    @Override
    void use(Player user, Player target) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}

class Absorb extends DamagingSkill implements ISpecialEffect
{

    public Absorb(){
	super("Absorb", "The user deals 10% damage to the opponent and steals 2 skill point from your opponent.", 8, 10);
    }
    
    @Override
    void use(Player user, Player target) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void cast(Player user, Player target) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
}

class DoubleEdge extends DamagingSkill
{

    public DoubleEdge(){
	super("Double Edge", "The user deals 15% damage to the opponent, but the user receives 5% damage in recoil.", 5, 15);
    }
    
    @Override
    void use(Player user, Player target) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}

class VincentS extends DamagingSkill
{
    private int damage = 50;
    
    public VincentS(){
	super("Vincent Soesanto", "The user deals 50% damage to the opponent, but the user HP will be reduced to 1%.", 20, 50);
    }
    
    @Override
    void use(Player user, Player target) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}

class Dodge extends Skill implements ISpecialEffect
{
    public Dodge(){
	super("Dodge", "Evade the next opponent's attack (cannot stack).", 9);
    }
    
    @Override
    void use(Player user, Player target) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
     @Override
    public void cast(Player user, Player target) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}

class RevengeCounter extends Skill implements ISpecialEffect
{
    public RevengeCounter(){
	super("Revenge Counter", "Stores energy for 2 turns. At the second turn unleash the stored energy, dealing twice the damage the user received.", 10);
    }
    
    @Override
    void use(Player user, Player target) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
     @Override
    public void cast(Player user, Player target) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}

class Recover extends Skill implements ISpecialEffect
{
    public Recover(){
	super("Recover", "The user restores 20% of the user max HP.", 8);
    }
    
    @Override
    void use(Player user, Player target) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
     @Override
    public void cast(Player user, Player target) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}

class QuickSand extends Skill implements ISpecialEffect
{
    public QuickSand(){
	super("Quick Sand", "The skill points that the opponent gets on the next turn is halved.", 11);
    }
    
    @Override
    void use(Player user, Player target) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
     @Override
    public void cast(Player user, Player target) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}

class TrapHole extends Skill implements ISpecialEffect
{
    public TrapHole(){
	super("Trap Hole", "The opponent cannot use any non-offensive skill for 2 turn(s).", 12);
    }
    
    @Override
    void use(Player user, Player target) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
     @Override
    public void cast(Player user, Player target) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}

class MirrorImage extends Skill implements ISpecialEffect
{
    public MirrorImage(){
	super("Mirror Image", "The user can use skill twice this turn (not including this skill), but the user must recharge on the next turn.", 10);
    }
    
    @Override
    void use(Player user, Player target) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
     @Override
    public void cast(Player user, Player target) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}