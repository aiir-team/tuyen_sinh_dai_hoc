# Hướng dẫn chạy project 
- Tải Intellij IDEA bản mới nhất (2017.2.5)
- Dùng tài khoản trường: 2013xxxx@student.hust.edu.vn rồi đăng ký và nhận key ở đây: https://www.jetbrains.com/student/

- Cài đặt SQL bản mới nhất: 
    + Ubuntu: https://www.digitalocean.com/community/tutorials/how-to-install-mysql-on-ubuntu-16-04
    + Win : https://www.youtube.com/watch?v=V_gu5IGSLSA
(Chú ý các thông số: username: root, password: x )

- Mở terminal hoặc cmd chạy lệnh: 
```mysql
  mysql -u root -p  (Sau đó nhập password: x)
```
    
- Tiếp chạy lệnh sau để tạo database: (Tên database là: tsdh - tuyển sinh đại học)
```mysql
  CREATE DATABASE tsdh CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
```
   
- Một số lệnh hay dùng trong sql như: 
```mysql
show databases, show tables, select * from ..., ....    
``` 


- Hướng dẫn import project vào Intellij IDEA 
( Các chú dùng editor khác thì tự tìm hiểu nhé, t chỉ làm trên Intellij thôi)

- Clone project về từ github : 
```mysql
  git clone https://github.com/HeTroGiup/tuyen_sinh_dai_hoc.git
```
- Có 1 chú ý với github là bình thường dùng: git clone nó sẽ không pull tất cả các branch trên remote về mà nó chỉ pull branch master. Vậy để có tất cả các branch trên local thì đầu tiên clone project về. Mở Intellij, ở góc màn hình bên dưới, và bên phải có chữ: Git: Master đó. Click vào đó và chọn chỗ : Remote Branchs --> click tiếp vào : origin/develop (nếu đây là branch muốn lấy từ trên remote xuống) --> click tiếp : Checkout as new local branch (Sau đó đặt tên cho local branch đấy là : develop ) --> Vậy là đã có thêm branch develop trên remote xuống local rồi. 

- Mở Intellij rồi chọn import project from ..
- Sau đó tìm đến project vừa clone về và chọn vào file pom.xml 
- Tiếp đó nhớ click vào cái check box có dòng: Auto import maven dependency...
nhé không là lỗi đấy (Để nó tự import thư viện)
- Chờ nó load xong project rồi chỉ việc tìm file rồi chạy : 
```mysql
  src/main/java/com.project.tuyensinhdaihoc/TuyenSinhDaiHocApplication.java 
```

