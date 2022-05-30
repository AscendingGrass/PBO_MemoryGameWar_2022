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
    static Player p3 = new Player(new Account("p3"));
    
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
        p3.deck[0] = Skill.list[10]; //Recover
        p3.deck[1] = Skill.list[11]; //QuickSand
        p3.deck[2] = Skill.list[12]; //TrapHole
        p3.deck[3] = Skill.list[13]; //MirrorImage
        p3.deck[4] = Skill.list[0]; //
        p1.addSP(100);
        p2.addSP(100);
        p3.addSP(100);
        
        System.out.println();
        
        printInfo();
        
        run(p1, p2, 0);        
        run(p1, p2, 0);        
        run(p1, p2, 0);    
        
        run(p2, p1, 0);
        run(p1, p2, 1);
        run(p2, p1, 1);
        run(p1, p2, 3);
        
        run(p2, p1, 3);
        run(p2, p1, 3);
        
        run(p1, p2, 0);
        run(p2, p1, 4);
        run(p1, p2, 0);
        run(p2, p1, 4);
        run(p1, p2, 2);
        run(p2, p1, 4);
        
        run(p3, p2, 1);
        p2.addSP(100);
        run(p2, p3, 0);
        System.out.println("=================");
        printInfo();
        
    }
    
    public static void run(Player p, Player t, int skillIndex)
    {
        System.out.println("=================");
        p.useSkill(t, skillIndex);
        printInfo();
        p.nextTurn();
    }
    
    public static void nextTurn(Player p)
    {
        System.out.println("=================");
        printInfo();
        p.nextTurn();
    }
    
    public static void printInfo()
    {
        System.out.println(p1);
        System.out.println(p2);
        System.out.println(p3);
    }
}
