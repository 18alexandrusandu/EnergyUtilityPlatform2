package ro.tuc.ds2020.controllers.handlers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.RequestEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ro.tuc.ds2020.controllers.handlers.dto.DeviceMeasurementDto;
import ro.tuc.ds2020.controllers.handlers.dto.MeasurementDto;
import ro.tuc.ds2020.entities.Device;
import ro.tuc.ds2020.entities.Measurement;
import ro.tuc.ds2020.entities.Role;
import ro.tuc.ds2020.services.implementation.DeviceServiceImplementation;

import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@CrossOrigin(origins = "*",methods = { RequestMethod.GET ,RequestMethod.POST }, allowedHeaders = "*")
public class DeviceController {
    @Autowired
    public DeviceServiceImplementation deviceServiceImplementation;


    @PostMapping("/insertDevice")
    public void postmethod2(@RequestBody Device device) {
        deviceServiceImplementation.createDevice(device);


    }

    @PostMapping("/deleteDevice")
    public void postmethod3(@RequestBody Device device) {
        deviceServiceImplementation.deleteDevice(device);

    }

    @PostMapping("/updateDevice")
    public void postmethod4(@RequestBody Device device) {
        deviceServiceImplementation.updateDevice(device);

    }

    @GetMapping("/device/{id}")
    public Device readDevice(@PathVariable(value = "id") Long Id) {
        return deviceServiceImplementation.readDevice(Id);

    }

    @GetMapping("/devices")
    public List<Device> readDevice() {
        return deviceServiceImplementation.readDevices();

    }


    @PostMapping("/insertMeasure")
    public void postmethod4(@RequestBody DeviceMeasurementDto dm) {


           Measurement m2=new Measurement();
           Float r=Float.valueOf(dm.getM().getEnergyCon());
           m2.setEnergyConsumption(r);
           m2.setUnityOfMeasurement(dm.getM().getUnityOfM());
           m2.setId(dm.getM().getId());
           System.out.println("Timestamp:"+dm.getM().getTimestamp());

           Timestamp t=Timestamp.valueOf(dm.getM().getTimestamp()+":00");
           Time tim=new Time(0,0,0);
           tim.setHours(t.getHours());
           tim.setHours(t.getMinutes());
           tim.setSeconds(t.getSeconds());
           m2.setTime(tim);
           Date dat=new Date(0,0,0);
           dat.setDate(t.getDay());
           dat.setMonth(t.getMonth());
           dat.setYear(t.getYear());
           m2.setDate(dat);
           deviceServiceImplementation.addMeasurement(dm.getD(),m2);

    }
}