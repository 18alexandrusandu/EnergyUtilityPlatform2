package ro.tuc.ds2020.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ro.tuc.ds2020.entities.Measurement;
import ro.tuc.ds2020.entities.Role;

import java.util.Optional;

@Repository
public interface MeasurementRepository extends CrudRepository<Measurement,Long> {
    public Optional<Measurement> findById(Long Id);
}
