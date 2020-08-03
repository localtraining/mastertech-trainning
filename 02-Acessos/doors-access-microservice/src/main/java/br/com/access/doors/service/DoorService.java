package br.com.access.doors.service;

import br.com.access.doors.exception.DoorNotFoundException;
import br.com.access.doors.model.Door;
import br.com.access.doors.repository.DoorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DoorService {
    @Autowired
    public DoorRepository floorRepository;

    public Door createDoor(Door door) {
        return floorRepository.save(door);
    }

    public Door findDoorById(Long id) {
        return floorRepository.findById(id).orElseThrow(DoorNotFoundException::new);
    }
}