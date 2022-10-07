<%@ include file="header.jsp" %>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8" contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


  <section class="book_section layout_padding">
    <div class="container">
      <div class="heading_container">
        <h2>
          會員登入 or <span class="label label-warning"><a href="/canteen/register.jsp">註冊</a></span>
        </h2>
      </div>
      <div class="row">
        <div class="col-md-6">
          <div class="form_container">
            <form action="/canteen/loginservlet?op=login" method="post">
            	
            	<div class="form-group">
        			<label for="username" class="col-sm-3 control-label">會員id</label>
        		<div class="col-sm-9 has-feedback has-success">
            		<input type="text" class="form-control" name="username" id="username" placeholder="請輸入帳號" />
            		<span class="glyphicon glyphicon-ok form-control-feedback" aria-hidden="true"></span>
        		</div>
    			</div>
    			<div class="form-group">
        			<label for="password" class="col-sm-3 control-label">會員密碼</label>
        		<div class="col-sm-9 has-feedback has-error">
            		<input type="password" class="form-control" name="userpass" id="password" placeholder="請輸入密碼" />
            		<span class="glyphicon glyphicon-remove form-control-feedback" aria-hidden="true"></span>
        		</div>
    			</div>
              <div class="btn_box">
                <button>
                  Login Now
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