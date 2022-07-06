<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

		<div id="header" class="clearfix">
			<h1><a href="">정우성의 블로그입니다.</a></h1>
			<ul class="clearfix">
			<c:choose>
				<c:when test="${authUser == null }">
				<li><a class="btn_s" href="">로그인</a></li>
				</c:when>
				<c:when test="${authUser.id == requestScope.userVo.id }">
				<li><a class="btn_s" href="">내블로그 관리</a></li>
				<li><a class="btn_s" href="">로그아웃</a></li>
		 		</c:when>
		 	</c:choose>
			</ul>
		</div>
		<!-- //header -->
		