<#import "layout/cafe_layout.ftl" as layout> 
<@layout.cafeLayout "${article.title} : ${cafe.name}">
<div id="content-area" >
  <div id="main-area">
    
    <div class="list-blog border-sub" id="post_6">
      <div class="inbox">
        <div class="tit-box">
            <div class="fl">
                <table cellspacing="0" cellpadding="0" border="0">
                    <tr valign="top">
                        <td>
                            <span class="b m-tcol-c">aaaa</span></td>
                        <td nowrap class="m-tcol-c filter-30">&#124;</td>
                        <td nowrap class="m-tcol-c"><a href="/${cafe.nickname}/board/${article.board.id}" class="m-tcol-c">${article.board.title}</a></td>
                        </tr>
                 </table>
            </div>
            <div class="fr date">
              ${article.createdAt?string("yyyy.MM.dd hh:mm")}
            </div>
        </div>  
                
        <div class="board-box-line-dashed"></div>   
                    
        <div class="etc-box">
          <div class="fl nick">
            ${article.member.nickname}
          </div>
        </div>
        <div class="h-10"></div>
        
        <div class="tbody m-tcol-c" id="tbody">
          ${article.content}
        </div>
                
        <div class="h-35"></div>
                
        <div class="reply-box" id="cmtMenu">
          <div class="fl">
                        <table cellspacing="0" cellpadding="0" border="0">
                        <tbody><tr style="vertical-align:top">
                        
                        <td class="reply">
                            <span class="reply b m-tcol-p _totalCnt" >덧글 0개
                            
                            </span>
                        </td>
                        <td class="m-tcol-c filter-30">&#124;</td>
                        <td class="_sortList" style="padding:0;">
                            <div style="position:relative;_top:3px;"><a href="#" class="b m-tcol-c"><span>등록순</span><span style="display:none">최신순</span><span id="cafe-menu"><span class="cafe-menu-tit" style="background:none; width:12px; height:12px; margin:0;"><span class="down-btn" style="background-position:0 0; background-repeat:no-repeat"><img height="12" width="12" alt="" src="http://cafeimgs.naver.net/cafe4/hidden.gif"></span></span></span></a>
                               <div class="perid-layer2" style="display:none;">
                               <ul>
                                   <li class="asc"><a href="#"><span>등록순</span></a></li>
                                   <li class="desc"><a href="#"><span>최신순</span></a></li>
                               </ul>
                               </div>
                           </div>
                        </td>
                        <td class="m-tcol-c filter-30">&#124;</td>
                        
                        <td><span class="b m-tcol-c reply ">조회수 </span><span class="b m-tcol-c reply _rosReadcount">0</span></td>
                        
                        </tr>
                        </tbody>
                        </table>
          </div>
        </div>
      </div>
      
      <#-- comment list -->          
      <div class="box-reply2 bg-color" id="P9NKn" style="display:none;">      
        <ul class="cmlist" id="cmt_list"></ul>
        <div style="clear: both; height: 0pt; font: 0pt/0pt arial;"></div>
        <div style="display:none;" class="cc_paginate cmt" id="cmt_paginate"></div>                                 
        <table cellspacing="0" class="cminput">
          <tbody>
              <tr>
                <td class="i1">
                  <div class="reply-write-ico" id="refCmt_emoticon">
                        <img src='http://itemimgs.naver.net/personacon/16/37/1433716.gif' style='cursor:pointer;' width='19' height='19' alt='' class='myemoticon'/>
                  </div>                                                                                                                                  
                  <span style="display:none;"></span>                     
                </td>
                <td class="i2">
                  <textarea id="comment_text" cols="50" rows="2" class="textarea m-tcol-c" maxlength="1000"></textarea>                       
                </td>
                <td class="i3">
                  <input type="image" name="" src="http://cafeimgs.naver.net/cafe4/btn_cmt_cfm_v1.gif"  alt="확인" class="_submitCmt" onclick="clickcr(this,'cmt.comment', '', '', event)">
                </td>
              </tr>
              <tr>
                <td colspan="3"></td>
              </tr>
          </tbody>
        </table>
      </div>
    </div>
  </div> 
  
  <#-- operation -->
  <div class="list-btn-nor">
    <div class="fr">   
      <div id="writeFormBtn" class="btn _rosRestrict"><span></span><p><strong><a href="#" class="m-tcol-c b" ><img src="http://cafeimgs.naver.net/cafe4/ico-btn-write.gif" width="10" height="10" alt="">글쓰기</a></strong></p></div>
      <div id="replyFormBtn" class="btn _rosRestrict"><span></span><p><a href="#" class="m-tcol-c" ><img src="http://cafeimgs.naver.net/cafe4/ico-btn-check.gif" width="9" height="8" alt="">답글</a></p></div>
      <div id="modifyFormBtn" class="btn _rosRestrict"><span></span><p><a href="#" class="m-tcol-c" >수정</a></p></div>
      <div class="btn _rosRestrict" onclick="javascript:checkLogin('move');"><span></span><p><a href="#" class="m-tcol-c" >이동</a></p></div>
      <div class="btn _rosRestrict" onclick="javascript:checkLogin('delete');"><span></span><p><a href="#" class="m-tcol-c" >삭제</a></p></div>
      <div class="btn" onclick="goList();"><span></span><p><a href="#" class="m-tcol-c" >목록</a></p></div>
    </div>
  </div>
                      
  <div class="h-35"></div>
  
  <#-- related articles -->
  <div class="article-board article_prenet">
    <table cellspacing="0" cellpadding="0" border="0" width="100%">
        <col width="81"><col width="*"><col width="120"><col width="92">
        <tr><td colspan="4" class="board-line"></td></tr>
        <tr align="center">
          <td class="prev_btn"><a href="#" onclick="goNext();clickcr(this,'art.next','','',event);" class="m-tcol-c"><img src="http://cafeimgs.naver.net/cafe4/ico-btn-net2_.gif" alt="">다음글</a></td>
          <td align="left" class="board-list">
            <span class="aaa">
            <a href="#" class="m-tcol-c">대략 테스트...</a> 
            </span>
          </td>
          <td align="left"><div class="pers_nick_area"><table cellspacing="0"><caption><span class="blind">퍼스나콘/아이디 영역</span></caption><tr><td class="pc"><img src="http://cafeimgs.naver.net/cafe4/hidden.gif" width="13" height="13" alt="" class="p-none"></td><td class="p-nick"><a href="#" class="m-tcol-c" onclick="ui(event, 'kielhong',3,'키엘','10000001','ma', 'true', 'false', 'cafeno1', 'true', '3'); return false;"><span class="wordbreak" id="refarticle_nextSiblingContent">키엘</span></a></td></tr></table></div><script type="text/javascript">wordBreak($("refarticle_nextSiblingContent"));</script></td>
          <td class="view-count m-tcol-c">2003.12.10</td>
        </tr>
        <tr><td colspan="4" class="board-line"></td></tr>
    </table>
  </div>
  
</div>
 
</@layout.cafeLayout>