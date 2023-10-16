package com.eshoppingzone.profile.userprofileservice.Pojo;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Controller;

@Document(collection = "userprofile")
@Controller
public class UserProfile {

    @Id
    private int profileId;
    private String fullName;
    private String image;
    private String emailId;
    private Long mobileNumber;
    private String about;
    private String dateOfBirth;
    private String gender;
    private String role;
    private String passWord;
    public Address address;

    public UserProfile(int profileId, String fullName, String image, String emailId, Long mobileNumber, String about,
            String dateOfBirth, String gender, String role, String passWord, Address address) {
        this.profileId = profileId;
        this.fullName = fullName;
        this.image = image;
        this.emailId = emailId;
        this.mobileNumber = mobileNumber;
        this.about = about;
        this.gender = gender;
        this.role = role;
        this.passWord = passWord;
        this.address = address;
    }

    public UserProfile() {
    }

    public UserProfile(int profileId, String fullName, String image, String emailId, Long mobileNumber, String about,
            String dateOfBirth, String gender, String role, String passWord) {
        this.profileId = profileId;
        this.fullName = fullName;
        this.image = image;
        this.emailId = emailId;
        this.mobileNumber = mobileNumber;
        this.about = about;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.role = role;
        this.passWord = passWord;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public int getProfileId() {
        return profileId;
    }

    public void setProfileId(int profileId) {
        this.profileId = profileId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public Long getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(Long mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    @Override
    public String toString() {
        return "UserProfile [about=" + about + ", address=" + address + ", emailId=" + emailId + ", fullName="
                + fullName + ", gender=" + gender + ", image=" + image + ", mobileNumber=" + mobileNumber
                + ", passWord=" + passWord + ", profileId=" + profileId + ", role=" + role + "]";
    }

}
