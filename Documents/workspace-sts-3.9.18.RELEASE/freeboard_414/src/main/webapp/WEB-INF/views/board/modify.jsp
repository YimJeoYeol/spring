<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- 23년 04월 19일 수업 -->    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ include file="..\includes\header.jsp" %>
<script>
	$(document).ready(function () {
		var formObj = $("form");
		
		$("button").on("click", function (e) {
			e.preventDefault();
			
			var operation = $(this).data("oper");
			console.log(operation);
			
			if(operation === "remove"){
				formObj.attr("action", "/board/remove");
				formObj.attr("method", "get")
			}else if(operation === "list"){
				//self.location = "/board/list";
				var pageNumTag = $("input[name='pageNum']").clone();
				var amountTam  = $("input[name='amount']").clone();
				
				formObj.attr("action", "/board/list").attr("method","get");
				formObj.empty();
				formObj.append(pageNumTag);
				formObj.append(amountTag);
				//return;
			}
			formObj.submit();
		})
	})
</script>
            <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header">게시판 조회</h1>
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
                        
                            <form role="form" action="/board/modify" method="post"> 
                            
                            	<input type="hidden" name="pageNum" value="${cri.pageNum }">
                            	<input type="hidden" name="amount" value="${cri.amount }">
                            	
                            	<div class="form-group">
                            		<label>번 호 : </label><input class="form-control" type="text" name="bno" value="${dto.bno }" readonly>
                            	</div>
                            	<div class="form-group">
                            		<label>제 목 : </label><input class="form-control" type="text" name="title" value="${dto.title }">
                            	</div>
                            	<div class="form-group">
                            		<label>내 용 : </label><textarea class="form-control" rows="5" name="content">${dto.content }</textarea>
                            	</div>
                            	<div class="form-group">
                            		<label>작성자 : </label><input class="form-control" type="text" name="writer" value="${dto.writer }">
                            	</div>
                            	<div class="form-group">
                            		<label>등록일 : </label><input class="form-control" type="text" name="regdate" value="<fmt:formatDate pattern="yyyy/MM/dd" value="${dto.updatedate}"/>" readonly>
                            	</div>
                            	<div class="form-group">
                            		<label>수정일 : </label><input class="form-control" type="text" name="updatedate" value="<fmt:formatDate pattern="yyyy/MM/dd" value="${dto.updatedate}"/>" readonly>
                            	</div>
                            	<button type="submit" data-oper="modify" class="btn btn-default"> 수 정 </button>
                            	<button type="submit" data-oper="remove" class="btn btn-danger" > 삭 제 </button>
                            	<button type="submit" data-oper="list"   class="btn btn-info"   > 목 록 </button>
                            </form> 
                        </div>
                        <!-- /.panel-body -->
                    </div>
                    <!-- /.panel -->
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <!-- /.row -->
           
<%@ include file="..\includes\footer.jsp" %>