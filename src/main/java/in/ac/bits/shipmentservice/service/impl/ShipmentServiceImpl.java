package in.ac.bits.shipmentservice.service.impl;

import com.google.gson.Gson;
import in.ac.bits.shipmentservice.domain.OrderDetails;
import in.ac.bits.shipmentservice.model.Shipments;
import in.ac.bits.shipmentservice.repository.ShipmentsRepository;
import in.ac.bits.shipmentservice.service.ShipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Optional;

@Service
public class ShipmentServiceImpl implements ShipmentService {

    @Autowired
    ShipmentsRepository shipmentsRepository;

    @Override
    public void handleOrder(OrderDetails orderDetails) {
        Shipments shipment = new Shipments();
        shipment.setDate(Instant.now().toString());
        shipment.setOrderDetails(new Gson().toJson(orderDetails));
        shipment.setStatus("REGISTERED");
        saveShipmentToDB(shipment);
        System.out.println("Shipment successfully created");
    }

    @Override
    public String getStatus(String id) throws NoSuchMethodException {
        Optional<Shipments> shipment = shipmentsRepository.findById(Integer.parseInt(id));
        if(shipment.isPresent()) {
            return shipment.get().getStatus();
        } else {
            throw new NoSuchMethodException("Shipment not found");
        }
    }

    private void saveShipmentToDB(Shipments shipment) {
        shipmentsRepository.save(shipment);
    }
}
