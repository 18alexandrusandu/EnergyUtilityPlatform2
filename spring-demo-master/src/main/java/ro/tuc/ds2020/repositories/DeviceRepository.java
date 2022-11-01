package ro.tuc.ds2020.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ro.tuc.ds2020.entities.Device;
import ro.tuc.ds2020.entities.Role;

import java.util.Optional;
@Repository
public interface DeviceRepository   extends CrudRepository<Device,Long>
{
    public Optional<Device> findById(Long Id);
}
