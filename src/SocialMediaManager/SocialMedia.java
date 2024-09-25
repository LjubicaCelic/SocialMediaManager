package SocialMediaManager;

import java.util.ArrayList;

public class SocialMedia {
    private String name;
    private ArrayList<User> users;

    public SocialMedia(String name, ArrayList<User> users) {
        this.name = name;
        this.users = users;
    }

    public ArrayList<User> getUsers() {
        return users;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setUsers(ArrayList<User> users) {
        this.users = users;
    }

    public String fromSameCity(String city) {
        ArrayList<User> matches = new ArrayList<>();
        StringBuilder sameUsers = new StringBuilder();

        for (User user : users) {
            if (user.getCity().equalsIgnoreCase(city)) {
                matches.add(user);
            }
        }

        if (matches.isEmpty()) {
            sameUsers.append("No users from").append(city);
        } else {
            for (int i = 0; i < matches.size(); i++) {
                sameUsers.append(matches.get(i).getFullName());
                if (i < matches.size() - 1) {
                    sameUsers.append(", ");
                }
            }
        }
        return sameUsers.toString();
    }

    public void addUser(User user) {
        users.add(user);
    }

    public boolean findUserByName1(String fullName) {
        for (User user : getUsers()) {
            if (user.getFullName().equals(fullName)) {
                return true;
            }
        }
        return false;
    }

    public String findUserByName(String fullName) {
        String match = "";
        boolean exist = false;
        for (User user : getUsers()) {
            if (user.getFullName().equals(fullName)) {
                exist = true;
            }
        }
        if (exist) {
            return "User found on ";
        } else {
            return "User not found on ";
        }
    }

    public String findUser(User user) {
        if (getUsers().contains(user)) {
            return "User found on ";
        } else {
            return "User not found on ";
        }
    }

    public void removeUnderageUsers() {
        if (!users.isEmpty()) {
            for (int i = users.size() - 1; i >= 0; i--) {
                if (!(users.get(i).userIsOlderThan18())) {
                    users.remove(i);
                }
            }
        } else {
            System.out.println("User list is empty!");
        }
    }


    @Override
    public String toString() {
        return "\n" + getName() + " users: " + users;

    }
}
