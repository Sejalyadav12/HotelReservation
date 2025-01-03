package com.hotel.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hotel.dto.RoomDTO;
import com.hotel.service.RoomService;

@RestController
public class RoomController {

    @Autowired
    private RoomService roomService;

    @GetMapping("/rooms")
    public ResponseEntity<List<RoomDTO>> getAvailableRooms(@RequestParam(value = "available", defaultValue = "no") String available) {
        if ("yes".equalsIgnoreCase(available)) {
            List<RoomDTO> rooms = roomService.getAvailableRooms();
            return ResponseEntity.ok(rooms);
        } else {
            return ResponseEntity.noContent().build();
        }
    }
}
