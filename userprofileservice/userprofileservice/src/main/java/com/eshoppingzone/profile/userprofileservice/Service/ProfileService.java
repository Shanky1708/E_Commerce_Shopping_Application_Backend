package com.eshoppingzone.profile.userprofileservice.Service;

import java.util.List;

import com.eshoppingzone.profile.userprofileservice.Pojo.UserProfile;

public interface ProfileService {
    
    public UserProfile addNewCustomerProfile(UserProfile userProfile);

    public List<UserProfile> getAllProfiles();

    public UserProfile getByProfileId(int profileId);

    public void updateProfile(UserProfile userProfile);

    public void deleteProfile(int profileId);

    public void addNewMerchantProfile(UserProfile userProfile);

    public void addNewDeliveryProfile(UserProfile userProfile);

    public UserProfile findByMobileNo(Long mobileNumber);

    public UserProfile getByUserName(String userName);
}
