package sandbox.worker.temperature;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import sandbox.repositories.TemperatureMeasure;

import javax.ws.rs.core.Response;

@RestController
public class TemperatureIngestorRest {


    @Autowired
    TemperatureSender sender;


    @PostMapping(path = "/tempmeasure")
    public Response ingestTemperature(@RequestBody TemperatureMeasure measure) {

        sender.send(measure);

        return Response.status(Response.Status.OK).build();


    }
}
