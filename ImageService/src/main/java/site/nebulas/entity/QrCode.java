package site.nebulas.entity;

public class QrCode {
  private int width;
  private int height;
  private String format;
  private String content;

  public QrCode() {
  }

  public QrCode(String content) {
    this.content = content;
  }

  public int getWidth() {
    return width;
  }

  public void setWidth(int width) {
    this.width = width;
  }

  public int getHeight() {
    return height;
  }

  public void setHeight(int height) {
    this.height = height;
  }

  public String getFormat() {
    return format;
  }

  public void setFormat(String format) {
    this.format = format;
  }

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }
}
