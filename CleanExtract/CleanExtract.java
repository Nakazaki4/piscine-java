public class CleanExtract {

    public static String extract(String s) {
        if (s == null || s.isEmpty()) {
            return "";
        }

        String[] substrings = s.split("\\|");
        StringBuilder result = new StringBuilder();

        for (String phrase : substrings) {
            phrase = phrase.trim();

            int first = phrase.indexOf('.');
            int last = phrase.lastIndexOf('.');

            if (first != -1 && last != -1 && first < last) {
                String extracted = phrase.substring(first + 1, last).trim();

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