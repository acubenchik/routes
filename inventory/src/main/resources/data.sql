insert into route(id, name, length, description) values (1, 'Karpaty', '50km', 'description');
insert into route(id, name, length, description) values (2, 'short route', '20km', 'description');
insert into route(id, name, length, description) values (3, 'medium route', '30km', 'description');
insert into route(id, name, length, description) values (4, 'short route 2', '20km', 'description');
insert into route(id, name, length, description) values (5, 'medium route 2', '30km', 'description');
insert into route(id, name, length, description) values (6, 'short route 3', '20km', 'description');
insert into guide(id, info, name) values (1, 'Deus Ex', 'John Smith');
insert into guide(id, info, name) values (2, 'Deus Ex', 'Johnny Walker');
insert into route_time_slot(id, guide_id, route_id, available_date) values (1, 1, 1, PARSEDATETIME ('31-05-18 11:34:24','dd-MM-yy hh:mm:ss'));
insert into route_time_slot(id, guide_id, route_id, available_date) values (2, 2, 1,  PARSEDATETIME ('28-05-18 11:34:24','dd-MM-yy hh:mm:ss'));