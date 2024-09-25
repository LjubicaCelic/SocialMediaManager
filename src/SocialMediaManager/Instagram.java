package SocialMediaManager;

import java.util.ArrayList;

public class Instagram extends SocialMedia {
    public Instagram(ArrayList<User> users) {
        super("Instagram", users);
    }

    @Override
    public void removeUnderageUsers() {
        ArrayList<User> olderThan16 = new ArrayList<>();
        for (User user : getUsers()) {
            if (user.userIsOlderThan16()) {
                olderThan16.add(user);
            }
        }
        setUsers(olderThan16);
    }
}
