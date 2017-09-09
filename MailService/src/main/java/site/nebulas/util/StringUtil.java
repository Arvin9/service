package site.nebulas.util;

/**
 * String工具类.
 * @author caihonghui
 * @create_time 20170910
 * */
public class StringUtil {

  /**
   * 判断字符串是否为空.
   * @param str
   * @return true|false
   * */
  public static boolean isNull(String str) {
    if (null == str || "".equals(str)) {
      return true;
    }
    return false;
  }

  /**
   * 判断int类型是否为空.
   * @param i
   * @return true|false
   * */
  public static boolean isIntNull(int i) {
    if (0 == i) {
      return true;
    }
    return false;
  }
}
