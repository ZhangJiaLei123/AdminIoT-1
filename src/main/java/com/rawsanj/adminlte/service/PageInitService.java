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
    public void initPage(String sessionId,String lastThermoQt1,String lastThermoQt2
            ,String lastThermoQt3 , String lastThermoQt4, String lastThermodQt1, String lastThermodQt3
            ,String lastThermoWt1 , String lastThermoWt3, String lastThermoWt4 ) throws InterruptedException {
        //System.out.println("Looking up " + lastThermoQt1);
        Thread.sleep(1500L);
        logger.info("lastThermoQt1 ="+ lastThermoQt1);

        //this.simpMessagingTemplate.convertAndSend("/topic/airquality/temperatureQt1", ""+ new ThermoSensorV2(33,lastThermoQt1,sessionId));
        this.simpMessagingTemplate.convertAndSend("/topic/airquality/temperatureQt1","{ \"id\":\"33\",\"value\":\""+lastThermoQt1+"\", \"sessionId\":\""+sessionId+"\"}");
        //this.simpMessagingTemplate.convertAndSend("/topic/airquality/temperatureQt2", ""+ new ThermoSensorV2(33,lastThermoQt2,sessionId));
        this.simpMessagingTemplate.convertAndSend("/topic/airquality/temperatureQt2","{ \"id\":\"33\",\"value\":\""+lastThermoQt2+"\", \"sessionId\":\""+sessionId+"\"}");
        //this.simpMessagingTemplate.convertAndSend("/topic/airquality/temperatureQt3", ""+ new ThermoSensorV2(33,lastThermoQt3,sessionId));
        this.simpMessagingTemplate.convertAndSend("/topic/airquality/temperatureQt3","{ \"id\":\"33\",\"value\":\""+lastThermoQt3+"\", \"sessionId\":\""+sessionId+"\"}");
        //this.simpMessagingTemplate.convertAndSend("/topic/airquality/temperatureQt4", ""+ new ThermoSensorV2(33,lastThermoQt4,sessionId));
        this.simpMessagingTemplate.convertAndSend("/topic/airquality/temperatureQt4","{ \"id\":\"33\",\"value\":\""+lastThermoQt4+"\", \"sessionId\":\""+sessionId+"\"}");
        //this.simpMessagingTemplate.convertAndSend("/topic/airquality/temperaturedQt1", ""+ new ThermoSensorV2(33,lastThermodQt1,sessionId));
        this.simpMessagingTemplate.convertAndSend("/topic/airquality/temperaturedQt1","{ \"id\":\"33\",\"value\":\""+lastThermodQt1+"\", \"sessionId\":\""+sessionId+"\"}");
        //this.simpMessagingTemplate.convertAndSend("/topic/airquality/temperaturedQt3", ""+ new ThermoSensorV2(33,lastThermodQt3,sessionId));
        this.simpMessagingTemplate.convertAndSend("/topic/airquality/temperaturedQt3","{ \"id\":\"33\",\"value\":\""+lastThermodQt3+"\", \"sessionId\":\""+sessionId+"\"}");
        //this.simpMessagingTemplate.convertAndSend("/topic/airquality/temperatureWt1", ""+ new ThermoSensorV2(33,lastThermoWt1,sessionId));
        this.simpMessagingTemplate.convertAndSend("/topic/airquality/temperatureWt1","{ \"id\":\"33\",\"value\":\""+lastThermoWt1+"\", \"sessionId\":\""+sessionId+"\"}");
        //this.simpMessagingTemplate.convertAndSend("/topic/airquality/temperatureWt3", ""+ new ThermoSensorV2(33,lastThermoWt3,sessionId));
        this.simpMessagingTemplate.convertAndSend("/topic/airquality/temperatureWt3","{ \"id\":\"33\",\"value\":\""+lastThermoWt3+"\", \"sessionId\":\""+sessionId+"\"}");
        //this.simpMessagingTemplate.convertAndSend("/topic/airquality/temperatureWt4", ""+ new ThermoSensorV2(33,lastThermoWt4,sessionId));
        this.simpMessagingTemplate.convertAndSend("/topic/airquality/temperatureWt4","{ \"id\":\"33\",\"value\":\""+lastThermoWt4+"\", \"sessionId\":\""+sessionId+"\"}");

    }
}
