package sandbox.ingestor.sensor;

import java.time.LocalTime;

public class TemperatureMeasure {

    LocalTime measureTime;
    String latitude;
    String longitude;
    String deviceId;

    public LocalTime getMeasureTime() {
        return measureTime;
    }

    public void setMeasureTime(LocalTime measureTime) {
        this.measureTime = measureTime;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }
}
