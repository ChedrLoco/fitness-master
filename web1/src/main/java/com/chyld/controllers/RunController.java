package com.chyld.controllers;


import com.chyld.entities.*;
import com.chyld.services.DeviceService;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;

@RestController
@RequestMapping("/runs")
public class RunController {

    private DeviceService deviceService;
    private RabbitTemplate rabbitTemplate;
    private TopicExchange topicExchange;


    @Autowired
    public void setDeviceService(DeviceService deviceService) {
        this.deviceService = deviceService;

    }


    @Autowired
    public void setTopicExchange(TopicExchange topicExchange){
        this.topicExchange = topicExchange;
    }

    @Autowired
    public void setRabbitTemplate(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    @RequestMapping(value = "/{sn}/start", method = RequestMethod.POST)
    public ResponseEntity<?> createRun(@PathVariable String sn) {



        String strTopicExchange = topicExchange.getName();

        rabbitTemplate.convertAndSend(strTopicExchange, "fit.topic.run.start", sn);

        return null;

//        Device d = deviceService.findDeviceBySerialNumber(sn);
//
//
//        if(d == null){
//
//        } else {
//
//            Run run = new Run();
//            run.setDevice(d);
//        }
//
//        deviceService.saveDevice(d);
//        return ResponseEntity.status(HttpStatus.CREATED).body(null);
    }
    @RequestMapping(value = "/{sn}/stop", method = RequestMethod.POST)
    public ResponseEntity<?> stopRun(@PathVariable String sn) {


//        Device d = deviceService.findDeviceBySerialNumber(sn);
//
//        if(d == null){
//
//        } else {
//            Run run = deviceService.findActiveRun(d);
//            run.setStopTime(new Date());
//        }
//
//        deviceService.saveDevice(d);
//        return ResponseEntity.status(HttpStatus.ACCEPTED).body(null);
        return null;
    }

//    @RequestMapping(value = "", method = RequestMethod.GET)
//    public Profile getProfile(Principal user) {
//        int uid = ((JwtToken)user).getUserId();
//        User u = userService.findUserById(uid);
//        return u.getProfile();
//    }
}
