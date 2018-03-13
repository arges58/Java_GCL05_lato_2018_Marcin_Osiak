public class UserRemoveException extends ChatException {
    long login;
    public UserRemoveException(long login2)
    {
        login = login2;
    }
    public long throwException()
    {
        System.out.println("Can't remove user, no matching ID: ");
        return login;
    }
}
