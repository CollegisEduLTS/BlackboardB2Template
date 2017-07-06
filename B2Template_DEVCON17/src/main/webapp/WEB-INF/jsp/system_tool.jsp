<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<%@taglib uri="/bbNG" prefix="bbNG"   %>
<%@taglib uri="/bbUI" prefix="bbUI"   %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<spring:message code="systemtool.title" var="pageTitle" />
<spring:message code="systemtool.body" var="body" />

<bbNG:genericPage title="${pageTitle})">
<bbNG:pageHeader>
	<bbNG:pageTitleBar title="${pageTitle}"/>
</bbNG:pageHeader>

<h2>${body}.</h2>
</bbNG:genericPage>