package br.com.access.control.controlmicroservice.controller;

import br.com.access.control.controlmicroservice.model.Control;
import br.com.access.control.controlmicroservice.model.ControlMapper;
import br.com.access.control.controlmicroservice.model.dto.ControlRequest;
import br.com.access.control.controlmicroservice.model.dto.ControlResponse;
import br.com.access.control.controlmicroservice.service.ControlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/acesso")
public class ControlController {
    @Autowired
    private ControlService controlService;

    @Autowired
    private ControlMapper controlMapper;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ControlResponse create(@Valid @RequestBody ControlRequest controlRequest) {
        Control control = controlMapper.fromControlRequset(controlRequest);

        return controlMapper.toControlResponse(controlService.grant(control));
    }

    @DeleteMapping("/{customerId}/{doorId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long customerId, @PathVariable Long doorId) {
        controlService.delete(customerId, doorId);
    }

    @GetMapping("/{customerId}/{doorId}")
    public ControlResponse find(@PathVariable Long customerId, @PathVariable Long doorId) {
        return controlMapper.toControlResponse(controlService.get(customerId,doorId));
    }
}
