import java.util.*;

public class ChatEngine {

Map<String, User> users;
Map<Long, User> users2;
long counter;
int numberOfUsers;
    public ChatEngine() {
        users = new HashMap<String, User>();
        users2 = new HashMap<Long, User>();
        counter = 0;
        numberOfUsers = 0;
    }
    public void loginUser(User user) throws UserLoginException
    {
        if (users.containsKey(user.name)) {
            throw new UserLoginException(user.name);
        }
        counter++;
        user.setId(counter);
        users.put(user.name, user);
        users2.put(counter, user);

        numberOfUsers++;
    }
    public void logoutUser(long userID) throws UserRemoveException
    {
        if(!(users2.containsKey(userID))){
            throw new UserRemoveException(userID);
        }
        numberOfUsers--;
        String nameTmp = users2.get(userID).name;
        users2.remove(userID);
        users.remove(nameTmp);
    }
    public int getNumberOfUsers()
    {
        return numberOfUsers;
    }
    public void addUserStar(String userName)
    {
        users.get(userName).numberOfStars++;
    }
    public void removeUserStar(String userName)
    {
        users.get(userName).numberOfStars--;
    }
    public boolean hasUser(long userID)
    {
        if(users2.containsKey(userID))
            return true;
        else
            return false;
    }
    public boolean hasUser(String userName)
    {
        if(users.containsKey(userName))
            return true;
        else
            return false;
    }

}


