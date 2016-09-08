package com.chyld.messaging;

import com.chyld.entities.Position;
import com.chyld.services.PositionService;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class PosService {
    private PositionService service;

    @Autowired
    public void setService(PositionService service) {
        this.service = service;
    }

    @RabbitListener(queues =  "fit.queue.pos")
    public void receive(Message msg, HashMap<String, Object> data) {
        String key = msg.getMessageProperties().getReceivedRoutingKey();
        String serial = (String)data.get("serial");
        Position position = (Position)data.get("position");
        service.savePosition(position);

    }

}
