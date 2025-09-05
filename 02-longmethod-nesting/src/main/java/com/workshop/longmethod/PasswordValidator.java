package com.workshop.longmethod;

import java.util.HashSet;
import java.util.Set;

/** Dirty: flags, deep nesting, mixed responsibilities, inconsistent returns */
public class PasswordValidator {
    private final Set<String> blacklist = new HashSet<>(Set.of("password","12345678","qwerty","letmein","welcome"));

    public String validate(String password){
        if(password == null) return "NULL";
        if(password.length() < 8) return "TOO_SHORT";

        boolean isBlacklisted = blacklist.contains(password);
        if(isBlacklisted) return "BLACKLISTED";

        boolean hasUpperCase = hasUpper(password);
        if(!hasUpperCase) return "NO_UPPER";

        boolean hasDigit = hasDigit(password);
        if(!hasDigit) return "NO_DIGIT";

        boolean hasSpecial = hasSpecial(password);
        if(!hasSpecial) return "NO_SPECIAL";

        boolean hasRepeat = hasRepeat(password);
        if(hasRepeat) return "REPEATING_CHARS";

        return "OK";
    }

    private static boolean hasUpper(String password) {
        for(char c : password.toCharArray()) {
            if(Character.isUpperCase(c)) return true;
        }
        return false;
    }

    private static boolean hasDigit(String password) {
        for(char c : password.toCharArray()) {
            if(Character.isDigit(c)) return true;
        }
        return false;
    }

    private static boolean hasSpecial(String password) {
        for(char c : password.toCharArray()) {
            if("!@#$%^&*".indexOf(c)>=0) return true;
        }
        return false;
    }

    private static boolean hasRepeat(String password) {
        char last=0;
        int repeat=1;
        for(char c : password.toCharArray()) {
            if(c==last) { repeat++; if(repeat>=3) return true; }
            else { repeat=1; last=c; }
        }
        return false;
    }
}
