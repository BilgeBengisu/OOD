public class PasswordValidator implements Validator {
    private Validator nextValidator;

    @Override
    public void setNext(Validator next) {
        this.nextValidator = next;
    }

    @Override
    public String validate(UserRegistration user) {
        String password = user.getPassword();
        if (password == null || password.isEmpty()) return "Username cannot be empty.";
        if (password.length() < 8) return "Password must be at least 8 characters long.";
        if (!password.matches(".*[A-Z].*")) return "Password must contain an uppercase letter.";
        if (!password.matches(".*[a-z].*")) return "Password must contain a lowercase letter.";
        if (!password.matches(".*\\d.*")) return "Password must contain a digit.";
    
        if (nextValidator != null) {
            return nextValidator.validate(user);
        }
        return null;
    }
}