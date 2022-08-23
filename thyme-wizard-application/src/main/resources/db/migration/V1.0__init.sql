CREATE TABLE tt_user
(
    id char(36) NOT NULL,
    first_name   varchar(45) NOT NULL,
    last_name    varchar(45) NOT NULL,
    gender       varchar(45) NOT NULL,
    birthday     date    NOT NULL,
    email        varchar(45) NOT NULL,
    phone_number varchar(45) NOT NULL,
    PRIMARY KEY (id)
);