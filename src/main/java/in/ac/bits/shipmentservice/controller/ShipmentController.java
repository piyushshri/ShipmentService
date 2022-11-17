package in.ac.bits.shipmentservice.controller;

import in.ac.bits.shipmentservice.service.ShipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ShipmentController {

    @Autowired
    ShipmentService shipmentservice;

    @GetMapping("/shipment/{id}/status")
    public ResponseEntity getShipment(@PathVariable String id){
        try {
            String status = shipmentservice.getStatus(id);
            return ResponseEntity.ok(status);
        } catch (NoSuchMethodException e) {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }
}
