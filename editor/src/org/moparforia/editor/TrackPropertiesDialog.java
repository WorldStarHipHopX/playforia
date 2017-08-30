/*
 * Created by JFormDesigner on Sat Aug 10 10:05:01 CEST 2013
 */

package org.moparforia.editor;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

/**
 * @author Johan Ljungberg
 */
public class TrackPropertiesDialog extends JDialog {
    public TrackPropertiesDialog(Frame owner) {
        super(owner);
        initComponents();
        loadValues();
    }

    public TrackPropertiesDialog(Dialog owner) {
        super(owner);
        initComponents();
    }

    private void loadValues() {
        textTrackName.setText(((TrackEditor)getOwner()).getMapCanvas().getTrackName());
        comboTrackCategory.setSelectedIndex(((TrackEditor)getOwner()).getMapCanvas().getTrackCategory() - 1);
    }

    private void okButtonActionPerformed(ActionEvent e) {
        if(textTrackName.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Track name cannot be empty!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        ((TrackEditor)getOwner()).getMapCanvas().updateProperties(textTrackName.getText(), comboTrackCategory.getSelectedIndex() + 1);
        this.dispose();
    }

    private void cancelButtonActionPerformed(ActionEvent e) {
        this.dispose();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        dialogPane = new JPanel();
        contentPanel = new JPanel();
        panel2 = new JPanel();
        label3 = new JLabel();
        textTrackName = new JTextField();
        panel1 = new JPanel();
        label2 = new JLabel();
        comboTrackCategory = new JComboBox();
        buttonBar = new JPanel();
        okButton = new JButton();
        cancelButton = new JButton();

        //======== this ========
        setTitle("Track Properties");
        setAlwaysOnTop(true);
        setResizable(false);
        setModal(true);
        setModalExclusionType(Dialog.ModalExclusionType.APPLICATION_EXCLUDE);
        Container contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());

        //======== dialogPane ========
        {
            dialogPane.setBorder(new EmptyBorder(12, 12, 12, 12));
            dialogPane.setLayout(new BorderLayout());

            //======== contentPanel ========
            {
                contentPanel.setLayout(new GridLayout(0, 1));

                //======== panel2 ========
                {
                    panel2.setLayout(new FlowLayout());

                    //---- label3 ----
                    label3.setText("Track Name:");
                    panel2.add(label3);

                    //---- textTrackName ----
                    textTrackName.setPreferredSize(new Dimension(200, 20));
                    panel2.add(textTrackName);
                }
                contentPanel.add(panel2);

                //======== panel1 ========
                {
                    panel1.setLayout(new FlowLayout());

                    //---- label2 ----
                    label2.setText("Track Category");
                    panel1.add(label2);

                    //---- comboTrackCategory ----
                    comboTrackCategory.setPreferredSize(new Dimension(200, 20));
                    comboTrackCategory.setModel(new DefaultComboBoxModel(new String[] {
                        "Basic",
                        "Traditional",
                        "Modern",
                        "Hole In One",
                        "Short",
                        "Long",
                        "Custom"
                    }));
                    panel1.add(comboTrackCategory);
                }
                contentPanel.add(panel1);
            }
            dialogPane.add(contentPanel, BorderLayout.CENTER);

            //======== buttonBar ========
            {
                buttonBar.setBorder(new EmptyBorder(12, 0, 0, 0));
                buttonBar.setLayout(new GridBagLayout());
                ((GridBagLayout)buttonBar.getLayout()).columnWidths = new int[] {0, 85, 80};
                ((GridBagLayout)buttonBar.getLayout()).columnWeights = new double[] {1.0, 0.0, 0.0};

                //---- okButton ----
                okButton.setText("OK");
                okButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        okButtonActionPerformed(e);
                    }
                });
                buttonBar.add(okButton, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 0, 5), 0, 0));

                //---- cancelButton ----
                cancelButton.setText("Cancel");
                cancelButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        cancelButtonActionPerformed(e);
                    }
                });
                buttonBar.add(cancelButton, new GridBagConstraints(2, 0, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 0, 0), 0, 0));
            }
            dialogPane.add(buttonBar, BorderLayout.SOUTH);
        }
        contentPane.add(dialogPane, BorderLayout.CENTER);
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JPanel dialogPane;
    private JPanel contentPanel;
    private JPanel panel2;
    private JLabel label3;
    private JTextField textTrackName;
    private JPanel panel1;
    private JLabel label2;
    private JComboBox comboTrackCategory;
    private JPanel buttonBar;
    private JButton okButton;
    private JButton cancelButton;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
