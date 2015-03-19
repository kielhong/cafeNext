<div id="content-area" >
  <div id="main-area" class="fr">
    <div id="sub-tit">
      <h3 class="sub-tit-color only-tit"><#if board??>${board.title}<#else>전체글보기</#if></h3>
    </div>
  <div class="sub-tit-bottom"></div>
  <div class="h-20"></div>

  <div class="article-board zindex6 m-tcol-c" id="upperArticleList">
    <table cellspacing="0" cellpadding="0" border="0" class="board-box">
      <col width="70">
      <col width="*">
      <col width="122">
      <col width="70">
      <col width="45">
      <col width="45">
      <tr><td colspan="6" class="board-line"  style="height:3px !important; "></td></tr>    
      <tr align="center" class="bg-color">
        <td class="p11"></td>
        <td class="p11">제목</td>
        <td class="p11">작성자</td>
        <td class="p11">작성일</td>
        <td class="p11">조회</td>
        <td class="p11">추천</td>
      </tr>
      <tr><td colspan="6" class="board-line"></td></tr>
    </table>
  </div>
  
  <div class="article-board m-tcol-c">
    <table cellspacing="0" cellpadding="0" border="0" class="board-box" style="table-layout:fixed">
      <col width="70">
      <col width="*">
      <col width="122">
      <col width="70">
      <col width="45">
      <col width="45">

      <#list articles as article>     
      <tr align="center">
        <td>
          <span class="m-tcol-c list-count">${article.id}</span>
        </td>
        <td align="left" class="board-list">
          <span class="aaa">
            <a href="/${cafe.domain}/articles/${article.id}" class="m-tcol-c">${article.title}</a>
          </span>
        </td>
        <td align="left">
          <div class="pers_nick_area" style="padding-left:14px"><span class="wordbreak" id="article_demiru_0">${article.member.nickname}</span></div>
        </td>
        <td class="view-count m-tcol-c">${article.createdAt?string("yyyy.MM.dd")}</td>
        <td class="view-count m-tcol-c">${article.readCount}</td>
        <td class="view-count m-tcol-c">${article.recommendCount}</td>
      </tr>
      <tr><td colspan="6" class="board-line"></td></tr> 
      </#list>   
    </table>
  </div>
 
  <table width="100%" cellspacing="0" cellpadding="0" border="0"><tr><td class="board-line" style="height:3px !important; "></td></tr></table>

  <div class="prev-next">
    <table summary="페이지 네비게이션" class="Nnavi" align="center">
      <tr>  
        <#list 0..page.totalPages-1 as p>
        <td><a href="?page=${p_index}" class="<#if p == page.number>m-tcol-p<#else>m-tcol-c</#if>">${p_index + 1}</a></td>
        </#list>
      <!--
          <td class="on"><a href="/ArticleList.nhn?search.boardtype=L&search.questionTab=A&search.clubid=13566444&search.totalCount=151&search.page=1" onclick="return dynamicParamLink('/ArticleList.nhn?search.boardtype=L&search.questionTab=A&search.clubid=13566444&search.totalCount=151&search.page=1', event)" class="m-tcol-p">1</a></td> 
        <td><a href="/ArticleList.nhn?search.boardtype=L&search.questionTab=A&search.clubid=13566444&search.totalCount=151&search.page=2" onclick="return dynamicParamLink('/ArticleList.nhn?search.boardtype=L&search.questionTab=A&search.clubid=13566444&search.totalCount=151&search.page=2', event)" class="m-tcol-c">2</a></td>
        <td><a href="/ArticleList.nhn?search.boardtype=L&search.questionTab=A&search.clubid=13566444&search.totalCount=151&search.page=3" onclick="return dynamicParamLink('/ArticleList.nhn?search.boardtype=L&search.questionTab=A&search.clubid=13566444&search.totalCount=151&search.page=3', event)" class="m-tcol-c">3</a></td>
          <td><a href="/ArticleList.nhn?search.boardtype=L&search.questionTab=A&search.clubid=13566444&search.totalCount=151&search.page=4" onclick="return dynamicParamLink('/ArticleList.nhn?search.boardtype=L&search.questionTab=A&search.clubid=13566444&search.totalCount=151&search.page=4', event)" class="m-tcol-c">4</a></td>
          <td><a href="/ArticleList.nhn?search.boardtype=L&search.questionTab=A&search.clubid=13566444&search.totalCount=151&search.page=5" onclick="return dynamicParamLink('/ArticleList.nhn?search.boardtype=L&search.questionTab=A&search.clubid=13566444&search.totalCount=151&search.page=5', event)" class="m-tcol-c">5</a></td>
          <td><a href="/ArticleList.nhn?search.boardtype=L&search.questionTab=A&search.clubid=13566444&search.totalCount=151&search.page=6" onclick="return dynamicParamLink('/ArticleList.nhn?search.boardtype=L&search.questionTab=A&search.clubid=13566444&search.totalCount=151&search.page=6', event)" class="m-tcol-c">6</a></td>
          <td><a href="/ArticleList.nhn?search.boardtype=L&search.questionTab=A&search.clubid=13566444&search.totalCount=151&search.page=7" onclick="return dynamicParamLink('/ArticleList.nhn?search.boardtype=L&search.questionTab=A&search.clubid=13566444&search.totalCount=151&search.page=7', event)" class="m-tcol-c">7</a></td>
          <td><a href="/ArticleList.nhn?search.boardtype=L&search.questionTab=A&search.clubid=13566444&search.totalCount=151&search.page=8" onclick="return dynamicParamLink('/ArticleList.nhn?search.boardtype=L&search.questionTab=A&search.clubid=13566444&search.totalCount=151&search.page=8', event)" class="m-tcol-c">8</a></td>
          <td><a href="/ArticleList.nhn?search.boardtype=L&search.questionTab=A&search.clubid=13566444&search.totalCount=151&search.page=9" onclick="return dynamicParamLink('/ArticleList.nhn?search.boardtype=L&search.questionTab=A&search.clubid=13566444&search.totalCount=151&search.page=9', event)" class="m-tcol-c">9</a></td>
          <td><a href="/ArticleList.nhn?search.boardtype=L&search.questionTab=A&search.clubid=13566444&search.totalCount=151&search.page=10" onclick="return dynamicParamLink('/ArticleList.nhn?search.boardtype=L&search.questionTab=A&search.clubid=13566444&search.totalCount=151&search.page=10', event)" class="m-tcol-c">10</a></td>
          <td class="pgR"><a href="/ArticleList.nhn?search.boardtype=L&search.questionTab=A&search.clubid=13566444&search.totalCount=151&search.page=11" onclick="return dynamicParamLink('/ArticleList.nhn?search.boardtype=L&search.questionTab=A&search.clubid=13566444&search.totalCount=151&search.page=11', event)" class="m-tcol-c pn"><span>다음</span><span class="ico-bl ico">▶</span></a></td>
-->           
      </tr>
    </table>      
  </div>
</div>

<div style="height: 160px;">&nbsp;</div>