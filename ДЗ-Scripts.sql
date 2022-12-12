--Задания 1, 2
create sequence sq_genres
    minvalue 1
    maxvalue 999999999999999999999999
    start with 1
    increment by 1
    cache 20;
create table genres (
                        id number default sq_genres.nextval not null,
                        name varchar2(255),
                        constraint pk_genres primary key (id)
);
create sequence sq_performers
    minvalue 1
    maxvalue 999999999999999999999999
    start with 1
    increment by 1
    cache 20;
create table perfomers (
                           id number default sq_performers.nextval not null,
                           name varchar2(255),
                           constraint pk_performers primary key (id)
);
create sequence sq_albums
    minvalue 1
    maxvalue 999999999999999999999999
    start with 1
    increment by 1
    cache 20;
create table albums(
                       id number default sq_albums.nextval not null,
                       name varchar2(255),
                       constraint pk_albums primary key (id)
);
create sequence sq_tracks
    minvalue 1
    maxvalue 999999999999999999999999
    start with 1
    increment by 1
    cache 20;
create table tracks (
                        id number default sq_tracks.nextval not null,
                        name varchar2(255) not null,
                        year varchar2(4),
                        length varchar2(20),
                        number_of_plays number,
                        genre_id number,
                        album_id number,
                        performer_id number,
                        constraint pk_tracks primary key (id),
                        constraint  fk_genre_id foreign key (genre_id) references genres(id),
                        constraint fk_album_id foreign key (album_id) references albums(id),
                        constraint fk_performer_id foreign key (performer_id) references perfomers(id)
);

--Задание 3
insert into genres (name) values ('Pop');
insert into genres (name) values ('Rock');
insert into genres (name) values ('Hip Hop');
insert into perfomers (name) values ('Madonna');
insert into perfomers (name) values ('Alan Walker');
insert into perfomers (name) values ('Elvis Presley');
insert into perfomers (name) values ('Elton John');
insert into albums (name) values ('Ray of Light');
insert into albums (name) values ('American Life');
insert into albums (name) values ('The Diving Board');
insert into tracks (name, year, length, number_of_plays, genre_id, album_id, performer_id)
values ('Frozen', 1998, '6:12', 142, (select id from genres where name = 'Pop'), (select id from albums where name = 'Ray of Light'), (select id from perfomers where name = 'Madonna'));
insert into tracks (name, year, length, number_of_plays, genre_id, album_id, performer_id)
values ('Swim', 1998, '5:00', 245, (select id from genres where name = 'Pop'), (select id from albums where name = 'Ray of Light'), (select id from perfomers where name = 'Madonna'));
insert into tracks (name, year, length, number_of_plays, genre_id, album_id, performer_id)
values ('Hollywood', 2003, '4:24', 365, (select id from genres where name = 'Pop'), (select id from albums where name = 'American Life'), (select id from perfomers where name = 'Madonna'));
insert into tracks (name, year, length, number_of_plays, genre_id, album_id, performer_id)
values ('Die Another Day', 2003, '4:38', 365, (select id from genres where name = 'Pop'), (select id from albums where name = 'American Life'), (select id from perfomers where name = 'Madonna'));
insert into tracks (name, year, length, number_of_plays, genre_id, album_id, performer_id)
values ('Oceans Away', 2013, '3:58', 365, (select id from genres where name = 'Rock'), (select id from albums where name = 'The Diving Board'), (select id from perfomers where name = 'Elton John'));

--Задание 4
select p.name, t.name, g.name from tracks t
left join perfomers p on t.performer_id = p.id
left join albums a on a.id = t.performer_id
left join genres g on t.genre_id = g.id
where g.name = 'Rock';

--Задание 5
select * from perfomers where id not in (
    select distinct t.performer_id from tracks t where t.genre_id = (select id from genres where name = 'Pop')
);

--Задание 6
select t.* from tracks t, genres g
where t.genre_id = g.id and g.name = 'Pop' and t.number_of_plays > 200;

--Задание 7
select p.name, avg(t.number_of_plays) as average_number_of_plays from tracks t
left join genres g on g.id = t.genre_id
left join perfomers p on p.id = t.performer_id
where g.name = 'Pop'
group by p.name
having avg(t.number_of_plays) > 250;