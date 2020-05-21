package top.womoe.utils;

public class Utils {

    public static String getRandomString(int length){
        StringBuilder res = new StringBuilder();
        for( int i = 0; i < length; ++i){
            res.append((char) (int) (Math.random() * 26 + 65));
        }
        return res.toString();
    }
}
