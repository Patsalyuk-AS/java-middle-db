create sequence sq_book_genres
    minvalue 1
    maxvalue 999999999999999999999999
    start with 1
    increment by 1
    cache 20;
create table book_genres (
                        id number default sq_book_genres.nextval not null,
                        name varchar2(255),
                        constraint pk_book_genres primary key (id)
);
create sequence sq_authors
    minvalue 1
    maxvalue 999999999999999999999999
    start with 1
    increment by 1
    cache 20;
create table authors (
                           id number default sq_authors.nextval not null,
                           name varchar2(255),
                           constraint pk_authors primary key (id)
);
create sequence sq_books
    minvalue 1
    maxvalue 999999999999999999999999
    start with 1
    increment by 1
    cache 20;
create table books (
                        id number default sq_books.nextval not null,
                        name varchar2(255) not null,
                        year varchar2(4),
                        book_size number,
                        downloaded number,
                        book_genre_id number,
                        author_id number,
                        constraint pk_books primary key (id),
                        constraint  fk_book_genre_id foreign key (book_genre_id) references book_genres(id),
                        constraint fk_author_id foreign key (author_id) references authors(id)
)
partition by range (year) (
    partition py0001 values less than (2000),
    partition py0002 values less than (maxvalue)
);
insert into book_genres (name) values ('Non-fiction');
insert into book_genres (name) values ('Исторический роман');
insert into book_genres (name) values ('фантастика');
insert into authors (name) values ('Митио Каку');
insert into authors (name) values ('Ричард Докинз');
insert into authors (name) values ('Ричард Фейнман');
insert into authors (name) values ('Юрий Тынянов');
insert into authors (name) values ('Аркадий и Борис Стругацкие');
insert into books
    (name, year, book_size, downloaded, book_genre_id, author_id)
values
    ('Физика невозможного', 2008, 460, 2000, (select id from book_genres where name = 'Non-fiction'), (select id from authors where name = 'Митио Каку'));
insert into books
    (name, year, book_size, downloaded, book_genre_id, author_id)
values
    ('Эгоистичный ген', 1989, 610, 400, (select id from book_genres where name = 'Non-fiction'), (select id from authors where name = 'Ричард Докинз'));
insert into books
(name, year, book_size, downloaded, book_genre_id, author_id)
values
    ('Вы, конечно, шутите, мистер Фейнман!', 1985, 450, 1000, (select id from book_genres where name = 'Non-fiction'), (select id from authors where name = 'Ричард Фейнман'));
insert into books
(name, year, book_size, downloaded, book_genre_id, author_id)
values
    ('Кюхля', 1925, 350, 2300, (select id from book_genres where name = 'Исторический роман'), (select id from authors where name = 'Юрий Тынянов'));
insert into books
(name, year, book_size, downloaded, book_genre_id, author_id)
values
    ('За миллиард лет до конца света', 1977, 150, 20000, (select id from book_genres where name = 'фантастика'), (select id from authors where name = 'Аркадий и Борис Стругацкие'));
insert into books
(name, year, book_size, downloaded, book_genre_id, author_id)
values
    ('Понедельник начинается в субботу', 1964, 250, 21000, (select id from book_genres where name = 'фантастика'), (select id from authors where name = 'Аркадий и Борис Стругацкие'));
insert into books
(name, year, book_size, downloaded, book_genre_id, author_id)
values
    ('Уравнение Бога. В поисках теории всего', 2021, 200, 1700, (select id from book_genres where name = 'фантастика'), (select id from authors where name = 'Митио Каку'));

select * from authors;
select * from book_genres;
select * from books;
select * from books partition (py0001);
select * from books partition (py0002);

create index idx_books_name on books (name);

select * from books where name = 'Понедельник начинается в субботу';

select sum(downloaded) as sum_of_download from books
where book_genre_id = (select id from book_genres where name = 'Исторический роман');

select sum(downloaded) as sum_of_download,  bg.name as genre from books b
inner join book_genres bg on b.book_genre_id = bg.id
group by bg.name;

select avg(downloaded) as avg_of_download,  a.name as author from books b
inner join authors a on b.author_id = a.id
group by a.name;


select sum(downloaded) as sum_of_download,  a.name as author from books b
inner join authors a on b.author_id = a.id
group by a.name;

select count(*) as count_of_books,  a.name as author from books b
inner join authors a on b.author_id = a.id
group by a.name;

insert into book_genres (name) values ('Детектив');
insert into book_genres (name) values ('Фэнтези');
insert into book_genres (name) values ('Биография');

select * from books b
inner join book_genres bg on b.book_genre_id = bg.id;

select * from books b
full join book_genres bg on b.book_genre_id = bg.id;

insert into authors (name) values ('Борис Пастернак');
insert into books
(name, year, book_size, downloaded, book_genre_id, author_id)
values
    ('Доктор Живаго', 1955, 660, 20300, null, (select id from authors where name = 'Борис Пастернак'));

select * from book_genres g
where g.id not in (select distinct b.book_genre_id from books b where b.book_genre_id is not null);