<%@include file="/common/taglib.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>

<head>

<meta charset="UTF-8">

<title>Trang chủ</title>

</head>

<body>
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
</body>
</html>