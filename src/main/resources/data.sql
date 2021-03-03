INSERT INTO credits (id, credit_name)
VALUES (1, '1/2021');

INSERT INTO credits (id, credit_name)
VALUES (2, '2/2021');

INSERT INTO customers (id, credit_id, firstname, surname, pesel)
VALUES (1, 1, 'Marek', 'Kowal', 94101232300);
INSERT INTO customers (id, credit_id, firstname, surname, pesel)
VALUES (2, 1, 'Janina', 'Kowal', 94122232300);
INSERT INTO customers (id, credit_id, firstname, surname, pesel)
VALUES (3, 2, 'Jan', 'Kot', 55120212300);

INSERT INTO products (id, credit_id, product_name, value)
VALUES (1, 1, 'Kredyt gotówkowy', 25000);

INSERT INTO products (id, credit_id, product_name, value)
VALUES (2, 2, 'Kredyt inwestycyjny', 100000);
