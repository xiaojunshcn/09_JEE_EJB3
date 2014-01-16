<!-- IMPORTANT: here the contextType is an xml, not html. -->
<%@ page language="java" contentType="text/xml; charset=UTF-8" %>

<%
	//key word from user input
	String word = (String) request.getAttribute("word");
%>
<words>
	<%if ("absolute".startsWith(word)) {%>
		<word>absolute</word>
	<%}%>
	<%if ("anyone".startsWith(word)) {%>
		<word>anyone</word>
	<%}%>
	<%if ("anything".startsWith(word)) {%>
		<word>anything</word>
	<%}%>
	<%if ("apple".startsWith(word)) {%>
		<word>apple</word>
	<%}%>
	<%if ("abandon".startsWith(word)) {%>
		<word>abandon</word>
	<%}%>
	<%if ("breach".startsWith(word)) {%>
		<word>breach</word>
	<%}%>
	<%if ("break".startsWith(word)) {%>
		<word>break</word>
	<%}%>
	<%if ("boolean".startsWith(word)) {%>
		<word>boolean</word>
	<%}%>
</words>