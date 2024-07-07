select * from books;
select * from orders;
select * from line_items;

CREATE TABLE books (
    id BIGINT  PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    price DECIMAL(10, 2) NOT NULL
);
CREATE TABLE line_items (
	id BIGINT  PRIMARY KEY,
    order_id BIGINT NOT NULL,
    book_id BIGINT NOT NULL,
    FOREIGN KEY (order_id) REFERENCES orders(id),
    FOREIGN KEY (book_id) REFERENCES books(id)
);
CREATE TABLE orders (
    id BIGINT  PRIMARY KEY,
    user_id BIGINT NOT NULL,
   FOREIGN KEY (user_id) REFERENCES users(user_id)
);
