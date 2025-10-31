public class Main {
    public static void main(String[] args) {
        // create validators
        Validator usernameValidator = new UsernameValidator();
        Validator emailValidator = new EmailValidator();
        Validator passwordValidator = new PasswordValidator();
        Validator phoneNumberValidator = new PhoneNumberValidator();

        // chain them together - Chain of Responsibility Pattern
        usernameValidator.setNext(emailValidator);
        emailValidator.setNext(passwordValidator);
        passwordValidator.setNext(phoneNumberValidator);

        // creating the form and injecting the first validator in the chain
        RegistrationForm form = new RegistrationForm(usernameValidator);
    }
}
