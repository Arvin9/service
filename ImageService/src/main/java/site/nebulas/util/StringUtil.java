package site.nebulas.util;

public class StringUtil {
  public static boolean isNull(String str) {
    if (null == str || "".equals(str)) {
      return true;
    }
    return false;
  }
  public static boolean isIntNull(int i) {
    if (0 == i) {
      return true;
    }
    return false;
  }
}
