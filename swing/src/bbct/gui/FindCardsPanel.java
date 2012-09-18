/*
 * This file is part of BBCT.
 *
 * Copyright 2012 codeguru <codeguru@users.sourceforge.net>
 *
 * BBCT is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * BBCT is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package bbct.gui;

import bbct.data.BaseballCard;
import bbct.data.BaseballCardIO;
import bbct.exceptions.BBCTIOException;
import bbct.exceptions.InputException;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Container;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;

/**
 * {@link FindCardsPanel} contains a {@link FindCardsByPanel} and two buttons,
 * "Find" and "Back". The {@link FindCardsByPanel} defines the criteria and
 * parameters used to find baseball card data in the underlying storage
 * mechanism. The "Find" button executes
 * {@link FindCardsByPanel#getBaseballCards()} and displays the returned data in
 * a {@link EditCardsPanel}. The "Back" button returns to the
 * {@link FindCardsMenuPanel}.
 *
 * @author codeguru <codeguru@users.sourceforge.net>
 */
public class FindCardsPanel extends JPanel {

    /**
     * Creates a new {@link FindCardsPanel}.
     *
     * @param bcio The {@link BaseballCardIO} object which is used to search for
     * baseball cards using the criteria input by the user.
     * @param inputPanel The panel containing input controls which vary
     * depending on the exact criteria used to search for cards.
     */
    public FindCardsPanel(BaseballCardIO bcio, FindCardsByPanel inputPanel) {
        this.bcio = bcio;
        this.inputPanel = inputPanel;

        this.initComponents();
    }

    private void initComponents() {
        this.setLayout(new java.awt.BorderLayout());

        this.add(this.inputPanel, BorderLayout.CENTER);

        JPanel buttonsPanel = new JPanel();
        
        final JButton findButton = new JButton("Find");
        // TODO: Don't create Font objects.
        findButton.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        findButton.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    List<BaseballCard> cards = FindCardsPanel.this.inputPanel.getBaseballCards();

                    if (cards.isEmpty()) {
                        JOptionPane.showMessageDialog(FindCardsPanel.this, "No cards found.", "No cards found.", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JPanel editCardsPanel = new EditCardsPanel(cards, FindCardsPanel.this.bcio);
                        Container parent = FindCardsPanel.this.getParent();
                        CardLayout cl = (CardLayout) parent.getLayout();

                        parent.add(editCardsPanel, BBCTFrame.EDIT_CARDS_PANEL_NAME);
                        cl.show(parent, BBCTFrame.EDIT_CARDS_PANEL_NAME);
                    }
                } catch (InputException ex) {
                    JOptionPane.showMessageDialog(FindCardsPanel.this, ex.getMessage(), "Invalid Input", JOptionPane.ERROR_MESSAGE);
                    Logger.getLogger(FindCardsPanel.class.getName()).log(Level.INFO, null, ex);
                } catch (BBCTIOException ex) {
                    Logger.getLogger(FindCardsPanel.class.getName()).log(Level.SEVERE, ex.getMessage(), ex);
                    JOptionPane.showMessageDialog(FindCardsPanel.this, ex.getMessage(), "I/O Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        buttonsPanel.add(findButton);

        JButton backButton = new JButton("Back");
        backButton.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        // TODO: This code appears in almost every JPanel subclass.
        backButton.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Container parent = FindCardsPanel.this.getParent();
                CardLayout cl = (CardLayout) parent.getLayout();

                cl.show(parent, BBCTFrame.FIND_CARDS_MENU_CARD_NAME);
            }
        });
        buttonsPanel.add(backButton);

        this.add(buttonsPanel, java.awt.BorderLayout.SOUTH);
        // TODO: This code appears in nearly every JPanel subclass.
        this.addAncestorListener(new AncestorListener() {
            @Override
            public void ancestorMoved(AncestorEvent evt) {
            }

            @Override
            public void ancestorAdded(AncestorEvent evt) {
                Container topLevelAncestor = FindCardsPanel.this.getTopLevelAncestor();

                if (topLevelAncestor instanceof BBCTFrame) {
                    BBCTFrame frame = (BBCTFrame) topLevelAncestor;
                    frame.setDefaultButton(findButton);
                }
            }

            @Override
            public void ancestorRemoved(AncestorEvent evt) {
            }
        });
    }
    private BaseballCardIO bcio = null;
    private FindCardsByPanel inputPanel = null;
}