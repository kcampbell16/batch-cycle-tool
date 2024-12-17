package gov.cms.mcs.batchtool.ui;

import java.io.IOException;
import java.util.Objects;
import java.util.Properties;
import javax.swing.*;

public class ImageIcons {

  private static final Properties properties = new Properties();

  static {
    try {
      properties.load(ImageIcons.class.getResourceAsStream("/icons.properties"));
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

  public static ImageIcon getIcon(String key) {
    String path = properties.getProperty(key);
    return (path != null)
        ? new ImageIcon(Objects.requireNonNull(ImageIcons.class.getResource(path)))
        : null;
  }
}
