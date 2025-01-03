_# HotelReservation
RESTful services for managing hotel room reservation for a hotel. Users should be able to reserve hotel room, view all available rooms, cancel reservation.

Entities (with attributes):
•	Room:Room ID, room number, type (single, double, suite), price, availability.
•	Reservation:Reservation ID, guest name, check-in date, check-out date, room ID, total price.
Users should be able to reserve hotel room, view all available rooms, cancel reservation.

Entities (with attributes):
•	Room:Room ID, room number, type (single, double, suite), price, availability.
•	Reservation:Reservation ID, guest name, check-in date, check-out date, room ID, total price.

Endpoints:
1.	Create Reservation:
•	Endpoint: POST /reservations
•	Request:JSON payload containing reservation details (guest name, check-in date, check-out date, room ID).
•	Response: Confirmation of the created reservation.

2.	Get Available rooms:
•	Endpoint: GET /rooms?available=yes
•	Request: Get all available rooms.
•	Response: Return the details of available rooms in JSON format.

3.	Cancel Reservation:
•	Endpoint: DELETE /reservations/{reservationId}
•	RequestCancel a reservation by providing its unique identifier.
•	Response: Confirmation of the canceled reservation.

API testing link -  http://localhost:8080/swagger-ui/index.html#/
