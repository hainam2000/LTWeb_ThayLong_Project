package tools;

public class Utils {

    public static String removeSpecialCharacters(String str){
        return str.replace("™","").replace("\"","").replace("®","").replace("ổ", "o")
                .replace("ứ", "u").replace("ộ","o").replace(" ", "").replace("đ", "d")
                .replace("tíchhợp", "tichhop").replace("â", "a").replace("uồn", "uo");
    }

    public static String upperCase(String str) {
        return str.toUpperCase();
    }
}
