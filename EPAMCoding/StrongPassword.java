package EPAMCoding;

public class StrongPassword {

    public static String checkPasswordStrength(String password) {
        if (password.length() < 8) {
            return "Weak: Too short";
        }

        boolean hasUpper = false;
        boolean hasLower = false;
        boolean hasDigit = false;
        boolean hasSpecial = false;
        String specialChars = "!@#$%^&*()-+=<>?";

        for (char ch : password.toCharArray()) {
            if (Character.isUpperCase(ch)) hasUpper = true;
            else if (Character.isLowerCase(ch)) hasLower = true;
            else if (Character.isDigit(ch)) hasDigit = true;
            else if (specialChars.contains(String.valueOf(ch))) hasSpecial = true;
        }

        if (hasUpper && hasLower && hasDigit && hasSpecial) {
            return "Strong password 💪";
        } else {
            return "Weak: Missing character types";
        }
    }

    public static void main(String[] args) {
        String password = "StrongP@ss1";
        System.out.println("Password: " + password);
        System.out.println("Strength: " + checkPasswordStrength(password));
    }

}

/*
public class PasswordValidationResult {
    private boolean valid;
    private List<String> violations;

    // constructor, getters, and toString
}

public class PasswordUtils {

    private static final int MIN_LENGTH = 8;
    private static final Pattern[] RULES = new Pattern[]{
            Pattern.compile("[A-Z]"),     // uppercase
            Pattern.compile("[a-z]"),     // lowercase
            Pattern.compile("\\d"),       // digit
            Pattern.compile("[!@#$%^&*()]")  // special character
    };

    public static PasswordValidationResult validate(String password) {
        List<String> violations = new ArrayList<>();

        if (password == null || password.length() < MIN_LENGTH) {
            violations.add("Password must be at least " + MIN_LENGTH + " characters");
        }

        if (!RULES[0].matcher(password).find()) violations.add("Missing uppercase letter");
        if (!RULES[1].matcher(password).find()) violations.add("Missing lowercase letter");
        if (!RULES[2].matcher(password).find()) violations.add("Missing digit");
        if (!RULES[3].matcher(password).find()) violations.add("Missing special character");

        return new PasswordValidationResult(violations.isEmpty(), violations);
    }
}

*/
