package com.chyld.controllers;

import com.chyld.entities.*;
import com.chyld.services.*;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;

@RestController
@RequestMapping("/positions")
public class PositionController {

    private DeviceService deviceService;
    private RunService runService;
    private PositionService positionService;
    private RabbitTemplate rabbitTemplate;
    private TopicExchange topicExchange;

    @Autowired
    public void setDeviceService(DeviceService deviceService) {
        this.deviceService = deviceService;

    }

    @Autowired
    public void setRunService(RunService runService) {
        this.runService = runService;
    }

    @Autowired
    public void setPositionnService(PositionService positionService) {
        this.positionService = positionService;
    }

    @Autowired
    public void setTopicExchange(TopicExchange topicExchange){
        this.topicExchange = topicExchange;
    }

    @Autowired
    public void setRabbitTemplate(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    @RequestMapping(value = "/{sn}", method = RequestMethod.POST)
    public ResponseEntity<?> createPosition(@PathVariable String sn, @RequestBody Position p) {
        String strTopicExchange = topicExchange.getName();
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("serial", sn);
        hashMap.put("position", p);
        rabbitTemplate.convertAndSend(strTopicExchange, "fit.topic.pos", hashMap);
        return null;
//
//        Device d = deviceService.findDeviceBySerialNumber(sn);
//
//        Run run = null;
//        if(d == null){
//
//        } else {
//
//            run = deviceService.findActiveRun(d);
//            run.getPositions().add(p);
//            p.setRun(run);
//        }
//
//        positionService.savePosition(p);
//        return ResponseEntity.status(HttpStatus.CREATED).body(null);
    }


}
