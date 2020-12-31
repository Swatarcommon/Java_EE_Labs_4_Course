FLUSH PRIVILEGES;
use wsr;

CREATE TABLE comment
(
    id      int(11) NOT NULL AUTO_INCREMENT,
    refId     int(11) NOT NULL,
    sessionId varchar(70) DEFAULT NULL,
    stamp     date        DEFAULT NULL,
    comment   varchar(70) DEFAULT NULL,
    PRIMARY KEY (id)
) ENGINE = InnoDB
  AUTO_INCREMENT = 18
  DEFAULT CHARSET = latin1;

CREATE TABLE `references`
(
    id      int(11) NOT NULL AUTO_INCREMENT,
    url         varchar(70) NOT NULL,
    description varchar(70) NOT NULL,
    minus       int(11)     NOT NULL,
    plus        int(11)     NOT NULL,
    PRIMARY KEY (id)
) ENGINE = InnoDB
  AUTO_INCREMENT = 16
  DEFAULT CHARSET = latin1;

delimiter //
CREATE PROCEDURE AddReference(in id int,
    in url varchar(70),
    in description varchar(70),
    in minus int,
    in plus int)
BEGIN
insert into `references` values (id, url, description, minus, plus);
commit;
END;//

delimiter //
CREATE PROCEDURE AddComment(in id int,
    in refId int,
    in sessionId varchar(70),
    in stamp date,
    in comment varchar(70))
BEGIN
insert into comment values (id, refId, sessionId, stamp, comment);
commit;
END; //