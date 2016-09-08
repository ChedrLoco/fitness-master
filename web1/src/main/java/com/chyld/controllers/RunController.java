package com.chyld.controllers;


import com.chyld.dtos.AuthDto;
import com.chyld.entities.*;
import com.chyld.enums.RoleEnum;
import com.chyld.security.JwtToken;
import com.chyld.services.DeviceService;
import com.chyld.utilities.JwtUtil;
import com.chyld.services.RoleService;
import com.chyld.services.UserService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;
import java.util.ArrayList;
import java.util.Date;

@RestController
@RequestMapping("/runs")
public class RunController {

    private DeviceService deviceService;


    @Autowired
    public void setDeviceService(DeviceService deviceService) {
        this.deviceService = deviceService;

    }

    @RequestMapping(value = "/{sn}/start", method = RequestMethod.POST)
    public ResponseEntity<?> createRun(@PathVariable String sn) {

        Device d = deviceService.findDeviceBySerialNumber(sn);


        if(d == null){

        } else {

            Run run = new Run();
            run.setDevice(d);
        }

        deviceService.saveDevice(d);
        return ResponseEntity.status(HttpStatus.CREATED).body(null);
    }
    @RequestMapping(value = "/{sn}/stop", method = RequestMethod.POST)
    public ResponseEntity<?> stopRun(@PathVariable String sn) {

        Device d = deviceService.findDeviceBySerialNumber(sn);

        if(d == null){

        } else {
            Run run = deviceService.findActiveRun(d);
            run.setStopTime(new Date());
        }

        deviceService.saveDevice(d);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(null);
    }

//    @RequestMapping(value = "", method = RequestMethod.GET)
//    public Profile getProfile(Principal user) {
//        int uid = ((JwtToken)user).getUserId();
//        User u = userService.findUserById(uid);
//        return u.getProfile();
//    }
}
