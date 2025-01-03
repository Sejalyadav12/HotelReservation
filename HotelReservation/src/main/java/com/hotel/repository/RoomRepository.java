package com.hotel.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hotel.model.Room;

@Repository
public interface RoomRepository extends JpaRepository<Room, Long> {
    List<Room> findByAvailabilityTrue();
}
