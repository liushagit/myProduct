<#include "/include/header.ftl">
<#if label_products?exists>
<table border="1">
 			<th>名字</th>
	        <th>id</th>
	        <th>数量</th>
	        <th>描述</th>
	        <th>价格</th>
	        <th>时间</th>
	<#list label_products as product>
	    <tr>
	        <td>${product.name}</td>
	        <td>${product.productId}</td>
	        <td>${product.productNum}</td>
	        <td>${product.destance}</td>
	        <td>${product.price}</td>
	        <td>${product.lastUpdate?string('yyyy-MM-dd hh:mm:ss')}</td>
	    </tr>
	</#list>
</table>
<#else>
产品不存在
</#if>
<#include "/include/footer.ftl">