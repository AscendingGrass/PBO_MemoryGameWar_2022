/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mgw.gameplay;
import mgw.main.Account;
import mgw.util.UtilArsa;

/**
 *
 * @author mejap
 */
public class TestingClass {
    static Player p1 = new Player(new Account("p1"));
    static Player p2 = new Player(new Account("p2"));
    
    public static void main(String[] args) {
        System.out.println("hello");
        
        
        p1.deck[0] = Skill.list[0]; //FireBall
        p1.deck[1] = Skill.list[1]; //IceBlast
        p1.deck[2] = Skill.list[2]; //MeteorStorm
        p1.deck[3] = Skill.list[3]; //ChainLightning
        p1.deck[4] = Skill.list[4]; //QuickSlash
        p2.deck[0] = Skill.list[5]; //Absorb
        p2.deck[1] = Skill.list[6]; //DoubleEdge
        p2.deck[2] = Skill.list[7]; //ClownGaze
        p2.deck[3] = Skill.list[8]; //Dodge
        p2.deck[4] = Skill.list[9]; //RevengeCounter
        p1.addSP(100);
        p2.addSP(100);
        
        System.out.println(p1);
        System.out.println(p2);
        
        run(p1, p2, 0);
        run(p2, p1, 0);
        run(p1, p2, 1);
        run(p2, p1, 1);
        run(p1, p2, 3);
        run(p2, p1, 3);
        run(p1, p2, 4);
    }
    
    public static void run(Player p, Player t, int skillIndex)
    {
        System.out.println("=================");
        p.useSkill(t, skillIndex);
        System.out.println(p1);
        System.out.println(p2);
        p.nextTurn();
    }
}
