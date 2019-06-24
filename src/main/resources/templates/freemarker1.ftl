this is my test page.<br>
${name}<br>
<#if gender == 1>
    男
<#elseif gender == 2>
    女
<#else>
    其他
</#if>
<br>
<#list userlist as user>
    ${user}<br>
</#list>