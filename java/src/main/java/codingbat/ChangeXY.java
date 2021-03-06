package codingbat;

/**
 * http://codingbat.com/prob/p101372
 */
public final class ChangeXY {
    public String changeXY(String str) {
        if (str == null || str.isEmpty()) {
            return "";
        }

        if ("x".equals(str.substring(0, 1))) {
            return "y" + changeXY(str.substring(1, str.length()));
        } else {
            return str.substring(0, 1) + changeXY(str.substring(1, str.length()));
        }
    }
}
