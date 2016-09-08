package com.chyld.messaging;

import com.chyld.entities.Device;
import com.chyld.entities.Run;
import com.chyld.services.DeviceService;
import com.chyld.services.RunService;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class RService {

    private RunService service;
    private DeviceService deviceService;

    @Autowired
    public void setDeviceService(DeviceService deviceService) {
        this.deviceService = deviceService;
    }

    @Autowired
    public void setService(RunService service) {
        this.service = service;
    }

    @RabbitListener(queues =  "fit.queue.run")
    public void receive(Message msg, String data) {
        String key = msg.getMessageProperties().getReceivedRoutingKey();
        String serial = data;

        Device d = deviceService.findDeviceBySerialNumber(serial);


        if(d == null){

        } else {

            Run run = new Run();
            run.setDevice(d);
        }

        deviceService.saveDevice(d);
        Run r = (Run)data.get("run");
        service.saveRun(r);

    }
}
