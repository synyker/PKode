create table Reference (
  id                        integer not null,
  textid                    varchar(255),
  type                      varchar(255),
  author                    varchar(255),
  title                     varchar(255),
  booktitle                 varchar(255),
  journal                   varchar(255),
  volume                    varchar(255),
  number                    varchar(255),
  year                      varchar(255),
  pages                     varchar(255),
  publisher                 varchar(255),
  address                   varchar(255),
  constraint pk_Reference primary key (id))
;

create sequence Reference_seq;