(Hoặc xem hướng dẫn như ở đây: https://spring.io/guides/gs/intellij-idea/)
(Hoặc ở đây: https://spring.io/guides/gs/spring-boot/)

- Khi chạy mà bị lỗi kiểu này: 

```mysql
  com.mysql.jdbc.exceptions.jdbc4.CommunicationsException: Communications link failure
```
   
thì là do chưa có database nhé. Nhớ làm bước tạo database trước. 



# Hướng dẫn đọc project 

## 1. Công cụ sử dụng 
- Framework Java Spring MVC, Spring Data Jpa, Hibernate, Mysql, Template Engine Thymeleaf,
và các thư viện như Bootstrap 3.3.7 , Jquery 3.2.1   
- Project được khởi tạo bởi Spring Boot version 1.5.8 

## 2. Main project là (đi từ ngoài vào trong):
- folder 'src': chứa mã nguồn java, chủ yếu làm việc trong này 
- file pom.xml (file chứa thông tin project và gọi các thư viện dùng cho project)
    + src/java: Chứa mã nguồn java 
    + src/resources: Chứa các tài nguyên như file static css, js, template html. 
    + (folder src/test: chưa cần dùng đến)

- Trong src/main/resources thì có: static, templates:
    + templates: chứa các folder của admin, client (ở đây do ta gộp 2 project quản lý của admin 
     và project view giành cho client lại thành 1 nên sẽ chia thành 2 folder template riêng cho admin hoặc client )
    + static: Chứa các tài nguyên như css, image, js (tương tự cũng chia ra admin và client)
    
- Trong src/main/java thì có package của project là: com.project.tuyensinhdaihoc .
Trong này gồm 4 folder chính và file chạy của app (Khi chạy app thì run file: TuyenSinhDaiHocApplication.java này)
    
- 4 folder đại diện cho 4 tầng: 
    + data_access_layer: Tầng này chịu trách nhiệm truy cập vào database lấy dữ liệu sau đó truyền lại cho service.
Trong này có 2 folder chính là: 
        + model: Nó chứa các class java map với các bảng trong database (trong database có bảng nào và gồm các trường gì 
        thì class ngoài này có tên giống bảng, các thuộc tính giống các trường)
        + repository: Chứa các interface tương ứng vs các class model. Có thể hiểu nó như là interface chứa các hàm 
        tiện ích có thể truy cập vào class model tương ứng để lấy dữ liệu hoặc thao tác với class đó.

    + service_layer: Tầng này chịu trách nhiệm lấy dữ liệu từ tầng data_access rồi truyền ra view của web_layer hoặc 
    lấy dữ liệu từ view của web rồi truyền lại vào data_access.
        + Mỗi 1 class model bên trên có 1 interface service tương ứng, và 1 class service implement thằng interface đó. 
        
    + web_layer: Tầng này chịu trách nhiệm quản lý các url trên web. Folder chính là controller. Do gộp 2 project thành
    1 nên ta cũng chia nó thành 2 folder là admin và client. (Các tầng bên trên ko chia là do chúng có thể dùng chung cho 
    cả 2 project nên ko cần chia riêng biệt.)
        + Mỗi 1 class controller trong này cũng tương ứng với các class model bên trên. 
        
    + helper_layer: Tầng này chứa code giải thuật (algorithm), các hàm tiện ích (utils), hằng số hay dùng (constants), 
    các hàm xử lý lỗi (errors), quản lý config của ứng dụng (config),      
    
## 3. Mô hình MVC thể hiện ở đây:
- data access: các file java trong model --> đại diện model (M) 
- template: các file html --> đại diện view (V)
- web_layer: các controller quản lý url --> đại diện controller (C)
--> Ứng dụng spring thêm vào các tầng như service để tách biệt liên kết giữa M và V và một số thứ khác nữa.
    
## 4. Ứng dụng hoạt động nhử nào: 
- Giả sử ta truy cập vào web để thêm 1 trường vào trong database. 
- Khi ta truy cập url --> controller bắt được đường dẫn --> Tìm file java (trong folder: controller) và tìm hàm xử lý ứng 
với đường dẫn url. --> Tiếp nó chạy code xử lý trong hàm đó. Trong TH này là thêm dữ liệu thì nó sẽ gọi ra Service để 
truyền dữ liệu vào service, sau đó service tương tác với repository (repository chứa các hàm xử lý được dữ liệu trong 
các class model - map với table trong database). Sau khi repository thêm vào table trong database, giả sử nó trả về 1 
cái gì đó (Vd như dữ liệu vừa bị thay đổi). --> Nó sẽ truyền về cho service --> Service lại truyền ra view bằng controller. 

==> 1 vòng: tương tác --> controller --> service --> database --> service --> controller --> view.     

## 5. Mã nguồn trên github
- 2 branch chính là: master và develop.
- Ae tất cả code trên develop nhé. Sau khi thấy ok rồi thì đẩy lên rồi sẽ check lại và nếu ok thì mới merge vào master.

## 6. Cách up code 
- Mỗi khi commit thì ae nhớ commit rõ ràng ra nhé, về sau còn theo dõi được, mẫu như sau: 

git commit -m "BranchName, Who, Task"

Vd: git commit -m "Develop, ThieuNv, update code interface"


#### 3/11/2017 (ThieuNv)
- Update giao diện web, do chưa có database nên dữ liệu vẫn là fix cứng. 
- File: InitialData.java class chứa dữ liệu cứng nhé. Về sau sẽ gọi các service vào để lấy dữ liệu từ database.
- Các class *VO.java là các class biểu diễn các model trong database ra ngoài giao diện. Về sau mình sẽ chỉ thao tác 
chủ yếu trên các class này, mà không phải các class trong package: model. Tức là các thao tác logic sẽ thực hiện 
trên các class này mà không phải là trong các class controller. (Controller ta chỉ nên dùng để quản lý router, còn 
business logic và transfer data thì dùng các service và các class VO).
- Để build được cái form input đó thì tạo object "advisory" rồi truyền vào form html theo cú pháp trong trang html.
```mysql
  <form ... th:object="advisory" > ... </form> 
```
- Cách truyền từ java vào là: 
```mysql
    model.addAttribute("advisory", new AdvisoryVO())
```
- Các thuộc tính của class "Advisory" tương ứng với các field của form nhé. 
 
- Mấy cái class liên quan đến Contact thì nó chả có tác dụng gì nhé. Mục đích t vẫn giữ lại vì hiện tại chưa có 
các class chính của project nên cứ để tạm đấy, khi nào tạo database thì sẽ loại bỏ chúng. 
- 3 router chính để view giao diện:
    localhost:8080/advisory/select-major (Giao diện nhập input các tham số)
    Click vào Tìm Trường sẽ đến giao diện mới (kết quả các trường)
    Click vào xem thêm sẽ đến giao diện chi tiết cho từng trường. (Các dữ liệu vẫn fix cứng nhé).
    
- Trong controller: AdvisoryController.java có đoạn comment. Code giải thuật ở đó hoặc nếu muốn rõ ràng nên viết 
class trong tầng helper_layer, rồi từ chỗ đó gọi vào class helper đó. 

#### 27/11/2017 
- To hop mon thi: http://luyenthithptquocgia.com/cac-khoi-thi-xet-tuyen-dai-hoc-cao-dang-2017-a487.html
- Xet tuyen bo sung: https://thituyensinh.vn/frontendTs/faces/TinTucBgdChiTiet?_adf.ctrl-state=18znej10dk_5&_afrLoop=20507704425108743
- Rank 100: http://aum.edu.vn/tin-tuc/bang-xep-hang-cac-truong-dai-hoc-tot-nhat-viet-nam-nam-2017.html
- World rank: http://www.hdcdgsnn.gov.vn/index.php/tin-tuc/tin-trong-nu-c/701-x-p-h-ng-trang-web-cac-tru-ng-d-i-h-c-vi-t-nam

- Neu chua co bang: university_detail thi su dung lenh sau de tao table:

```mysql
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

```

- Sau khi tạo được bảng thì mở terminal và import dữ liệu từ file csv.
```mysql
mysqlimport --ignore-lines=1 --fields-terminated-by=, --columns='id,univ_code,univ_name,univ_level,branch_name,branch_code,combination_code,amount_student,type_admission,total_score,receive_time,deadline_time,geographic,univ_rank,last_year_base_mark,last_year_amount_student' --local -u root -p tsdh ~/Downloads/university_detail.csv
```



- Thymeleaf List in form: https://stackoverflow.com/questions/36500731/how-to-bind-an-object-list-with-thymeleaf

- Loi ko search duoc vietnamese trong hibernate: 
    spring.datasource.url=jdbc:mysql://localhost:3306/tsdh?useSSL=false&characterEncoding=utf8
    
 https://kipalog.com/posts/Cach-tim-kiem-co-dau-tren-Mysql---Search-utf8-on-Mysql
    https://stackoverflow.com/questions/21456494/spring-jpa-query-with-like
    https://stackoverflow.com/questions/27626825/spring-data-jpa-query-by-example
    https://docs.spring.io/spring-data/jpa/docs/current/reference/html/
    
- Matrix java: 
    https://introcs.cs.princeton.edu/java/95linear/Matrix.java.html
    
- Array java
    https://stackoverflow.com/questions/6537589/best-way-to-copy-from-one-array-to-another
    
- Get keys of hashmap
    https://stackoverflow.com/questions/6589744/how-to-return-a-list-of-keys-from-a-hash-map
- Convert set to array
    http://www.baeldung.com/convert-array-to-set-and-set-to-array
- Hashmap:
    https://stackoverflow.com/questions/5920135/printing-hashmap-in-java
    
    
- Thêm Controller chartController: 
    http://localhost:8080/advisory/chart  (File: client/graph/chart.html - ông code trong file này nhé.)
    
#### 29/11/2017
- Query distinct
    https://stackoverflow.com/questions/16915948/using-distinct-in-spring-data-over-multiple-columns
    
- Check list empty thymeleaf:
    https://stackoverflow.com/questions/33106391/how-to-check-if-list-is-empty-using-thymeleaf
    
https://drive.google.com/file/d/1qwfzIj3TNbfJEnKJZqvEskhI3F0LAURu/view

https://docs.google.com/spreadsheets/d/1Yy-nX08G4UgNyI_GlxNkyqaEQGOxdC1QhHABi4ZtqJM/edit#gid=631367577

http://vietnamnet.vn/vn/giao-duc/tuyen-sinh/xet-tuyen-dai-hoc-so-sanh-chi-tiet-pho-diem-nam-2016-va-2017-382965.html

https://docs.google.com/spreadsheets/d/1PbbOMf50mBpeOUteTR156ar_XSlYUNQ3-LstCjJS4Co/edit#gid=532991876


#### 30/11/2017
- Update table: 
```mysql
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
```

- Open terminal: 
```mysql
mysqlimport --ignore-lines=1 --fields-terminated-by=, --columns='id,block_name,less1,less2,less3,less4,less5,less6,less7,less8,less9,less10,less11,less12,less13,less14,less15,less16,less17,less18,less19,less20,less21,less22,less23,less24,less25,less26,less27,less28,less29,less30' --local -u root -p tsdh universal_point.csv
```

http://localhost:8080/rest/chart?id=1
