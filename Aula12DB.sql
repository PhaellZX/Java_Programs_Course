CREATE DATABASE Aula12;

CREATE TABLE authors(
    authorsID INTEGER PRIMARY KEY auto_increment,
    firstName VARCHAR(255),
    lastName VARCHAR(255)
);

CREATE TABLE titles(
    ISBN INTEGER PRIMARY KEY auto_increment,
    title VARCHAR(255),
    editionNum VARCHAR(255),
    copyright VARCHAR(255)
);

CREATE TABLE AuthorTitle (
	atAuthorsID INTEGER,
    atISBN INTEGER,
     FOREIGN KEY (atAuthorsID) REFERENCES authors(authorsID),
     FOREIGN KEY (atISBN) REFERENCES titles(isbn)
);