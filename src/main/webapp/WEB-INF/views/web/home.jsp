<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Trang chủ</title>

<!-- Bootstrap core CSS -->
<link href="<c:url value='/template/web/vendor/bootstrap/css/bootstrap.min.css'/>" rel="stylesheet">

<!-- Custom styles for this template -->
<link href="<c:url value='/template/web/css/shop-homepage.css'/>" rel="stylesheet">
<link href="<c:url value='/template/web/css/shop-item.css'/>" rel="stylesheet">
</head>
<body>


	<!-- Navigation -->
<nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
	<div class="container">
		<a class="navbar-brand" href="<c:url value="/trang-chu"/>">Trang chủ</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarResponsive" aria-controls="navbarResponsive"
			aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarResponsive">
			<ul class="navbar-nav ml-auto">
				<c:choose>
				  <c:when test="${not empty user}">
				    <li class="nav-item"><a class="nav-link" href="<c:url value='/dang-nhap'/>"> Xin chào ${user.fullName}</a></li>
					<li class="nav-item"><a class="nav-link" href="<c:url value='/thoat'/>">Thoát</a></li>
				  </c:when>
				  <c:otherwise>
				    <li class="nav-item"><a class="nav-link" href="<c:url value='/dang-nhap'/>">Đăng nhập</a></li>
				  </c:otherwise>
				</c:choose>
			</ul>
		</div>
	</div>
</nav>

	<!-- Page Content -->
	<div class="container">

		<div class="row">
			<div class="col-lg-3">
				<h1 class="my-4">Menu</h1>
				<div class="list-group">
				<c:forEach var="item" items="${categories}">
						<c:url var="categoryURL" value="/trang-chu">
							<c:param name="id" value="${item.id}" />
						</c:url>
						<a href="${categoryURL}" class="list-group-item">${item.name}</a>
					</c:forEach>
				</div>
			</div>
			<!-- /.col-lg-3 -->

			<div class="col-lg-9">

				<div id="carouselExampleIndicators" class="carousel slide my-4"
					data-ride="carousel">
					
				</div>

				<div class="row">
					<c:forEach var="item" items="${model.listResult}">
						<div class="col-lg-4 col-md-6 mb-4">
							<div class="card h-100">
								<c:url var="newURL" value="/tin-tuc">
									<c:param name="id" value="${item.id}" />
								</c:url>
								<div class="card-body">
									<h4 class="card-title">
										<a href="${newURL}">${item.title}</a>
									</h4>
									<p class="card-text">${item.shortDescription}</p>
								</div>
							</div>
						</div>
					</c:forEach>
				</div>
				<!-- /.row -->

			</div>
			<!-- /.col-lg-9 -->

		</div>
		<!-- /.row -->

	</div>
	<!-- /.container -->
	
	<!-- Footer -->
<footer class="py-5 bg-dark fixed-botom">
	<div class="container">
		<p class="m-0 text-center text-white">Copyright &copy; 20110594 - Nguyễn Minh Tuấn</p>
	</div>
	<!-- /.container -->
</footer>


	<!-- Bootstrap core JavaScript -->
	<script src="<c:url value='/template/web/vendor/jquery/jquery.min.js'/>"></script>
	<script src="<c:url value='/template/web/vendor/bootstrap/js/bootstrap.bundle.min.js'/>"></script>

</body>
</html>