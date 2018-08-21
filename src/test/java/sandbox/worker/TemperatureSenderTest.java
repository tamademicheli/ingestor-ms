package sandbox.worker;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import sandbox.repositories.TemperatureMeasure;
import sandbox.ingestor.temperature.TemperatureSender;

import java.time.LocalDateTime;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TemperatureSenderTest {

	@Autowired
	TemperatureSender sender;


	@Test
	public void testSendTemperature_Successfull() {
		Assert.assertNotNull(sender);
		TemperatureMeasure temperatureMeasure = new TemperatureMeasure();
		temperatureMeasure.setDeviceId("bosch-heinrichstrasse-x123");
		temperatureMeasure.setMeasureTime(LocalDateTime.now());
		temperatureMeasure.setLatitude("47.388468");
		temperatureMeasure.setLongitude("8.521560");



        sender.send( temperatureMeasure );

	}

}
