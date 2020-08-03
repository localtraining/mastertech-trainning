package br.com.access.control.controlmicroservice.model;

import br.com.access.control.controlmicroservice.model.dto.ControlRequest;
import br.com.access.control.controlmicroservice.model.dto.ControlResponse;
import org.springframework.stereotype.Component;

@Component
public class ControlMapper {
    public Control fromControlRequset(ControlRequest controlRequest) {
        Control control = new Control();

        control.setCustomerId(controlRequest.getCustomerId());
        control.setDoorId(controlRequest.getDoorId());

        return control;
    }

    public ControlResponse toControlResponse(Control control) {
        ControlResponse controlResponse = new ControlResponse();

        controlResponse.setCustomerId(control.getCustomerId());
        controlResponse.setDoorId(control.getDoorId());

        return controlResponse;
    }
}
