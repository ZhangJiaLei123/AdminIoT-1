package com.rawsanj.adminlte.service;

import com.rawsanj.adminlte.model.ThermoSensor;
import com.rawsanj.adminlte.model.ThermoSensorV2;
import com.rawsanj.adminlte.web.controller.DashboardController;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class PageInitService {

    private static Log logger = LogFactory.getLog(DashboardController.class);

    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate;


    @Async
    public void initPage(ThermoSensorV2 sensor) throws InterruptedException {
        System.out.println("Looking up " + sensor);
        Thread.sleep(1500L);

        logger.info("thermo sensor ="+ sensor.toString());

        this.simpMessagingTemplate.convertAndSend("/topic/airquality/temperature",
                "{ \"id\":\"33\",\"value\":\""+sensor.getValue()+"\", \"sessionId\":\""+sensor.getSessionId()+"\"}");
        this.simpMessagingTemplate.convertAndSend("/topic/airquality/windspeed",
                "{ \"id\":\"33\",\"value\":\""+sensor.getValue()+"\", \"sessionId\":\""+sensor.getSessionId()+"\"}" );
    }
}
