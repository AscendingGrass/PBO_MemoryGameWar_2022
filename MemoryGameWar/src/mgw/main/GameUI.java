/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package mgw.main;
import javax.swing.Timer;
import mgw.gameplay.GameManager;
import mgw.util.UtilArsa;


/**
 *
 * @author mejap
 */
public class GameUI extends javax.swing.JPanel {
    public static GameUI activeGameUI;
    public Program parent;
    private GameManager gm;
    Deck2[] deck = new Deck2[5];
    Card[] card = new Card[20];
    Card opened = null;
    
    public GameUI() {
        initComponents(); 
        initDeck();
        shuffleCard();
    }
   
    
    public void log(String value)
    {
        jta_Log.append(value + "\n");
    }
    
    public void clearDeck()
    {
       for(int i = 0; i < deck.length; i++)
           deck[i] = new Deck2();
    }
    
    public void showDeck()
    {
        
    }
    
    public void initDeck(){
        jp_PlayListOfDeck.removeAll();
        jp_PlayListOfDeck.repaint();
        jp_PlayListOfDeck.revalidate();
        
        int x = 10, y = 7;
        for(int i = 0; i < deck.length; i++){
            deck[i] = new Deck2();
            deck[i].setBounds(x,y, 114, 114);
            jp_PlayListOfDeck.add(deck[i]);
            x+= 125;
        }
    }
    public void initDeck(Account active){
        for(int i = 0; i < deck.length; i++){
            deck[i].setLogo(active.listSkill[i].img);
            deck[i].skill = active.listSkill[i];
            System.out.println("berhasil");
        }
        checkDeck();
    }
    
    public void shuffleCard(){
        jp_TwinsCard.removeAll();
        jp_TwinsCard.repaint();
        jp_TwinsCard.revalidate();
        opened = null;
        for (int i = 0; i < Card.resourceImages.length * 2; i++) {
            card[i] = new Card(Card.resourceImages[i/2]);
        }
        UtilArsa.shuffle(card);
        checkCard();
        int x = 25, y = 6;
        for(int i = 0; i < card.length; i++){
            card[i].setBounds(x, y, 130, 130);
            jp_TwinsCard.add(card[i]);
            x+= 180;
            if(x  > 900){
                x = 25;
                y += 136;
            }
        }
        Timer timer = new Timer(5000, (evt)->{
            flipShutAllCards();
        });
        timer.setRepeats(false);
        timer.start();
    }
    
