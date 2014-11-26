<#macro cafeLayout title="CafeNext">
<html lang="ko">
<head>
<title>${title}</title>
<link rel="stylesheet" href="/static/css/mycafe-common.css" type="text/css">
<link rel="stylesheet" href="/static/css/mycafe-layout.css" type="text/css">
<link rel="stylesheet" href="/static/css/mycafe-main.css" type="text/css">
<link rel="stylesheet" href="/static/css/mycafe-sub.css" type="text/css">
</head>

<body>

<h1 class="d-none">$cafe.name</h1>

<div id="cafe-body-skin" > 
    <div id="cafe-body">
        <#include "tiles/cafe_special_menu.ftl" />
        <#include "tiles/cafe_search.ftl" />
        <div id="content-area">
            <div id="group-area" class="fr">
                <#include "tiles/cafe_info.ftl" />            
                <#include "tiles/cafe_menu.ftl" />       
            </div>
            <div id="main-area" class="fl">
                <#nested />     
            </div>
        </div>
    </div>
    
    <#include "tiles/cafe_footer.ftl" />
</div>

</body>
</html>
</#macro>