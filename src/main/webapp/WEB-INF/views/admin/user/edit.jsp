<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<c:url var="userURL" value="/quan-tri/tai-khoan/danh-sach" />
<c:url var="editUserURL" value="/quan-tri/tai-khoan/chinh-sua" />
<c:url var="userAPI" value="/api/user" />
<!DOCTYPE html>
<html>
<head>
<title>Chỉnh sửa tài khoản</title>
<link rel="stylesheet"
	href="<c:url value='/template/admin/assets/css/bootstrap.min.css' />" />
<link rel="stylesheet"
	href="<c:url value='/template/admin/font-awesome/4.5.0/css/font-awesome.min.css' />" />
<link rel="stylesheet"
	href="<c:url value='/template/admin/assets/css/ace.min.css' />"
	class="ace-main-stylesheet" id="main-ace-style" />
<script
	src="<c:url value='/template/admin/assets/js/ace-extra.min.js' />"></script>
<link rel="stylesheet"
	href="https://ajax.googleapis.com/ajax/libs/jqueryui/1.11.4/themes/smoothness/jquery-ui.css">
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script type='text/javascript'
	src='<c:url value="/template/admin/js/jquery-2.2.3.min.js" />'></script>
<script
	src="<c:url value='/template/admin/assets/js/jquery.2.1.1.min.js' />"></script>
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>

<!-- sweetalert -->
<script
	src="<c:url value='/template/admin/sweetalert/sweetalert2.min.js' />"></script>
<link rel="stylesheet"
	href="<c:url value='/template/admin/sweetalert/sweetalert2.min.css' />" />

<!-- ckeditor -->
<script src="<c:url value='/ckeditor/ckeditor.js' />"></script>

