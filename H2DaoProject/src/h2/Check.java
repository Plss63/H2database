package h2;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Check {

    public boolean checkDevice(String str) {
        int l = str.length();
        if (l == 0 || l > 30)
            return false;
        else
            return true;
    }

    public boolean checkWifi(String str) {
        Pattern p = Pattern.compile("^YES|NO$");
        Matcher m = p.matcher(str);
        return m.matches();
    }

    public boolean checkDate(String str) {
        Pattern p = Pattern.compile("^(19[8-9]\\d|200\\d|201[0-4])\\-([0]\\d|[1][0-2])\\-([012]\\d|[3][0-1])$");
        Matcher m = p.matcher(str);
        return m.matches();
    }

    public boolean checkInt(String str) {
        Pattern p = Pattern.compile("^[1-9]|[1]\\d|20$");
        Matcher m = p.matcher(str);
        return m.matches();
    }
    
}
