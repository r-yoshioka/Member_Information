<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file = "../header.html" %>

<section>

<form action = "reginst.jsp" method ="post">
<p><input type="submit" value="会員情報登録"></p>
</form>

<form action = "update.jsp" method ="post">
<p><input type="submit" value="会員情報更新"></p>
</form>

<form action = "delete.jsp" method ="post">
<p><input type="submit" value="会員情報削除"></p>
</form>

</section>

<%@ include file = "../footer.html" %>