package br.com.access.doors.model.dto;

import br.com.access.doors.model.Door;
import org.springframework.stereotype.Component;

@Component
public class DoorMapper {
    public Door fromDoorRequest(NewDoorRequest newDoor) {
        Door door = new Door();

        door.setFloor(newDoor.getFloor());
        door.setRoom(newDoor.getRoom());

        return door;
    }

    public DoorResponse toDoorResponse(Door door) {
        DoorResponse doorResponse = new DoorResponse();

        doorResponse.setId(door.getId());
        doorResponse.setFloor(door.getFloor());
        doorResponse.setRoom(door.getRoom());

        return doorResponse;
    }
}
