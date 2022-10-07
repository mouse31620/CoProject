<%@ include file="header.jsp" %>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8" contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<% double moneys=Double.parseDouble(request.getParameter("total")) ; %>
 <section class="slider_section ">
      <div id="customCarousel1" class="carousel slide" data-ride="carousel">
         <div class="heading_container" align="center" >
         <h2>訂單確認</h2><br></div>
         <div class="carousel-inner">
          <div class="carousel-item active">
            <div class="container ">
			<table class="table table-bordered border-primary">
  				<thead class="table-dark" >
  				<tr>
          		<th>商品編號</th>
         	    <th>商品名稱</th>
        		<th>商品單價</th>
        		<th>商品數量</th>
        		<th>商品金額</th>
        		<th>修改訂單</th>
   				</tr>
   <% double total=0;  pageContext.setAttribute("total",total);%>
  </thead>
      <tbody class="table-success">
      
        <c:forEach var="food"  items="${sessionScope.cart}"  >
		   		<tr>
		   		<td>${food.key }</td>
		   		<td>${food.value.foodInfo.foodName }</td>
		   		<td>${food.value.foodInfo.foodPrice }</td>
		   		<td>${food.value.count }</td>
		   		<td>${food.value.foodInfo.foodPrice * food.value.count }</td>
		   		<td></td>
		   		</tr>
		</c:forEach>	
		<tr><td>總計：</td><td colspan="3"></td><td><%= moneys %></td><td></td>
		</tbody>
</table>
</div>
</div>
</div>
</div>
</div>
</section>
 
 <!-- book section -->
  <section class="book_section layout_padding">
    <div class="container center">
      <div class="heading_container">
        <h2>
          請確認商品項目及金額
        </h2>
      </div>
      <div class="row">
        <div class="col-md-6">
          <div class="form_container">
            <form action="/canteen/foodinfoservlet?op=reg" method="post">
            
            <c:forEach var="food"  items="${sessionScope.cart}"  >
            <div hidden>
            	<input type="text" class="form-control" name="foods_id" id="foods_id" value="${food.key }" />
            </div>
            <div hidden>
            	<input type="text" class="form-control" name="foods_name" id="foods_name" value="${food.value.foodInfo.foodName }" />
            </div>
            <div hidden>
            	<input type="text" class="form-control" name="foods_number" id="foods_number" value="${food.value.count }" />
            </div>
            <div hidden>
            	<input type="text" class="form-control" name="foods_price" id="foods_price" value="${food.value.foodInfo.foodPrice }" />
            </div>
            <div hidden>
            	<input type="text" class="form-control" name="subtotal" id="subtotal" value="${food.value.foodInfo.foodPrice * food.value.count }" />
            </div>
            </c:forEach>
        
            <c:forEach var="user"  items="${sessionScope.user}"  >
            	<div class="form-group" hidden>
        			<label for="username" class="col-sm-3 control-label">會員編號：</label>
        		<div class="col-sm-9 has-feedback has-success">
            		<input type="text" class="form-control" name="user_id" id="user_id" value="${user.value.getUser_id() }" />
            		<span class="glyphicon glyphicon-ok form-control-feedback" aria-hidden="true"></span>
        		</div>
    			</div> 
            	<div class="form-group">
        			<label for="username" class="col-sm-3 control-label">訂餐人姓名：</label>
        		<div class="col-sm-9 has-feedback has-success">
            		<input type="text" class="form-control" name="customerName" id="customerName" value="${user.value.getUser_name() }" />
            		<span class="glyphicon glyphicon-ok form-control-feedback" aria-hidden="true"></span>
        		</div>
    			</div>    			
    			<div class="form-group">
        			<label for="username" class="col-sm-3 control-label">email：</label>
        		<div class="col-sm-9 has-feedback has-success">
            		<input type="text" class="form-control" name="email" id="email" value="${user.value.getEmail() }" />
            		<span class="glyphicon glyphicon-ok form-control-feedback" aria-hidden="true"></span>
        		</div>
    			</div>
    			<div class="form-group">
        			<label for="username" class="col-sm-3 control-label">市內電話：</label>
        		<div class="col-sm-9 has-feedback has-success">
            		<input type="text" class="form-control" name="tel" id="tel" value="${user.value.getTel() }" />
            		<span class="glyphicon glyphicon-ok form-control-feedback" aria-hidden="true"></span>
        		</div>
    			</div>
    			<div class="form-group">
        			<label for="username" class="col-sm-3 control-label">行動手機：</label>
        		<div class="col-sm-9 has-feedback has-success">
            		<input type="text" class="form-control" name="mobile" id="mobile" value="${user.value.getMobile() }" />
            		<span class="glyphicon glyphicon-ok form-control-feedback" aria-hidden="true"></span>
        		</div>
    			</div>
    			<div class="form-group">
        			<label for="username" class="col-sm-3 control-label">送餐地址：</label>
        		<div class="col-sm-9 has-feedback has-success">
            		<input type="text" class="form-control" name="address" id="address" value="${user.value.getAddress() }" />
            		<span class="glyphicon glyphicon-ok form-control-feedback" aria-hidden="true"></span>
        		</div>
    			</div>
    			<div class="form-group">
        			<label for="username" class="col-sm-3 control-label">總金額：</label>
        		<div class="col-sm-9 has-feedback has-success">
            		<input type="text" style="background-color:FloralWhite;" name="totalPrice" id="totalPrice" value="<%=moneys %>" readonly />元
            		<span class="glyphicon glyphicon-ok form-control-feedback" aria-hidden="true"></span>
        		</div>
    			</div>
    			<div class="form-group">
        			<label for="username" class="col-sm-3 control-label">留言：</label>
        		<div class="col-sm-9 has-feedback has-success">
            		<textarea rows="5" cols="37" name="notice" id="notice" placeholder="留言"></textarea>
            		<span class="glyphicon glyphicon-ok form-control-feedback" aria-hidden="true"></span>
        		</div>
    			</div>
    			</c:forEach>
    			
              <div class="btn_box">
                <button>
                  送 出
                </button>
              </div>
            </form>
          </div>
        </div>
        
      </div>
    </div>
  </section>
</div>  


		   
		   
<%@ include file="footer.jsp" %>