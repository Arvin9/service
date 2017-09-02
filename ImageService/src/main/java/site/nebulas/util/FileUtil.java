package site.nebulas.util;

/**
 * @author caihonghui
 *  20170902
 * */
public class FileUtil {
    /**
     * 获取文件扩展名
     * @param filename
     * @return extensionName
     * */
    public static String getExtensionName(String filename) {
        if ((filename != null) && (filename.length() > 0)) {
            int dot = filename.lastIndexOf('.');
            if ((dot >-1) && (dot < (filename.length() - 1))) {
                return filename.substring(dot);
            }
        }
        return filename;
    }
}
