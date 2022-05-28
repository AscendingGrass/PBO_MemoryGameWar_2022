package mgw.main;

import mgw.gameplay.*;

public class Account{
    public final String username;
    public final Skill[] deck = new Skill [5];
    public Account(String username) {
        this.username = username;
    }
    
    public boolean deckIsNotFilled(){
        for(Skill i : deck)
            if (i == null) return true;

        return false;
    }
    public void isiDeck(Deck [] d){
        for(int i =0; i < deck.length; i++)
            deck[i] = (Skill) d[i].skill;
    }
    public void testIsiDeck(){
        for(Skill i : deck)
            if(i != null)System.out.println(i.name);
    }
    @Override
    public String toString() {
        return username + "!";
    }
    
}
