<%@ include file="header.jsp" %>
<%@ page language="java" import="java.util.*,java.text.*" pageEncoding="utf-8" contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%
            java.util.Date currentTime = new java.util.Date();
            SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");            
%>
<nav class="navbar navbar-default">
    <div class="form_container">
        <div class="navbar-header">
        </div>
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav navbar-right">
                <li><a href="login.jsp">登入</a></li>
            </ul>
        </div>
    </div>
</nav>
<section class="book_section layout_padding">
<div class="container">
    <div class="row">
        <div class="col-md-4">
        </div>
        <div class="col-md-4">

            <form action="/canteen/adduserservlet?op=useradd" method="post">
                <h2 class="form-signin-heading">會員註冊</h2>
                <div id="info">
				<div></div>
                </div>
                <label for="">會員姓名</label>
                <input type="text" name="user_name" id="user_name" class="form-control" placeholder="請輸入會員姓名" required autofocus><br>
                <label for="">會員id<c:if test="${requestScope.change==change}"> <font color="red" size="2">*${requestScope.change}</font></c:if></label>
                <input type="text" name="login_id" id="login_id" class="form-control" placeholder="請輸入會員id" required autofocus><br>
                <label for="">會員密碼</label>
                <input type="password" name="login_pw" id="login_pw" class="form-control" placeholder="請輸入會員密碼" required><br>
                <label for="">再次輸入密碼</label>
                <input type="password" name="login_pw2" id="login_pw2" class="form-control" placeholder="請再次輸入密碼" required maxLength="16"><br>
                <label for="">email</label>
                <input type="email" name="email" id="email" class="form-control" placeholder="請輸入email" required><br>
                <label for="">市內電話</label>
                <input type="text" name="tel" id="tel" class="form-control" placeholder="請輸入市內電話"><br>
                <label for="">手機號碼</label>
                <input type="tel" name="mobile" id="mobile" class="form-control" pattern="[0-9]{4}-[0-9]{3}-[0-9]{3}" placeholder="格式: 0912-345-678" required><br>
                <label for="">會員地址</label>
                <input type="text" name="address" id="address" class="form-control" placeholder="請輸入送貨地址" required><br>
                <!-- label for="" type="hidden">註冊日期時間</label-->
                <input type="text" hidden name="contact" id="contact" class="form-control" ><br>
                <!-- label for="">最後登入日期時間</label-->
                <input type="text" hidden name="lastlogin" id="lastlogin" class="form-control" value="<%= ft.format(currentTime) %>"><br>
                
                <button type="submit" class="btn btn-primary" id="btn-reg">註冊</button>
                <a href="login.jsp" class="btn btn-default" id="btn-reg">返回會員登入</a>
            </form>
          
            
        </div>
        <div class="col-md-4">
        </div>
    </div>
</section>

</div>	

<%@ include file="footer.jsp" %>