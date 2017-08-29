package site.nebulas.util;

import java.util.UUID;

/**
 * Created by Administrator on 2017/2/28.
 */
public class UUIDUtil {

    public static String getRandomUUID(){
        UUID uuid = UUID.randomUUID();
        return uuid.toString().replaceAll("\\-", "");
    }

    public static void main(String[] args) {

        System.out.println(getRandomUUID());
    }
}
