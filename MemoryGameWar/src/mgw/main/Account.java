package mgw.main;

import java.util.ArrayList;
import mgw.gameplay.*;

public class Account{
    public final String username;
    public ArrayList<HistoryLog> history = new ArrayList();
    public Skill[] listSkill;
    public SkillCard [] cardSkill;
    public Deck [] cardDeck;
    public int counter = 0;
    public Account(String username) {
        this.username = username;
        listSkill = new Skill [5];
        cardSkill = new SkillCard[Skill.list.length];
        cardDeck  = new Deck[5];
        initComponent();
    }
    public void initComponent(){
        for(int i = 0; i < cardSkill.length; i++){
            cardSkill[i] = new SkillCard(Skill.list[i]);
            if(i < 5){
                cardDeck[i] = new Deck();
            }
        }
    }
    public boolean deckIsNotFilled(){
        for(Skill i : listSkill)
            if (i == null) return true;

        return false;
    }
    public boolean listSkillEmpty(){
        return listSkill == null;
    }
    public void isiDeck(Deck[] d){
        int j = 0;
        for(Deck i : d){
            listSkill[j++] = i.skill;
        }
    }
    
    public void testIsiDeck(){
        for(Skill i : listSkill)
            if(i != null)System.out.println(i.name);
    }
    
    @Override
    public String toString() {
        return username + "!";
    }
    
}
