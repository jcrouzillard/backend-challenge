package com.example.backendchallenge.validator;

import java.util.HashSet;
import java.util.Set;

public class PasswordValidator {
    private static final String SPECIAL_CHARS = "!@#$%^&*()-+";

    public static boolean isValid(String password) {
        if (password == null || password.length() < 9) return false;

        boolean hasUpper = false, hasLower = false, hasDigit = false, hasSpecial = false;
        Set<Character> seen = new HashSet<>();

        for (char c : password.toCharArray()) {
            if (!seen.add(c)) return false;
            if (Character.isUpperCase(c)) hasUpper = true;
            else if (Character.isLowerCase(c)) hasLower = true;
            else if (Character.isDigit(c)) hasDigit = true;
            else if (SPECIAL_CHARS.indexOf(c) >= 0) hasSpecial = true;
        }

        return hasUpper && hasLower && hasDigit && hasSpecial;
    }
}