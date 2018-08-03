package sandbox.ingestor.sensor;


import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.json.GsonJsonParser;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

@Component
public class TemperatureMeasureSender {

    private static final Logger LOGGER = LoggerFactory.getLogger(TemperatureMeasureSender.class);

    @Value("${temperature.topic}")
    String temperatureTopic;


    @Autowired
    KafkaTemplate<String,TemperatureMeasure> kafkaTemplate;




    // TODO Enhance Callback
    public void send( TemperatureMeasure temperatureMeasure) {
        LOGGER.info("sending temperatureMeasure='{}' to topic='{}'", temperatureMeasure, temperatureTopic);

        String temperatureJson = new Gson().toJson(temperatureMeasure);

        ListenableFuture<SendResult<String, TemperatureMeasure>> send = kafkaTemplate.send(temperatureTopic, temperatureMeasure);
        send.addCallback(new ListenableFutureCallback<SendResult<String, TemperatureMeasure>>() {

            @Override
            public void onSuccess(SendResult<String, TemperatureMeasure> result) {
                   LOGGER.info("SUCCESS");
            }

            @Override
            public void onFailure(Throwable ex) {
                LOGGER.error("FAILURE",ex);
            }

        });
    }

}
