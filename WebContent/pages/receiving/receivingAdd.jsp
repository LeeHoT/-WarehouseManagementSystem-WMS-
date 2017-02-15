<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
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

<link rel="stylesheet" href="<%=path%>lib/font-awesome/css/font-awesome.css">
<link rel="stylesheet" type="text/css"
	href="<%=path%>lib/bootstrap/css/bootstrap-datetimepicker.min.css">
<link rel="stylesheet" type="text/css" href="<%=path%>stylesheets/theme.css">
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
			//document.getElementById("hensaku").disabled = true;
			//document.getElementById("torouku").disabled = false;
			document.getElementById("tableid").style.display = '';
		}
        function cleardiv(){
            document.getElementById("tableid").style.display = 'none';
        }
	</script>
	<!--<![endif]-->
	<form action="#" class="form-horizontal">
		<div class="navbar">
			<div class="navbar-inner" align="right">
				<a class="brand" href="index.html"><span class="second"><strong style="color: white;"></strong></span></a>
				<div class="btn-toolbar" style="margin-left: 65px;">
					<a href="#myModal" data-toggle="modal" class="btn" onclick="window.open('<%=path%>index.html','_self'); ">首頁</a>
					<a href="#myModal" data-toggle="modal" class="btn" onclick="window.open('<%=path%>index.html','_self'); ">退出</a>
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
							<li><a href="../product/productAdd.jsp">产品新增</a></li>
							<li><a href="../product/productModify.jsp">产品修改</a></li>
							<li><a href="../product/productSelect.jsp">产品查询</a></li>

						</ul>
                        <div class="nav-header" data-toggle="collapse"
                             data-target="#accounts-menu">
                            <i class="icon-briefcase"></i>供应商管理
                        </div>
                        <ul id="accounts-menu" class="nav nav-list collapse">
                            <li><a href="../provider/providerAdd.jsp">供应商新增</a></li>
                            <li><a href="../provider/providerModify.jsp">供应商修改</a></li>
                            <li><a href="../provider/providerSelect.jsp">供应商查询</a></li>
                        </ul>

                        <div class="nav-header" data-toggle="collapse"
                             data-target="#settings-menu">
                            <i class="icon-exclamation-sign"></i>订单管理
                        </div>
                        <ul id="settings-menu" class="nav nav-list collapse">
                            <li><a href="../order/orderAdd.jsp">订单新增</a></li>
                            <li><a href="../order/orderModify.jsp">订单修改</a></li>
                            <li><a href="../order/orderSelect.jsp">订单查询</a></li>
                        </ul>

                        <div class="nav-header" data-toggle="collapse"
                             data-target="#legal-menu">
                            <i class="icon-legal"></i>收货管理
                        </div>
                        <ul id="legal-menu" class="nav nav-list collapse">
                            <li class="active"><a href="../receiving/receivingAdd.jsp">新发生收货</a></li>
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
                        <h1 class="page-title">收货管理</h1>
                        <div class="well">
                            <h2>收货信息录入</h2>
                            <hr/>
                            <form>
                                <label>订单编号</label>
                                <input type="text" class="span3"/>
                                <input type="submit" class="btn btn-primary" value="查询未收货订单" onclick="hensa()"/>
                                <input type="reset" class="btn btn-primary" value="关闭查询结果" onclick="cleardiv()"/>
                            </form>
                        </div>
                    </div>
                    <div id="tableid" class="well" align="center" style="display: none;">
                        <h3>未收货订单信息</h3>
                        <hr/>
                        <table class="table-bordered table" border="1">
                            <tr>
                                <td><label>订单编号：001</label></td>
                                <td><label>供应商：长颈龙电脑</label></td>
                                <td><label>采购员：张三</label></td>
                                <td><label>付款方式：现金</label></td>
                                <td><label>审核人：李四</label></td>
                            </tr>
                            <tr>
                                <td><label>创建者：王五</label></td>
                                <td><label>下单时间：2015-1-20</label></td>
                                <td><label>订单状态：未处理</label></td>
                                <td><label>订单金额：10000.00</label></td>
                                <td>
                                </td>
                            </tr>
                        </table>
                        <div class="btn-toolbar" align="right">
                            <form>
                                <input type="button" class="btn btn-primary" value="订单详情" onclick="window.open('../receiving/receivingOrder.jsp','_self');"/>
                                <input type="submit" class="btn btn-primary" value="确认收货"/>
                            </form>
                        </div>
                    </div>
				</div>

			</div>
		</div>
	</form>




	<!-- Le javascript
    ================================================== -->
	<!-- Placed at the end of the document so the pages load faster -->
	<script src="<%=path%>lib/jquery-1.8.1.min.js" type="text/javascript"></script>
	<script src="<%=path%>lib/bootstrap/js/bootstrap.js"></script>
	<script src="<%=path%>lib/bootstrap/js/bootstrap-datetimepicker.js"></script>
	<script src="<%=path%>lib/bootstrap/js/bootstrap-datetimepicker.min.js"></script>
	<script type="text/javascript" src="<%=path%>js/locales/bootstrap-datetimepicker.zh-CN.js" charset="UTF-8"></script>
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


