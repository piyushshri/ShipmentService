package in.ac.bits.shipmentservice.service;

import in.ac.bits.shipmentservice.domain.OrderDetails;

public interface ShipmentService {
    void handleOrder(OrderDetails orderDetails);

    String getStatus(String id) throws NoSuchMethodException;
}
