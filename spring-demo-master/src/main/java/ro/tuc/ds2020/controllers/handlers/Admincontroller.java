package ro.tuc.ds2020.controllers.handlers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ro.tuc.ds2020.controllers.handlers.dto.MappingDto;
import ro.tuc.ds2020.controllers.handlers.dto.MappingDto2;
import ro.tuc.ds2020.entities.Device;
import ro.tuc.ds2020.entities.UserAccount;
import ro.tuc.ds2020.services.implementation.MappingServiceImplementation;

import java.util.List;

@RestController
@CrossOrigin(origins = "*",methods = { RequestMethod.GET ,RequestMethod.POST }, allowedHeaders = "*")
public class Admincontroller {
    @Autowired
    MappingServiceImplementation mappingService;

    @PostMapping("/addDeviceToUser")
    public void postmethod2(@RequestBody MappingDto md)
    {    System.out.println("mapping"+md);
         mappingService.addDeviceToUser(md.getUa(),md.getDev());


    }

    @PostMapping("/deleteDeviceFromUser")
    public void postmethod4(@RequestBody MappingDto md)
    {
        System.out.println("delete here");
        mappingService.deletedevice(md.getUa(),md.getDev());


    }


}
