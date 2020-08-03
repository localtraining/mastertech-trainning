package br.com.access.doors.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class NewDoorRequest {
    @NotBlank
    @JsonProperty("andar")
    private String floor;

    @JsonProperty("sala")
    @Size(min = 5)
    private String room;

    public String getFloor() {
        return floor;
    }

    public void setFloor(String floor) {
        this.floor = floor;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }
}
