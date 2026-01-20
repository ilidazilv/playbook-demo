CREATE TABLE address (
                      id SERIAL PRIMARY KEY,
                      single_line TEXT,
                      apartments_no DOUBLE PRECISION []
);

CREATE TYPE demo_type AS ENUM ('RESIDENTIAL', 'COMMERCIAL');

CREATE TABLE demo (
                          id SERIAL PRIMARY KEY,
                          name TEXT,
                          type demo_type,
                          address_id INTEGER REFERENCES address(id)
);

CREATE TABLE host (
    id SERIAL PRIMARY KEY,
    name TEXT
);

CREATE TABLE host_to_demo (
    host_id INTEGER REFERENCES host(id),
    demo_id INTEGER REFERENCES demo(id)
);


INSERT INTO address (single_line, apartments_no) VALUES ('test', '{1, 2, 3}');
INSERT INTO demo (name, address_id) VALUES ('test', 1);
INSERT INTO host(name) VALUES ('host_name');
INSERT INTO host_to_demo(host_id, demo_id) VALUES (1, 1);