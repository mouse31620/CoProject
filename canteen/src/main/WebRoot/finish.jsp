<%@ include file="header.jsp" %>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8" contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>    
    
 <base href="<%=basePath%>">  

<% 
  if(request.getParameter("total")!=null){
  double moneys=Double.parseDouble(request.getParameter("total")) ; 
  }
  if(request.getParameter("total")==null)
  {
  	 double moneys=0;
  }
%>
<section class="book_section layout_padding center">
    <div class="container">
      <div class="heading_container">
<div >
	
		   	</div>
		   	<c:if test="${requestScope.buy==buy}">
		   	<h1>${requestScope.buy}</h1>		   	
		   	</c:if>
		   	<c:if test="${requestScope.ok==ok}">
		   	<h1>${requestScope.ok}</h1>
		   	</c:if>
		   	<c:if test="${requestScope.success==success}">
		   	<h1>${requestScope.success}</h1>
		   	${param.success}
		   	</c:if>
		   	<c:if test="${requestScope.fail==fail}">
		   	<h1>${requestScope.fail}</h1>
		   	</c:if>
		   	<c:if test="${requestScope.faila==faila}">
		   	<h1>${requestScope.faila}</h1>
		   	</c:if>
		   </div>
		   
		   <div>
		   	<h1><%= request.getAttribute("msg") == null?"":request.getAttribute("msg") %></h1>
		   	<h1><%= request.getAttribute("errors") == null?"": request.getAttribute("errors")%></h1>
		   </div>
</div>
</div>
</div>	
</div>
</div>
</div>	

</section> 
<%@ include file="footer.jsp" %>