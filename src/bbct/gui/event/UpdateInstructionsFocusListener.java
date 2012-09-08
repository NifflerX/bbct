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
package bbct.gui.event;

import bbct.gui.BBCTFrame;
import java.awt.Container;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.JComponent;

/**
 * TODO: JavaDoc
 *
 *
 * @author codeguru <codeguru@users.sourceforge.net>
 */
public class UpdateInstructionsFocusListener extends FocusAdapter {

    /**
     *
     * @param instr
     */
    public UpdateInstructionsFocusListener(String instr) {
        this.instr = instr;
    }

    /**
     *
     * @param fe
     */
    @Override
    public void focusGained(FocusEvent fe) {
        Container topLevelAncestor = ((JComponent) fe.getComponent()).getTopLevelAncestor();

        if (topLevelAncestor instanceof BBCTFrame) {
            ((BBCTFrame) topLevelAncestor).setInstructions(instr);
        }
    }
    private String instr = null;
}