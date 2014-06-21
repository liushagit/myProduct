<#--
<#include "/include/header.ftl">
 <#if label_desc?exists>
 ${label_desc}<br/>
 <#else>
 创建<br/>
 </#if>
 <a href="<@link "/p?p_CP/${sign}/1234562/测试/测试111/1/100/10/3/"/>">创建</a>
 <a href="<@link "/p?p_MP/${sign}/"/>">产品</a>
<#include "/include/footer.ftl">

-->
<#if label_create?exists>
	<form id="form1" name="form1" method="post" action="/g">
	<input type="hidden" id="cmd" name="cmd" value="p_CP"/> 
	<input type="hidden" id="sign" name="sign" value="${sign}"/> 
		<table width="300" border="0" cellspacing="0">
			<tr>
				<td colspan="2">请录入产品信息</td>
			</tr>
			<tr>
				<td width="80">产品编号：</td>
				<td><input name="1" type="text" size="20" maxlength="20"/></td>
			</tr>
			<tr>
				<td>产品名称：</td>
				<td><input name="2" type="text" size="20" maxlength="30"/></td>
			</tr>
			<tr>
				<td>产品说明：</td>
				<td><textarea name="3" cols="20"></textarea></td>
			</tr>
			<tr>
				<td>产品数量：</td>
				<td><input name="4" type="text" size="20" maxlength="4"/></td>
			</tr>
			<tr>
				<td>产品价格：</td>
				<td><input name="5" type="text" size="20" maxlength="4" value="1"/></td>
			</tr>
			<tr>
				<td>产品折扣：</td>
				<td><input name="6" type="text" size="20" maxlength="4" value="90"/></td>
			</tr>
			<tr>
				<td>产品优惠：</td>
				<td><input name="7" type="text" size="20" maxlength="4" value="0"/></td>
			</tr>
			<tr>
				<td><input type="submit" value="保存"/></td>
				<td><input type="reset" value="清空"/></td>
			</tr>
		</table>
	</form>
<#elseif label_desc?exists>
	${label_desc}<br/>
<#else>
	创建失败<br/>
</#if>