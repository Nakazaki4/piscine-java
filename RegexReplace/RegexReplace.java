
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexReplace {

    public static String removeUnits(String s) {
        Pattern p = Pattern.compile("\\d+cm\s|\\d+€\s");
        Matcher m = p.matcher(s);
        return m.replaceAll("");
    }

    public static String obfuscateEmail(String s) {
        if (s == null || !s.contains("@")) {
            return null;
        }

        String[] email = s.split("@");
        if (email.length > 2) {
            return null;
        }
        String nameSide = email[0];
        String domainSide = email[1];
        if (!nameSide.trim().isEmpty() && !domainSide.trim().isEmpty()) {
            String on = obfuscateName(nameSide);
            String od = obfuscateEmail(domainSide);
            return on + od;
        }
        return null;
    }

    private static String obfuscateDomain(String s) {

    }

    private static String obfuscateName(String s) {
        Pattern p = Pattern.compile("(?!.*[.|-|_])\\w+");
        Matcher m = p.matcher(s);
        if (m.find()) {
            return m.replaceAll("*");
        }

        if (s.length() > 3){
            Pattern p = Pattern.compile("");
        }
    }
}