    private void checkCard(){
        for (Card i : card) {
            i.addMouseListener(new java.awt.event.MouseAdapter() {
                @Override
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    if(evt.getSource() instanceof Card c && !c.flip){
                        c.flipOpen();
                        if (opened == null) {
                            opened = c;
                        }
                        else if(opened.equals(c))
                        {
                            gm.getCurrentPlayer().addSP(2);
                            opened.setIconNull();
                            c.setIconNull();
                            opened = null;
                            if (allCardsArePaired()) {
                                pickSkill();
                            }
                        }
                        else
                        {
                            pickSkill();
                        }
                    }
                }
                @Override
                public void mouseEntered(java.awt.event.MouseEvent evt) {
                    if(evt.getSource() instanceof Card c){
                        
                    }
                }
                @Override
                public void mouseExited(java.awt.event.MouseEvent evt) {
                    if(evt.getSource() instanceof Card c){
                        
                    }
                }
            });
        }
    }
    
    public boolean allCardsArePaired()
    {
        for (Card c : card) {
            if (!c.paired) {
                return false;
            }
        }
        return true;
    }
    
    public void pickSkill()
    {
        setAllCardsNull();
        initDeck(gm.getCurrentPlayer().user);
        //shuffleCard();
    }
    
    public void flipShutAllCards()
    {
        for (Card c : card) {
            c.flipShut();
        }
    }
    
    public void setAllCardsNull()
    {
        for (Card c : card) {
            c.setIconNull();
        }
    }
    
    public void checkDeck(){
        for (Deck2 deck1 : deck) {
            deck1.addMouseListener(new java.awt.event.MouseAdapter() {
                @Override
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    if(evt.getSource() instanceof Deck2 d){
                        d.jLabel.setIcon(null);
                    }
                }
                @Override
                public void mouseEntered(java.awt.event.MouseEvent evt) {
                    if(evt.getSource() instanceof Deck2 d){
                        //SkillLabel.setText(d.skill.name);
                        //DescriptionLabel.setText(d.skill.description);
                    }
                }
                @Override
                public void mouseExited(java.awt.event.MouseEvent evt) {
                    if(evt.getSource() instanceof Deck2 d){
                        SkillLabel.setText("Skill Name");
                        DescriptionLabel.setText("Description");
                    }
                }
            });
        }
    }
    public void setGameManager(GameManager gm)
    {
        this.gm = gm;
        statusBarLeft1.setPlayer(gm.players[1]);
        statusBarRight1.setPlayer(gm.players[0]);
        updateStatusBars();
    }
    
    public void updateStatusBars()
    {
        statusBarLeft1.update();
        statusBarRight1.update();
    }
    
    public void setProgram(Program p)
    {
        parent = p;
    }
    
    public GameManager getGM()
    {
        return gm;
    }
    
    public void back()
    {
        parent.toMainMenu();
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jp_PlayListOfDeck = new javax.swing.JPanel();
        jp_TwinsCard = new javax.swing.JPanel();
        statusBarLeft1 = new mgw.main.StatusBarLeft();
        statusBarRight1 = new mgw.main.StatusBarRight();
        jp_Description = new javax.swing.JPanel();
        jl_PlayRound = new javax.swing.JLabel();
        jl_NamePlayer = new javax.swing.JLabel();
        jp_SkipButton = new javax.swing.JPanel();
        jl_Skip = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        SkillLabel = new javax.swing.JLabel();
        DescriptionLabel = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jta_Log = new javax.swing.JTextArea();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setBackground(new java.awt.Color(0, 0, 0));

        jp_PlayListOfDeck.setBackground(new java.awt.Color(102, 102, 102));
        jp_PlayListOfDeck.setPreferredSize(new java.awt.Dimension(637, 140));

        javax.swing.GroupLayout jp_PlayListOfDeckLayout = new javax.swing.GroupLayout(jp_PlayListOfDeck);
        jp_PlayListOfDeck.setLayout(jp_PlayListOfDeckLayout);
        jp_PlayListOfDeckLayout.setHorizontalGroup(
            jp_PlayListOfDeckLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 637, Short.MAX_VALUE)
        );
        jp_PlayListOfDeckLayout.setVerticalGroup(
            jp_PlayListOfDeckLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 128, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jp_TwinsCardLayout = new javax.swing.GroupLayout(jp_TwinsCard);
        jp_TwinsCard.setLayout(jp_TwinsCardLayout);
        jp_TwinsCardLayout.setHorizontalGroup(
            jp_TwinsCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 902, Short.MAX_VALUE)
        );
        jp_TwinsCardLayout.setVerticalGroup(
            jp_TwinsCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 451, Short.MAX_VALUE)
        );

        jp_Description.setPreferredSize(new java.awt.Dimension(300, 130));

        jl_PlayRound.setFont(new java.awt.Font("Segoe UI Symbol", 0, 18)); // NOI18N
        jl_PlayRound.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jl_PlayRound.setText("Round");
        jl_PlayRound.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        jl_NamePlayer.setFont(new java.awt.Font("Segoe UI Symbol", 0, 18)); // NOI18N
        jl_NamePlayer.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jl_NamePlayer.setText("Name");

        jp_SkipButton.setBackground(new java.awt.Color(51, 51, 255));

        jl_Skip.setFont(new java.awt.Font("Segoe UI Symbol", 0, 18)); // NOI18N
        jl_Skip.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jl_Skip.setText("Skip");

        javax.swing.GroupLayout jp_SkipButtonLayout = new javax.swing.GroupLayout(jp_SkipButton);
        jp_SkipButton.setLayout(jp_SkipButtonLayout);
        jp_SkipButtonLayout.setHorizontalGroup(
            jp_SkipButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jl_Skip, javax.swing.GroupLayout.DEFAULT_SIZE, 93, Short.MAX_VALUE)
        );
        jp_SkipButtonLayout.setVerticalGroup(
            jp_SkipButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jl_Skip, javax.swing.GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jp_DescriptionLayout = new javax.swing.GroupLayout(jp_Description);
        jp_Description.setLayout(jp_DescriptionLayout);
        jp_DescriptionLayout.setHorizontalGroup(
            jp_DescriptionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jp_DescriptionLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jp_DescriptionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jl_NamePlayer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jp_DescriptionLayout.createSequentialGroup()
                        .addGap(0, 91, Short.MAX_VALUE)
                        .addGroup(jp_DescriptionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jp_SkipButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jl_PlayRound))
                        .addGap(0, 92, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jp_DescriptionLayout.setVerticalGroup(
            jp_DescriptionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jp_DescriptionLayout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addComponent(jl_NamePlayer)
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jl_PlayRound, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jp_SkipButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel2.setFont(new java.awt.Font("DialogInput", 0, 18)); // NOI18N

        SkillLabel.setFont(new java.awt.Font("DialogInput", 0, 24)); // NOI18N
        SkillLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        SkillLabel.setText("Skill Name");

        DescriptionLabel.setFont(new java.awt.Font("DialogInput", 0, 18)); // NOI18N
        DescriptionLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        DescriptionLabel.setText("Description");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(DescriptionLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(SkillLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 246, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(SkillLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(DescriptionLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 317, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(172, Short.MAX_VALUE))
        );

        jPanel3.setPreferredSize(new java.awt.Dimension(350, 800));

        jta_Log.setEditable(false);
        jta_Log.setColumns(20);
        jta_Log.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jta_Log.setRows(5);
        jta_Log.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jta_Log.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jta_Log.setHighlighter(null);
        jScrollPane1.setViewportView(jta_Log);
        jScrollPane1.setBorder(null);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 270, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
        );

        jButton1.setText("back");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });

        jButton2.setText("Clear");
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton2MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(14, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jp_PlayListOfDeck, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(139, 139, 139))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jp_TwinsCard, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)))
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(statusBarLeft1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jp_Description, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(statusBarRight1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButton2, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(statusBarLeft1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(statusBarRight1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jp_Description, javax.swing.GroupLayout.PREFERRED_SIZE, 132, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addGap(18, 18, 18)
                        .addComponent(jButton2)))
                .addGap(13, 13, 13)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jp_TwinsCard, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(jp_PlayListOfDeck, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 597, Short.MAX_VALUE))
                .addGap(24, 24, 24))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        // TODO add your handling code here:
        back();
    }//GEN-LAST:event_jButton1MouseClicked

    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseClicked
        // TODO add your handling code here:
        clearDeck();
    }//GEN-LAST:event_jButton2MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel DescriptionLabel;
    private javax.swing.JLabel SkillLabel;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel jl_NamePlayer;
    private javax.swing.JLabel jl_PlayRound;
    private javax.swing.JLabel jl_Skip;
    private javax.swing.JPanel jp_Description;
    private javax.swing.JPanel jp_PlayListOfDeck;
    private javax.swing.JPanel jp_SkipButton;
    private javax.swing.JPanel jp_TwinsCard;
    private javax.swing.JTextArea jta_Log;
    public mgw.main.StatusBarLeft statusBarLeft1;
    public mgw.main.StatusBarRight statusBarRight1;
    // End of variables declaration//GEN-END:variables
}
