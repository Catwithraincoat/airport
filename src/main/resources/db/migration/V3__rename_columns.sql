ALTER TABLE airports
    RENAME COLUMN id_deleted TO is_deleted;


ALTER TABLE boarding_passes
    RENAME COLUMN id_deleted TO is_deleted;


ALTER TABLE bookings
    RENAME COLUMN id_deleted TO is_deleted;


ALTER TABLE flights
    RENAME COLUMN id_deleted TO is_deleted;


ALTER TABLE seats
    RENAME COLUMN id_deleted TO is_deleted;


ALTER TABLE tickets
    RENAME COLUMN id_deleted TO is_deleted;


ALTER TABLE ticket_flights
    RENAME COLUMN id_deleted TO is_deleted;


