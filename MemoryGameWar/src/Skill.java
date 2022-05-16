
public class Skill
{
    public static Skill[] skills = new Skill[]{
        
    };
    
    public final String name, description;
    
    public Skill(String name, String description)
    {
        this.name = name;
        this.description = description;
    }
}

class Fireball extends Skill
{
    public Fireball() {
        super("Fireball", "saldfjlskflsafks");
    }
}

