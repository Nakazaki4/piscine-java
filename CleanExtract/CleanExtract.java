public class CleanExtract {
    public static String extract(String s) {
        String[] substrings = s.split("\\|");

        StringBuilder result = new StringBuilder();

        for (String phrase : substrings) {
            int indexOfFirst = phrase.indexOf(".");
            int indexOfLast = phrase.lastIndexOf(".");

            if (indexOfFirst != -1 && indexOfLast != -1 && indexOfFirst != indexOfLast) {
                String extracted = phrase.substring(indexOfFirst+1, indexOfLast).trim();
                if (!extracted.isEmpty()) {
                    if (result.length() > 0){
                    result.append(" ");
                    }
                    result.append(extracted);
                }else {
                    continue;
                }
            }
        }
        return result.toString();
    }
}