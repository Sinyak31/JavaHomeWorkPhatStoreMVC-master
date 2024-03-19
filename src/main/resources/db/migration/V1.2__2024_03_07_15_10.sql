create table orders
(
    id      serial primary key,
    status  varchar(20) not null,
    ordered timestamp not null default current_timestamp,
    is_paid boolean not null default false
);

create table order_item
(
    id       serial primary key,
    amount   integer not null check (amount >= 0),
    item_id  integer not null references items(id),
    order_id integer not null references orders(id)
);

