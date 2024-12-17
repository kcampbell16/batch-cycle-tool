package gov.cms.mcs.batchtool;

import gov.cms.mcs.batchtool.ui.Window;
import javax.swing.SwingUtilities;

public class Main {
  public static void main(String[] args) {
    SwingUtilities.invokeLater(Window::new);
  }
}
