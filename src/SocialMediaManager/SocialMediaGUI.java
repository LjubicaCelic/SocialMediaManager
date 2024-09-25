package SocialMediaManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.ArrayList;

public class SocialMediaGUI extends JFrame {

    private JPanel socialMedia;
    private JTextField txtBirthYear;
    private JButton addNewUserButton;
    private JTextField txtFullName;
    private JTextField txtNumberOfPhotos;
    private JTextField txtNumberOfVideos;
    private JTextField txtCity;
    private JLabel fullNameLabel;
    private JLabel birthYearLabel;
    private JLabel cityLabel;
    private JLabel numberOfPhotosLabel;
    private JLabel numberOfVideosLabel;
    private JCheckBox facebookCheckBox;
    private JCheckBox instagramCheckBox;
    private JCheckBox tikTokCheckBox;
    private JButton showAllUsersButton;
    private JButton removeUnderageUsersButton;
    private JTextArea outputArea;
    private JButton showUsersFromTheButton;
    private JButton showEarningsFromTiktokButton;
    private JButton findUserByNameButton;

    private static final int minBirthYear = 1900;
    private static final int maxBirthYear = LocalDate.now().getYear();

    Facebook facebook = new Facebook(new ArrayList<>());
    Instagram instagram = new Instagram(new ArrayList<>());
    TikTok tiktok = new TikTok(new ArrayList<>());
    Social social = new Social(new ArrayList<>());

    public SocialMediaGUI() {
        setContentPane(socialMedia);
        setTitle("Social Media Management");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null);
        setVisible(true);

        addNewUserButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                User user = newUser();
                boolean addedToAnyMedia = false;

                if (user != null) {
                    if (facebookCheckBox.isSelected()) {
                        facebook.addUser(user);
                        JOptionPane.showMessageDialog(SocialMediaGUI.this, "User added to Facebook!");
                        addedToAnyMedia = true;
                    }
                    if (instagramCheckBox.isSelected()) {
                        instagram.addUser(user);
                        JOptionPane.showMessageDialog(SocialMediaGUI.this, "User added to Instagram!");
                        addedToAnyMedia = true;
                    }
                    if (tikTokCheckBox.isSelected()) {
                        tiktok.addUser(user);
                        JOptionPane.showMessageDialog(SocialMediaGUI.this, "User added to TikTok!");
                        addedToAnyMedia = true;
                    }
                    if (!addedToAnyMedia) {
                        JOptionPane.showMessageDialog(SocialMediaGUI.this, "Please select a social network to add the user.");
                    }
                }
                if (addedToAnyMedia) {
                    resetFields();
                }
            }
        });

        showAllUsersButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showAllUsers();
            }
        });

        showUsersFromTheButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String city = JOptionPane.showInputDialog("Enter city");
                if (city != null && !city.trim().isEmpty()) {
                    outputArea.setText("");
                    outputArea.append("Facebook:\n" + facebook.fromSameCity(city) + " from " + city);
                    outputArea.append("\nInstagram:\n" + instagram.fromSameCity(city) + " from " + city);
                    outputArea.append("\nTiktok:\n" + tiktok.fromSameCity(city) + " from " + city);
                } else {
                    JOptionPane.showMessageDialog(SocialMediaGUI.this, "No matches.");
                }
            }
        });

        findUserByNameButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String fullName = JOptionPane.showInputDialog("Enter user's full name");
                outputArea.setText("");
                outputArea.append(facebook.findUserByName(fullName) + "Facebook \n");
                outputArea.append(instagram.findUserByName(fullName) + "Instagram \n");
                outputArea.append(tiktok.findUserByName(fullName) + "Tiktok \n");
            }
        });

        showEarningsFromTiktokButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String userEarnings = tiktok.getUserEarnings();
                JOptionPane.showMessageDialog(SocialMediaGUI.this, userEarnings, "Earnings report", JOptionPane.INFORMATION_MESSAGE);
            }
        });

        removeUnderageUsersButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                removeUnderageUsers();
            }
        });
    }

    private User newUser() {
        try {
            String name = txtFullName.getText();
            String city = txtCity.getText();
            int birthYear = Integer.parseInt(txtBirthYear.getText());
            int numberOfVideos = Integer.parseInt(txtNumberOfVideos.getText());
            int numberOfPhotos = Integer.parseInt(txtNumberOfPhotos.getText());

            if (birthYear < minBirthYear || birthYear > maxBirthYear) {
                JOptionPane.showMessageDialog(this, "Please enter a valid birth year between 1900 and 2024.");
                return null;
            }

            if (name.isEmpty() || city.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please fill mandatory fields!");
                return null;
            }

            return new User(name, birthYear, numberOfVideos, numberOfPhotos, city);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Please enter valid numbers for birth year, photos, and videos.");
            return null;
        }
    }

    private void resetFields() {
        txtFullName.setText("");
        txtBirthYear.setText("");
        txtNumberOfPhotos.setText("");
        txtNumberOfVideos.setText("");
        txtCity.setText("");
        facebookCheckBox.setSelected(false);
        instagramCheckBox.setSelected(false);
        tikTokCheckBox.setSelected(false);
    }

    private void showAllUsers() {
        outputArea.setText("");
        outputArea.append(facebook + "\n");
        outputArea.append(instagram + "\n");
        outputArea.append(tiktok + "\n");
    }

    private void removeUnderageUsers() {
        instagram.removeUnderageUsers();
        facebook.removeUnderageUsers();
        JOptionPane.showMessageDialog(this, "Underage users removed from Instagram and Facebook");
    }

    private void createUIComponents() {
        socialMedia = new JPanel();
        socialMedia.setLayout(new BorderLayout());
    }
}
