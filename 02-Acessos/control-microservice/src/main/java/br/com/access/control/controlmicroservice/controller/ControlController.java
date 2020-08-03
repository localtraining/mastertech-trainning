package br.com.access.control.controlmicroservice.controller;

import br.com.access.control.controlmicroservice.model.Control;
import br.com.access.control.controlmicroservice.model.ControlMapper;
import br.com.access.control.controlmicroservice.model.dto.ControlResponse;
import br.com.access.control.controlmicroservice.service.ControlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/acesso")
public class ControlController {
    @Autowired
    private ControlService controlService;

    @Autowired
    private ControlMapper controlMapper;

    @PostMapping
    public ControlResponse create(Control control) {
        return controlMapper.toControlResponse(controlService.grant(control));
    }

    @GetMapping("/acesso/{customerId}/{doorId}")
    public ControlResponse find(@PathVariable Long customerId, @PathVariable Long doorId) {
        return controlMapper.toControlResponse(controlService.get(customerId,doorId));
    }
}
