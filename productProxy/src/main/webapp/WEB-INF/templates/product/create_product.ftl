<#include "/include/header.ftl">
 <#if label_desc?exists>
 ${label_desc}<br/>
 <#else>
 创建<br/>
 </#if>
 <a href="<@link "/p?p_CP/${sign}/1234562/测试/测试111/1/100/10/3/"/>">创建</a>
 <a href="<@link "/p?p_MP/${sign}/"/>">产品</a>
<#include "/include/footer.ftl">