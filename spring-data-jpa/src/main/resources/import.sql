insert into library (id, library_name) values (1, 'Pierwsza biblioteka');
insert into library (id, library_name) values (2, 'Druga biblioteka');
insert into library (id, library_name) values (3, 'Trzecia biblioteka');

insert into book (id, title, library_entity) values (1, 'Pierwsza książka', 1);
insert into book (id, title, library_entity) values (2, 'Druga książka', 2);
insert into book (id, title, library_entity) values (3, 'Trzecia książka', 3);
insert into book (id, title, library_entity) values (4, 'Czwarta książka', 3);
insert into book (id, title, library_entity) values (5, 'Piąta książka', 2);

insert into author (id, first_name, last_name) values (1, 'Jan', 'Kowalski');
insert into author (id, first_name, last_name) values (2, 'Piotr', 'Zieliński');
insert into author (id, first_name, last_name) values (3, 'Marek', 'Kosowski');

insert into book_author(book_id, author_id) values (1, 3);
insert into book_author(book_id, author_id) values (2, 2);
insert into book_author(book_id, author_id) values (3, 1);
insert into book_author(book_id, author_id) values (3, 2);
insert into book_author(book_id, author_id) values (3, 3);
insert into book_author(book_id, author_id) values (4, 3);
insert into book_author(book_id, author_id) values (4, 2);
insert into book_author(book_id, author_id) values (5, 2);