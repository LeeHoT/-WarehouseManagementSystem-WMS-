<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<div class="nav-header" data-toggle="collapse"
     data-target="#dashboard-menu">
    <i class="icon-dashboard"></i>产品档案管理
</div>
<ul id="dashboard-menu" class="nav nav-list collapse">
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
    <li><a hr】ef="../provider/providerSelect.jsp">供应商查询</a></li>
</ul>

<div class="nav-header" data-toggle="collapse"
     data-target="#settings-menu">
    <i class="icon-exclamation-sign"></i>订单管理
</div>
<ul id="settings-menu" class="nav nav-list collapse in">
    <li><a href="../order/orderAdd.html">订单新增</a></li>
    <li class="active"><a href="../order/orderModify.jsp">订单修改</a></li>
    <li><a href="../order/orderSelect.jsp">订单查询</a></li>
</ul>

<div class="nav-header" data-toggle="collapse"
     data-target="#legal-menu">
    <i class="icon-legal"></i>收货管理
</div>
<ul id="legal-menu" class="nav nav-list collapse">
    <li><a href="../receiving/receivingAdd.jsp">新发生收货</a></li>
    <li><a href="../receiving/receivingSelect.jsp">收货查询 </a></li>
</ul>

<div class="nav-header" data-toggle="collapse"
     data-target="#legal-menu1">
    <i class="icon-legal"></i>退货管理
</div>
<ul id="legal-menu1" class="nav nav-list collapse">
    <li><a href="../returns/returnAdd.jsp">退货登记</a></li>
    <li><a href="../returns/returnSelect.jsp">退货查询 </a></li>
</ul>
