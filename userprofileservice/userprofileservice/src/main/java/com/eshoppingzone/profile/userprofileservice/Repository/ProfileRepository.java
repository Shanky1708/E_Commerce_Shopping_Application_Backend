package com.eshoppingzone.profile.userprofileservice.Repository;

import com.eshoppingzone.profile.userprofileservice.Pojo.UserProfile;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfileRepository extends MongoRepository<UserProfile, Integer> {

    public UserProfile findAllByMobileNumber(Long mobileNumber);

    public UserProfile findByFullName(String fullname);

    public UserProfile findByProfileId(int profileId);

    public void deleteByProfileId(int profileId);

    public UserProfile findByEmailIdAndPassWord(String emailId, String passWord);

}
