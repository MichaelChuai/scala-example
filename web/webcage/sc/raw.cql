DROP TABLE cage.raw ;

CREATE TABLE cage.raw(id uuid PRIMARY KEY, species text,
lastUpload timestamp, name text, org text, publication text);

