package com.smnet.core.utils;

import java.util.regex.Pattern;

public class PasswordUtils {

    public static EnumPasswordStrong isStrong(String password) {

        if (!Pattern.compile("[A-Z]").matcher(password).find())
            return EnumPasswordStrong.NO_UPPERCASE;

        if (!Pattern.compile("[a-z]").matcher(password).find())
            return EnumPasswordStrong.NO_LOWERCASE;

        if (!Pattern.compile("[0-9]").matcher(password).find())
            return EnumPasswordStrong.NO_DIGIT;

        if (password.length() < 8)
            return EnumPasswordStrong.NO_LENGTH;

        if (password.contains(" "))
            return EnumPasswordStrong.SPACES;

        String unicodeAe = "\u00c4";
        String unicodeae = "\u00e4";
        String unicodeOe = "\u00d6";
        String unicodeoe = "\u00f6";
        String unicodeUe = "\u00dc";
        String unicodeue = "\u00fc";
        String unicodeSS = "\u00df";

        String pattern = String.format("[%s%s%s%s%s%s%s]", unicodeAe, unicodeae, unicodeOe, unicodeoe, unicodeUe,
                unicodeue, unicodeSS);

        if (Pattern.compile(pattern).matcher(password).find())
            return EnumPasswordStrong.UMLAUTS;

        if (!Pattern.compile("[!\"§$%&/()=?*'_:;>{\\[\\]}\\\\~+#\\-.,<|]").matcher(password).find())
            return EnumPasswordStrong.NO_SPECIAL;

        return EnumPasswordStrong.STRONG;
    }

    public enum EnumPasswordStrong {

        NO_UPPERCASE,
        NO_LOWERCASE,
        NO_DIGIT,
        NO_LENGTH,
        NO_SPECIAL,
        SPACES,
        UMLAUTS,
        STRONG;
    }
}
