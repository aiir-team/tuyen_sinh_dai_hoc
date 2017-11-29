USE tsdh;

SET  FOREIGN_KEY_CHECKS=0;

DROP TABLE IF EXISTS university;
CREATE TABLE university
(
  id            INTEGER(11)                         NOT NULL AUTO_INCREMENT,
  code         NVARCHAR(256)                         NOT NULL UNIQUE,
  name        NVARCHAR(256)                         NOT NULL UNIQUE,
  geographic  NVARCHAR(256)                       DEFAULT 'Hà Nội' NOT NULL,
  rank        INTEGER(11)                        DEFAULT 101   NOT NULL,
  receiving_time      TIMESTAMP DEFAULT '2017-08-10 00:00:00' NOT NULL,
  deadline_time      TIMESTAMP DEFAULT '2010-08-31 17:00:00' NOT NULL,
  created_at  TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL,
  updated_at      TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (id)
)
  ENGINE = InnoDB DEFAULT CHARSET=utf8;


DROP TABLE IF EXISTS branch;
CREATE TABLE branch
(
  id             INTEGER(11)                     NOT NULL AUTO_INCREMENT,
  code           NVARCHAR(256)                    NOT NULL UNIQUE,
  name           NVARCHAR(256)                       NOT NULL,
  created_at     TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL,
  updated_at      TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (id)
)
  ENGINE = InnoDB DEFAULT CHARSET=utf8;



DROP TABLE IF EXISTS subject;
CREATE TABLE subject
(
  id                INTEGER(11)                  NOT NULL AUTO_INCREMENT,
  name              NVARCHAR(256)                NOT NULL UNIQUE,
  created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL,
  updated_at      TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (id)
)
  ENGINE = InnoDB DEFAULT CHARSET=utf8;


DROP TABLE IF EXISTS combination;
CREATE TABLE combination
(
  id                INTEGER(11)                         NOT NULL AUTO_INCREMENT,
  code              NVARCHAR(256)                        NOT NULL,
  id_sub1                INTEGER(11)                     NOT NULL,
  id_sub2                INTEGER(11)                     NOT NULL,
  id_sub3                INTEGER(11)                     NOT NULL,
  created_at  TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL,
  updated_at      TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (id)
)
  ENGINE = InnoDB DEFAULT CHARSET=utf8;

ALTER TABLE combination ADD FOREIGN KEY (id_sub1) REFERENCES subject (id);
ALTER TABLE combination ADD FOREIGN KEY (id_sub2) REFERENCES subject (id);
ALTER TABLE combination ADD FOREIGN KEY (id_sub3) REFERENCES subject (id);


DROP TABLE IF EXISTS admission;
CREATE TABLE admission
(
  id              INTEGER(11)  NOT NULL AUTO_INCREMENT,
  id_univ         INTEGER(11) NOT NULL ,
  id_bran         INTEGER(11) NOT NULL,
  id_comb         INTEGER(11) NOT NULL,
  amount          INTEGER(11) NOT NULL,
  score           INTEGER(11) NOT NULL,
  level_univ      NVARCHAR(256) DEFAULT 'Đại học' NOT NULL,
  created_at      TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  updated_at      TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (id)
)
  ENGINE = InnoDB DEFAULT CHARSET=utf8;

ALTER TABLE admission ADD FOREIGN KEY (id_univ) REFERENCES university (id);
ALTER TABLE admission ADD FOREIGN KEY (id_bran) REFERENCES branch (id);
ALTER TABLE admission ADD FOREIGN KEY (id_comb) REFERENCES combination (id);


DROP TABLE IF EXISTS university_detail;
CREATE TABLE university_detail
(
  id              INTEGER(11)  NOT NULL AUTO_INCREMENT,
  univ_code       NVARCHAR(64) NOT NULL,
  univ_name         NVARCHAR(256) NOT NULL,
  univ_level         NVARCHAR(64) DEFAULT 'Đại học' NOT NULL,
  branch_name         NVARCHAR(256) NOT NULL,
  branch_code          NVARCHAR(64) NOT NULL,
  amount_student           INTEGER(11) NOT NULL,
  type_admission      NVARCHAR(64) DEFAULT 'Kết quả thi THPT QG' NOT NULL,
  total_score       FLOAT(2,2) NOT NULL,
  receive_time      TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  deadline_time     TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  geographic        NVARCHAR(256) DEFAULT 'Hà Nội' NOT NULL,
  university_rank    INTEGER(11) DEFAULT 101 NOT NULL,
  created_at      TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  updated_at      TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (id)
)
  ENGINE = InnoDB DEFAULT CHARSET=utf8;


SET  FOREIGN_KEY_CHECKS=1;







