
public class CleanExtract {

    public static String extract(String s) {
        String[] parts = s.split("\\|");
        StringBuilder result = new StringBuilder();
        for (String phrase : parts) {
            phrase = phrase.trim();
            int firstDot = phrase.indexOf('.');
            int lastDot = phrase.lastIndexOf('.');
            String cleaned = "";

            if (firstDot != -1) {
                if (firstDot == lastDot) {
                    cleaned = phrase.substring(firstDot + 1).trim();
                } else {
                    cleaned = phrase.substring(firstDot + 1, lastDot).trim();
                }
            }
            if (!cleaned.isEmpty()) {
                if (!result.isEmpty()) {
                    result.append(" ");
                }
                result.append(cleaned);
            }
        }
        return result.toString();
    }
}
