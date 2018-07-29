truncate table drink;
insert into drink(DRINK_ID, drink_name, price) values (1, 'オレンジジュース', 120);
insert into drink(DRINK_ID, drink_name, price) values (2, 'コーラ', 120);
insert into drink(DRINK_ID, drink_name, price) values (3, 'お茶', 100);
insert into drink(DRINK_ID, drink_name, price) values (4, 'コーヒー', 150);
insert into drink(DRINK_ID, drink_name, price) values (5, '水', 80);

truncate table user;
insert into user(USERNAME, PASSWORD) values ('shirajun', '$2a$10$JDABEH/TnOss16bxt1I21eF5VNx1iSyVE4FR2LHT4q7z1UE/KP5yS');