insert into route(id, name, length) values (1, 'long route', '50km');
insert into route(id, name, length) values (2, 'short route', '40km');
insert into guide(id, info, name) values (1, 'info1', 'name1');
insert into guide(id, info, name) values (2, 'info2', 'name2');
insert into route_time_slot(id, guide_id, route_id, available_date) values (1, 1, 1, PARSEDATETIME ('31-05-18 11:34:24','dd-MM-yy hh:mm:ss'));
insert into route_time_slot(id, guide_id, route_id, available_date) values (2, 2, 1,  PARSEDATETIME ('28-05-18 11:34:24','dd-MM-yy hh:mm:ss'));