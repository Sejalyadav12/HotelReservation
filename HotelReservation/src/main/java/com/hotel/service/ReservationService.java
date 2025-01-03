package com.hotel.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotel.dto.ReservationDTO;
import com.hotel.model.Reservation;
import com.hotel.model.Room;
import com.hotel.repository.ReservationRepository;
import com.hotel.repository.RoomRepository;

@Service
public class ReservationService {

    @Autowired
    private ReservationRepository reservationRepository;

    @Autowired
    private RoomRepository roomRepository;

    @Autowired
    private ModelMapper modelMapper;

    public ReservationDTO createReservation(ReservationDTO reservationDTO) {
        Room room = roomRepository.findById(reservationDTO.getRoomId())
                                  .orElseThrow(() -> new RuntimeException("Room not found"));
        if (!room.isAvailability()) {
            throw new RuntimeException("Room is not available");
        }

        Reservation reservation = modelMapper.map(reservationDTO, Reservation.class);
        reservation.setRoom(room);
        reservation.setTotalPrice(room.getPrice() * (reservationDTO.getCheckOutDate().toEpochDay() - reservationDTO.getCheckInDate().toEpochDay()));
        room.setAvailability(false);
        roomRepository.save(room);
        return modelMapper.map(reservationRepository.save(reservation), ReservationDTO.class);
    }

    public void cancelReservation(Long reservationId) {
        Reservation reservation = reservationRepository.findById(reservationId)
                                                      .orElseThrow(() -> new RuntimeException("Reservation not found"));

        Room room = reservation.getRoom();
        room.setAvailability(true);
        roomRepository.save(room);
        reservationRepository.delete(reservation);
    }
}
