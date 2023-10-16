package com.eshoppingzone.profile.userprofileservice.resource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import com.eshoppingzone.profile.userprofileservice.Pojo.Address;
import com.eshoppingzone.profile.userprofileservice.Pojo.UserProfile;
import com.eshoppingzone.profile.userprofileservice.Service.ProfileService;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@TestMethodOrder(OrderAnnotation.class)
@SpringBootTest(classes = { ProfileResourceTest.class })
public class ProfileResourceTest {

    @Mock
    private ProfileService profileService;

    @InjectMocks
    private ProfileResource profileResource;

    @Test
    @Order(1)
    void testAddNewCustomerProfile() {

        Address a1 = new Address(11, "dadf", "fgxx", "cxwcy", "jvuzu", 42546);
        UserProfile myUserProfile = new UserProfile(2, "Shanky", "image", "Shanky121@gmail.com", 1234567898L,
                "Developer", "1999-12-01", "male", "Customer", "123456", a1);
        when(this.profileService.addNewCustomerProfile(myUserProfile)).thenReturn(myUserProfile);
        ResponseEntity<UserProfile> responseEntity=this.profileResource.addNewCustomerProfile(myUserProfile);
        assertEquals(HttpStatus.FOUND, responseEntity.getStatusCode());

    }

    @Test
    @Order(2)
    void testAddNewDeliveryProfile() {

        Address a1 = new Address(12, "dadf", "fgxx", "cxwcy", "jvuzu", 42546);
        UserProfile myUserProfile = new UserProfile(3, "Shanky", "image", "Shanky121@gmail.com", 1234567898L,
                "Developer", "1999-12-01", "male", "Customer", "123456", a1);
        profileResource.addNewDeliveryProfile(myUserProfile);
        ResponseEntity<?> responseEntity=profileResource.addNewDeliveryProfile(myUserProfile);
        assertEquals(HttpStatus.FOUND,responseEntity.getStatusCode());

    }

    @Test
    @Order(3)
    void testAddNewMerchantProfile() {

        Address a1 = new Address(12, "dadf", "fgxx", "cxwcy", "jvuzu", 42546);
        UserProfile myUserProfile = new UserProfile(3, "Shanky", "image", "Shanky121@gmail.com", 1234567898L,
                "Developer", "1999-12-01", "male", "Customer", "123456", a1);
        profileResource.addNewMerchantProfile(myUserProfile);
        ResponseEntity<?> responseEntity=profileResource.addNewMerchantProfile(myUserProfile);
        assertEquals(HttpStatus.FOUND,responseEntity.getStatusCode());
    }

    @Test
    @Order(4)
    void testDeleteProfile() {

        int profileId = 1;
        profileResource.deleteProfile(profileId);
        ResponseEntity<?> responseEntity=profileResource.deleteProfile(profileId);
        assertEquals(HttpStatus.FOUND,responseEntity.getStatusCode());

    }

    @Test
    @Order(5)
    void testGetAllProfiles() {

        List<UserProfile> myUserProfile = new ArrayList<UserProfile>();
        Address a1 = new Address(10, "dadf", "fgxx", "cxwcy", "jvuzu", 42546);
        myUserProfile.add(new UserProfile(1, "xyz", "image", "xyz121@gmail.com", 1234567898L, "coder", "1999-12-01",
                "male", "Customer", "123456", a1));
        when(this.profileService.getAllProfiles()).thenReturn(myUserProfile);
        ResponseEntity<List<UserProfile>> responseEntity=profileResource.getAllProfiles();
        assertEquals(HttpStatus.FOUND, responseEntity.getStatusCode());

    }

    @Test
    @Order(6)
    void testGetByPhoneNumber() {

        Address a1 = new Address(11, "dadf", "fgxx", "cxwcy", "jvuzu", 42546);
        UserProfile myUserProfile = new UserProfile(2, "Shanky", "image", "Shanky121@gmail.com", 1234567898L,
                "Developer", "1999-12-01", "male", "Customer", "123456", a1);
        Long mobileNumber = 1234567898L;
        when(this.profileService.findByMobileNo(mobileNumber)).thenReturn(myUserProfile);
        ResponseEntity<UserProfile> responseEntity=profileResource.getByPhoneNumber(mobileNumber);
        assertEquals(HttpStatus.FOUND, responseEntity.getStatusCode());
    }

    @Test
    @Order(7)
    void testGetByProfileId() {

        Address a1 = new Address(10, "dadf", "fgxx", "cxwcy", "jvuzu", 42546);
        UserProfile myUserProfile = new UserProfile(1, "xyz", "image", "xyz121@gmail.com", 1234567898L, "coder",
                "1999-12-01", "male", "Customer", "123456", a1);
        int Id = 1;
        when(this.profileService.getByProfileId(Id)).thenReturn(myUserProfile);
        ResponseEntity<UserProfile> responseEntity=profileResource.getByProfileId(Id);
        assertEquals(HttpStatus.FOUND, responseEntity.getStatusCode());

    }

    @Test
    @Order(8)
    void testGetByUserName() {

        Address a1 = new Address(10, "dadf", "fgxx", "cxwcy", "jvuzu", 42546);
        UserProfile myUserProfile = new UserProfile(1, "xyz", "image", "xyz121@gmail.com", 1234567898L, "coder",
                "1999-12-01", "male", "Customer", "123456", a1);
        String name = "xyz";
        when(this.profileService.getByUserName(name)).thenReturn(myUserProfile);
        ResponseEntity<UserProfile> responseEntity=profileResource.getByUserName(name);
        assertEquals(HttpStatus.FOUND, responseEntity.getStatusCode());

    }

    @Test
    @Order(9)
    void testUpdateProfile() {

        Address a1 = new Address(10, "dadf", "fgxx", "cxwcy", "jvuzu", 42546);
        UserProfile myUserProfile = new UserProfile(2, "xyz", "image", "xyz121@gmail.com", 1234567898L, "coder",
                "1999-12-01", "male", "Customer", "123456", a1);
        profileResource.updateProfile(myUserProfile);
        ResponseEntity<?> responseEntity=profileResource.updateProfile(myUserProfile);
        assertEquals(HttpStatus.FOUND,responseEntity.getStatusCode());

    }
}
