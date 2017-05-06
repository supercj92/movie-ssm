<#if authResulst == '1'>
	<video id="my-video"  preload="auto" controls width="640px" height="320px">
    <source src="" type='video/mp4'>
  </video>
  <div>
  	<button id="getFiles" type="button">getFiles</button>
	<input id="path" type = "text"/>
  </div>
	
	<div id = "myDiv"></div>
<#else>
认证失败
</#if>
  