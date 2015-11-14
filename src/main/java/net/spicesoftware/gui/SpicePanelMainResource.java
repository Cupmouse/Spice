package net.spicesoftware.gui;

import net.spicesoftware.api.project.resource.ResourceManager;
import net.spicesoftware.api.project.resource.ResourceTreeFolder;
import net.spicesoftware.api.util.Validate;

import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeModel;
import javax.swing.tree.TreePath;
import java.awt.event.MouseEvent;
import java.util.Arrays;
import java.util.Random;

/**
 * @author Cupmouse
 * @since 2015/06/09
 */
public class SpicePanelMainResource extends javax.swing.JPanel {

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu jMenuAdd;
    private javax.swing.JMenuItem jMenuItemAddFolder;
    private javax.swing.JMenuItem jMenuItemAddResource;
    private javax.swing.JMenuItem jMenuItemDelete;
    private javax.swing.JPopupMenu jPopupMenu;
    private javax.swing.JTree resourceTree;
    private javax.swing.JScrollPane scrollPane;
    private net.spicesoftware.gui.common.SpiceTextField searchingTextField;
    // End of variables declaration//GEN-END:variables

    private final ResourceManager resourceManager;
    private final DefaultMutableTreeNode treeRootNode;

    public SpicePanelMainResource(ResourceManager resourceManager) {
        Validate.nullNot(resourceManager);
        this.resourceManager = resourceManager;
        this.treeRootNode = new DefaultMutableTreeNode();
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu = new javax.swing.JPopupMenu();
        jMenuAdd = new javax.swing.JMenu();
        jMenuItemAddResource = new javax.swing.JMenuItem();
        jMenuItemAddFolder = new javax.swing.JMenuItem();
        jMenuItemDelete = new javax.swing.JMenuItem();
        scrollPane = new javax.swing.JScrollPane();
        resourceTree = new javax.swing.JTree();
        searchingTextField = new net.spicesoftware.gui.common.SpiceTextField();

        jMenuAdd.setText("追加");

        jMenuItemAddResource.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_R, 0));
        jMenuItemAddResource.setText("リソースの追加...");
        jMenuItemAddResource.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemAddResourceActionPerformed(evt);
            }
        });
        jMenuAdd.add(jMenuItemAddResource);

        jMenuItemAddFolder.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F, 0));
        jMenuItemAddFolder.setText("フォルダーを追加");
        jMenuItemAddFolder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemAddFolderActionPerformed(evt);
            }
        });
        jMenuAdd.add(jMenuItemAddFolder);

        jPopupMenu.add(jMenuAdd);

        jMenuItemDelete.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_D, 0));
        jMenuItemDelete.setText("削除");
        jMenuItemDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemDeleteActionPerformed(evt);
            }
        });
        jPopupMenu.add(jMenuItemDelete);

        setLayout(new java.awt.BorderLayout());

        scrollPane.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        scrollPane.setName(""); // NOI18N
        scrollPane.setRequestFocusEnabled(false);

        resourceTree.setModel(new DefaultTreeModel(treeRootNode));
        resourceTree.setComponentPopupMenu(jPopupMenu);
        resourceTree.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                resourceTreeMouseClicked(evt);
            }
        });
        scrollPane.setViewportView(resourceTree);

        add(scrollPane, java.awt.BorderLayout.CENTER);

        searchingTextField.setToolTipText("");
        searchingTextField.setPlaceHolder("検索する条件を入力...");
        add(searchingTextField, java.awt.BorderLayout.PAGE_START);
        searchingTextField.getAccessibleContext().setAccessibleName("");
    }// </editor-fold>//GEN-END:initComponents

    private void resourceTreeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_resourceTreeMouseClicked
        if (evt.getButton() == MouseEvent.BUTTON3) {
//            jPopupMenu.show(this, evt.getX(), evt.getY());
        }
    }//GEN-LAST:event_resourceTreeMouseClicked

    private void jMenuItemAddResourceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemAddResourceActionPerformed

    }//GEN-LAST:event_jMenuItemAddResourceActionPerformed

    private void jMenuItemAddFolderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemAddFolderActionPerformed
        String name = "te" + new Random().nextInt();
        ResourceTreeFolder newFolder = resourceManager.getRootOfResourceTree().createNewFolder(name);

        TreePath selectionPath = resourceTree.getSelectionPath();
        DefaultTreeModel model = ((DefaultTreeModel) resourceTree.getModel());

        DefaultMutableTreeNode selectedNode;
        if (selectionPath != null) {
            selectedNode = ((DefaultMutableTreeNode) selectionPath.getLastPathComponent());
        } else {
            selectedNode = treeRootNode;
        }

        selectedNode.insert(new DefaultMutableTreeNode(name), selectedNode.getChildCount());

        model.nodeStructureChanged(selectedNode);
        System.out.println(newFolder);
    }//GEN-LAST:event_jMenuItemAddFolderActionPerformed

    private void jMenuItemDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemDeleteActionPerformed
        DefaultMutableTreeNode selectedNode = (DefaultMutableTreeNode) resourceTree.getSelectionPath().getLastPathComponent();

        if (selectedNode.isRoot()) {
            return;
        }
        DefaultTreeModel model = (DefaultTreeModel) resourceTree.getModel();
//        selectedNode.removeFromParent();

        model.removeNodeFromParent(selectedNode);
//        model.nodeChanged(selectedNode.getParent());
    }//GEN-LAST:event_jMenuItemDeleteActionPerformed
}
