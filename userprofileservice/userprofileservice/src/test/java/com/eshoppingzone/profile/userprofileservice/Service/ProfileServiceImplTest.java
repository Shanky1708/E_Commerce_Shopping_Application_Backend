package com.eshoppingzone.profile.userprofileservice.Service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import com.eshoppingzone.profile.userprofileservice.Pojo.Address;
import com.eshoppingzone.profile.userprofileservice.Pojo.UserProfile;
import com.eshoppingzone.profile.userprofileservice.Repository.ProfileRepository;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

@TestMethodOrder(OrderAnnotation.class)
@SpringBootTest(classes = { ProfileServiceImplTest.class })
public class ProfileServiceImplTest {

    @Mock
    private ProfileRepository profileRepository;

    @InjectMocks
    private ProfileServiceImpl profileServiceImpl;


    @Test
    @Order(1)
    void testAddNewCustomerProfile() {

        Address a1 = new Address(11, "dadf", "fgxx", "cxwcy", "jvuzu", 42546);
        UserProfile myUserProfile = new UserProfile(2, "Shanky", "image", "Shanky121@gmail.com", 1234567898L,
                "Developer", "1999-12-01", "male", "Customer", "123456", a1);
        when(this.profileRepository.save(myUserProfile)).thenReturn(myUserProfile);
        assertEquals(myUserProfile, profileServiceImpl.addNewCustomerProfile(myUserProfile));
    }

    @Test
    @Order(2)
    void testAddNewDeliveryProfile() {

        Address a1 = new Address(12, "dadf", "fgxx", "cxwcy", "jvuzu", 42546);
        UserProfile myUserProfile = new UserProfile(3, "Shanky", "image", "Shanky121@gmail.com", 1234567898L,
                "Developer", "1999-12-01", "male", "Customer", "123456", a1);
        profileServiceImpl.addNewDeliveryProfile(myUserProfile);
        verify(profileRepository, times(1)).save(myUserProfile);
    }

    @Test
    @Order(3)
    void testAddNewMerchantProfile() {

        Address a1 = new Address(12, "dadf", "fgxx", "cxwcy", "jvuzu", 42546);
        UserProfile myUserProfile = new UserProfile(3, "Shanky", "image", "Shanky121@gmail.com", 1234567898L,
                "Developer", "1999-12-01", "male", "Customer", "123456", a1);
        profileServiceImpl.addNewMerchantProfile(myUserProfile);
        verify(profileRepository, times(1)).save(myUserProfile);
    }

    @Test
    @Order(4)
    void testDeleteProfile() {

        int profileId = 1;
        profileServiceImpl.deleteProfile(profileId);
        verify(profileRepository, times(1)).deleteByProfileId(profileId);
    }

    @Test
    @Order(5)
    void testFindByMobileNo() {

        Address a1 = new Address(11, "dadf", "fgxx", "cxwcy", "jvuzu", 42546);
        UserProfile myUserProfile = new UserProfile(2, "Shanky", "image", "Shanky121@gmail.com", 1234567898L,
                "Developer", "1999-12-01", "male", "Customer", "123456", a1);
        Long mobileNumber = 1234567898L;
        when(this.profileRepository.findAllByMobileNumber(mobileNumber)).thenReturn(myUserProfile);
        assertEquals(myUserProfile, profileServiceImpl.findByMobileNo(mobileNumber));
    }

    @Test
    @Order(6)
    void testGetAllProfiles() {

        List<UserProfile> myUserProfile = new ArrayList<UserProfile>();
        Address a1 = new Address(10, "dadf", "fgxx", "cxwcy", "jvuzu", 42546);
        myUserProfile.add(new UserProfile(1, "xyz", "image", "xyz121@gmail.com", 1234567898L, "coder", "1999-12-01",
                "male", "Customer", "123456", a1));
        when(this.profileRepository.findAll()).thenReturn(myUserProfile);
        assertEquals(1, profileServiceImpl.getAllProfiles().size());
    }

    @Test
    @Order(7)
    void testGetByProfileId() {

        Address a1 = new Address(10, "dadf", "fgxx", "cxwcy", "jvuzu", 42546);
        UserProfile myUserProfile = new UserProfile(1, "xyz", "image", "xyz121@gmail.com", 1234567898L, "coder",
                "1999-12-01", "male", "Customer", "123456", a1);
        int Id = 1;
        when(this.profileRepository.findByProfileId(Id)).thenReturn(myUserProfile);
        assertEquals(Id, profileServiceImpl.getByProfileId(Id).getProfileId());
    }

    @Test
    @Order(8)
    void testGetByUserName() {

        Address a1 = new Address(10, "dadf", "fgxx", "cxwcy", "jvuzu", 42546);
        UserProfile myUserProfile = new UserProfile(1, "xyz", "image", "xyz121@gmail.com", 1234567898L, "coder",
                "1999-12-01", "male", "Customer", "123456", a1);
        String name = "xyz";
        when(this.profileRepository.findByFullName(name)).thenReturn(myUserProfile);
        assertEquals(name, profileServiceImpl.getByUserName(name).getFullName());
    }

    @Test
    @Order(9)
    void testUpdateProfile() {

        Address a1 = new Address(10, "dadf", "fgxx", "cxwcy", "jvuzu", 42546);
        UserProfile myUserProfile = new UserProfile(2, "xyz", "image", "xyz121@gmail.com", 1234567898L, "coder",
                "1999-12-01", "male", "Customer", "123456", a1);
        profileServiceImpl.updateProfile(myUserProfile);
        verify(profileRepository, times(1)).save(myUserProfile);
    }

}
