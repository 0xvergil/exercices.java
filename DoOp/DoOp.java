public class DoOp {
    public static String operate(String[] args) {
        if (args == null || args.length != 3) {
            return "Error";
        }
        int first = Integer.parseInt(args[0]);
        int second = Integer.parseInt(args[2]);
        String Op = args[1];
        switch (Op) {
            case "+":
                return Integer.toString(first+second);
            case "-":
                return Integer.toString(first-second);
            case "/":
                if (second == 0) {
                    return "Error";
                }
                return Integer.toString(first/second);
            case "*":
                return Integer.toString(first*second);
            case "%":
                if (second == 0) {
                    return "Error";
                }
                return Integer.toString(first%second);
            default:
                return "Error";
        }
    }
}