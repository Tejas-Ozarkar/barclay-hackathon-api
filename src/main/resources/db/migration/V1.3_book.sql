
CREATE TABLE IF NOT EXISTS book
(
    bookID        int AUTO_INCREMENT,
    title text,
    authors  text,
    ratings_count  text,
    isbn     text,
    price  int,
    average_rating text,
    language_code text
);
