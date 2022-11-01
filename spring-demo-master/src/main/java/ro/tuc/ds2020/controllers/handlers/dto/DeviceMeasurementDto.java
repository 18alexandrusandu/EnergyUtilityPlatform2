package ro.tuc.ds2020.controllers.handlers.dto;

import lombok.Data;
import ro.tuc.ds2020.entities.Measurement;
@Data
public class DeviceMeasurementDto {
    private Long d;
    private MeasurementDto m;
}
