package com.rawsanj.adminlte.model;


public class ThermoSensor {

    private String id;
    private String value;

    public ThermoSensor(){

    }


    public ThermoSensor(String id, String value) {
        this.id = id;
        this.value = value;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "ThermoSensor{" +
                "id=" + id +
                ", value=" + value +
                '}';
    }
}
