INSERT INTO credit (id, credit_name)
VALUES (1, '1/2021');

INSERT INTO credit (id, credit_name)
VALUES (2, '2/2021');

INSERT INTO customer (id, credit_id, firstname, surname, pesel)
VALUES (1, 1, 'Marek', 'Kowal', 94101232300);
INSERT INTO customer (id, credit_id, firstname, surname, pesel)
VALUES (2, 2, 'Jan', 'Kot', 55120212300);

INSERT INTO product (id, credit_id, product_name, value)
VALUES (1, 1, 'Kredyt gotówkowy', 25000);

INSERT INTO product (id, credit_id, product_name, value)
VALUES (2, 'Kredyt inwestycyjny', 100000);
