package gov.cms.mcs.batchtool.ui;

import java.awt.Dimension;
import javax.swing.*;

public class Window extends JFrame {

  public Window() {
    setPreferredSize(new Dimension(500, 500));
    setUndecorated(true);

    UpperPanel upperPanel = new UpperPanel();

    GroupLayout layout = new GroupLayout(getContentPane());
    getContentPane().setLayout(layout);

    layout.setHorizontalGroup(
        layout
            .createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(
                upperPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));
    layout.setVerticalGroup(
        layout
            .createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(
                layout
                    .createSequentialGroup()
                    .addComponent(
                        upperPanel,
                        GroupLayout.PREFERRED_SIZE,
                        GroupLayout.DEFAULT_SIZE,
                        GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 373, Short.MAX_VALUE)));

    pack();
    setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    setLocationRelativeTo(null);
    setVisible(true);
  }
}
