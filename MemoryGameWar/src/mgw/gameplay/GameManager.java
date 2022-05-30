package mgw.gameplay;

import mgw.util.UtilArsa;

public class GameManager {
    private final Player[] players = new Player[2];
    private int turn = 1; 
    
    public GameManager(Player player1, Player player2)
    {
        if (UtilArsa.roll(1, 2))
        {
            players[0] = player1;
            players[1] = player2;
        }
        else
        {
            players[1] = player1;
            players[0] = player2;
        }
    }
    
    private void matchCards(Player player)
    {
        
    }
    
    private void nextTurn(Player player)
    {
        player.nextTurn();
        matchCards(players[++turn % 2]);
    }
    
    public void start()
    {
        matchCards(players[turn%2]);
    }
    
    public void useCurrentPlayerSkill(int skillIndex)
    {
        players[turn % 2].useSkill(players[(turn+1) % 2], skillIndex);
        StatusEffect temp = getCurrentPlayer().getStatusOfType("Boosted");
        if (temp != null && ((Boosted)temp).check()) 
        {
            //call method to pick moves again
        }
        else
        {
            nextTurn(players[turn%2]);
        }
    }
    
    public Player getCurrentPlayer()
    {
        return players[turn % 2];
    }
}
