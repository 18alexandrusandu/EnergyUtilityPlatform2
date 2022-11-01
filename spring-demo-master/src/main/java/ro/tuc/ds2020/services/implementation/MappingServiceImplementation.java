package ro.tuc.ds2020.services.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.tuc.ds2020.entities.Device;
import ro.tuc.ds2020.entities.UserAccount;
import ro.tuc.ds2020.repositories.DeviceRepository;
import ro.tuc.ds2020.repositories.UserRepository;

import java.util.Iterator;
import java.util.List;
@Service


public class MappingServiceImplementation {
     @Autowired
    public UserRepository userRepository;

    @Autowired
    public DeviceRepository deviceRepository;


    public void addDeviceToUser(Long userId, Long deviceId) {
        UserAccount ua1= userRepository.findById(userId).get();
        if(ua1!=null)
        {
            Device dev=deviceRepository.findById(deviceId).get();
            ua1.getDevices().add(dev);
            userRepository.save(ua1);
        }
    }
    public void deletedevice(Long ua, Long dev) {
        UserAccount ua1= userRepository.findById(ua).get();
        Device dev1= deviceRepository.findById(dev).get();

        if(ua1!=null)
        {

            System.out.println(ua1.getDevices());
            System.out.println(dev1);
           for(int i=0;i< ua1.getDevices().size();i++)
           {
               Device dev2=ua1.getDevices().get(i);
               if(dev2.getId()==dev1.getId()) {
                   ua1.getDevices().remove(dev2);
                   i--;
               }
                          ;}

            userRepository.save(ua1);
        }
    }

}
