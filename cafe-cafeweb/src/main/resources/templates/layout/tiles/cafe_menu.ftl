<div id="cafe-menu">
  <div class="box-g-t"></div>
  <div class="box-g-m">      
    <ul class="cafe-menu-list">
      <li>
        <img src="http://cafeimgs.naver.net/cafe4/hidden.gif" class="ico-list" alt="">
        <a href="/${cafe.domain}" class="gm-tcol-c">전체글보기</a> 
        <span class="gm-tcol-c p11" style="padding-right:2px;">(<strong>${cafe.articleCount}</strong>)</span>
      </li>
      <#list cafe.boards as board>
      <li>
        <img src="http://cafeimgs.naver.net/cafe4/hidden.gif" class="ico-list" alt="">
        <a href="/${cafe.domain}/board/${board.id}" class="gm-tcol-c">${board.title}</a>
      </li>
      </#list>
    </ul>
  </div>
  <div class="box-g-b"></div>
</div>