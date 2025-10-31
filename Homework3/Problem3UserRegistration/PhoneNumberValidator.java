public class PhoneNumberValidator implements Validator {
    private Validator nextValidator;

    // shared by all validators
    @Override
    public void setNext(Validator next) {
        this.nextValidator = next;
    }

    @Override
    public String validate(UserRegistration user) {
        String phone = user.getPhoneNumber();
        if (phone == null || phone.isEmpty()) return "Phone Number cannot be empty";
        // check if contains only numbers and 10 digits in total
        if (!phone.matches("\\d{10}")) {
            return "Phone number must be exactly 10 digits.";
        }

        // pass to next validator if available
        if (nextValidator != null) {
            return nextValidator.validate(user);
        }
        return null; // all good - no error
    }
}