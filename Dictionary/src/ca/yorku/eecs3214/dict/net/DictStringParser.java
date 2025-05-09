package ca.yorku.eecs3214.dict.net;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DictStringParser {

    private static final Pattern stringUnit = Pattern.compile("\"([^\"]*)\"|(\\S+)");

    /**
     * Splits a String into DICT-supported atoms. This is equivalent to <code>String.split()</code>, but if a set of
     * quotes is found, the spaces within the quotes are not used for splitting.
     *
     * @param original Original string to be split.
     * @return An array of strings corresponding to all "atoms" found in the original string.
     */
    public static List<String> splitAtoms(String original) {
        List<String> list = new ArrayList<>();
        Matcher m = stringUnit.matcher(original);
        while (m.find()) {
            list.add(m.group(m.group(1) != null ? 1 : 2));
        }
        return list;
    }
}
