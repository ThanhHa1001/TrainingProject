select * from dm_khoa;
select * from dmmh;
select * from dmsv;
select * from ket_qua;

-- 1.	Liệt kê danh sách sinh viên, gồm các thông tin sau: Mã sinh viên, Họ sinh viên, Tên 
-- sinh viên, Học bổng. Danh sách sẽ được sắp xếp theo thứ tự Mã sinh viên tăng dần. 
select MA_SV, HO_SV, TEN_SV, HOC_BONG 
from DMSV
order by MA_SV;

-- 2.	Danh sách các sinh viên gồm thông tin sau: Mã sinh viên, họ tên sinh viên, Phái, Ngày 
-- sinh. Danh sách sẽ được sắp xếp theo thứ tự Nam/Nữ. 

select MA_SV, HO_SV, TEN_SV, GIOI_TINH, NGAY_SINH
from DMSV
order by GIOI_TINH;

--3.	Thông tin các sinh viên gồm: Họ tên sinh viên, Ngày sinh, Học bổng. Thông tin sẽ 
-- được sắp xếp theo thứ tự Ngày sinh tăng dần và Học bổng giảm dần. 
select HO_SV, TEN_SV, NGAY_SINH, HOC_BONG
from DMSV
order by NGAY_SINH ASC, HOC_BONG DESC;

--4.	Danh sách các môn học có tên bắt đầu bằng chữ T, gồm các thông tin: Mã môn, Tên 
-- môn, Số tiết. 
select MA_MH, TEN_MH, SO_TIET
from DMMH
where TEN_MH like 'T%';

--5.	Liệt kê danh sách những sinh viên có chữ cái cuối cùng trong tên là I, gồm các thông 
-- tin: Họ tên sinh viên, Ngày sinh, Phái. 
select HO_SV, TEN_SV, NGAY_SINH, GIOI_TINH
from DMSV
where TEN_SV like '%I';

select HO_SV, TEN_SV, NGAY_SINH, GIOI_TINH
from DMSV
where TEN_SV like '%i';

select HO_SV, TEN_SV, NGAY_SINH, GIOI_TINH
from DMSV
where UPPER (TEN_SV) like '%I';

select HO_SV, TEN_SV, NGAY_SINH, GIOI_TINH
from DMSV
where LOWER (TEN_SV) like '%i';

--6.	Danh sách những khoa có ký tự thứ hai của tên khoa có chứa chữ N, gồm các thông tin: 
-- Mã khoa, Tên khoa. 
select MA_KHOA, TEN_KHOA
from DM_KHOA
where UPPER (TEN_KHOA) like '_N%';

--7.	Liệt kê những sinh viên mà họ có chứa chữ Thị. 
select *
from DMSV
where HO_SV like '%Th?%';

--8.	Cho biết danh sách những sinh viên có ký tự đầu tiên của tên nằm trong khoảng từ a 
-- đến m, gồm các thông tin: Mã sinh viên, Họ tên sinh viên, Phái, Học bổng. 
select MA_SV, HO_SV, TEN_SV, GIOI_TINH, HOC_BONG
from DMSV
where regexp_like (TEN_SV, '^[A-M]');

select MA_SV, HO_SV, TEN_SV, GIOI_TINH, HOC_BONG
from DMSV
where lower(substr(TEN_SV, 1, 2)) between 'a%' and 'n%';

-- 9.	Cho biết danh sách những sinh viên mà tên có chứa ký tự nằm trong khoảng từ a đến 
-- m, gồm các thông tin: Họ tên sinh viên, Ngày sinh, Nơi sinh, Học bổng. Danh sách 
-- được sắp xếp tăng dần theo họ tên sinh viên. 
select HO_SV, TEN_SV, NGAY_SINH, NOI_SINH, HOC_BONG
from DMSV
where REGEXP_LIKE (lower(TEN_SV), '[a-n]')
order by HO_SV, TEN_SV;

-- 10.	Cho biết danh sách các sinh viên có học bổng lớn hơn 100,000, gồm các thông tin: Mã 
-- sinh viên, Họ tên sinh viên, Mã khoa, Học bổng. Danh sách sẽ được sắp xếp theo thứ tự 
-- Mã khoa giảm dần. 
select MA_SV, HO_SV, TEN_SV, MA_KHOA, HOC_BONG
from DMSV
where HOC_BONG > 100000
order by MA_KHOA desc;

-- 11.	Liệt kê các sinh viên có học bổng từ 150,000 trở lên và sinh ở Hà Nội, gồm các thông 
-- tin: Họ tên sinh viên, Mã khoa, Nơi sinh, Học bổng. 
select HO_SV, TEN_SV, MA_KHOA, NOI_SINH, HOC_BONG
from DMSV
where HOC_BONG >= 150000 and NOI_SINH = 'Hà Nội';

