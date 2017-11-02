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