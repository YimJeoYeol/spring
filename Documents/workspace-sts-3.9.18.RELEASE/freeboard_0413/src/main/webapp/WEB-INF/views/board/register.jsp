<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- 23년 04월 19일 수업 -->    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ include file="..\includes\header.jsp" %>
            <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header">게시판 새글쓰기</h1>
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <!-- /.row -->
            <div class="row">
                <div class="col-lg-12">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                           Board Register
                        </div>
                        <!-- /.panel-heading -->
                        <div class="panel-body">
                            <form role="form" action="/board/register" method="post">
                            	<div class="form-group">
                            		<label>제 목 : </label><input class="form-control" type="text" name="title">
                            	</div>
                            	<div class="form-group">
                            		<label>내 용 : </label><textarea class="form-control" rows="3" name="content"></textarea>
                            	</div>
                            	<div class="form-group">
                            		<label>작성자 : </label><input class="form-control" type="text" name="writer">
                            	</div>
                            	<button type="submit" class="btn btn-info">신규등록</button>
                            	<button type="reset" class="btn btn-default">다시쓰기</button>
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

