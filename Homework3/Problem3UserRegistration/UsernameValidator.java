public class UsernameValidator implements Validator {
    private Validator nextValidator;

    // shared by all validators
    @Override
    public void setNext(Validator next) {
        this.nextValidator = next;
    }

    // username validation
    @Override
    public String validate(UserRegistration user) {
        String username = user.getUsername();
        if (username == null || username.isEmpty()) {
            return "Username cannot be empty.";
        }
        if (username.length() < 5) {
            return "Username must be at least 5 characters long.";
        }

        // pass to next validator if available
        if (nextValidator != null) {
            return nextValidator.validate(user);
        }
        return null; // all good - no error
    }
}