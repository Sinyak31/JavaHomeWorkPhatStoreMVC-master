create table brands
(
    id      serial primary key,
    name    varchar(20) not null
);

create table categories
(
    id      serial primary key,
    name    varchar(20)
);

create table items
(
    id          serial primary key,
    model       varchar(255) not null,
    amount      integer not null,
    color       varchar(30) not null check (color = 'БЕЛЫЙ' or color = 'ЧЁРНЫЙ' or color = 'КРАСНЫЙ' or color = 'ЗЕЛЁНЫЙ' or color = 'БЕЖЕВЫЙ'),
    size        varchar(5) not null,
    sex         varchar(20) not null check (sex = 'MEN' or sex = 'WOMEN' or sex = 'UNISEX'),
    price       integer,
    brand_id    integer not null references brands,
    category_id integer not null references categories
);