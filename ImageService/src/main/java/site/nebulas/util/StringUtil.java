package site.nebulas.util;

public class StringUtil {
  public static boolean isNull(String str) {
    if (null == str || "".equals(str)) {
      return true;
    }
    return false;
  }
  public static boolean isIntNull(int i) {
    Integer integer = new Integer(i);
    if (null == integer) {
      return true;
    }
    return false;
  }
}
