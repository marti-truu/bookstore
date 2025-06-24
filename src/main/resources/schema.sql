-- Created by Vertabelo (http://vertabelo.com)
-- Last modification date: 2025-06-24 19:21:34.616

-- tables
-- Table: book
CREATE TABLE book (
    id int GENERATED ALWAYS AS IDENTITY (START WITH 1) NOT NULL,
    book_genre_id int  NOT NULL,
    name varchar(100)  NOT NULL,
    author varchar(50)  NOT NULL,
    price decimal(10,2)  NULL,
    CONSTRAINT book_pk PRIMARY KEY (id)
);

-- Table: book_genre
CREATE TABLE book_genre (
    id int GENERATED ALWAYS AS IDENTITY (START WITH 1) NOT NULL,
    genre_name varchar(50)  NOT NULL,
    CONSTRAINT book_genre_ak_1 UNIQUE (genre_name),
    CONSTRAINT book_genre_pk PRIMARY KEY (id)
);

-- Table: customer
CREATE TABLE customer (
    id int GENERATED ALWAYS AS IDENTITY (START WITH 1) NOT NULL,
    first_name varchar(50)  NOT NULL,
    last_name varchar(50)  NOT NULL,
    phone varchar(20)  NULL,
    CONSTRAINT customer_pk PRIMARY KEY (id)
);

-- Table: sale
CREATE TABLE sale (
    id int GENERATED ALWAYS AS IDENTITY (START WITH 1) NOT NULL,
    book_id int  NOT NULL,
    customer_id int  NOT NULL,
    sale_date date  NOT NULL,
    sale_price decimal(10,2)  NOT NULL,
    CONSTRAINT sale_pk PRIMARY KEY (id)
);

-- foreign keys
-- Reference: book_book_genre (table: book)
ALTER TABLE book ADD CONSTRAINT book_book_genre
    FOREIGN KEY (book_genre_id)
    REFERENCES book_genre (id);

-- Reference: sale_book (table: sale)
ALTER TABLE sale ADD CONSTRAINT sale_book
    FOREIGN KEY (book_id)
    REFERENCES book (id);

-- Reference: sale_customer (table: sale)
ALTER TABLE sale ADD CONSTRAINT sale_customer
    FOREIGN KEY (customer_id)
    REFERENCES customer (id);

-- End of file.

