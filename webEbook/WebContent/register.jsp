<%@ page contentType="text/html; charset=UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>





 <form action="registerAction" method="POST">
 
    <div class="container">
      <label><b>Tên đăng nhập</b></label>
      <input type="text" placeholder="Tên đăng nhập" name="username" >

      <label><b>Mật khẩu</b></label>
      <input type="password" placeholder="Mật Khẩu" name="password" >
      
      <label><b>Xác nhận mật khẩu</b></label>
      <input type="password" placeholder="Mật Khẩu" name="re_password" >
      
      <label><b>Họ</b></label>
      <input type="text" placeholder="Họ" name="firstName" >
      
      <label><b>Tên Đệm</b></label>
      <input type="text" placeholder="Tên đệm" name="midName" >
      
      <label><b>Tên</b></label>
      <input type="text" placeholder="Tên" name="lastName" >
      
      
      <label><b>Địa chỉ</b></label>
      <input type="text" placeholder="Địa chỉ" name="address" >
      
      <label><b>Email</b></label>
      <input type="text" placeholder="email@gmail.com" name="email" >
      
      <label><b>Số điện thoại</b></label>
      <input type="text" placeholder="" name="phone" >
      
      <button type="submit" >Đăng ký</button>
    </div>

  </form>



</body>
</html>