package ro.tuc.ds2020.controllers.handlers.dto;

import lombok.Data;
import ro.tuc.ds2020.entities.Device;
import ro.tuc.ds2020.entities.UserAccount;

@Data
public class MappingDto2 {
    UserAccount ua;
    Device dev;
}
