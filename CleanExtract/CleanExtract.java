public class CleanExtract {
    public static String extract(String s) {
        String[] Splitted = s.split("\\|");
        String res = "";
            for (int j = 0; j < Splitted.length; j++) {
                String part = Splitted[j];
                String validPart = "";
                int dotCounter = 0;
                boolean green = false;

                if (!part.contains(".")) {
                    res += part.trim();
                    continue;
                }

                for ( int i = 0; i < part.length(); i++ ) {
                    char c = part.charAt(i);
                    if (c == '.') {
                        dotCounter++;
                        if (dotCounter == 3) {
                            if (c != ' ') {
                                validPart += c;
                            }
                        }
                        green = !green;
                        continue;
                    }
                    if (green) {
                        validPart += c;
                    }
                }
                if (validPart != "") {
                    res += " " + validPart.trim();
                }
        }

        return res.trim();
    }
}