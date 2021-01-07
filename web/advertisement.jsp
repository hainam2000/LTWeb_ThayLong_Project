<%--
  Created by IntelliJ IDEA.
  User: ThienLong
  Date: 1/8/21
  Time: 01:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<body>
<div class="advertisement">
    <div class="submenu">
        <ul>
            <c:forEach items="${clist}" var="c">
                <li>
                    <a href="category?cid=${c.id}">${c.name}</a>
                </li>
            </c:forEach>
        </ul>
    </div>
    <div class="fotorama headerFotorama">
        <img src="http://localhost:8080/LTWeb_war_exploded/assets/images/advertisement/solid1.jpg" alt="">
        <img src="http://localhost:8080/LTWeb_war_exploded/assets/images/advertisement/solid2.jpg" alt="">
        <img src="http://localhost:8080/LTWeb_war_exploded/assets/images/advertisement/solid3.jpg" alt="">
        <img src="http://localhost:8080/LTWeb_war_exploded/assets/images/advertisement/solid4.jpg" alt="">
        <img src="http://localhost:8080/LTWeb_war_exploded/assets/images/advertisement/solid5.jpg" alt="">
    </div>
    <div class="rightmenu">
        <img src="http://localhost:8080/LTWeb_war_exploded/assets/images/advertisement/solid6.jpg" alt="">
        <br>
        <img src="http://localhost:8080/LTWeb_war_exploded/assets/images/advertisement/solid7.jpg" alt="">
    </div>
</div>
</body>
</html>
