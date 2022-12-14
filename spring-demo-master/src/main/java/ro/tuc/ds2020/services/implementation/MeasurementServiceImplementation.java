package ro.tuc.ds2020.services.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.tuc.ds2020.entities.Measurement;
import ro.tuc.ds2020.repositories.MeasurementRepository;
import ro.tuc.ds2020.services.MeasurementService;

import java.util.List;

@Service
public class MeasurementServiceImplementation implements MeasurementService {
    @Autowired
    public MeasurementRepository measurementRepository;

    public Measurement createMeasurement( Measurement mpud)
    {

        return  measurementRepository.save(mpud);
    }
    public List<Measurement> readMeasurements()
    {

        return (List<Measurement> )measurementRepository.findAll();
    }
}
