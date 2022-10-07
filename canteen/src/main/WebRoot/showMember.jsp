<%@ include file="header.jsp" %>
<%@ page language="java" import="java.util.*,com.uch.vo.*" pageEncoding="utf-8" contentType="text/html; charset=utf-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div>
    <section class="slider_section ">
      <div id="customCarousel1" class="carousel slide" data-ride="carousel">
         <div class="carousel-inner">
          <div class="carousel-item active">
            <div class="container ">
			<table class="table table-bordered border-primary">
  				<thead class="table-dark">
  				<tr>
          		<th>會員編號</th>
         	    <th>會員姓名</th>
         	    <th>會員email</th>
        		<th>會員電話</th>
        		<th>會員地址</th>
   				</tr>
 				 </thead>
 				 <tbody class="table-success">
 				 <c:forEach var="user"  items="${sessionScope.user}"  >
 				 <tr>
	   					<td>${user.value.getUser_id()}</td>
	   					<td>${user.value.getUser_name() }</td>
	   					<td>${user.value.getEmail() }</td>
	   					<td>${user.value.getTel() }</td>
	   					<td>${user.value.getAddress() }</td>
	   				</tr>
	   			</c:forEach>
	   			
	   			
	   			</tbody>
	   			<!-- 想在這邊抓到permisssion的值 -->
 				 <!--   
 				<c:if test="${sessionScope.permission==1 }"> 
 				<div class="col-sm-9 has-feedback has-success">
							<form class="form-inline" action="/canteen/memberservlet" method="post">
							
			              	<input type="hidden" name="op" value="member">
			      <button style="float:right;margin-right: 65%;" class="btn  my-2 my-sm-0 nav_search-btn" type="submit">
				               <i class="fa fa-search" aria-hidden="true"></i>
				                </button>
			              	<div>
			             
				              	<input  type="text" class="form-control" style="width:30%;margin-bottom: 5px;"  name="username" value="${username}"  placeholder="請輸入會員編號或電話查詢" />
				                
			              	</div>
			     
			              </form>
        		</div>

      <tbody class="table-success">
      
      			
      			<c:forEach var="user" items="${users}">
					<tr>
	   					<td>${user.user_id}</td>
	   					<td>${user.user_name }</td>
	   					<td>${user.email }</td>
	   					<td>${user.tel }</td>
	   					<td>${user.address }</td>
	   				</tr>
   				</c:forEach>
   				
   				
  		</tbody>
  		</c:if> 
  		-->
  		
  		
</table>
<button type="button" class="btn btn-primary btn-sm" onclick="location.href='/canteen/historyservlet'">歷史訂單查詢</button>
<button type="button" class="btn btn-primary btn-sm" onclick="location.href='/canteen/loginservlet?op=logout'">登出</button>
</div>
</div>
</div>
</div>
</div>
</section>
</div>
<%@ include file="footer.jsp" %>