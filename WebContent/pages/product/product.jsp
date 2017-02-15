<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html lang="zh">
<head>
<meta charset="utf-8">
<title>Bootstrap Admin</title>
<meta content="IE=edge,chrome=1" http-equiv="X-UA-Compatible">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">
<%
	String path = request.getContextPath() + "/";
%>
<link rel="stylesheet" type="text/css"
	href="<%=path%>lib/bootstrap/css/bootstrap.css">

<link rel="stylesheet"
	href="<%=path%>lib/font-awesome/css/font-awesome.css">
<link rel="stylesheet" type="text/css"
	href="<%=path%>lib/bootstrap/css/bootstrap-datetimepicker.min.css">
<link rel="stylesheet" type="text/css"
	href="<%=path%>stylesheets/theme.css">


<script src="<%=path%>js/jquery.1.3.2.js" type="text/javascript"
	language="javascript"></script>
<script language="JavaScript" type="text/javascript"
	src="<%=path%>js/popup_layer.js"></script>


<!-- Demo page code -->


<!-- Le HTML5 shim, for IE6-8 support of HTML5 elements -->
<!--[if lt IE 9]>
      <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
    <![endif]-->

<!-- Le fav and touch icons -->
</head>

<!--[if lt IE 7 ]> <body class="ie ie6"> <![endif]-->
<!--[if IE 7 ]> <body class="ie ie7"> <![endif]-->
<!--[if IE 8 ]> <body class="ie ie8"> <![endif]-->
<!--[if IE 9 ]> <body class="ie ie9"> <![endif]-->
<!--[if (gt IE 9)|!(IE)]><!-->
<body>
	<script type="text/javascript">
		function hensa() {
			document.getElementById("hensaku").disabled = true;
			document.getElementById("torouku").disabled = false;
			document.getElementById("tableid").style.display = '';
		}
	</script>
	<!--<![endif]-->
	<div class="form-horizontal">
		<div class="navbar">
			<div class="navbar-inner" align="right">
				<a class="brand" href="index.html"><span class="second"><strong
						style="color: white;"></strong></span></a>
				<div class="btn-toolbar" style="margin-left: 65px;">
					<a href="#myModal" data-toggle="modal" class="btn"
						onclick="window.open('<%=path%>index.jsp','_self'); ">首頁</a> <a
						href="#myModal" data-toggle="modal" class="btn"
						onclick="window.open('<%=path%>index.jsp','_self'); ">退出</a>
				</div>
			</div>
		</div>


		<div class="container-fluid">
			<div class="row-fluid">
				<div class="span2">
					<div class="sidebar-nav">
                        <div class="nav-header" data-toggle="collapse"
                             data-target="#dashboard-menu">
                            <i class="icon-dashboard"></i>产品档案管理
                        </div>
                        <ul id="dashboard-menu" class="nav nav-list collapse in">
                            <li class="active"><s:a href="../product/productAdd.jsp">产品新增</s:a></li>
                            <li><s:a href="../product/getAllProduct">产品修改</s:a></li>
                            <li><a href="../product/getAllProduct1">产品查询</a></li>

                        </ul>
                        <div class="nav-header" data-toggle="collapse"
                             data-target="#accounts-menu">
                            <i class="icon-briefcase"></i>供应商管理
                        </div>
                        <ul id="accounts-menu" class="nav nav-list collapse">
                            <li><a href="../provider/providerAdd.jsp">供应商新增</a></li>
                            <li><a href="../provider/getAllProvider">供应商修改</a></li>
                            <li><a href="../provider/getAllProvider1">供应商查询</a></li>
                        </ul>

                        <div class="nav-header" data-toggle="collapse"
                             data-target="#settings-menu">
                            <i class="icon-exclamation-sign"></i>订单管理
                        </div>
                        <ul id="settings-menu" class="nav nav-list collapse">
                            <li><a href="../order/getProductInOrderAdd">订单新增</a></li>
                            <li><a href="../order/getAllOrder">订单修改</a></li>
                            <li><a href="../order/getAllOrder1">订单查询</a></li>
                        </ul>

                        <div class="nav-header" data-toggle="collapse"
                             data-target="#legal-menu">
                            <i class="icon-legal"></i>收货管理
                        </div>
                        <ul id="legal-menu" class="nav nav-list collapse">
                            <li><a href="../receiving/receivingAdd.jsp">新发生收货</a></li>
                            <li><a href="../receiving/receivingSelect.jsp">收货查询</a></li>
                        </ul>

                        <div class="nav-header" data-toggle="collapse"
                             data-target="#legal-menu1">
                            <i class="icon-legal"></i>退货管理
                        </div>
                        <ul id="legal-menu1" class="nav nav-list collapse">
                            <li><a href="../returns/returnAdd.jsp">退货登记</a></li>
                            <li><a href="../returns/returnSelect.jsp">退货查询 </a></li>
                        </ul>
					</div>
				</div>
				<div class="span9">
					<div class="faq-content">
						<h1 class="page-title">产品管理</h1>
						<div class="well">
							<h2>新增产品信息录入</h2>
							<hr />
							<%
								String ID = request.getParameter("id");
								String NAME = new String(request.getParameter("name").getBytes("ISO8859-1"), "UTF-8");
								String PRICE = request.getParameter("price");
								String TYPE = new String(request.getParameter("type").getBytes("ISO8859-1"), "UTF-8");
								String SPEC = new String(request.getParameter("spec").getBytes("ISO8859-1"), "UTF-8");
								String PRODATE = request.getParameter("proDate");
								String MATERIAL = new String(request.getParameter("material").getBytes("ISO8859-1"), "UTF-8");
							%>
							<s:form action="/pages/product/modifyProduct" method="post"
								theme="simple">
								<label>产品名称</label>
								<input type="hidden" name="productDto.id" value="<%=ID %>"/>
								<input type="text" class="span5" name="productDto.name" value="<%=NAME%>" />
								<label>产品单价</label>
								<input type="text" class="span5" name="productDto.price" value="<%=PRICE%>" />
								<label>产品规格</label>
								<input type="text" class="span5" name="productDto.spec" value="<%=SPEC%>" />
								<label>产品类型</label>
								<input type="text" class="span5" name="productDto.type" value="<%=TYPE%>" />
								<label>生产日期</label>
								<div class="date form_date" data-date="1979-09-16T05:25:07Z"
									data-date-format="yyyy-mm-dd" data-link-field="dtp_input2"
									data-link-format="yyyy-mm-dd">
									<input type="text" name="productDto.proDate" value="<%=PRODATE%>" id="rjrf"
										class="span5" readonly="readonly"> <span
										class="add-on"><i class="icon-th"></i></span>
								</div>
								<label>产品材质</label>
								<input type="text" class="span5" name="productDto.material" value="<%=MATERIAL%>" />
								<hr />
								<div class="btn-toolbar">
									<input type="submit" class="btn btn-primary" value="保存" /> <input
										type="reset" class="btn btn-primary" value="还原" />
								</div>
							</s:form>
						</div>
					</div>
				</div>

			</div>
		</div>
	</div>




	<!-- Le javascript
    ================================================== -->
	<!-- Placed at the end of the document so the pages load faster -->
	<script src="<%=path%>lib/jquery-1.8.1.min.js" type="text/javascript"></script>
	<script src="<%=path%>lib/bootstrap/js/bootstrap.js"></script>
	<script src="<%=path%>lib/bootstrap/js/bootstrap-datetimepicker.js"></script>
	<script src="<%=path%>lib/bootstrap/js/bootstrap-datetimepicker.min.js"></script>
	<script type="text/javascript"
		src="<%=path%>js/locales/bootstrap-datetimepicker.zh-CN.js"
		charset="UTF-8"></script>
	<script type="text/javascript">
		$('.form_datetime').datetimepicker({
			//language:  'fr',
			weekStart : 1,
			todayBtn : 1,
			autoclose : 1,
			todayHighlight : 1,
			startView : 2,
			forceParse : 0,
			showMeridian : 1
		});
		$('.form_date').datetimepicker({
			language : 'zh-CN',
			weekStart : 1,
			todayBtn : 1,
			autoclose : 1,
			todayHighlight : 1,
			startView : 2,
			minView : 2,
			forceParse : 0
		});
		$('.form_time').datetimepicker({
			language : 'zh-CN',
			weekStart : 1,
			todayBtn : 1,
			autoclose : 1,
			todayHighlight : 1,
			startView : 1,
			minView : 0,
			maxView : 1,
			forceParse : 0
		});
	</script>













</body>
</html>


