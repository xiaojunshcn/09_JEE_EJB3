<!-- IMPORTANT: here the contextType is an xml, not html. -->
<%@ page language="java" contentType="text/xml; charset=UTF-8" %>
.<%@ page import="java.util.List"%>
<%@ taglib uri="/WEB-INF/c.tld" prefix="c" %>

<%
	//key word from user input
	String word = (String) request.getAttribute("word");
	//System.out.println("word:" + word);
	List<String> words = (List<String>) request.getAttribute("words");
	
	//System.out.println("words:" + words.size());
%>
<words>
	<c:forEach var="obj" items="words" >
		<word>${obj}</word>
	</c:forEach>
</words>