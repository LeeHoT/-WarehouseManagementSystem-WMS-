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
                            <li><s:a href="../product/productAdd.jsp">产品新增</s:a></li>
                            <li><s:a href="../product/getAllProduct">产品修改</s:a></li>
                            <li class="active"><a href="../product/getAllProduct1">产品查询</a></li>

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
							<h2>产品信息查询</h2>
							<s:form action="/pages/product/selectProductByAll" method="post"
								theme="simple">
								<div id="myTabContent" class="tab-content row-fluid">
									<div class="tab-pane active in span3">
										<label>产品编号</label> <input type="text"
											name="productSearchDto.id" class="input-xlarge" />
									</div>
									<div class="span3 control-group">
										<label>产品名称</label> <input type="text"
											name="productSearchDto.name" class="input-xlarge" />
									</div>
									<div class="span3 control-group">
										<label>产品单价</label> <input type="text"
											name="productSearchDto.fprice" class="input-small" />~<input
											type="text" name="productSearchDto.lprice"
											class="input-small" />
									</div>
									<s:hidden name="currentPage" value="1"></s:hidden>
									<s:hidden name="maxPageNumber"></s:hidden>
									<div class="span3 control-group">
										<label>产品材质</label> <input type="text"
											name="productSearchDto.material" class="input-xlarge" />
									</div>
								</div>
								<div id="myTabContent" class="tab-content row-fluid">
									<div class="tab-pane active in span3">
										<label>生产日期(起始)</label>
										<div class="date form_date" data-date=""
											data-date-format="yyyy-mm-dd" data-link-field="dtp_input2"
											data-link-format="yyyy-mm-dd">
											<input type="text" id="rjrf" name="productSearchDto.proDate"
												class="input-xlarge" readonly="readonly"> <span
												class="add-on"><i class="icon-th"></i></span>
										</div>
									</div>
									<div class="tab-pane active in span3">
										<label>&nbsp;</label> <input type="submit"
											class="btn btn-primary" value="查询" />
									</div>
								</div>
							</s:form>

						</div>
						<div class="well">
							<h3>产品信息</h3>
							<table class="table">
								<thead>
									<tr>
										<th>产品编号</th>
										<th>产品名称</th>
										<th>产品规格</th>
										<th>产品单价</th>
										<th>产品材质</th>
										<th>生产日期</th>
										<th>产品类型</th>
										<th>操作</th>
									</tr>
								</thead>
								<tbody>
									<s:iterator value="list" var="pro">
									<tr>
										<td><s:property value="#pro.id" /></td>
										<td><s:property value="#pro.name" /></td>
										<td><s:property value="#pro.spec" /></td>
										<td><s:property value="#pro.price" /></td>
										<td><s:property value="#pro.material" /></td>
										<td><s:property value="#pro.proDate" /></td>
										<td><s:property value="#pro.type" /></td>
										<td><a
											href="../product/product.jsp?id=<s:property value="#pro.id"/>&name=<s:property value="#pro.name"/>&spec=<s:property value="#pro.spec"/>&price=<s:property value="#pro.price"/>&type=<s:property value="#pro.type"/>&proDate=<s:property value="#pro.proDate"/>&material=<s:property value="#pro.material"/>"><i
												class="icon-pencil"></i></a> <a
											href="../product/deleteProduct?id=<s:property value="#pro.id"/>"
											role="button" data-toggle="modal"
											onclick="return confirm('确定要删除吗？');"><i
												class="icon-remove"></i></a></td>
										<lable  id="actionMessage" value='${ actionMessages[0]}'/> 
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


