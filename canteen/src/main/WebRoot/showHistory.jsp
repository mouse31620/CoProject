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
          		<th>訂單人</th>
         	    <th>下單時間</th>
         	    <th>商品名稱</th>
        		<th>商品數量</th>
        		<th>商品金額</th>
        		<th>商品總金額</th>
   				</tr>
 				 </thead>
 				 <tbody class="table-success">
 				 <c:forEach var="history"  items="${historyOrder}"  >
 				 <tr>
	   					<td>${history.reciver}</td>
	   					<td>${history.add_time }</td>
	   					<td>${history.foodName }</td>
	   					<td>${history.foods_number }</td>
	   					<td>${history.foodPrice }</td>
	   					<td>${history.subtotal }</td>
	   				</tr>
	   			</c:forEach>
	   			
	   			
	   			</tbody>
</table>
</div>
</div>
</div>
</div>
</div>
</section>
</div>
<%@ include file="footer.jsp" %>
	   			