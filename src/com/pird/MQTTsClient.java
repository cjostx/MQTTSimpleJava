package com.pird;

import org.eclipse.paho.client.mqttv3.*;

public class MQTTsClient implements MqttCallback {


    MqttClient mClient;
    private MqttConnectOptions connOpt;


    public MQTTsClient (String URLBroken, String clientid) throws MqttException {
        connOpt = new MqttConnectOptions();
        connOpt.setCleanSession(true);
        connOpt.setKeepAliveInterval(30);
        mClient = new MqttClient(URLBroken, clientid);
        mClient.setCallback(this);
        mClient.connect(connOpt);
        System.out.println("Conectado a "+mClient.getServerURI());

    }

    public void SuscribeTopic(String topic) throws MqttException {
        this.SuscribeTopic(topic, 0);
    }

    public void SuscribeTopic(String topic, int subQos) throws MqttException {
        mClient.subscribe(topic, subQos);
    }

    public void Publish(String topic, String msg) throws MqttException {
        MqttMessage message = new MqttMessage(msg.getBytes());
        mClient.publish(topic, message);
    }


    @Override
    public void connectionLost(Throwable throwable) {

    }

    @Override
    public void messageArrived(String s, MqttMessage mqttMessage) throws Exception {
        System.out.println(new String(mqttMessage.getPayload()));
    }

    @Override
    public void deliveryComplete(IMqttDeliveryToken iMqttDeliveryToken) {

    }
}
