<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- 23년 04월 19일 수업 -->    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ include file="..\includes\header.jsp" %>

<script type="text/javascript">
	$(document).ready(function(){
		var operForm = $("#operForm")
		
		$("button[data-oper='modify']").on("click", function(e){
			operForm.attr("action", "/board/modify").submit();
		});
		
		$("button[data-oper='List']").on("click", function(e){
			operForm.find("#bno").remove();
			operForm.attr("action", "/board/list").submit();
		});
	})	
</script>


            <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header">게시글 조회</h1>
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <!-- /.row -->
            <div class="row">
                <div class="col-lg-12">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            Board Read Page
                        </div>
                        <!-- /.panel-heading -->
                        <div class="panel-body">
								<div class="form-group">
								  <label>번 호</label>
								  <input class="form-control" type="text" name="bno" value="${dto.bno}" readonly>
								</div>
								<div class="form-group">
								  <label>제 목</label>
								  <input class="form-control" type="text" name="title" value="${dto.title}" readonly>
								</div>
								<div class="form-group">
								  <label>내 용</label>
								  <textarea class="form-control" rows="3" name="content" readonly>${dto.content}</textarea>
								</div>
								<div class="form-group">
								  <label>작성자</label>
								  <input class="form-control" type="text" name="writer" value="${dto.writer}" readonly>
								</div>
								<button data-oper="modify" class="btn btn-info" >수정하기</button> <!-- onclick="location.href='/board/modify?bno=' + ${dto.bno}" -->
								<button data-oper="List"   class="btn btn-info" >목록</button> <!--onclick="location.href='/board/list?pageNum=${cri.pageNum}&amount=${cri.amount}'"  -->
                        </div>
              					<form id="operForm" action="/board/modify" method="get">
                            		<input type="hidden" name="pageNum" value="${cri.pageNum}">
                            		<input type="hidden" name="amount"  value="${cri.amount}">
                            		<input type="hidden" id="bno" name="bno"  value="${dto.bno}">
                            	</form>
                        <!-- /.panel-body -->
                    </div>
                    <!-- /.panel -->
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <!-- /.row -->
            <%@ include file="../includes/footer.jsp" %>