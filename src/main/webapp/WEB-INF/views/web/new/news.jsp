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

				<div class="card mt-4">
					<img class="card-img-top img-fluid"
						src="http://placehold.it/900x400" alt="">
					<div class="card-body">
						<p class="card-text">${model.content}</p>
					</div>
				</div>
				<!-- /.card -->

				<section class="mb-5">
					<div class="card bg-light">
						<div class="card-body">
						
							<!-- Comment form-->
							<form action="/gui-tin" method="post" class="mb-4">
								 <div class="form-group">
									<textarea class="form-control" rows="3" name="content"
									placeholder="Join the discussion and leave a comment!"></textarea>
								</div>
								<button type="submit" class="btn btn-primary">Gửi</button>
							</form>
							
							
							<c:forEach var="comment" items="${comments}">
								<div class="d-flex mb-4">
									<div class="flex-shrink-0">
										<img class="rounded-circle"
											src="https://dummyimage.com/50x50/ced4da/6c757d.jpg" alt="..." />
									</div>
									<div class="ms-3">
										<div class="fw-bold">${comment.userName}</div>
										${comment.content}
									</div>
								</div>
							</c:forEach>
						</div>
					</div>
				</section>

			</div>
			<!-- /.col-lg-9 -->

		</div>

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