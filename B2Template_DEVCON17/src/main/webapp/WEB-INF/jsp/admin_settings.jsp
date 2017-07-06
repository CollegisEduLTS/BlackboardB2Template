<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<%@ taglib uri="/bbNG" prefix="bbNG"%>
<bbNG:learningSystemPage>
	<bbNG:pageHeader>
		<bbNG:breadcrumbBar environment="SYS_ADMIN_PANEL"
			navItem="admin_plugin_manage">
			<bbNG:breadcrumb title="Global B2 Settings" />
		</bbNG:breadcrumbBar>
		<bbNG:pageTitleBar showTitleBar="true"
			title="Configure Global B2 Settings" />
	</bbNG:pageHeader>
	<bbNG:form action="" id="id_simpleForm" name="simpleForm" method="post"
		onsubmit="return validateForm();">
		<bbNG:dataCollection markUnsavedChanges="true"
			showSubmitButtons="true">
			<bbNG:step hideNumber="false" id="LogLevelSettings"
				title="Log Settings">
				<bbNG:dataElement isRequired="true" label="Log Level">
					<bbNG:selectElement name="logLevel">
						<bbNG:selectOptionElement value="TRACE" optionLabel="TRACE"
							isSelected="${settings['logLevel']=='TRACE' ? 'true' : 'false'}" />
						<bbNG:selectOptionElement value="DEBUG" optionLabel="DEBUG"
							isSelected="${settings['logLevel']=='DEBUG' ? 'true' : 'false'}" />
						<bbNG:selectOptionElement value="INFO" optionLabel="INFO"
							isSelected="${settings['logLevel']=='INFO' ? 'true' : 'false'}" />
						<bbNG:selectOptionElement value="WARN" optionLabel="WARN"
							isSelected="${settings['logLevel']=='WARN' ? 'true' : 'false'}" />
						<bbNG:selectOptionElement value="ERROR" optionLabel="ERROR"
							isSelected="${settings['logLevel']=='ERROR' ? 'true' : 'false'}" />
					</bbNG:selectElement>
				</bbNG:dataElement>
			</bbNG:step>
			<bbNG:stepSubmit hideNumber="false" showCancelButton="true" cancelUrl="${cancelUrl}"/>
		</bbNG:dataCollection>
	</bbNG:form>
</bbNG:learningSystemPage>
