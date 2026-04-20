
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexReplace {

    public static String removeUnits(String s) {
        Pattern p = Pattern.compile("(?<=\\d)(cm|€)(?=\\s|$)");
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
            String od = obfuscateDomain(domainSide);
            return on + "@" + od;
        }
        return null;
    }

    private static String obfuscateDomain(String s) {
        Pattern p = Pattern.compile("^([^.]+)\\.([^.]+)(?:\\.([^.]+))?$");
        Matcher m = p.matcher(s);

        if (m.matches()) {
            if (m.group(3) != null) {
                return "*".repeat(m.group(1).length()) + "." + 
                       m.group(2) + "." + 
                       "*".repeat(m.group(3).length());
            } else {
                String top = m.group(2);
                String hiddenSecond = "*".repeat(m.group(1).length());

                if (top.matches("com|org|net")) {
                    return hiddenSecond + "." + top;
                } else {
                    return hiddenSecond + "." + "*".repeat(top.length());
                }
            }
        }
        
        return s;
    }

    private static String obfuscateName(String s) {
        Pattern p = Pattern.compile("[-._]");
        Matcher m = p.matcher(s);
        
        if (m.find()) {
            int sepIndex = m.start();
            String kept = s.substring(0, sepIndex + 1);
            String hidden = s.substring(sepIndex + 1).replaceAll(".", "*");
            return kept + hidden;
        }

        if (s.length() > 3) {
            String kept = s.substring(0, 3);
            String hidden = s.substring(3).replaceAll(".", "*");
            return kept + hidden;
        }

        return s;
    }
}
