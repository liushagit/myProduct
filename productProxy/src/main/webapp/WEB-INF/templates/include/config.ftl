<#assign game_title="进销存管理系统"/>
<#macro link url>
<#local newUrl = ""/>
<#local cmd = ""/>
<#local cmd2 = ""/>
<#local sign = ""/>
<#local param = ""/>
<#local locUrl = url?trim />
<#if !locUrl?starts_with("/")>
<#local locUrl="/"+locUrl />
</#if>
<#local size = locUrl?split("/")?size/>
<#if (size<4)><#local newUrl=locUrl /><#else>
<#list locUrl?split("/") as x>
<#if x_index = 1><#local cmd = x/></#if>
<#if x_index = 2><#local sign = x/></#if>
<#if (size==x_index+1)>
<#if x!="">
<#local param = param + x+"/" />
</#if>
<#elseif (x_index>2)>
<#local param = param + x+"/" />
</#if>
</#list>
<#list cmd?split("?") as xx>
	<#if xx_index = 0><#local serve = xx/></#if>
   <#if xx_index = 1><#local cmd2 = xx/></#if>
   <#if xx_index = 2><#local cmd2 = xx/></#if>
</#list>
<#local newUrl = "/"+cmd+"/"+sign+"-"+MD5.encodeZone(cmd2 + sign+param)+"/"+param />
</#if>
<#if label_contextPath?exists && label_contextPath != ''>${label_contextPath}${newUrl}<#else>${newUrl}</#if></#macro>
