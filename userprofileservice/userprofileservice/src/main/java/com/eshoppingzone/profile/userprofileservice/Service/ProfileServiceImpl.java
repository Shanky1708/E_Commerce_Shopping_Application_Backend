package com.eshoppingzone.profile.userprofileservice.Service;

import java.util.List;

import com.eshoppingzone.profile.userprofileservice.Pojo.UserProfile;
import com.eshoppingzone.profile.userprofileservice.Repository.ProfileRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProfileServiceImpl implements ProfileService {

    @Autowired
    public ProfileRepository profileRepository;

    @Override
    public UserProfile addNewCustomerProfile(UserProfile userProfile) {

        UserProfile u1 = this.profileRepository.save(userProfile);
        return u1;
    }

    @Override
    public List<UserProfile> getAllProfiles() {
        List<UserProfile> u1 = this.profileRepository.findAll();
        return u1;
    }

    @Override
    public UserProfile getByProfileId(int profileId) {
        UserProfile u1 = this.profileRepository.findByProfileId(profileId);
        return u1;
    }

    @Override
    public void updateProfile(UserProfile userProfile) {
        userProfile.setProfileId(userProfile.getProfileId());
        this.profileRepository.save(userProfile);

    }

    @Override
    public void deleteProfile(int profileId) {
        this.profileRepository.deleteByProfileId(profileId);

    }

    @Override
    public void addNewMerchantProfile(UserProfile userProfile) {
        this.profileRepository.save(userProfile);
    }

    @Override
    public void addNewDeliveryProfile(UserProfile userProfile) {
        this.profileRepository.save(userProfile);

    }

    @Override
    public UserProfile findByMobileNo(Long mobileNumber) {
        UserProfile u1 = this.profileRepository.findAllByMobileNumber(mobileNumber);
        return u1;
    }

    @Override
    public UserProfile getByUserName(String userName) {
        UserProfile u1 = this.profileRepository.findByFullName(userName);
        return u1;
    }

}
