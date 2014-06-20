<#include "/include/header.ftl">
<form id="form" class="form"  method="post" action="g">
<input type="hidden" id="cmd" name="cmd" value="u_CP"/> 
<table width="300" border="0" cellspacing="0" align="center">
  <tr>
    <td>用户名：</td>
    <td><input type="text" id="1" name="1" /></td>
  </tr>
  <tr>
    <td>密&nbsp;&nbsp;码：</td>
    <td><input type="password" id="2" name="2" /></td>
  </tr>
  <tr>
    <td>确认密码</td>
    <td><input type="password" id="3" name="3" /><input type="hidden" id="4" name="4" value="1"/> </td>
  </tr>
  <tr>
    <td><input type="submit" value="注册" /> </td>
    <td><input type="button" value="清空" /> </td>
  </tr>
</table>
</form>
<#include "/include/footer.ftl">