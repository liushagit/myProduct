<#if label_products?exists>
<table border="1" align="center" cellspacing="0"  width="100%">
 			<th width=50>名字</th>
	        <th width=50>id</th>
	        <th width=50>创建时间</th>
	        <th width=50>产品数量</th>
	        <th width=50>最近更新时间</th>
	        <th width=50>价格</th>
	        <th width=50>折扣</th>
	        <th width=50>优惠价格</th>
	<#list label_products as product>
	    <tr>
	        <td>${product.name}</td>
	        <td>${product.productId}</td>
	        <td>${product.createTime?string('yyyy-MM-dd hh:mm:ss')}</td>
	        <td>${product.productNum}</td>
	        <td>${product.lastUpdate?string('yyyy-MM-dd hh:mm:ss')}</td>
	        <td>${product.price}</td>
	        <td>${product.discount}%</td>
	        <td>${product.deductPrice}</td>
	    </tr>
	</#list>
</table>
<#else>
产品不存在
</#if>