</head>
<body class="no-skin">
	<!-- header -->
	<div id="navbar" class="navbar navbar-default          ace-save-state">
		<div class="navbar-container ace-save-state" id="navbar-container">
			<div class="navbar-header pull-left">
				<a href="#" class="navbar-brand"> <small> <i
						class="fa fa-leaf"></i> Trang quản trị
				</small>
				</a>
			</div>
			<div
				class="navbar-buttons navbar-header pull-right collapse navbar-collapse"
				role="navigation">
				<ul class="nav ace-nav">
				<li class="light-blue dropdown-modal"><a class="nav-link" href="<c:url value='/dang-nhap'/>"> Xin chào ${user.fullName}</a></li>
					<li class="light-blue dropdown-modal"><a
						href='<c:url value="/thoat"/>'> <i
							class="ace-icon fa fa-power-off"></i> Thoát
					</a>
				</li>	
				</ul>
			</div>
		</div>
	</div>
	<!-- header -->

	<div class="main-container" id="main-container">
		<script type="text/javascript">
			try {
				ace.settings.check('main-container', 'fixed')
			} catch (e) {
			}
		</script>
		<!-- header -->
		<div id="sidebar"
			class="sidebar                  responsive                    ace-save-state">
			<script type="text/javascript">
				try {
					ace.settings.loadState('sidebar')
				} catch (e) {
				}
			</script>
			<div class="sidebar-shortcuts">
				<div class="sidebar-shortcuts-large">
					<button class="btn btn-success">
						<i class="ace-icon fa fa-signal"></i>
					</button>

					<button class="btn btn-info">
						<i class="ace-icon fa fa-pencil"></i>
					</button>

					<button class="btn btn-warning">
						<i class="ace-icon fa fa-users"></i>
					</button>

					<button class="btn btn-danger">
						<i class="ace-icon fa fa-cogs"></i>
					</button>
				</div>
				<div class="sidebar-shortcuts-mini">
					<span class="btn btn-success"></span> <span class="btn btn-info"></span>

					<span class="btn btn-warning"></span> <span class="btn btn-danger"></span>
				</div>
			</div>
			<ul class="nav nav-list">
				<li><a href="#" class="dropdown-toggle"> <i
						class="menu-icon fa fa-list"></i> <span class="menu-text"></span>
						Quản lý bài viết <b class="arrow fa fa-angle-down"></b>
				</a> <b class="arrow"></b>
					<ul class="submenu">
						<li><a
							href='<c:url value = "/quan-tri/tai-khoan/danh-sach"/>'>
								<i class="menu-icon fa fa-caret-right"></i> Danh sách bài viết
						</a> <b class="arrow"></b></li>
					</ul>
					<ul class="submenu">
						<li><a href='<c:url value = "/quan-tri/tai-khoan/danh-sach"/>'>
								<i class="menu-icon fa fa-caret-right"></i> Danh sách tài khoản
						</a> <b class="arrow"></b></li>
					</ul>
					<ul class="submenu">
						<li><a href='<c:url value = "/quan-tri/chuyen-muc/danh-sach"/>'>
								<i class="menu-icon fa fa-caret-right"></i> Danh sách chuyên mục
						</a> <b class="arrow"></b></li>
					</ul>
					<ul class="submenu">
						<li><a href='<c:url value = "/quan-tri/vai-tro/danh-sach"/>'>
								<i class="menu-icon fa fa-caret-right"></i> Danh sách vai trò
						</a> <b class="arrow"></b></li>
					</ul>
					<ul class="submenu">
						<li><a href='<c:url value = "/quan-tri/binh-luan/danh-sach"/>'>
								<i class="menu-icon fa fa-caret-right"></i> Danh sách bình luận
						</a> <b class="arrow"></b></li>
					</ul></li>
			</ul>
			<div class="sidebar-toggle sidebar-collapse">
				<i class="ace-icon fa fa-angle-double-left ace-save-state"
					data-icon1="ace-icon fa fa-angle-double-left"
					data-icon2="ace-icon fa fa-angle-double-right"></i>
			</div>
		</div>
		<!-- header -->

		<div class="main-content">
			<div class="main-content-inner">
				<div class="breadcrumbs" id="breadcrumbs">
					<script type="text/javascript">
						try {
							ace.settings.check('breadcrumbs', 'fixed')
						} catch (e) {
						}
					</script>

					<ul class="breadcrumb">
						<li><i class="ace-icon fa fa-home home-icon"></i> <a
								href="#">Trang chủ</a></li>
							<li><a href="#">Danh sách tài khoản</a></li>
					</ul>
					<!-- /.breadcrumb -->
				</div>
				<div class="page-content">
					<div class="row">
						<div class="col-xs-12">
							<c:if test="${not empty message}">
								<div class="alert alert-${alert}">${message}</div>
							</c:if>
							<form:form class="form-horizontal" role="form" id="formSubmit"
								modelAttribute="model">
								<div class="form-group">
									<label for="categoryCode"
										class="col-sm-3 control-label no-padding-right">Vai trò:</label>
									<div class="col-sm-9">
										<form:select path="roleCode" id="roleCode">
											<form:option value="" label="-- Chọn thể loại --" />
											<form:options items="${roles}" />
										</form:select>
									</div>
								</div>

								<div class="form-group">
									<label class="col-sm-3 control-label no-padding-right"
										for="form-field-1">Tên tài khoản:</label>
									<div class="col-sm-9">
										<form:input path="userName" cssClass="col-xs-10 col-sm-5" />
									</div>
								</div>

								<div class="form-group">
									<label class="col-sm-3 control-label no-padding-right"
										for="form-field-1">Mật khẩu:</label>
									<div class="col-sm-9">
										<form:input path="password" cssClass="col-xs-10 col-sm-5" />
									</div>
								</div>

								<div class="form-group">
									<label class="col-sm-3 control-label no-padding-right">Tên đầy đủ:</label>
									<div class="col-sm-9">
										<form:input path="fullName" cssClass="col-xs-10 col-sm-5" />
									</div>
								</div>

								<div class="form-group">
									<label class="col-sm-3 control-label no-padding-right">Trạng thái:</label>
									<div class="col-sm-9">
										<form:input path="status" cssClass="col-xs-10 col-sm-5" />
									</div>
								</div>
								<form:hidden path="id" id="userId" />
								<div class="clearfix form-actions">
									<div class="col-md-offset-3 col-md-9">
										<c:if test="${not empty model.id}">
											<button class="btn btn-info" type="button"
												id="btnAddOrUpdateUser">
												<i class="ace-icon fa fa-check bigger-110"></i> Cập nhật tài khoản
											</button>
										</c:if>
										<c:if test="${empty model.id}">
											<button class="btn btn-info" type="button"
												id="btnAddOrUpdateUser">
												<i class="ace-icon fa fa-check bigger-110"></i> Thêm tài khoản
											</button>
										</c:if>

										&nbsp; &nbsp; &nbsp;
										<button class="btn" type="reset">
											<i class="ace-icon fa fa-undo bigger-110"></i> Hủy
										</button>
									</div>
								</div>
							</form:form>
						</div>
					</div>
				</div>
			</div>
		</div>
		<script>
			$('#btnAddOrUpdateUser').click(function(e) {
				e.preventDefault();
				var data = {};
				var formData = $('#formSubmit').serializeArray();
				$.each(formData, function(i, v) {
					data["" + v.name + ""] = v.value;
				});
				var id = $('#userId').val();
				if (id == "") {
					addUser(data);
				} else {
					updateUser(data);
				}
			});

			function addUser(data) {
				$
						.ajax({
							url : '${userAPI}',
							type : 'POST',
							contentType : 'application/json',
							data : JSON.stringify(data),
							dataType : 'json',
							success : function(result) {
								window.location.href = "${editUserURL}?id="
										+ result.id + "&message=insert_success";
							},
							error : function(error) {
								window.location.href = "${userURL}?message=error_system";
							}
						});
			}

			function updateUser(data) {
				$.ajax({
					url : '${userAPI}',
					type : 'PUT',
					contentType : 'application/json',
					data : JSON.stringify(data),
					dataType : 'json',
					success : function(result) {
						window.location.href = "${editUserURL}?id=" + result.id
								+ "&message=update_success";
					},
					error : function(error) {
						window.location.href = "${editUserURL}?id=" + result.id
								+ "&message=error_system";
					}
				});
			}
		</script>

		<!-- footer -->
		<div class="footer">
			<div class="footer-inner">
				<div class="footer-content">
					<span class="bigger-120"> <span class="blue bolder">20110594 - Nguyễn Minh Tuấn</span>
					</span> &nbsp; &nbsp; <span class="action-buttons"> <a href="#">
							<i class="ace-icon fa fa-twitter-square light-blue bigger-150"></i>
					</a> <a href="#"> <i
							class="ace-icon fa fa-facebook-square text-primary bigger-150"></i>
					</a> <a href="#"> <i
							class="ace-icon fa fa-rss-square orange bigger-150"></i>
					</a>
					</span>
				</div>
			</div>
			<!-- footer -->

			<a href="#" id="btn-scroll-up"
				class="btn-scroll-up btn btn-sm btn-inverse display"> <i
				class="ace-icon fa fa-angle-double-up icon-only bigger-110"></i>
			</a>
		</div>
	</div>


	<script
		src="<c:url value='/template/admin/paging/jquery.twbsPagination.js'/>"></script>
	<script
		src="<c:url value='/template/admin/assets/js/bootstrap.min.js' />"></script>
	<script
		src="<c:url value='/template/admin/assets/js/jquery-ui.custom.min.js' />"></script>
	<script
		src="<c:url value='/template/admin/assets/js/jquery.ui.touch-punch.min.js' />"></script>
	<script
		src="<c:url value='/template/admin/assets/js/jquery.easypiechart.min.js' />"></script>
	<script
		src="<c:url value='/template/admin/assets/js/jquery.sparkline.min.js' />"></script>
	<script
		src="<c:url value='/template/admin/assets/js/jquery.flot.min.js' />"></script>
	<script
		src="<c:url value='/template/admin/assets/js/jquery.flot.pie.min.js' />"></script>
	<script
		src="<c:url value='/template/admin/assets/js/jquery.flot.resize.min.js' />"></script>
	<script
		src="<c:url value='/template/admin/assets/js/ace-elements.min.js' />"></script>
	<script src="<c:url value='/template/admin/assets/js/ace.min.js' />"></script>
	<script
		src="<c:url value='/template/admin/assets/js/bootstrap.min.js'/>"></script>

	<!-- page specific plugin scripts -->
	<script
		src="<c:url value='/template/admin/assets/js/jquery-ui.min.js'/>"></script>
</body>
</html>