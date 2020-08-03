package br.com.access.control.controlmicroservice.model;

import br.com.access.control.controlmicroservice.model.dto.ControlResponse;
import org.springframework.stereotype.Component;

@Component
public class ControlMapper {
    public ControlResponse toControlResponse(Control control) {
        ControlResponse controlResponse = new ControlResponse();

        controlResponse.setCustomerId(control.getCustomerId());
        controlResponse.setDoorId(control.getDoorId());

        return controlResponse;
    }
}
