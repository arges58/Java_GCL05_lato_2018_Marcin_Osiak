public class User {
    
    long id;
    String name;
    public long numberOfStars;
    long numberOfSentMessages;

    public User()
    {
        numberOfStars = 0;
        numberOfSentMessages =0;
    }
    public void setId(long tmp)
    {
        id = tmp;
    }
    public void setName(String tmp)
    {
        name = tmp;
    }
    public void setnumberOfStars(long tmp)
    {
        numberOfStars = tmp;
    }
    public long getId()
    {
        return id;
    }
    public String getName()
    {
        return name;
    }

    public long getnumberOfStars() {
        return numberOfStars;
    }
}
