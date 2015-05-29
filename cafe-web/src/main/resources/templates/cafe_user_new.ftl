<#import "layout/cafe_layout.ftl" as layout>
<@layout.cafeLayout "${cafe.name}">
<div id="main-area" class="fl">

<form name="frm" id="applyFrm"  action="/${cafe.domain}/users/create" method="post" >
    <div id="sub-tit">
        <h3 class="sub-tit-color">카페 가입하기</h3>
        <p class="m-tcol-c">카페 가입을 위한 정보를 입력해주세요</p>
    </div>
    <div class="sub-tit-bottom"></div>
    <div class="h-20"></div>


	<center>
	<div style="width: 100px">
	    <input type="submit" class="btn" value="가입하기"/>
    </div>
	</center>
</form>
</div>

</@layout.cafeLayout>