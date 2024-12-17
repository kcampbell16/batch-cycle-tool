package gov.cms.mcs.batchtool.ui;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.function.Consumer;
import javax.swing.*;
import lombok.Setter;

public class InteractiveLabel extends JLabel {

  private final String unHoveredIconProperty;
  private final String hoveredIconProperty;

  @Setter private Consumer<MouseEvent> onMouseClicked;

  public InteractiveLabel(String unHoveredIconProperty, String hoveredIconProperty) {
    this.unHoveredIconProperty = unHoveredIconProperty;
    this.hoveredIconProperty = hoveredIconProperty;

    setIcon(ImageIcons.getIcon(unHoveredIconProperty));
    addMouseListener(new CompositeMouseListener());
  }

  private class CompositeMouseListener implements MouseListener {

    /**
     * Invoked when the mouse button has been clicked (pressed and released) on a component.
     *
     * @param e the event to be processed
     */
    @Override
    public void mouseClicked(MouseEvent e) {
      if (onMouseClicked != null) onMouseClicked.accept(e);
    }

    /**
     * Invoked when the mouse enters a component.
     *
     * @param e the event to be processed
     */
    @Override
    public void mouseEntered(MouseEvent e) {
      if (hoveredIconProperty != null) setIcon(ImageIcons.getIcon(hoveredIconProperty));
    }

    /**
     * Invoked when the mouse exits a component.
     *
     * @param e the event to be processed
     */
    @Override
    public void mouseExited(MouseEvent e) {
      if (unHoveredIconProperty != null) setIcon(ImageIcons.getIcon(unHoveredIconProperty));
    }

    /**
     * Invoked when a mouse button has been pressed on a component.
     *
     * @param e the event to be processed
     */
    @Override
    public void mousePressed(MouseEvent e) {
      // Stub to match interface
    }

    /**
     * Invoked when a mouse button has been released on a component.
     *
     * @param e the event to be processed
     */
    @Override
    public void mouseReleased(MouseEvent e) {
      // Stub to match interface
    }
  }
}
