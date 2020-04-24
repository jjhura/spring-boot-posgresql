
description project:

framework : spring boot
language : java 11
database : posgresql 12
ide : intelij
type : maven project

port :9000

api : localhost:9000/api/loyalty-card/transaction/add
data sample : 
{
	"loyaltyCardId" : 1,
	"spentAdjust" : 5000000
}

api : localhost:9000/api/loyalty-card/config
data sample : 
{
	"pointOfConversion": 100
}
aswer :
1 : 
- thêm bảng config_history để lưu lại những config cũ bao gồm giá trị config và thời gian khởi tạo . khi dữ liệu được tổng hợp vào hệ thống tích điểm thì có thể dựa vào thời gian 
tạo transaction và thời gian những config được sửa đổi để mà áp dụng những config tương ứng . vd những transaction được thực hiện buổi sáng sẽ áp dụng config trước 12h trưa
còn những transaction buổi chiều thì áp dụng config sau 12h trưa 
2 :
- để tăng hiệu năng hệ thống thì ta có thể áp dụng cache để lưu lại những data master ít thay đổi vd như config , LoyaltyCard,.. ngoài ra ta có thể chấp nhận việc gom các transaction lại và 
update trong 1 khoảng t.gian nhất định. vd 5p 1 lần update xong thì có thể thông báo cho khách hàng thông qua hệ thống notify.
