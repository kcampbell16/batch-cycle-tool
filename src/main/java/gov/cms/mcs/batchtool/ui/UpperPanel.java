package gov.cms.mcs.batchtool.ui;

import java.awt.event.MouseEvent;
import java.util.function.Consumer;
import javax.swing.*;

public class UpperPanel extends JPanel {

  private GroupLayout groupLayout;

  private InteractiveLabel exitLabel;
  private InteractiveLabel maximizeLabel;
  private InteractiveLabel minimizeLabel;

  public UpperPanel() {
    createComponents();
    createLayout();

    setLayout(groupLayout);
  }

  private void createComponents() {
    exitLabel = new InteractiveLabel("exit", "exit-hovered");
    exitLabel.setOnMouseClicked(event -> System.exit(0));

    maximizeLabel = new InteractiveLabel("maximize", "maximize-hovered");
    maximizeLabel.setOnMouseClicked(getWindowEvent(JFrame.MAXIMIZED_BOTH));

    minimizeLabel = new InteractiveLabel("minimize", "minimize-hovered");
    minimizeLabel.setOnMouseClicked(getWindowEvent(JFrame.ICONIFIED));
  }

  private Consumer<MouseEvent> getWindowEvent(int state) {
    return event -> {
      Window window = (Window) SwingUtilities.getWindowAncestor(event.getComponent());
      if (window != null) {
        window.setExtendedState(state);
      }
    };
  }

  private void createLayout() {
    groupLayout = new GroupLayout(this);
    groupLayout.setHorizontalGroup(
        groupLayout
            .createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(
                GroupLayout.Alignment.TRAILING,
                groupLayout
                    .createSequentialGroup()
                    .addContainerGap(565, Short.MAX_VALUE)
                    .addComponent(minimizeLabel)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(maximizeLabel)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(exitLabel)
                    .addContainerGap()));
    groupLayout.setVerticalGroup(
        groupLayout
            .createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(
                groupLayout
                    .createSequentialGroup()
                    .addContainerGap()
                    .addGroup(
                        groupLayout
                            .createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(minimizeLabel)
                            .addComponent(maximizeLabel)
                            .addComponent(exitLabel))
                    .addContainerGap(43, Short.MAX_VALUE)));
  }
}
