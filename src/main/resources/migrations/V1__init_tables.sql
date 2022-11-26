create table role(
                     id bigint not null auto_increment primary key,
                     role_name varchar(255) not null unique key,
                     access_level bigint not null
);


create table user (
                      id bigint not null auto_increment primary key,
                      name varchar(45) not null,
                      passport varchar(45) not null,
                      email varchar(255),
                      role_id bigint not null,
                      foreign key (role_id) references role(id)
);


create table login (
                       id bigint not null auto_increment primary key,
                       user_id bigint not null unique key,
                       password varchar(255) not null,
                       foreign key (user_id) references user(id)
);


create table car_status(
                           id bigint not null auto_increment primary key,
                           status varchar(255) not null unique key
);


create table car (
                     id bigint not null auto_increment primary key,
                     car_status_id bigint not null,
                     vendor varchar(45) not null,
                     model varchar(45) not null,
                     rent bigint not null,
                     foreign key (car_status_id) references car_status(id)
);


create table request_status(
                               id bigint not null auto_increment primary key,
                               status varchar(255) unique key
);


create table request(
                        id bigint not null auto_increment primary key,
                        user_id bigint not null,
                        car_id bigint not null,
                        rent_duration bigint not null,
                        start_date timestamp DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
                        request_status_id bigint not null,
                        comment varchar(255),
                        foreign key (user_id) references user(id),
                        foreign key (car_id) references car(id),
                        foreign key (request_status_id) references request_status(id)
);


create table payment_status(
                               id bigint not null auto_increment primary key,
                               status varchar(255) unique key
);


create table payment (
                         id bigint not null auto_increment primary key,
                         payment_status_id bigint not null,
                         request_id bigint not null,
                         amount bigint not null,
                         foreign key (payment_status_id) references payment_status(id),
                         foreign key (request_id) references request(id)
);


