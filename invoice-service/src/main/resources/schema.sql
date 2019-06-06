DROP TABLE if exists reward_point;
DROP TABLE if exists discount;

create table if not exists  reward_point (
    id int(11) not null auto_increment,
    point DOUBLE not null,
    value DOUBLE not null,
    primary key (id)
);

create table if not exists  discount (
  id int(11) not null auto_increment,
  discount DOUBLE not null,
  price_range int(11),
  primary key (id)
);
