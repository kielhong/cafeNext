<#import "layout/cafe_layout.ftl" as layout>
<@layout.cafeLayout "${cafe.name}">
<link rel="stylesheet" href="/css/mycafe-write.css" type="text/css">
<link rel="stylesheet" href="/css/common-editor.css" type="text/css">

<form id="postArticle" name="postArticle" method="post" action="/${cafe.domain}/articles/${article.id}">
	<input type="hidden" name="_method" value="put" />
	<input type="hidden" name="id" value="${article.id}"/>
    <div id="nboard" style="width: 773px; text-align: left;">
		<div id="editer_border">
	    	<div id="naver_common_editor">
		    	<ul class="subject">
					<li>
					    <label class="item" for="board">카테고리</label>
						<div>
			                <select id="board" name="board.id" class="step01" style="width: 156px;" >
			                    <#list boards as board>
			                    <option value="${board.id}" <#if board.id == article.board.id>selected</#if>>${board.title}</option>
			                    </#list>
							</select>
						</div>
					</li>
					<li>
					    <label class="item" for="title">제목</label>
						<div>
                            <input type="text" name="title" placeholder="게시물 제목을 입력하세요" id="title" class="box_input" value="${article.title}">
					    </div>
					</li>
				</ul>

				<table width="740" cellspacing="0" cellpadding="0" class="wrap" id="toolbox">
            		<tr>
						<td colspan="2" class="b_tool_bg"></td>
					</tr>
					<tr valign="top">
						<td class="read">
						    <textarea id="textbox" name="content" cols="93" rows="28">${article.content}</textarea>
						</td>
					</tr>
				</table>
			</div>

			<div class="btn_post">
				<input type="submit"/>
			</div>
		</div>
	</form>

</@layout.cafeLayout>