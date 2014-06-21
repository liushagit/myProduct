<#if label_center?exists>

	<#if label_center==1>
		<#include "/product/my_product.ftl">
	</#if>
	<#if label_center==2>
		<#include "/product/create_product.ftl">
	</#if>
	<#if label_center==3>
		<table width="100%" border="0" align="center" cellspacing="0">
		  <tr>
		    <td height="100%" >消费产品</td>
		  </tr>
		</table>
	</#if>
<#else>
请选择
</#if>