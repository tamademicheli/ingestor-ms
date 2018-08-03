package sandbox.ingestor.sensor;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.ws.rs.core.Response;

@RestController
public class IngestSensorDataRestController {


    @Autowired
    TemperatureMeasureSender sender;


    @PostMapping(path = "/tempmeasure")
    public Response ingestTemperature(TemperatureMeasure measure) {

        sender.send(measure);

        return Response.status(Response.Status.OK).build();


    }
}
