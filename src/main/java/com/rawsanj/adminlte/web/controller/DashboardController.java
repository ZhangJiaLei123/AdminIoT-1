package com.rawsanj.adminlte.web.controller;

import com.rawsanj.adminlte.dto.ChartDataDTO;
import com.rawsanj.adminlte.model.ThermoSensor;
import com.rawsanj.adminlte.model.ThermoSensorV2;
import com.rawsanj.adminlte.service.PageInitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.apache.commons.logging.LogFactory;
import org.apache.commons.logging.Log;


import java.util.List;
import java.util.Random;


@Controller
public class DashboardController {

    private static Log logger = LogFactory.getLog(DashboardController.class);

    private  String lastThermo;

    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate;

    @Autowired
    private PageInitService pageInitService;


    @RequestMapping("/")
    public String index() {
        return "dashboard/index";
    }

    @RequestMapping("/index2")
    public String index2() {
        return "dashboard/index2";
    }




    // Added to test 500 page
    @RequestMapping(path = "/tigger-error", produces = MediaType.APPLICATION_JSON_VALUE)
    public void error500() throws Exception {
        throw new Exception();
    }

    @RequestMapping(value = "/data", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> getData() {
        return ResponseEntity.ok(new ChartDataDTO(System.currentTimeMillis(), new Random().nextInt(100)));
    }


    @PostMapping("/sensors/thermoinit")
    public ResponseEntity<String> temperatureinit(@RequestBody ThermoSensorV2 sensor) {

        try {
            if (lastThermo!=null) {
                sensor.setValue(lastThermo);
                pageInitService.initPage(sensor);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return ResponseEntity.status(HttpStatus.ACCEPTED).contentType(MediaType.TEXT_PLAIN).body("success");
    }


    @PostMapping("/sensors/thermo")
    public ResponseEntity<String> temperature(@RequestBody List<ThermoSensor> sensors) {

        for(ThermoSensor sensor : sensors){
            logger.info("thermo sensor ="+ sensor.toString());
            if(sensor.getId().equals("Qt1")) {
                lastThermo = sensor.getValue();
                this.simpMessagingTemplate.convertAndSend("/topic/airquality/temperatureQt1", "" + sensor.getValue());
            }
            if(sensor.getId().equals("Qt2")) {
                lastThermo = sensor.getValue();
                this.simpMessagingTemplate.convertAndSend("/topic/airquality/temperatureQt2", "" + sensor.getValue());
            }
            if(sensor.getId().equals("Qt3")) {
                lastThermo = sensor.getValue();
                this.simpMessagingTemplate.convertAndSend("/topic/airquality/temperatureQt3", "" + sensor.getValue());
            }
            if(sensor.getId().equals("Qt4")) {
                lastThermo = sensor.getValue();
                this.simpMessagingTemplate.convertAndSend("/topic/airquality/temperatureQt4", "" + sensor.getValue());
            }
            if(sensor.getId().equals("dQt1")) {
                lastThermo = sensor.getValue();
                this.simpMessagingTemplate.convertAndSend("/topic/airquality/temperaturedQt1", "" + sensor.getValue());
            }
            if(sensor.getId().equals("dQt3")) {
                lastThermo = sensor.getValue();
                this.simpMessagingTemplate.convertAndSend("/topic/airquality/temperaturedQt3", "" + sensor.getValue());
            }
            if(sensor.getId().equals("Wt1")) {
                lastThermo = sensor.getValue();
                this.simpMessagingTemplate.convertAndSend("/topic/airquality/temperatureWt1", "" + sensor.getValue());
            }
            if(sensor.getId().equals("Wt3")) {
                lastThermo = sensor.getValue();
                this.simpMessagingTemplate.convertAndSend("/topic/airquality/temperatureWt3", "" + sensor.getValue());
            }
            if(sensor.getId().equals("Wt4")) {
                lastThermo = sensor.getValue();
                this.simpMessagingTemplate.convertAndSend("/topic/airquality/temperatureWt4", "" + sensor.getValue());
            }

        }

        return ResponseEntity.status(HttpStatus.ACCEPTED).contentType(MediaType.TEXT_PLAIN).body("success");
    }

    @PostMapping("/sensors/count")
    public ResponseEntity<String> count(@RequestBody ThermoSensor sensor) {

        logger.info("count sensor = "+ sensor.toString());

        this.simpMessagingTemplate.convertAndSend("/topic/airquality/count", ""+sensor.getValue() );
        return ResponseEntity.status(HttpStatus.ACCEPTED).contentType(MediaType.TEXT_PLAIN).body("success");

    }

    @PostMapping("/sensors/humidity")
    public ResponseEntity<String> humidity(@RequestBody ThermoSensor sensor) {

        logger.info("humidity sensor = "+ sensor.toString());

        this.simpMessagingTemplate.convertAndSend("/topic/airquality/humidity", ""+sensor.getValue() );
        return ResponseEntity.status(HttpStatus.ACCEPTED).contentType(MediaType.TEXT_PLAIN).body("success");

    }

}
