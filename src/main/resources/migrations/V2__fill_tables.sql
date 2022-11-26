insert into request_status(status) value ('Awaiting approval');
insert into request_status(status) value ('Awaiting payment');
insert into request_status(status) value ('Active');
insert into request_status(status) value ('Completed');
insert into request_status(status) value ('Overdue');
insert into request_status(status) value ('Rejected');

insert into car_status(status) value ('Free');
insert into car_status(status) value ('Service');
insert into car_status(status) value ('Reserved');
insert into car_status(status) value ('Repair');
insert into car_status(status) value ('In use');

insert into payment_status(status) value ('Awaiting payment');
insert into payment_status(status) value ('Rejected');
insert into payment_status(status) value ('Completed');

insert into role (role_name, access_level) value ('ROLE_ADMIN', '5');
insert into role (role_name, access_level) value ('ROLE_USER', '1');

insert into user (name, passport, email, role_id) values ('yury_admin', 'QWER', 'yury@mail.com', '1');
insert into user (name, passport, email, role_id) values ('ivan_user', 'ASDF', 'ivan@mail.com', '2');
insert into user (name, passport, email, role_id) values ('roman_user', 'ZXCV', 'roman@mail.com', '2');
insert into user (name, passport, email, role_id) values ('dima_user', 'POIU', 'dimon@mail.com', '2');

insert into login (user_id, password) value ('1', '$2a$12$Kb8E5yCQJfDOMSvu6cJmRe2/qK.ElxNCNSRIogcgWNIuQeVqYP4qG');
insert into login (user_id, password) value ('2', '$2a$12$mdPNU67PaoF71Azu5QiG7.P4WZ.jFrLziaEb.tH4DX23bGQ9aWC0S');
insert into login (user_id, password) value ('3', '333');
insert into login (user_id, password) value ('4', '444');

insert into car (car_status_id, vendor, model, rent) values ('1', 'Opel', 'Astra', '1000');
insert into car (car_status_id, vendor, model, rent) values ('3', 'Volvo', 'S40', '1100');
insert into car (car_status_id, vendor, model, rent) values ('1', 'Peugeot', '407', '600');
insert into car (car_status_id, vendor, model, rent) values ('1', 'BMW', '3-series', '1300');
insert into car (car_status_id, vendor, model, rent) values ('4', 'Ferrari', 'F40', '2500');
insert into car (car_status_id, vendor, model, rent) values ('1', 'Ford', 'Focus', '1150');
insert into car (car_status_id, vendor, model, rent) values ('2', 'Bentley', 'Continental', '2350');



insert into request(user_id, car_id, rent_duration, request_status_id) values ('2', '1', '5', '1');
insert into request(user_id, car_id, rent_duration, request_status_id) values ('3', '2', '2', '2');
insert into request(user_id, car_id, rent_duration, request_status_id) values ('4', '3', '14', '1');



insert into payment(payment_status_id, request_id, amount) value ('1', '2', '1100');