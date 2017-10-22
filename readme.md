# Hướng dẫn chạy project 
- Tải Intellij IDEA bản mới nhất (2017.2.5)
- Dùng tài khoản trường: 2013xxxx@student.hust.edu.vn rồi đăng ký và nhận key ở đây: https://www.jetbrains.com/student/
- Clone project về từ github 

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

- Tìm file: src/main/java/com.project.tuyensinhdaihoc/TuyenSinhDaiHocApplication.java rồi chạy 

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

