<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--
  Created by IntelliJ IDEA.
  User: ThienLong
  Date: 1/28/21
  Time: 00:18
  To change this template use File | Settings | File Templates.
--%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<p>asdjfhaslkdjfh</p>
<c:forEach items="${userOrderList}" var="order">
    <p><span>${order.id}</span></p>
<%--    <p><span>${order.idUser}</span></p>--%>
<%--    <p><span>${order.totalPrice}</span></p>--%>
<%--    <p><span>${order.status}</span></p>--%>
<%--    <p><span>${order.date}</span></p>--%>
    </c:forEach>
</body>
</html>
