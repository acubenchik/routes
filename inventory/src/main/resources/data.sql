insert into route(id, name, length) values (1, 'long route', '50km');
insert into route(id, name, length) values (2, 'short route', '40km');
insert into guide(id, info, name) values (1, 'info1', 'name1');
insert into guide(id, info, name) values (2, 'info2', 'name2');
insert into route_time_slot(id, guide_id, route_id) values (1, 1, 1);
insert into route_time_slot(id, guide_id, route_id) values (2, 2, 1);