-- 12.	Danh sách các sinh viên của khoa Anh văn và khoa Vật lý, gồm các thông tin: Mã sinh 
-- viên, Mã khoa, Phái. 
select MA_SV, MA_KHOA, GIOI_TINH
from DMSV
where MA_KHOA = 'AV' or MA_KHOA = 'VL';

select MA_SV, sv.MA_KHOA, GIOI_TINH
from DMSV sv
inner join DM_KHOA kh on sv.MA_KHOA = kh.MA_KHOA
where kh.TEN_KHOA = 'Anh Văn' or kh.TEN_KHOA = 'Vật Lý';  

--13.	Cho biết những sinh viên có ngày sinh từ ngày 01/01/1991 đến ngày 05/06/1992 gồm 
--các thông tin: Mã sinh viên, Ngày sinh, Nơi sinh, Học bổng. 
select MA_SV, NGAY_SINH, NOI_SINH, HOC_BONG
from DMSV
where NGAY_SINH between date '1991-01-01' and date '1992-06-05';

select MA_SV, NGAY_SINH, NOI_SINH, HOC_BONG
from DMSV
where NGAY_SINH between to_date('01/01/1991', 'dd/MM/yyyy') and to_date('05/06/1992', 'dd/MM/yyyy');

--14.	Danh sách những sinh viên có học bổng từ 80.000 đến 150.000, gồm các thông tin: Mã 
--sinh viên, Ngày sinh, Phái, Mã khoa. 
select MA_SV, NGAY_SINH, GIOI_TINH, MA_KHOA
from DMSV
where HOC_BONG between 80000 and 150000;

--15.	Cho biết những môn học có số tiết lớn hơn 30 và nhỏ hơn 45, gồm các thông tin: Mã 
--môn học, Tên môn học, Số tiết. 
select MA_MH, TEN_MH, SO_TIET
from DMMH
where SO_TIET between 31 and 44;

--16.	Liệt kê những sinh viên nam của khoa Anh văn và khoa tin học, gồm các thông tin: Mã 
--sinh viên, Họ tên sinh viên, tên khoa, Phái. 
select MA_SV, HO_SV, TEN_SV, k.TEN_KHOA, sv.GIOI_TINH
from DMSV sv
inner join DM_KHOA k on sv.MA_KHOA = k.MA_KHOA
where sv.GIOI_TINH like 'Nam'
  and (TEN_KHOA = 'Anh Văn' 
  or TEN_KHOA = 'Tin Học');
  
--17.	Liệt kê những sinh viên nữ, tên có chứa chữ N
select *
from DMSV
where GIOI_TINH = 'Nữ' and lower(TEN_SV) like '%n%';

--18.	Danh sách sinh viên có nơi sinh ở Hà Nội và sinh vào tháng 02, gồm các thông tin: Họ 
--sinh viên, Tên sinh viên, Nơi sinh, Ngày sinh.
select HO_SV, TEN_SV, NOI_SINH, NGAY_SINH, to_char(NGAY_SINH, 'mm')
from DMSV
where NOI_SINH = 'Hà Nội'
  and to_char(NGAY_SINH, 'mm') = '02';

--19.	Cho biết những sinh viên có tuổi lớn hơn 20, thông tin gồm: Họ tên sinh viên, Tuổi,Học bổng. 
select HO_SV, TEN_SV, trunc(MONTHS_BETWEEN(sysdate, NGAY_SINH) / 12, 0) as TUOI 
from DMSV;

select * 
from (select HO_SV, TEN_SV, trunc(MONTHS_BETWEEN(sysdate, NGAY_SINH) / 12, 0) as TUOI 
from DMSV)
where TUOI > 20;

--20.	Danh sách những sinh viên có tuổi từ 20 đến 25, thông tin gồm: Họ tên sinh viên, Tuổi, 
--Tên khoa. 
select HO_SV, TEN_SV, TUOI, TEN_KHOA
from (SELECT HO_SV, TEN_SV, TEN_KHOA, trunc(months_between(sysdate, NGAY_SINH) / 12, 0) as TUOI
from DMSV sv
inner join DM_KHOA k on sv.MA_KHOA = k.MA_KHOA)
where TUOI >= 20 and TUOI < 30;

--21.	Danh sách sinh viên sinh vào mùa xuân năm 1990, gồm các thông tin: Họ tên sinh viên, 
--Phái, Ngày sinh. 
select HO_SV, TEN_SV, GIOI_TINH, NGAY_SINH
from DMSV
where NGAY_SINH between date '1990-01-01' and date '1990-03-31';

--22.	Cho biết thông tin về mức học bổng của các sinh viên, gồm: Mã sinh viên, Phái, Mã 
--khoa, Mức học bổng. Trong đó, mức học bổng sẽ hiển thị là “Học bổng cao” nếu giá trị 
--của field học bổng lớn hơn 500,000 và ngược lại hiển thị là “Mức trung bình” 
select MA_SV, GIOI_TINH, MA_KHOA, HOC_BONG,
case
  when HOC_BONG > 500000
    then 'Học bổng cao'
  else
    'Mức trung bình'
  end MUC_HOC_BONG
