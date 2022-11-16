package in.ac.bits.shipmentservice.repository;

import in.ac.bits.shipmentservice.model.Shipments;
import org.springframework.data.repository.CrudRepository;

public interface ShipmentsRepository extends CrudRepository<Shipments, Integer> {
}
