package mgw.gameplay;

import mgw.main.Account;

public class Player {
    private Account user;
    private int hp = 100;
    private int sp = 0;
    
    public Player() {
        
    }
    public void PlusSP(){
        sp+=2;
    }
    
    public void receiveDmg(int dmg){
        hp = (hp - dmg >= 0)? hp-dmg : 0;
    }
    public void attack(Player p, Skill x){
        //p.receiveDmg(x.);
    }
    public void useSkill(Skill x){
        if(sp >= x.skillPoint)
            sp -= x.skillPoint;
    }
    
}
