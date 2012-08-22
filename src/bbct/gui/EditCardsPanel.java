package bbct.gui;

import bbct.data.BaseballCard;
import bbct.data.BaseballCardIO;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * TODO: JavaDoc
 *
 * @author codeguru <codeguru@users.sourceforge.net>
 */
public class EditCardsPanel extends javax.swing.JPanel {

    /**
     * Creates new {@link EditCardPanel}.
     */
    public EditCardsPanel() {
        initComponents();
    }

    /**
     * Creates new {@link EditCardPanel}.
     * @param cards
     * @param bcio  
     */
    public EditCardsPanel(List<BaseballCard> cards, BaseballCardIO bcio) {
        this.bcio = bcio;
        
        initComponents();
        
        for (BaseballCard card : cards) {
            JPanel cardDetailsPanel = new CardDetailsPanel(card, false);
            
            this.allCardDetailsPanel.add(cardDetailsPanel);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.JPanel buttonsPanel = new javax.swing.JPanel();
        javax.swing.JButton prevButton = new javax.swing.JButton();
        javax.swing.JButton nextButton = new javax.swing.JButton();
        javax.swing.JButton doneButton = new javax.swing.JButton();
        allCardDetailsPanel = new javax.swing.JPanel();

        setMinimumSize(new java.awt.Dimension(370, 350));
        setPreferredSize(new java.awt.Dimension(370, 350));
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });
        setLayout(new java.awt.BorderLayout());

        prevButton.setText("<-- Previous");
        prevButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                prevButtonActionPerformed(evt);
            }
        });
        buttonsPanel.add(prevButton);

        nextButton.setText("Next -->");
        nextButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nextButtonActionPerformed(evt);
            }
        });
        buttonsPanel.add(nextButton);

        doneButton.setText("Done");
        doneButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                doneButtonActionPerformed(evt);
            }
        });
        buttonsPanel.add(doneButton);

        add(buttonsPanel, java.awt.BorderLayout.SOUTH);

        allCardDetailsPanel.setLayout(new java.awt.CardLayout());
        add(allCardDetailsPanel, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
        JFrame frame = (JFrame) this.getTopLevelAncestor();

        frame.setTitle(GUIResources.EDIT_CARD_PANEL_TITLE);
    }//GEN-LAST:event_formComponentShown

    private void prevButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_prevButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_prevButtonActionPerformed

    private void nextButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nextButtonActionPerformed

    private void doneButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_doneButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_doneButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel allCardDetailsPanel;
    // End of variables declaration//GEN-END:variables

    BaseballCardIO bcio = null;
}