<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html lang="zh">
<head>
<%
	String path = request.getContextPath() + "/";
%>
<meta charset="utf-8">
<title>Bootstrap Admin</title>
<meta content="IE=edge,chrome=1" http-equiv="X-UA-Compatible">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">

<link rel="stylesheet" type="text/css"
	href="<%=path%>lib/bootstrap/css/bootstrap.css">

<link rel="stylesheet"
	href="<%=path%>lib/font-awesome/css/font-awesome.css">
<link rel="stylesheet" type="text/css"
	href="<%=path%>lib/bootstrap/css/bootstrap-datetimepicker.min.css">
<link rel="stylesheet" type="text/css"
	href="<%=path%>stylesheets/theme.css">



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
						onclick="window.open('<%=path%>index.html','_self'); ">首頁</a> <a
						href="#myModal" data-toggle="modal" class="btn"
						onclick="window.open('<%=path%>index.html','_self'); ">退出</a>
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
                        <ul id="dashboard-menu" class="nav nav-list collapse">
                            <li><s:a href="../product/productAdd.jsp">产品新增</s:a></li>
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
                        <ul id="settings-menu" class="nav nav-list collapse in">
                            <li><a href="../order/getProductInOrderAdd">订单新增</a></li>
                            <li class="active"><a href="../order/getAllOrder">订单修改</a></li>
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
						<h1 class="page-title">订单管理</h1>
						<div class="well">
							<h2>订单修改</h2>
							<s:form action="/pages/order/getOrderById" method="post" theme="simple">
								<label>订单编号</label>
								<input type="text" name="orderId" class="span5" />
								<input type="submit" class="btn btn-primary" value="查询" />
							</s:form>
						</div>
						<div class="well">
							<h3>订单信息</h3>
							<table class="table">
								<thead>
									<tr>
										<th>订单编号</th>
										<th>供应商</th>
										<th>采购员</th>
										<th>付款方式</th>
										<th>审核人</th>
										<th>创建者</th>
										<th>下单时间</th>
										<th>订单状态</th>
										<th>订单金额</th>
										<th>操作</th>
									</tr>
								</thead>
								<tbody>
									<s:iterator value="list" var="order">
										<tr>
											<td><s:property value="#order.id" /></td>
											<td><s:property value="#order.provider.name" /></td>
											<td><s:property value="#order.buyer" /></td>
											<td><s:property value="#order.paymentDto.payment" /></td>
											<td><s:property value="#order.reviewer" /></td>
											<td><s:property value="#order.usersDto.USER_NAME" /></td>
											<td><s:property value="#order.proDate" /></td>
											<td><s:property value="#order.statusDto.order_status" /></td>
											<td><s:property value="#order.price" /></td>
											<td><a href="../order/order.jsp?id=<s:property value="#order.id" />"><i
													class="icon-pencil"></i></a> <a href="../order/deleteOrder" role="button"
												data-toggle="modal" onclick="return confirm('确定要删除吗？');"><i
													class="icon-remove"></i></a></td>
										</tr>
									</s:iterator>
								</tbody>
							</table>
							<div class="row-fluid">
								<div class="span6">共有5条记录，当前为第1页。</div>
								<div class="span4" style="text-align: right;">
									<input type="button" class="btn btn-primary" value="首页">
									<input type="button" class="btn btn-primary" value="上一页">
									<input type="button" class="btn btn-primary" value="下一页">
									<input type="button" class="btn btn-primary" value="尾页">
								</div>
								<div class="span2">
									转到第<input type="text" style="width: 10px;">页&nbsp;&nbsp;&nbsp;&nbsp;<input
										type="button" class="btn btn-primary" value="跳转">
								</div>
							</div>
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


