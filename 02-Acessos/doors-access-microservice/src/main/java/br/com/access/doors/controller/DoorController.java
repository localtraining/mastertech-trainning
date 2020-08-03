package br.com.access.doors.controller;

import br.com.access.doors.model.Door;
import br.com.access.doors.model.dto.DoorMapper;
import br.com.access.doors.model.dto.DoorResponse;
import br.com.access.doors.model.dto.NewDoorRequest;
import br.com.access.doors.service.DoorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/porta")
public class DoorController {
    @Autowired
    public DoorService doorService;

    @Autowired
    public DoorMapper doorMapper;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public DoorResponse createDoor(@Valid @RequestBody NewDoorRequest newDoorRequest) {
        Door door = doorService.createDoor(doorMapper.fromDoorRequest(newDoorRequest));

        return doorMapper.toDoorResponse(door);
    }

    @GetMapping(value="/{id}")
    public DoorResponse findDoor(@PathVariable Long doorId) {
        return doorMapper.toDoorResponse(doorService.findDoorById(doorId));
    }
}