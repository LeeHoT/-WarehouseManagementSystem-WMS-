﻿<%@ page language="java" contentType="text/html; charset=UTF-8"
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


<script src="<%=path%>js/jquery.1.3.2.js" type="text/javascript"
	language="javascript"></script>
<script language="JavaScript" type="text/javascript"
	src="<%=path%>js/popup_layer.js"></script>


<!-- Demo page code -->
<script language="javascript">
	$(document)
			.ready(
					function() {
						var t9 = new PopupLayer({
							trigger : "#ele9",
							popupBlk : "#blk9",
							closeBtn : "#close9",
							useOverlay : true,
							useFx : true,
							popupLayerClass : "#container-fluid",
							offsets : {
								x : 0,
								y : -41
							}
						});
						t9.doEffects = function(way) {
							if (way == "open") {
								this.popupLayer
										.css({
											opacity : 0.3
										})
										.show(
												400,
												function() {
													this.popupLayer
															.animate(
																	{
																		left : ($(
																				document)
																				.width() - this.popupLayer
																				.width()) / 2 - 100,
																		top : (document.documentElement.clientHeight - this.popupLayer
																				.height())
																				/ 2
																				+ $(
																						document)
																						.scrollTop(),
																		opacity : 0.8
																	},
																	1000,
																	function() {
																		this.popupLayer
																				.css(
																						"opacity",
																						1)
																	}
																			.binding(this));
												}.binding(this));
							} else {
								this.popupLayer.animate({
									left : this.trigger.offset().left,
									top : this.trigger.offset().top,
									opacity : 0.1
								}, {
									duration : 500,
									complete : function() {
										this.popupLayer.css("opacity", 1);
										this.popupLayer.hide()
									}.binding(this)
								});
							}
						}
					});
</script>
<script type="text/javascript">
	function validate() {
		document.getElementByIdx_x('addOrder').submit();
	}
</script>
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
	<s:form action="/pages/order/addOrder" method="post" theme="simple"
		class="form-horizontal">
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
                            <li class="active"><a href="../order/getProductInOrderAdd">订单新增</a></li>
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
						<h1 class="page-title">订单管理</h1>
						<div class="well">
							<h2>新订单录入</h2>
							<hr />
							<div>
								<div id="myTabContent" class="tab-content row-fluid">
									<div class="tab-pane active in span3">
										<label>供应商</label> <select name="providerName"
											class="input-xlarge">
											<option>APPLE(中国)</option>
											<option>SUMSUNG</option>
											<option>DELL</option>
										</select>
									</div>
									<div class="span3 control-group">
										<label>采购员</label> <input type="text" name="billhtDto.buyer"
											class="input-xlarge" />
									</div>
									<div class="span3 control-group">
										<label>付款方式</label> <select name="payment"
											class="input-xlarge">
											<option>不限</option>
											<option>现金</option>
											<option>刷卡</option>
											<option>银行电子汇款</option>
											<option>邮局汇款</option>
										</select>
									</div>
									<div class="span3 control-group">
										<label>审核人</label> <input type="text"
											name="billhtDto.reviewer" class="input-xlarge" />
									</div>
								</div>
								<div id="myTabContent" class="tab-content row-fluid">
									<div class="tab-pane active in span3">
										<label>创建者</label> <input type="text" name="creator"
											class="input-xlarge" />
									</div>
									<div class="span3 control-group">

										<label>创建时间</label>
										<div class="date form_date" data-date=""
											data-date-format="yyyy-mm-dd" data-link-field="dtp_input2"
											data-link-format="yyyy-mm-dd">
											<input type="text" id="rjrf" name="billhtDto.proDate"
												class="input-xlarge" readonly="readonly"> <span
												class="add-on"><i class="icon-th"></i></span>
										</div>
									</div>

								</div>
								<input type="hidden" id="checkString" name="checkString">
								<div class="btn-toolbar">
									<input type="submit" class="btn btn-primary" value="创建订单" />
								</div>
							</div>
						</div>
					</div>
					<div class="well">

						<h3>
							产品信息<input type="button" class="btn btn-primary pull-right"
								id="ele9" value="查询" />
						</h3>
						<table class="table">
							<thead>
								<tr>
									<th>选中</th>
									<th>产品编号</th>
									<th>产品名称</th>
									<th>产品规格</th>
									<th>产品单价</th>
									<th>产品材质</th>
									<th>生产日期</th>
									<th>产品类型</th>
									<th>数量</th>
								</tr>
							</thead>
							<tbody>

								<s:iterator value="list" var="pro" status="st">
									<tr>
										<td><input type="checkbox" name="check"
											value="<s:property value="#st.index"/>" class="checkbox" /></td>
										<td><s:property value="#pro.id" /><input type="hidden"
											name="id" value="<s:property value="#pro.id" />"></td>
										<td><s:property value="#pro.name" /></td>
										<td><s:property value="#pro.sepc" /> <input
											type="hidden" name="price"
											value="<s:property value="#pro.price" />"></td>
										<td><s:property value="#pro.price" /></td>
										<td><s:property value="#pro.material" /></td>
										<td><s:property value="#pro.proDate" /></td>
										<td><s:property value="#pro.type" /></td>
										<td><input type="text" name="quantity" class="input-mini" /></td>
									</tr>
								</s:iterator>

							</tbody>
						</table>
						<div class="row-fluid">
							<div class="span6">共有10条记录，当前为第1页。</div>
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
	</s:form>
	<s:form>
		<div id="blk9" class="blk" style="display: none;">
			<div class="head">
				<div class="head-right"></div>
			</div>
			<div class="main">
				<h2>请输入查询条件</h2>
				<div class="dhee">
					产品编号:<input type="text" name="productDto.id" />
				</div>
				<div class="dhee">
					产品价格:<input type="text" name="productDto.fprice" class="input1" />&nbsp;到<input
						type="text" name="productDto.lprice" class="input1" />
				</div>
				<div class="dhee">
					生产日期: <span class="date form_date" data-date="1979-09-16T05:25:07Z"
						data-date-format="yyyy-mm-dd" data-link-field="dtp_input2"
						data-link-format="yyyy-mm-dd"> <input type="text"
						name="fProDate" class="input2" /> <span class="add-on"><i
							class="icon-th"></i></span>
					</span> &nbsp;到 <span name="lProDate" class="date form_date"
						data-date="1979-09-16T05:25:07Z" data-date-format="yyyy-mm-dd"
						data-link-field="dtp_input2" data-link-format="yyyy-mm-dd">
						<input type="text" class="input2" /> <span class="add-on"><i
							class="icon-th"></i></span>
					</span>
				</div>
				<div class="dhee">
					<a href="../order/getProductBySome" class="btn">查询</a> <a
						href="javascript:void(0)" id="close9" class="btn">关闭</a>
				</div>
				<div class="foot"></div>
			</div>
		</div>
	</s:form>




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

