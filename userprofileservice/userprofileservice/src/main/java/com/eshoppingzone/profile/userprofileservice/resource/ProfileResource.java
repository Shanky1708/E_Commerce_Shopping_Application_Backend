package com.eshoppingzone.profile.userprofileservice.resource;

import java.util.List;

import com.eshoppingzone.profile.userprofileservice.Pojo.UserProfile;
import com.eshoppingzone.profile.userprofileservice.Repository.ProfileRepository;
import com.eshoppingzone.profile.userprofileservice.Service.ProfileService;

import org.slf4j.ILoggerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/profile")
@CrossOrigin
public class ProfileResource {

    Logger logger= LoggerFactory.getLogger(ProfileResource.class);

    @Autowired
    public ProfileService profileService;

    @Autowired
    public ProfileRepository profileRepository;

    @Autowired(required = true)
    public UserProfile userProfile;

    public ProfileResource() {

    }

    @PostMapping("/addNewCustomerProfile")
    public ResponseEntity<UserProfile> addNewCustomerProfile(@RequestBody UserProfile userProfile) {

        logger.debug("Request {}",userProfile);
        try {
            UserProfile u1 = this.profileService.addNewCustomerProfile(userProfile);
            logger.debug("Response {}",u1);
            return new ResponseEntity<UserProfile>(u1, HttpStatus.FOUND);
        } catch (Exception e){
            logger.debug("Response {}",HttpStatus.NOT_FOUND);
            return new ResponseEntity<UserProfile>(HttpStatus.NOT_FOUND);
        }

    }

    @PostMapping("/addNewMerchantProfile")
    public ResponseEntity<?> addNewMerchantProfile(@RequestBody UserProfile userProfile) {

        logger.debug("Request {}",userProfile);
        try{
            this.profileService.addNewMerchantProfile(userProfile);
            logger.debug("Response {}",HttpStatus.FOUND);
            return new ResponseEntity<>(HttpStatus.FOUND);
        } catch (Exception e){
            logger.debug("Response {}",HttpStatus.NOT_FOUND);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

    @PostMapping("/addNewDeliveryProfile")
    public ResponseEntity<?> addNewDeliveryProfile(@RequestBody UserProfile userProfile) {
        logger.debug("Request {}",userProfile);
        try{
            this.profileService.addNewDeliveryProfile(userProfile);
            logger.debug("Response {}",HttpStatus.FOUND);
            return new ResponseEntity<>(HttpStatus.FOUND);
        } catch (Exception e){
            logger.debug("Response {}",HttpStatus.NOT_FOUND);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

    @GetMapping("/getAllProfiles")
    public ResponseEntity<List<UserProfile>> getAllProfiles() {

        try {
            List<UserProfile> u1 = this.profileService.getAllProfiles();
            logger.debug("Response {}",u1);
            return new ResponseEntity<List<UserProfile>>(u1,HttpStatus.FOUND);
        } catch (Exception e){
            logger.debug("Response {}",HttpStatus.NOT_FOUND);
            return new ResponseEntity<List<UserProfile>>(HttpStatus.NOT_FOUND);
        }


    }

    @GetMapping("/getByProfileId/{id}")
    public ResponseEntity<UserProfile> getByProfileId(@PathVariable("id") int id) {

        logger.debug("Request {}",id);
        try{
            UserProfile u1 = this.profileService.getByProfileId(id);
            logger.debug("Response {}",u1);
            return new ResponseEntity<UserProfile>(u1,HttpStatus.FOUND);
        } catch (Exception e){
            logger.debug("Response {}",HttpStatus.NOT_FOUND);
            return  new ResponseEntity<UserProfile>(HttpStatus.NOT_FOUND);
        }

    }

    @GetMapping("/getByPhoneNumber/{phoneNumber}")
    public ResponseEntity<UserProfile> getByPhoneNumber(@PathVariable("phoneNumber") Long phoneNumber) {

        logger.debug("Request{}",phoneNumber);
        try{
            UserProfile u1 = this.profileService.findByMobileNo(phoneNumber);
            logger.debug("Response {}",u1);
            return new ResponseEntity<UserProfile>(u1,HttpStatus.FOUND);
        } catch (Exception e){
            logger.debug("Response {}",HttpStatus.NOT_FOUND);
            return new ResponseEntity<UserProfile>(HttpStatus.NOT_FOUND);
        }

    }

    @PutMapping("/updateProfile")
    public ResponseEntity<?> updateProfile(@RequestBody UserProfile userProfile) {

        logger.debug("Request {}",userProfile);
        try {
            this.profileService.updateProfile(userProfile);
            logger.debug("Response {}",HttpStatus.FOUND);
            return new ResponseEntity<>(HttpStatus.FOUND);
        } catch (Exception e){
            logger.debug("Response {}",HttpStatus.NOT_FOUND);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/deleteProfile/{id}")
    public ResponseEntity<?> deleteProfile(@PathVariable("id") int id) {

        logger.debug("Request {}",id);
       try{
           this.profileService.deleteProfile(id);
           logger.debug("Response {}",HttpStatus.FOUND);
           return new ResponseEntity<>(HttpStatus.FOUND);
       } catch (Exception e){
           logger.debug("Response {}",HttpStatus.NOT_FOUND);
           return new ResponseEntity<>(HttpStatus.NOT_FOUND);
       }


    }

    @GetMapping("/getByUserName/{fullName}")
    public ResponseEntity<UserProfile> getByUserName(@PathVariable("fullName") String fullName) {

        logger.debug("Request {}",fullName);
        try{
            UserProfile u1 = this.profileService.getByUserName(fullName);
            logger.debug("Response {}",u1);
            return new ResponseEntity<UserProfile>(u1,HttpStatus.FOUND);
        } catch (Exception e){
            logger.debug("Response {}",HttpStatus.NOT_FOUND);
            return new ResponseEntity<UserProfile>(HttpStatus.NOT_FOUND);
        }


    }

}
