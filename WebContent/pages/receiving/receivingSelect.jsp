<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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


<script src="<%=path %>js/jquery.1.3.2.js" type="text/javascript" language="javascript"></script>
<script language="JavaScript" type="text/javascript" src="<%=path %>js/popup_layer.js"></script>


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
                        <ul id="dashboard-menu" class="nav nav-list collapse in">
							<li><a href="../product/productAdd.jsp">产品新增</a></li>
							<li><a href="../product/productModify.jsp">产品修改</a></li>
							<li><a href="../product/productSelect.jsp">产品查询</a></li>

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
                            <li><a href="../receiving/receivingAdd.jsp">新发生收货</a></li>
                            <li class="active"><a href="../receiving/receivingSelect.jsp">收货查询</a></li>
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
                            <h2>收货信息查询</h2>
                            <form>
                                <div id="myTabContent" class="tab-content row-fluid">
                                    <div class="tab-pane active in span5">
                                        <label>收货单编号</label>
                                        <input type="text" class="span7"/>
                                    </div>
                                    <div class="tab-pane active in span5">
                                        <label>生产日期</label>
                                        <div class="date form_date" data-date="1979-09-16T05:25:07Z" data-date-format="yyyy-mm-dd" data-link-field="dtp_input2" data-link-format="yyyy-mm-dd">
                                            <input type="text" id="rjrf" class="span7" readonly="readonly">
                                            <span class="add-on"><i class="icon-th"></i></span>
                                        </div>
                                    </div>
                                    <div class="tab-pane active in span2">
                                        <label>&nbsp;</label>
                                        <input type="submit" class="btn btn-primary pull-right" value="查询"/>
                                    </div>
                                </div>
                            </form>
                        </div>
                        <div class="well">
                            <h3>收货产品信息</h3>
                            <table class="table">
                                <thead>
                                <tr>
                                    <th>收货单编号</th>
                                    <th>产品名称</th>
                                    <th>收货数量</th>
                                    <th>收货时间</th>
                                    <th>操作</th>
                                </tr>
                                </thead>
                                <tbody>
                                <tr>
                                    <td>001</td>
                                    <td>笔记本电脑</td>
                                    <td>100</td>
                                    <td>2015-4-16</td>
                                    <td>
                                        <a href="../provider/provider.html"><i class="icon-pencil"></i></a>
                                        <a href="#" role="button" data-toggle="modal" onclick="return confirm('确定要删除吗？');"><i class="icon-remove"></i></a>
                                    </td>
                                </tr>
                                <tr>
                                    <td>001</td>
                                    <td>笔记本电脑</td>
                                    <td>100</td>
                                    <td>2015-4-16</td>
                                    <td>
                                        <a href="../provider/provider.html"><i class="icon-pencil"></i></a>
                                        <a href="#" role="button" data-toggle="modal" onclick="return confirm('确定要删除吗？');"><i class="icon-remove"></i></a>
                                    </td>
                                </tr>
                                <tr>
                                    <td>001</td>
                                    <td>笔记本电脑</td>
                                    <td>100</td>
                                    <td>2015-4-16</td>
                                    <td>
                                        <a href="../provider/provider.html"><i class="icon-pencil"></i></a>
                                        <a href="#" role="button" data-toggle="modal" onclick="return confirm('确定要删除吗？');"><i class="icon-remove"></i></a>
                                    </td>
                                </tr>
                                <tr>
                                    <td>001</td>
                                    <td>笔记本电脑</td>
                                    <td>100</td>
                                    <td>2015-4-16</td>
                                    <td>
                                        <a href="../provider/provider.html"><i class="icon-pencil"></i></a>
                                        <a href="#" role="button" data-toggle="modal" onclick="return confirm('确定要删除吗？');"><i class="icon-remove"></i></a>
                                    </td>
                                </tr>
                                <tr>
                                    <td>001</td>
                                    <td>笔记本电脑</td>
                                    <td>100</td>
                                    <td>2015-4-16</td>
                                    <td>
                                        <a href="../provider/provider.html"><i class="icon-pencil"></i></a>
                                        <a href="#" role="button" data-toggle="modal" onclick="return confirm('确定要删除吗？');"><i class="icon-remove"></i></a>
                                    </td>
                                </tr>
                                </tbody>
                            </table>
                            <div class="row-fluid">
                                <div class="span6">共有10条记录，当前为第1页。</div>
                                <div class="span4" style="text-align: right;">
                                    <input type="button" class="btn btn-primary" value="首页"> <input
                                        type="button" class="btn btn-primary" value="上一页"> <input
                                        type="button" class="btn btn-primary" value="下一页"> <input
                                        type="button" class="btn btn-primary" value="尾页">
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


