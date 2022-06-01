package mgw.main;

import mgw.gameplay.*;

public class Account{
    public final String username;
    public Skill[] deck;
    public Account(String username) {
        this.username = username;
        deck = new Skill [5];
    }
    
    public boolean deckIsNotFilled(){
        for(Skill i : deck)
            if (i == null) return true;

        return false;
    }
    
    public void isiDeck(Deck[] d){
        int j = 0;
        for(Deck i : d){
            deck[j++] = i.skill;
        }
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
