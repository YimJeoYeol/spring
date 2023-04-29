<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- 23년 04월 17일(예시원본넣어서 확인),19일(본격적인 Board리스트 작업) 수업 -->    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ include file="..\includes\header.jsp" %>

<script type="text/javascript">
	$(document).ready(function(){
		var result = '<c:out value="${result}"/>';
		//alert(result);
		console.log(result);
		checkModal(result);
		
		function checkModal(result) {
			if(result === ''){
				return;
			}
			if(parseInt(result) >0){
				$(".modal-body").html("게시글 " + parseInt(result) + "번이 등록되었습니다.")
			}
			$("#myModal").modal("show");
		}
		
		$("#regBtn").on("click", function(){
			self.location="/board/register";
		})
		
		var actionForm = $("#actionForm");
		
		$(".pagination_button a").on("click",function(e){
			e.preventDefault();
			console.log("click");
			actionForm.find("input[name='pageNum']").val($(this).attr("href"));
			actionForm.submit();
		});
		
		$(".move").on("click", function(e) {
			e.preventDefault();
			actionForm.append("<input type='hidden' name='bno' value='" + $(this).attr("href")+ "''>");
			actionForm.attr("action", "/board/get");
			actionForm.submit();
		});
		
	});
	

</script>


            <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header">게시판 목록</h1>
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <!-- /.row -->
            <div class="row">
                <div class="col-lg-12">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                           Board List Page
                           <button id="regBtn" type="button" class="btn btn-success pull-right">신규등록</button>
                        </div>
                        <!-- /.panel-heading -->
                        <div class="panel-body">
                            <table width="100%" class="table table-striped table-bordered table-hover">
                                <thead>
                                    <tr>
                                        <th>#번호</th>
                                        <th>제목</th>
                                        <th>작성자</th>
                                        <th>작성일</th>
                                        <th>수정일</th>
                                    </tr>
                                </thead>
                               
                               <c:forEach items="${list}" var="board">
                               		<tr>
                               			<td>${board.bno}</td>
                               			<td><a class="move" href="${board.bno}">${board.title}</a></td>
                               			<td>${board.writer}</td>
                               			<td><fmt:formatDate pattern="yyyy-MM-dd" value="${board.regdate}"/></td>
                               			<td><fmt:formatDate pattern="yyyy-MM-dd" value="${board.updatedate}"/></td>
                               		</tr>
                               </c:forEach>
                               
                               
                               <%-- <div class="pull-rigth">
                               		<ul class="pageination">
                               			<c:if test="${pageMaker.prev }">
                               				<li class="paginate_button previous"><a href="">Previous</a></li>
                               			</c:if>
                               			
                               			<c:forEach var="num" begin="${pageMaker.startPage}" end="${pageMaker.endPage}">
                               				<li class="pageinate_button"><a href=""> ${num} </li>
                               			</c:forEach>
                               			
                               			<c:if test="${pageMaker.next }">
                               				<li class="paginate_button next"><a href="">Next</a></li>
                               			</c:if>
                               		</ul>
                               </div> --%>
                              
                               
                            </table>
                            <!-- /.table-responsive -->
                            <!-- 페이징 처리 -->
                            <div class="pull-right">
                               <ul class="pagination">
                                  <c:if test="${pageMaker.prev}">
                                     <li class="pagination_button previous"><a href="${pageMaker.startPage - 1 }">Previous</a></li>
                                  </c:if>
                                  <c:forEach var="num" begin="${pageMaker.startPage}" end="${pageMaker.endPage}">
                                     <li class="pagination_button ${pageMaker.cri.pageNum == num ? 'active' : '' }"><a href="${num}">${num}</a></li>
                                  </c:forEach>
                                  <c:if test="${pageMaker.next}">
                                     <li class="pagination_button next"><a href="${pageMaker.endPage + 1 }">Next</a></li>
                                  </c:if>
                               </ul>
                            </div>
                            
                            <form id="actionForm" action="/board/list" method="get">
                            	<input type="hidden" name="pageNum" value="${pageMaker.cri.pageNum }">
                            	<input type="hidden" name="amount" value="${pageMaker.cri.amount }">
                            </form>
                            
					      <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
					      	<div class="modal-dialog">
					      		<div class="modal-content">
					      			<div class="modal-header">
					      				<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
					      				<h4 class="modal-title" id="myModalLabel">Modal title</h4>
					      			</div>
					      			<div class="modal-body">처리가 완료되었습니다.</div>
					      			<div class="modal-footer">
					      				<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
					      				
					      			</div>	
					      		</div>
					      	</div>
					      </div>
                          
                        </div>
                        <!-- /.panel-body -->
                    </div>
                    <!-- /.panel -->
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <!-- /.row -->
           
<%@ include file="..\includes\footer.jsp" %>

