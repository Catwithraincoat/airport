alter table airports
    add column created_at TIMESTAMP,
    add column updated_at TIMESTAMP,
    add column id_deleted BOOLEAN not null DEFAULT false;