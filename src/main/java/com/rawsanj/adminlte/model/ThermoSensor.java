package com.rawsanj.adminlte.model;


public class ThermoSensor {

    private int id;
    private Integer value;

    public ThermoSensor(){

    }


    public ThermoSensor(int id, Integer value) {
        this.id = id;
        this.value = value;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
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
