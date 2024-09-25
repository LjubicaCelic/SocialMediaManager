package SocialMediaManager;

import java.util.ArrayList;

public class TikTok extends SocialMedia implements Promotion {
    public TikTok(ArrayList<User> users) {
        super("Tik tok", users);
    }

    @Override
    public double earnings() {
        double totalEarnings = 0;
        for (User user : getUsers()) {
            totalEarnings += ((user.getNumberOfPhotos() * 10) + (user.getNumberOfVideos() * 15));
        }
        return totalEarnings;
    }

    public String getUserEarnings() {
        StringBuilder earningsReport = new StringBuilder();
        for (User user : getUsers()) {
            double earnings = (user.getNumberOfPhotos() * 10) + (user.getNumberOfVideos() * 15);
            earningsReport.append(user.getFullName()).append(": ").append(earnings).append("\n");
        }
        return earningsReport.toString();
    }

    @Override
    public String toString() {
        return super.toString() + "Earnings" + earnings();
    }
}
