public class UserLoginException extends ChatException {
    String badName;
    public UserLoginException(String name)
    {
        badName = name;
    }
    public String throwException()
    {
        return "Can't creaate user with that login: "+ badName;
    }
}
