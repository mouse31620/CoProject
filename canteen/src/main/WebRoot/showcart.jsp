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
		   		<td>
		   		<button type="button"  onclick="location.href='/canteen/countcarservlet?foodid=${food.key}&count=minus'">- </button>
		   		${food.value.count }
		   		<button type="button"  onclick="location.href='/canteen/countcarservlet?foodid=${food.key}&count=add'">+</button>
		   		</td>
		   		<td>${food.value.foodInfo.foodPrice * food.value.count }</td>
		   		<td><button type="button" class="btn btn-primary btn-sm" onclick="location.href='/canteen/removecarservlet?foodid=${food.key}'">取消</button>	
		   		</td>
		   		</tr>
		</c:forEach>
		
		<%	HashMap map=(HashMap)session.getAttribute("cart"); 
		   		 if(map!=null){
   					Set keys=map.keySet(); 
   					Object[] kes = keys.toArray(); 
   					for(int i=0;i<keys.size();i++)
			   			{
				   			Item item=(Item)map.get(kes[i]);
				   			total=total+item.getFoodInfo().getFoodPrice()*item.getCount();
				   		 	pageContext.setAttribute("total",total);
			   			}
   					}  
		   		%>
		
		
		<tr><td>總計：</td><td colspan="3"></td><td>${pageScope.total}</td><td></td>
		<tr><td colspan="2">
					<button type="button" class="btn btn-primary btn-sm" onclick="shoping()" >繼續購物</button>
		   			<script type="text/javascript">
						   function shoping()
						   {
						   	window.location="/canteen/foodinfoservlet?op=login";
						   }
					</script> 
		</td><td></td><td></td>
		<td colspan="2">
					<button type="button" class="btn btn-primary btn-sm" onclick="endmoney()" >結&nbsp&nbsp&nbsp&nbsp帳</button>
		   			<script type="text/javascript">
						   function endmoney()
						   {
						   	window.location="/canteen/money.jsp?total=${pageScope.total}";
						   }
					</script>
		</td>
		</tr>
		
		
		<c:forEach var="user" items="${requestScope.userlist}">       
          <div class="col-sm-6 col-lg-4 all">
            <div class="box">
              <div>
                <div class="img-box">
                  <img src="./view/front/images/${user.userId}" alt="">
                </div>
                <div class="detail-box">
                	<h5>
                    編號：${user.loginname}
                  </h5>
                  <h5>
                    ${user.email}
                  </h5>
                  <p>
                    ${user.address}
                  </p>
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