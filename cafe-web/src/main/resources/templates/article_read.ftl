<#import "layout/cafe_layout.ftl" as layout> 
<@layout.cafeLayout "${article.title} : ${cafe.name}">
  <div id="main-area">
    
    <div class="list-blog border-sub" id="post_6">
      <div class="inbox">
        <div class="tit-box">
            <div class="fl">
                <table cellspacing="0" cellpadding="0" border="0">
                    <tr valign="top">
                        <td><span class="b m-tcol-c">aaaa</span></td>
                        <td nowrap class="m-tcol-c filter-30">&#124;</td>
                        <td nowrap class="m-tcol-c"><a href="/${cafe.domain}/boards/${board.id}" class="m-tcol-c">${board.title}</a></td>
                        </tr>
                 </table>
            </div>
            <div class="fr date">
              ${article.createDatetime?string("yyyy.MM.dd hh:mm")}
            </div>
        </div>  
                
        <div class="board-box-line-dashed"></div>   
                    
        <div class="etc-box">
          <div class="fl nick">
            ${article.user.username}
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
              <tbody>
                <tr style="vertical-align:top">                        
                  <td class="reply"><span class="reply b m-tcol-p _totalCnt" >덧글 ${article.commentCount}개</span></td>
                  <td class="m-tcol-c filter-30">&#124;</td>
                  <td><span class="b m-tcol-c reply ">조회수 ${article.readCount}</span></td>
                </tr>
              </tbody>
            </table>
          </div>
        </div>
      </div>
      
      <#-- comment list -->          
      <div class="box-reply2 bg-color" style="display:block;">      
        <ul class="cmlist" id="cmt_list">         
        </ul>
        <div style="clear: both; height: 0pt; font: 0pt/0pt arial;"></div>                                 
        <table cellspacing="0" class="cminput">
          <tbody>
              <tr>
                <td class="i2">
                  <textarea id="comment_content" cols="50" rows="2" class="textarea m-tcol-c" maxlength="1000"></textarea>                       
                </td>
                <td class="i3">
                  <input type="image" name="" src="http://cafeimgs.naver.net/cafe4/btn_cmt_cfm_v1.gif"  alt="확인" id="comment_submit" class="_submitCmt">
                </td>
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
  
<script type="text/javascript">
function appendComment(container, comment) {
    container.append("<li style=\"margin-top:10px; padding:0; height:40px;\">" 
                        + "<span style=\"font-weight:bold\">" + comment.user.username + "</span>" 
                        + "<span class=\"m-tcol-c\">" + comment.create_datetime + "</span>"
                        + "<span><a href=\"#\" class=\"m-tcol-c\">답글</a></span>"
                        + "<p class=\"comm m-tcol-c\"><span class=\"comm_body\">" + comment.content + "</span></p>"
                        + "</li>"
                        + "<li class=\"filter-30 board-box-line-dashed\"></li>");
}

function loadComment(data) {
  $("#cmt_list").empty();
  
  for (var i = 0; i < data.length; i++) {
    appendComment($("#cmt_list"), data[i]);
  }
}

$("#comment_submit").click(function() {
  $.ajax({
    type: "POST",
    url: "/api/articles/${article.id}/comments",
    data: {"content": $("textarea#comment_content").val()}
  }).success(function(data) {
    $("#comment_content").val("");
    appendComment($("#cmt_list"), data);
  });
});

$(document).ready(function(){
  $.ajax({
    type: "GET",
    url: "/api/articles/${article.id}/comments"
  }).success(function(data) {
    loadComment(data);
  });
});

</script>  
 
</@layout.cafeLayout>