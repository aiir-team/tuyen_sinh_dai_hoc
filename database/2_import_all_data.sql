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
  univ_rank    INTEGER(11) DEFAULT 101 NOT NULL,
  created_at      TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  updated_at      TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (id)
)
  ENGINE = InnoDB DEFAULT CHARSET=utf8;

SET  FOREIGN_KEY_CHECKS=1;


mysqlimport --ignore-lines=1 --fields-terminated-by=, --columns='id,univ_code,univ_name,univ_level,branch_name,branch_code,combination_code,amount_student,type_admission,total_score,receive_time,deadline_time,geographic,univ_rank' --local -u root -p tsdh ~/Downloads/university_detail.csv
