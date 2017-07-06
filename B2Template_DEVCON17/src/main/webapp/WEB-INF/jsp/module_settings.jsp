<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<%@ taglib uri="/bbNG" prefix="bbNG"%>
<bbNG:learningSystemPage>
	<bbNG:pageHeader>
		<bbNG:pageTitleBar showTitleBar="true"
			title="Configure Module" />
	</bbNG:pageHeader>
	<bbNG:form action="" id="id_simpleForm" name="simpleForm" method="post"
		onsubmit="return validateForm();">
		<bbNG:dataCollection markUnsavedChanges="true"
			showSubmitButtons="true">
			<bbNG:step hideNumber="false" id="stepOne"
				title="Instructor Information"
				instructions="Complete all of the fields below.">
				<bbNG:dataElement isRequired="true" label="First Name">
					<bbNG:textElement name="firstName" value="${firstName }" size="50"
						minLength="1" />
				</bbNG:dataElement>
			</bbNG:step>
			<bbNG:stepSubmit hideNumber="false" showCancelButton="true" />
		</bbNG:dataCollection>
	</bbNG:form>
</bbNG:learningSystemPage>