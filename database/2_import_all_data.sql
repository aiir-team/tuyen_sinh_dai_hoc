SET  FOREIGN_KEY_CHECKS=0;

DROP TABLE IF EXISTS university_detail;
CREATE TABLE university_detail
(
  id              INTEGER(11)  NOT NULL AUTO_INCREMENT,
  univ_code       NVARCHAR(64) NOT NULL,
  univ_name         NVARCHAR(256) NOT NULL,
  univ_level         NVARCHAR(64) DEFAULT 'Đại học' NOT NULL,
  branch_name         NVARCHAR(256) NOT NULL,
  branch_code          NVARCHAR(64) NOT NULL,
  combination_code      NVARCHAR(256) NOT NULL,
  amount_student           INTEGER(11) NOT NULL,
  type_admission      NVARCHAR(64) DEFAULT 'Kết quả thi THPT QG' NOT NULL,
  total_score       FLOAT(7,2) NOT NULL,
  receive_time      TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  deadline_time     TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  geographic        NVARCHAR(256) DEFAULT 'Hà Nội' NOT NULL,
  univ_rank    INTEGER(11) DEFAULT 10 NOT NULL,
  last_year_base_mark  INTEGER(11) NOT NULL,
  last_year_amount_student INTEGER(11) NOT NULL,
  created_at      TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  updated_at      TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (id)
)
  ENGINE = InnoDB DEFAULT CHARSET=utf8;

SET  FOREIGN_KEY_CHECKS=1;

mysqlimport --ignore-lines=1 --fields-terminated-by=, --columns='id,univ_code,univ_name,univ_level,branch_name,branch_code,combination_code,amount_student,type_admission,total_score,receive_time,deadline_time,geographic,univ_rank,last_year_base_mark,last_year_amount_student' --local -u root -p tsdh ~/Downloads/university_detail.csv



SET  FOREIGN_KEY_CHECKS=0;

DROP TABLE IF EXISTS universal_point;
CREATE TABLE universal_point
(
  id              INTEGER(11)  NOT NULL AUTO_INCREMENT,
  block_name      NVARCHAR(64)  NOT NULL,
  less1           INTEGER(11) NOT NULL,
  less2           INTEGER(11) NOT NULL,
  less3           INTEGER(11) NOT NULL,
  less4           INTEGER(11) NOT NULL,
  less5           INTEGER(11) NOT NULL,
  less6           INTEGER(11) NOT NULL,
  less7           INTEGER(11) NOT NULL,
  less8           INTEGER(11) NOT NULL,
  less9           INTEGER(11) NOT NULL,
  less10           INTEGER(11) NOT NULL,
  less11           INTEGER(11) NOT NULL,
  less12           INTEGER(11) NOT NULL,
  less13           INTEGER(11) NOT NULL,
  less14           INTEGER(11) NOT NULL,
  less15           INTEGER(11) NOT NULL,
  less16           INTEGER(11) NOT NULL,
  less17           INTEGER(11) NOT NULL,
  less18           INTEGER(11) NOT NULL,
  less19           INTEGER(11) NOT NULL,
  less20           INTEGER(11) NOT NULL,
  less21           INTEGER(11) NOT NULL,
  less22           INTEGER(11) NOT NULL,
  less23           INTEGER(11) NOT NULL,
  less24           INTEGER(11) NOT NULL,
  less25           INTEGER(11) NOT NULL,
  less26           INTEGER(11) NOT NULL,
  less27           INTEGER(11) NOT NULL,
  less28           INTEGER(11) NOT NULL,
  less29           INTEGER(11) NOT NULL,
  less30           INTEGER(11) NOT NULL,
  created_at      TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  updated_at      TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (id)
)
  ENGINE = InnoDB DEFAULT CHARSET=utf8;

SET  FOREIGN_KEY_CHECKS=1;

mysqlimport --ignore-lines=1 --fields-terminated-by=, --columns='id,univ_code,univ_name,univ_level,branch_name,branch_code,combination_code,amount_student,type_admission,total_score,receive_time,deadline_time,geographic,univ_rank' --local -u root -p tsdh ~/Downloads/university_detail.csv



