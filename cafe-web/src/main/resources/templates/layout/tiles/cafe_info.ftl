<div class="cafe-info-action" id="cafe-info-action">
  <div id="cafe-info-data">
    
    <#-- tab menu -->
    <ul class="info-action-tab">
      <li class="tit-info-on" id="ia-info">
        <p class="gm-tcol-t">카페정보</p>
      </li>
      <li class="tit-action" id="ia-action">
        <p><a href="#" onclick="showMyAction();return false;">나의활동</a></p>
      </li>
      <li class="tit-bookmark">
        <a href="#" title="즐겨찾는 카페 등록"><img src="http://cafeimgs.naver.net/cafe4/hidden.gif" width="27" height="28" alt="즐겨찾는 카페 등록" class="btn-bookmark-off" id="favoriteCafeInCafeInfo"></a>
      </li>
    </ul>
        
    <#-- cafe info -->
    <div class="box-g">
      <h4 class="d-none">카페정보</h4>
        <div class="ia-info-data" id="ia-info-data">
          <ul>
            <li class="gm-tcol-c">
                <div class="ball"><img src="http://cafeimgs.naver.net/cafe4/hidden.gif" width="27" height="13" class="ico-manager" alt="매니저"></div>
                <a href="#"class="id mlink gm-tcol-c">
                  <div class="ellipsis gm-tcol-c">${cafeManager.user.username}</div>
                </a>
            </li>
            <li class="gm-tcol-c">
                <div class="thm"><a href="/CafeHistoryView.nhn?clubid=10000001" class="gm-tcol-c" target="cafe_main">since ${cafe.createDatetime?date}</a></div>
                <div class="info-view"><a href="#" class="u gm-tcol-c">카페소개</a></div>
            </li>
            <li>
                <div class="cafe-admin">
                    <img src="http://cafeimgs.naver.net/cafe4/hidden.gif" width="11" height="10" alt="" class="ico-admin"> 
                    <strong>
                      <a href="/ManageHome.nhn?clubid=10000001" class="gm-tcol-c" >카페관리</a>
                    </strong>
                    <span class="gm-tcol-c filter-30 bar">|</span>
                    <img src="http://cafeimgs.naver.net/cafe4/hidden.gif" width="11" height="10" alt="" class="ico-stat"> <a href="/ManageStatisticsSummary.nhn?clubid=10000001" class="gm-tcol-c" onclick="clickcr(this, 'cia*i.stats', '', '', event);">통계</a>
                </div>
            </li>
          </ul>
        </div>
            
        <div class="ia-info-data2">
          <ul>
                <li class="level-info border-sub" onmouseover="$('hiddenCafeDescLayer').style.display = '';" onmouseout="$('hiddenCafeDescLayer').style.display = 'none';">
                    <span class="ico_lock"></span><br><span class="txt_lock gm-tcol-c"><em>비공개카페</em></span>
                </li>
                <li class="mem-cnt-info"  style="cursor:pointer;">
                    <strong class="d-none">카페회원수</strong>
                            <a href="#" onclick="showCafeMember();clickcr(this, 'cia*i.member', '', '', event);return false;" class="gm-tcol-c"><span class="ico"></span><br><em>2</em></a>
                    <div class="ly_info_dsc" style="font-weight:normal;top:31px;left:5px;display:none;" id="hiddenCafeApplyLayer"> 
                        <div class="cont cont_v1" style="width:60px"> 
                            <p><a href="/ManageJoinApplication.nhn?search.clubid=10000001" >가입대기 <span>0</span></a></p> 
                            <span class="tail" style="left:31px"></span> 
                        </div> 
                    </div>                  
                </li>
          </ul>
        </div>

        <div class="ia-info-data3" id="cafePopularityLog"></div>

        <div class="ia-info-btn">
          <ul class="ia-info-list">
            <li>
              <a href="#" class="gm-tcol-c">가입</a>
            </li>
            <li>
                <a href="#"class="gm-tcol-c">채팅하기</a>
            </li>
           </ul>
        </div>
      </div>

      <div class="box_g_b"></div>
        
      <div class="cafe-write-btn">
        <#if isCafeUser>
        <a href="/${cafe.domain}/articles/new"><img src="http://cafeimgs.naver.net/cafe4/hidden.gif" width="171" height="34" alt="카페 글쓰기" class="btn-write"></a>
        <#else>
        <a href="/${cafe.domain}/users/new"><img src="http://cafeimgs.naver.net/cafe4/hidden.gif" width="171" height="34" alt="카페 가입하기" class="btn-join"></a>
        </#if>
      </div>
    </div>

    <#-- my action -->
    <div id="member-action-data" style="display:none">
        <ul class="info-action-tab">
        <li class="tit-info" id="ia-info">
            <p><a href="#" onclick="showCafeInfo();clickcr(this, 'cia.cafe', '', '', event);return false;">카페정보</a></p>
        </li>
        <li class="tit-action-on" id="ia-action">
            <p class="gm-tcol-t">나의활동</p>
        </li>
        <li class="tit-bookmark">
            <a href="#" title="즐겨찾는 카페 등록" onClick="setupFavoriteCafe(true, true, 10000001);clickcr(this, 'cia.fav', '', '', event);return false;"><img src="http://cafeimgs.naver.net/cafe4/hidden.gif" width="27" height="28" alt="즐겨찾는 카페 등록" class="btn-bookmark-off" id="favoriteCafeInMemberInfo"></a>
        </li>
        </ul>
        <div class="box-g">
            <h4 class="d-none">나의활동</h4>
            <div id="ia-action-data"></div>
            <div class="ia-action-data ia-action-link" id="myActivityLink">
                <a href="/CafeMemberNetworkView.nhn?m=view&clubid=10000001&memberid=kielhong" class="gm-tcol-c" target="cafe_main" onclick="clickcr(this, 'cia*a.mypost', '', '', event); targetCleaner(this);">내가 쓴 글</a>
                <span class="bar gm-tcol-c filter-20">ㅣ</span>
                <a href="#" target="_blank" class="gm-tcol-c _open_app_player _param(http://apps.naver.com/myAppList|myAppList)"  onclick="clickcr(this, 'cia*a.app', '', '', event);">내 앱 목록</a>
            </div>
            <div id="myAppListDIV" class="layer_myjoinapp" style="display: none;"></div>
        </div>
        <div class="cafe-write-btn">
            <a href="/${cafe.domain}/articles/new><img src="http://cafeimgs.naver.net/cafe4/hidden.gif" width="171" height="34" alt="카페 글쓰기" class="btn-write"></a>
        </div>
    </div>
</div>