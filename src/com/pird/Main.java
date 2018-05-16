package com.pird;


import org.eclipse.paho.client.mqttv3.MqttException;

public class Main {

    public static void main(String[] args) {

        String Broken = "tcp://10.108.0.45:1883";
        String client = "charlie";
        try {
            MQTTsClient mc = new MQTTsClient(Broken, client);
            mc.SuscribeTopic("tele/sonoff/SENSOR");
            mc.Publish("cmnd/sonoff/POWER", "TOGGLE");

        } catch (MqttException e) {
            e.printStackTrace();
        }

    }
}
