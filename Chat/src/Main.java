public class Main {

    public static void main(String[] args)
    {
        User newUser = new User();
        newUser.setName("Arnold");

        ChatEngine newChat = new ChatEngine();
        try {
            newChat.loginUser(newUser);
        } catch (UserLoginException e) {
            System.out.println(e.throwException());
        }

        User newUser2 = new User();
        newUser2.setName("Tomek");
        try {
            newChat.loginUser(newUser2);
        } catch (UserLoginException e) {
            System.out.println(e.throwException());
        }
        System.out.println(newChat.hasUser("Arnold"));
        System.out.println(newChat.hasUser(1));
        System.out.println(newChat.hasUser("Tomek"));
        System.out.println(newChat.hasUser(2));
        try {
            newChat.logoutUser(2);
        } catch (UserRemoveException e) {
            e.throwException();
        }
        System.out.println(newChat.hasUser("Tomek"));
        System.out.println(newChat.hasUser(2));

        newChat.addUserStar("Arnold");
        System.out.println(newUser.numberOfStars);
    }

}
