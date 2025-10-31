// CoR Handler

public interface Validator {
    void setNext(Validator next);
    String validate(UserRegistration user);
}