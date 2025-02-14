<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id = "amt" scope = "request" class = "bean.CookingRecipeBean" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ハンバーグのレシピ</title>
<h1>家庭的な基本のハンバーグのレシピ/作り方</h1>
<link rel ="stylesheet" href = "/CookingRecipes/CookingRecipeAppearance.css">
</head>
<body>
	<h2><%= request.getParameter("servings") %>人前のレシピ</h2>
	<h2>ハンバーグの材料</h2></br>
	<div class = "flex-container">
	<div class ="flex-item"><h3>合いびき肉・・・<%= request.getAttribute("meat") %>g</h3></div>
	<div class ="flex-item"><h3>玉ねぎ・・・<%= request.getAttribute("onion") %>g</h3></div>
	<div class ="flex-item"><h3>サラダ油・・・大さじ1</h3></div>
	<div class ="flex-item"><h3>パン粉・・・<%= request.getAttribute("breadcrumbs") %></h3></div>
	<div class ="flex-item"><h3>牛乳・・・<%= request.getAttribute("Milk") %></h3></div>
	<div class ="flex-item"><h3>おろしにんにく・・・<%= request.getAttribute("garlic") %>片分</h3></div>
	<div class ="flex-item"><h3>塩・・・<%= request.getAttribute("solt") %></h3></div>
	<div class ="flex-item"><h3>砂糖・・・<%= request.getAttribute("sugar") %></h3></div>
	<div class ="flex-item"><h3>こしょう・・・<%= request.getAttribute("pepper") %>振り</h3></div>
	<div class ="flex-item"><h3>ケチャップ・・・<%= request.getAttribute("ketchup") %></h3></div>
	<div class ="flex-item"><h3>ウスターソース・・・<%= request.getAttribute("WorcestershireSauce") %></h3></div>
	<div class ="flex-item"><h3>醤油・・・<%= request.getAttribute("soySauce") %></h3></div>
	</div>
</body>
</html>