## Training project

### BT_QLDT

1. Viết một chương trình Java (Java console) cho phép các giáo vụ quản lý việc đào tạo ở một trung tâm đào tạo theo các mô tả như sau:

    - Khi vào ứng dụng, giáo vụ được yêu cầu nhập các thông tin gồm: account, first-name, last-name, email. Những giá trị này bắt buộc, account là duy nhất trong ứng dụng.
    - Trường hợp account đã tồn tại thì ứng dụng sẽ lưu lại thông tin giáo vụ, các thông tin đã bị thay đổi cũng như thời gian truy cập của giáo vụ.
    - Sau khi đăng nhập thành công, giáo vụ được chuyển đến màn hình gồm danh sách các học viên (ID, Họ tên, email, SĐT, lớp, ghi chú) của các lớp minh phụ trách. Từ đây cho phép giáo vụ có thể:
    - Lọc danh sách học viên theo lớp
    - Tìm hoặc sắp xếp học viên theo 1 trong các tiêu chí họ, tên, email, SĐT
    - Thêm, sửa, xóa một học viên cụ thể

    Yêu cầu bổ sung:

    - Giao diện cần dễ đọc, thao tác
    - Khi nhập thông tin cần có các kiểm tra tương ứng
    - Cần xử lý đầy đủ các ngoại lệ có thể xảy ra trong ứng dụng
    - Có cơ chế log các thông tin ra file ở các mức: debug , cảnh báo (warn), lỗi (error)


2. Từ yêu cầu của bài 1. Hãy học cách thao tác với database. Chương trình đáp ứng các yêu cầu sau: 
    - Tạo database trên phpMyAdmin. 
    - Hiển thị danh sách học viên sau khi giáo vụ đăng nhập thành công. 
    - Thêm, sửa, xóa với thông tin của giáo vụ, sinh viên, lớp. Có check validate các thông tin (length, format, dataType). 
    - Tìm kiếm thông tin học viên theo tên, lớp, email do giáo vụ đó phụ trách.
