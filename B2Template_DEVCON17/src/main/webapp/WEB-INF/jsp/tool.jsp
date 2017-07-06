<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<%@taglib uri="/bbNG" prefix="bbNG"   %>
<%@taglib uri="/bbUI" prefix="bbUI"   %>

<bbNG:learningSystemPage title="Student Tool">
<bbNG:pageHeader>
	<bbNG:pageTitleBar title="Template Student Tool"/>
</bbNG:pageHeader>

<%-- Use requirejs to manage all javascript for this page 
<script data-main="../js/config" src="../js/require.js"></script>
--%>
<h2>This is a student tool.</h2>
First Name (from settings): ${firstName }
</bbNG:learningSystemPage>