insert into request_status(status) value ('Awaiting approval');
insert into request_status(status) value ('Awaiting payment');
insert into request_status(status) value ('Active');
insert into request_status(status) value ('Completed');
insert into request_status(status) value ('Overdue');
insert into request_status(status) value ('Rejected');
insert into request_status(status) value ('Canceled');
insert into request_status(status) value ('Damaged');

insert into car_status(status) value ('Free');
insert into car_status(status) value ('Service');
insert into car_status(status) value ('Reserved');
insert into car_status(status) value ('Repair');
insert into car_status(status) value ('In use');

insert into payment_status(status) value ('Waiting');
insert into payment_status(status) value ('Completed');

insert into role (role_name, access_level) value ('ROLE_ADMIN', '5');
insert into role (role_name, access_level) value ('ROLE_USER', '1');

insert into user (name, passport, email, role_id) values ('yury_admin', 'QWER', 'yury@mail.com', '1');
insert into user (name, passport, email, role_id) values ('ivan_user', 'ASDF', 'ivan@mail.com', '2');

insert into login (user_id, password) value ('1', '$2a$12$Kb8E5yCQJfDOMSvu6cJmRe2/qK.ElxNCNSRIogcgWNIuQeVqYP4qG');
insert into login (user_id, password) value ('2', '$2a$12$mdPNU67PaoF71Azu5QiG7.P4WZ.jFrLziaEb.tH4DX23bGQ9aWC0S');


insert into car (car_status_id, vendor, model, rent) values ('3', 'Opel', 'Astra', '55');
insert into car (car_status_id, vendor, model, rent) values ('1', 'Volvo', 'S40', '60');
insert into car (car_status_id, vendor, model, rent) values ('1', 'Peugeot', '407', '50');
insert into car (car_status_id, vendor, model, rent) values ('1', 'BMW', '3-series', '70');
insert into car (car_status_id, vendor, model, rent) values ('1', 'Ferrari', 'F40', '150');
insert into car (car_status_id, vendor, model, rent) values ('1', 'Ford', 'Focus', '53');
insert into car (car_status_id, vendor, model, rent) values ('1', 'Bentley', 'Continental', '120');



insert into request(user_id, car_id, rent_duration, request_status_id) values ('2', '1', '5', '1');


