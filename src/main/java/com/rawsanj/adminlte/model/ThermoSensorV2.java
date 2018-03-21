package com.rawsanj.adminlte.model;


public class ThermoSensorV2 {

    private int id;
    private String value;
    private String sessionId;


    public ThermoSensorV2(){

    }

    public ThermoSensorV2(int id, String value) {
        this.id = id;
        this.value = value;
    }


    public ThermoSensorV2(int id, String value, String sessionId) {
        this.id = id;
        this.value = value;
        this.sessionId = sessionId;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    @Override
    public String toString() {
        return "ThermoSensorV2{" +
                "id=" + id +
                ", value=" + value +
                ", sessionId='" + sessionId + '\'' +
                '}';
    }
}
