public class CleanExtract {

    public static String extract(String s) {
        if (s == null || s.isEmpty()) {
            return "";
        }
        String[] substrings = s.split("\\|", -1);

        StringBuilder result = new StringBuilder();

        for (String phrase : substrings) {
            int indexOfFirst = phrase.indexOf(".");
            int indexOfLast = phrase.lastIndexOf(".");

            if (indexOfFirst != -1 && indexOfLast != -1 && indexOfFirst != indexOfLast) {
                String extracted = phrase.substring(indexOfFirst + 1, indexOfLast).trim();
                if (!extracted.isEmpty()) {
                    if (result.length() > 0) {
                        result.append(" ");
                    }
                    result.append(extracted);
                }
            }
        }
        return result.toString();
    }
}
