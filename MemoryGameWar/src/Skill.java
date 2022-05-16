
public abstract class Skill
{
    public static Skill[] skills = new Skill[]{
        
    };
    
    public final String name, description;
    public final int skillPoint;
    
    public Skill(String name, String description, int skillPoint)
    {
        this.name = name;
        this.description = description;
	this.skillPoint = skillPoint;
    }
}

class Fireball extends Skill
{
    public Fireball() {
        super("Fireball", "The user deals 15% damage to the opponent, and reduce total damage received by 5% for the next turn.", 8);
    }
}


class IceBlast extends Skill
{
    public IceBlast(){
	super("Ice Blast", "The user deals 5% damage to the opponent and reduce opponent's skill point by 1.", 3);
    }
}

class MeteorStorm extends Skill
{
    public MeteorStorm(){
	super("Meteor Storm", "The user deals 20% damage to the opponent.", 8);
    }
}

class ChainLightning extends Skill
{
    public ChainLightning(){
	super("Chain Lightning", "The user deals 10% damage to the opponent 1-3 times.", 7);
    }
}

class QuickSlash extends Skill
{
    public QuickSlash(){
	super("Quick Slash", "The user deals 5% damage to the opponent 2-7 times.", 7);
    }
}

class Absorb extends Skill
{
    public Absorb(){
	super("Absorb", "The user deals 10% damage to the opponent and steals 2 skill point from your opponent.", 8);
    }
}

class DoubleEdge extends Skill
{
    public DoubleEdge(){
	super("Double Edge", "The user deals 15% damage to the opponent, but the user receives 5% damage in recoil.", 5);
    }
}

class Vincent extends Skill
{
    public Vincent(){
	super("Vincent", "The user deals 50% damage to the opponent, but the user HP will be reduced to 1%.", 20);
    }
}

class Dodge extends Skill
{
    public Dodge(){
	super("Dodge", "Evade the next opponent's attack (cannot stack).", 9);
    }
}

class RevengeCounter extends Skill
{
    public RevengeCounter(){
	super("Revenge Counter", "Stores energy for 2 turns. At the second turn unleash the stored energy, dealing twice the damage the user received.", 10);
    }
}

class Recover extends Skill
{
    public Recover(){
	super("Recover", "The user restores 20% of the user max HP.", 8);
    }
}

class QuickSand extends Skill
{
    public QuickSand(){
	super("Quick Sand", "The skill points that the opponent gets on the next turn is halved.", 11);
    }
}

class TrapHole extends Skill
{
    public TrapHole(){
	super("Trap Hole", "The opponent cannot use any non-offensive skill for 2 turn(s).", 12);
    }
}

class MirrorImage extends Skill
{
    public MirrorImage(){
	super("Mirror Image", "The user can use skill twice this turn (not including this skill), but the user must recharge on the next turn.", 10);
    }
}