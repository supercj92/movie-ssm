<#if authResult == '1'>
    <video id="my-video" preload="auto" controls width="100%" height="320px" autoplay="autoplay">
        <source src="" type='video/mp4'>
    </video>
    <div class="form-group">
        <input id="path" class="form-control" type="text"/>
    </div>
    <button id="getFiles" class="btn btn-primary btn-lg" type="button">getFiles</button>
    <div id="myDiv"></div>
<#else>
认证失败
</#if>