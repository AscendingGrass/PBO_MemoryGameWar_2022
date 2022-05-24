package mgw.main;

import mgw.gameplay.*;

public class Account{
    public final String username;
    public Skill[] deck = new Skill [5];
    public Account(String username) {
        this.username = username;
    }
    
    public boolean deckIsNotFilled(){
        for(Skill i : deck)
            if (i == null) return true;

        return false;
    }

    @Override
    public String toString() {
        return username + "!";
    }
    
}
