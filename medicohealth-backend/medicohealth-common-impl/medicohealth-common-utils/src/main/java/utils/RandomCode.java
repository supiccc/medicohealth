package utils;

/**
 * Created by supiccc on 2018-11-02 20:01
 * Description 获取指定长度的验证码
 */
public class RandomCode {

    /**
     * 返回指定长度的int类型验证码
     * @param length
     * @return
     */
    public static int getRandomCode(int length) {
        int randomCode = (int)(Math.random() * Math.pow(10, length));
        int decimalSystem = 10;
        while (randomCode < Math.pow(decimalSystem, length - 1) || randomCode >= Math.pow(decimalSystem, length)) {
            // 如果前面为0，重新赋值
            randomCode = (int) (Math.random() * Math.pow(10, length));
        }
        return randomCode;
    }

    /**
     * 返回指定长度的String类型验证码
     * @param length
     * @return
     */
    public static String getRandomCodeStr(int length) {
        return String.valueOf(getRandomCode(length));
    }

    /**
     * 返回六位长度的String类型验证码
     * @return
     */
    public static String getRandomCodeStr6() {
        return getRandomCodeStr(6);
    }
}
