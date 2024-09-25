package SocialMediaManager;

import java.util.ArrayList;

public class Social {

    private ArrayList<SocialMedia> socialNetworks;

    public Social(ArrayList<SocialMedia> socialNetworks) {
        this.socialNetworks = socialNetworks;
    }

    public ArrayList<SocialMedia> getSocialNetworks() {
        return socialNetworks;
    }

    public void setSocialNetworks(ArrayList<SocialMedia> socialNetworks) {
        this.socialNetworks = socialNetworks;
    }

    public void addNewSocialNetwork(SocialMedia network) {
        if (!socialNetworks.contains(network)) {
            socialNetworks.add(network);
        } else {
            System.out.println("Social network already exists!");
        }
    }

    public void deleteFacebook() {
        ArrayList<SocialMedia> withoutFacebook = new ArrayList<>();
        for (SocialMedia network : socialNetworks) {
            if (!(network instanceof Facebook)) {
                withoutFacebook.add(network);
            }
        }
        setSocialNetworks(withoutFacebook);
    }

    //Another way to delete Facebook
    public void deleteFacebook2() {
        socialNetworks.removeIf(socialNetwork -> socialNetwork instanceof Facebook);
    }

    public String printSocialNetworks() {
        StringBuilder socialNetworksList = new StringBuilder();
        if (!socialNetworks.isEmpty()) {
            for (SocialMedia network : socialNetworks) {
                socialNetworksList.append(network.getName()).append("\n");
            }
        } else {
            System.out.println("The list of social networks is empty!");
        }
        return socialNetworksList.toString();
    }

    @Override
    public String toString() {
        return "Social Networks: " + socialNetworks;
    }
}
