<%@ include file="header.jsp" %>
<%@ page language="java" import="java.util.*,java.sql.*" pageEncoding="utf-8" contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>

    <section class="slider_section ">
      <div id="customCarousel1" class="carousel slide" data-ride="carousel">
         <div class="carousel-inner">
          <div class="carousel-item active">
            <div class="container ">            
              <div class="row">
                <div class="col-md-7 col-lg-6 ">
                  <div class="detail-box">
                    <h1>
                      Fast Food Restaurant
                    </h1>
                    <p>
                      餐廳的內部設施主要是桌、椅、收款處和廚房攤位。現在一般的餐廳也提供風扇或者空調。

餐廳通常類似快餐店經營，一般是先付款，後取收據到廚房窗口去取食物。有些餐廳出菜部一般分為幾個，分別售賣不同種類的食物，增加去餐廳進餐的人的選擇範圍。出菜部一般分為水吧、燒味部、中餐、西餐等。
                    </p>
                    <div class="btn-box">
                      <a href="" class="btn1">
                        Order Now
                      </a>
                    </div>
                  </div>
                </div>
              </div>
            </div>
          </div>
      </div>
</div>
    </section>
  </div>


<sql:setDataSource var="snapshot" driver="com.mysql.cj.jdbc.Driver"
     url="jdbc:mysql://127.0.0.1:3306/canteen"
     user="hr"  password="hr"/>
     
 <sql:query dataSource="${snapshot}" var="result">
SELECT * from foodInfo where foodType=0;
</sql:query>

<sql:query dataSource="${snapshot}" var="result1">
SELECT * from foodInfo where foodType=2;
</sql:query>

<sql:query dataSource="${snapshot}" var="result2">
SELECT * from foodInfo where foodType=1;
</sql:query>

<sql:query dataSource="${snapshot}" var="result3">
SELECT * from foodInfo where foodType=3;
</sql:query>
 

  <section class="food_section layout_padding-bottom">
    <div class="container">
      <div class="heading_container heading_center">
        <h2>
          菜&nbsp&nbsp單
        </h2>
      </div>
      <ul class="filters_menu">
        <li class="active" data-filter="*">All</li>
        <li data-filter=".rice">飯類</li>
        <li data-filter=".noodles">麵類</li>
        <li data-filter=".soup">湯類</li>
        <li data-filter=".other">特色小吃</li>
      </ul>
      
      <div class="filters-content">
        <div class="row grid">
        
<c:forEach var="food" items="${result.rows}">        
          <div class="col-sm-6 col-lg-4 all rice">
            <div class="box">
              <div>
                <div class="img-box">
                  <img src="./view/front/images/${food.foodImage}" alt="">
                </div>
                <div class="detail-box">
                  <h5>
                    ${food.foodName}
                  </h5>
                  <p>
                    ${food.description}
                  </p>
                  <div class="options">
                    <h6>NT$&nbsp
                      ${food.foodPrice}
                    </h6>
                  </div>
                </div>
              </div>
            </div>
          </div>
</c:forEach> 

<c:forEach var="food" items="${result1.rows}">        
          <div class="col-sm-6 col-lg-4 all noodles">
            <div class="box">
              <div>
                <div class="img-box">
                  <img src="./view/front/images/${food.foodImage}" alt="">
                </div>
                <div class="detail-box">
                  <h5>
                    ${food.foodName}
                  </h5>
                  <p>
                    ${food.description}
                  </p>
                  <div class="options">
                    <h6>NT$&nbsp
                      ${food.foodPrice}
                    </h6>
                  </div>
                </div>
              </div>
            </div>
          </div>
</c:forEach>

<c:forEach var="food" items="${result2.rows}">        
          <div class="col-sm-6 col-lg-4 all soup">
            <div class="box">
              <div>
                <div class="img-box">
                  <img src="./view/front/images/${food.foodImage}" alt="">
                </div>
                <div class="detail-box">
                  <h5>
                    ${food.foodName}
                  </h5>
                  <p>
                    ${food.description}
                  </p>
                  <div class="options">
                    <h6>NT$&nbsp
                      ${food.foodPrice}
                    </h6>
                  </div>
                </div>
              </div>
            </div>
          </div>
</c:forEach>        

<c:forEach var="food" items="${result3.rows}">        
          <div class="col-sm-6 col-lg-4 all other">
            <div class="box">
              <div>
                <div class="img-box">
                  <img src="./view/front/images/${food.foodImage}" alt="">
                </div>
                <div class="detail-box">
                  <h5>
                    ${food.foodName}
                  </h5>
                  <p>
                    ${food.description}
                  </p>
                  <div class="options">
                    <h6>NT$&nbsp
                      ${food.foodPrice}
                    </h6>
                  </div>
                </div>
              </div>
            </div>
          </div>
</c:forEach>         
        </div>
      </div>
      
      
    </div>
  </section>

  
	    
<%@ include file="footer.jsp" %>