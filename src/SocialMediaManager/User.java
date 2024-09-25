package SocialMediaManager;

import java.time.LocalDate;

public class User {
    private String fullName;
    private int birthYear;
    private int numberOfVideos;
    private int numberOfPhotos;
    private String city;

    public User(String fullName, int birthYear, int numberOfVideos, int numberOfPhotos, String city) {
        this.fullName = fullName;
        this.birthYear = birthYear;
        this.numberOfVideos = numberOfVideos;
        this.numberOfPhotos = numberOfPhotos;
        this.city = city;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(int birthYear) {
        this.birthYear = birthYear;
    }

    public int getNumberOfVideos() {
        return numberOfVideos;
    }

    public void setNumberOfVideos(int numberOfVideos) {
        this.numberOfVideos = numberOfVideos;
    }

    public int getNumberOfPhotos() {
        return numberOfPhotos;
    }

    public void setNumberOfPhotos(int numberOfPhotos) {
        this.numberOfPhotos = numberOfPhotos;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int calculateAge() {
        int currentYear = LocalDate.now().getYear();
        return currentYear - birthYear;
    }

    public boolean userIsOlderThan18() {
        int currentYear = LocalDate.now().getYear();
        int age = currentYear - birthYear;
        if (age > 18) {
            return true;
        } else {
            System.out.println("User " + getFullName() + " should not have a social media account because they are under 16!");
            return false;
        }
    }

    public boolean userIsOlderThan16() {
        int currentYear = LocalDate.now().getYear();
        int age = currentYear - birthYear;
        if (age > 16) {
            return true;
        } else {
            System.out.println("User " + getFullName() + " should not have a social media account because they are under 16!");
            return false;
        }
    }

    @Override
    public String toString() {
        return "\nUser: " + fullName + "\nBirth year: " + birthYear +
                "\nNumber of videos: " + numberOfVideos +
                "\nNumber of photos: " + numberOfPhotos +
                "\nCity: " + city;
    }
}
