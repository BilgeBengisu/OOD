public class EmailValidator implements Validator {
    private Validator nextValidator;

    @Override
    public void setNext(Validator next) {
        this.nextValidator = next;
    }

    @Override
    public String validate(UserRegistration user) {
        String email = user.getEmail();
        // checking if the format matches username@domain.com
        if (email == null || !email.matches("^[\\w.-]+@[\\w.-]+\\.\\w+$")) {
            return "Invalid email format.";
        }

        // pass to next validator if available
        if (nextValidator != null) {
            return nextValidator.validate(user);
        }
        return null; // all good - no error
    }
}