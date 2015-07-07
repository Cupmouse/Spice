/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.spicesoftware.gui.common;

import net.spicesoftware.api.gui.common.CopyableLabel;
import net.spicesoftware.api.util.gui.GUIUtil;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * @since 2015/07/05
 */
public class SpiceCopyableLabel extends JLabel implements CopyableLabel {

    private JPopupMenu jPopupMenu;

    public SpiceCopyableLabel(String text, Icon icon, int horizontalAlignment) {
        super(text, icon, horizontalAlignment);
        addCopyListener();
    }

    public SpiceCopyableLabel(String text, int horizontalAlignment) {
        super(text, horizontalAlignment);
        addCopyListener();

    }

    public SpiceCopyableLabel(String text) {
        super(text);
        addCopyListener();
    }

    public SpiceCopyableLabel(Icon image, int horizontalAlignment) {
        super(image, horizontalAlignment);
        addCopyListener();
    }

    public SpiceCopyableLabel(Icon image) {
        super(image);
        addCopyListener();
    }

    public SpiceCopyableLabel() {
        addCopyListener();
    }

    private void addCopyListener() {
        jPopupMenu = new JPopupMenu();
        JMenuItem menuItemCopy = new JMenuItem("コピー");
        menuItemCopy.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GUIUtil.copyToClipboard(getText());
            }
        });
        jPopupMenu.add(menuItemCopy);

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                labelClicked(e);
            }
        });
    }

    private void labelClicked(MouseEvent mouseEvent) {
        jPopupMenu.show(this, mouseEvent.getX(), mouseEvent.getY());
    }


}