from DMSV;

--23.	Cho biết tổng số sinh viên của toàn trường
select count(MA_SV) as tong_so_sv_toan_truong
from DMSV;

--24.	Cho biết tổng sinh viên và tổng sinh viên nữ. 
select count(a.MA_SV) tong_sv, count(b.MA_SV) tong_sv_nu
FROM DMSV a
left join DMSV b on a.MA_SV = b.MA_SV
      and a.GIOI_TINH = 'Nữ';
      
--25.	Cho biết tổng số sinh viên của từng khoa. 
select MA_KHOA, count(MA_KHOA) as tong_so
from DMSV
group by MA_KHOA;

--26.	Cho biết số lượng sinh viên học từng môn.
select  DMMH.TEN_MH, count(kq_distinct.MA_MH) as So_luong_sv_theo_hoc
from (select distinct MA_SV, MA_MH from KET_QUA) kq_distinct
inner join DMMH on kq_distinct.MA_MH = DMMH.MA_MH
group by kq_distinct.MA_MH, DMMH.TEN_MH;

--27.	Cho biết số lượng môn học mà sinh viên đã học(tức tổng số môn học có torng bảng kq)
select count(distinct Ma_MH) as tong_so_mon_hoc
from KET_QUA;

--28.	Cho biết tổng số học bổng của mỗi khoa.
select k.MA_KHOA, k.TEN_KHOA, result_dmsv.SO_LUONG_HOC_BONG 
from (select count(MA_KHOA) as SO_LUONG_HOC_BONG, MA_KHOA
      from DMSV
      where HOC_BONG > 0
      group by MA_KHOA) result_dmsv, 
    DM_KHOA k
where result_dmsv.MA_KHOA = k.MA_KHOA;

--29.	Cho biết học bổng cao nhất của mỗi khoa. 
select k.MA_KHOA, k.TEN_KHOA, result.HOC_BONG_CAO_NHAT
from (select MA_KHOA, max(HOC_BONG) HOC_BONG_CAO_NHAT
      from dmsv
      group by MA_KHOA) result, 
      DM_KHOA k
where result.MA_KHOA = k.MA_KHOA;

--30.	Cho biết tổng số sinh viên nam và tổng số sinh viên nữ của mỗi khoa.
select count(GIOI_TINH) as Nu, count(GIOI_TINH) as Nam
from DMSV
where MA_KHOA = 'TH'
group by GIOI_TINH;


--31.	Cho biết số lượng sinh viên theo từng độ tuổi. 
select result.TUOI, count(result.TUOI) as so_luong_sing_vien
from (select trunc(months_between(sysdate, NGAY_SINH) / 12, 0) as TUOI
      from dmsv) result
group by result.TUOI;

--32.	Cho biết những năm sinh nào có 2 sinh viên đang theo học tại trường.
select result.year, count(result.year) so_sv_dang_hoc
from (select extract(YEAR from NGAY_SINH) as year
      from DMSV) result
group by result.year
having count(result.year) = 2;

--33.	Cho biết những nơi nào có hơn 2 sinh viên đang theo học tại trường. 
select NOI_SINH, count(NOI_SINH)
from DMSV
group by NOI_SINH
having count(NOI_SINH) = 2;

--34.	Cho biết những môn nào có trên 3 sinh viên dự thi.

--35.	Cho biết những sinh viên thi lại trên 2 lần. 

--36.	Cho biết những sinh viên nam có điểm trung bình lần 1 trên 7.0 

--37.	Cho biết sinh viên nào có điểm thi lần 1 môn cơ sở dữ liệu cao nhất. 
--38.	Cho biết sinh viên khoa anh văn có tuổi lớn nhất. 
--39.	Cho biết khoa nào có đông sinh viên nhất. 
--40.	Cho biết sinh viên không học khoa anh văn có điểm thi môn phạm lớn hơn điểm thi văn 
--41.	Cho biết những sinh viên có học bổng lớn hơn bất kỳ học bổng của sinh viên học khóa anh văn 
--42.	Cho biết sinh viên nào có điểm thi môn cơ sở dữ liệu lần 2 lớn hơn tất cả điểm thi lần 1 
--môn cơ sở dữ liệu của những sinh viên khác. 
--43.	Cho biết sinh viên nào không thi lần 1 mà có dự thi lần 2. 
--44.	Cho biết những sinh viên khoa anh văn chưa học môn văn phạm.
--45.	Cho biết những sinh viên học khoa anh văn có học bổng và những sinh viên chưa bao 
--giờ rớt.
--46.	Cho biết khoa nào có đông sinh viên nhận học bổng nhất và khoa nào khoa nào có ít 
--sinh viên nhận học bổng nhất. 
--47.	Cho biết những môn được tất cả các sinh viên theo học. 
--48.	Cho biết những sinh viên học những môn giống sinh viên có mã số A02 học. 
--49.	Cho biết những sinh viên học những môn bằng đúng những môn mà sinh viên A02 học.
