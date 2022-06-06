package mgw.gameplay;

import javax.swing.Timer;
import mgw.main.Account;
import mgw.main.GameUI;
import mgw.main.HistoryLog;
import mgw.util.UtilArsa;

public final class GameManager {
    public final Account challenger, challenged;
    public final Player[] players = new Player[2];
    private final GameUI gu;
    private int turn = 1; 
    
    public GameManager(GameUI gu, Player challenger, Player challenged)
    {
        this.challenger = challenger.user;
        this.challenged = challenged.user;
        this.gu = gu;
        if (UtilArsa.roll(1, 2))
        {
            players[0] = challenger;
            players[1] = challenged;
        }
        else
        {
            players[1] = challenger;
            players[0] = challenged;
        }
        
        gu.log(players[1].user.username + " moves first");
        start();
    }
    
    private void matchCards(Player player)
    {
        gu.shuffleCard();
    }
    
    public void nextTurn()
    {
        nextTurn(getCurrentPlayer());
    }
    
    private void nextTurn(Player player)
    {
        player.nextTurn();
        // check if the game is already over
        if(!checkGameState())
        {
            ++turn;
            matchCards(getCurrentPlayer());
        }
    }
    
    public void start()
    {
        gu.initDeck();
        matchCards(players[turn%2]);
        gu.initDeck(getCurrentPlayer());
        //gu.initDeck(challenger);
    }
    
    public boolean checkGameState()
    {
        HistoryLog hl = null;
        if (players[0].getHP() == 0) {
            hl = new HistoryLog(challenger, challenged, players[1].user, turn);
        } else if (players[1].getHP() == 0) {
            hl = new HistoryLog(challenger, challenged, players[0].user, turn);
        }
        
        if (hl != null) {
            challenger.history.add(hl);
            challenged.history.add(hl);
            gu.log(hl.winner().username + " WON THE GAME!!");
            Timer t = new Timer(4000, (evt) -> {
                gu.back();
            });
            t.setRepeats(false);
            t.start();
            return true;
        }
        return false;
    }
    
    public void useCurrentPlayerSkill(Skill skill)
    {
        Player p = getCurrentPlayer();
        for (int i = 0; i < 5; i++) {
            if (p.deck[i].equals(skill)) {
                useCurrentPlayerSkill(i);
                return;
            }
        }
    }
    
    public void useCurrentPlayerSkill(int skillIndex)
    {
        gu.clearDeck();
        getCurrentPlayer().useSkill(players[(turn+1) % 2], skillIndex);
        StatusEffect temp = getCurrentPlayer().getStatusOfType("Boosted");
        if (temp != null && ((Boosted)temp).check()) 
        {
            //call method to pick moves again
        }
        else
        {
            nextTurn();
        }
    }
    
    public Player getCurrentPlayer()
    {
        return players[turn % 2];
    }
}
