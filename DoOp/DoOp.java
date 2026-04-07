public class DoOp {
    public static String operate(String[] args) {
        if (args == null || args.length != 3) {
            return "Error";
        }
        int p1 = Integer.parseInt(args[0].trim());
        int p2 = Integer.parseInt(args[2].trim());

        return switch (args[1]) {
            case "+" -> String.valueOf(p1 + p2);
            case "-" -> String.valueOf(p1 - p2);
            case "*" -> String.valueOf(p1 * p2);
            case "/" -> p2 == 0 ? "Error" : String.valueOf(p1 / p2);
            case "%" -> p2 == 0 ? "Error" : String.valueOf(p1 % p2);
            default -> "Error";
        };
    }
}
