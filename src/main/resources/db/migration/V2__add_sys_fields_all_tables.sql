alter table bookings
    add column created_at TIMESTAMP,
    add column updated_at TIMESTAMP,
    add column id_deleted BOOLEAN not null DEFAULT false;


alter table boarding_passes
    add column created_at TIMESTAMP,
    add column updated_at TIMESTAMP,
    add column id_deleted BOOLEAN not null DEFAULT false;


alter table flights
    add column created_at TIMESTAMP,
    add column updated_at TIMESTAMP,
    add column id_deleted BOOLEAN not null DEFAULT false;


alter table seats
    add column created_at TIMESTAMP,
    add column updated_at TIMESTAMP,
    add column id_deleted BOOLEAN not null DEFAULT false;


alter table ticket_flights
    add column created_at TIMESTAMP,
    add column updated_at TIMESTAMP,
    add column id_deleted BOOLEAN not null DEFAULT false;


alter table tickets
    add column created_at TIMESTAMP,
    add column updated_at TIMESTAMP,
    add column id_deleted BOOLEAN not null DEFAULT false;