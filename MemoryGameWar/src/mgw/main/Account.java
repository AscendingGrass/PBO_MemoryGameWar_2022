package mgw.main;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import mgw.gameplay.*;

public class Account implements Serializable{
    public final String username;
    public ArrayList<HistoryLog> history = new ArrayList();
    public Skill[] listSkill;
    public boolean[] skillNotUsed = new boolean[Skill.list.length];
    //public SkillCard [] cardSkill;
    //public Deck [] cardDeck;
    public int counter = 0;
    public Account(String username) {
        this.username = username;
        listSkill = new Skill [5];
        Arrays.fill(skillNotUsed, true);
        //cardSkill = new SkillCard[Skill.list.length];
        //cardDeck  = new Deck[5];
        //initComponent();
    }/*
    public void initComponent(){
        for(int i = 0; i < cardSkill.length; i++){
            cardSkill[i] = new SkillCard(Skill.list[i]);
            if(i < 5){
                cardDeck[i] = new Deck();
            }
        }
    }*/
    public void cardDeck(Deck[] d){
        for(int i = 0; i < d.length; i++){
            d[i] = (listSkill[i] == null? new Deck() : new Deck(listSkill[i]));
        }
        
    }
    public void cardSkill(SkillCard[] s){
        for(int i = 0; i < s.length; i++){
            s[i] = new SkillCard(Skill.list[i], !skillNotUsed[i]);
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
    public void isiDeck(Deck[] d, SkillCard [] c){
        for(int i = 0; i < c.length; i++){
            skillNotUsed[i] = !c[i].clicked;
            if(i < 5) listSkill[i] = d[i].skill;
        }
    }
    
    public void testIsiDeck(){
        System.out.println(username);
        for(Skill i : listSkill)
            if(i != null)System.out.println(i.name);
    }
    
    @Override
    public String toString() {
        return username + "!";
    }
    
}
