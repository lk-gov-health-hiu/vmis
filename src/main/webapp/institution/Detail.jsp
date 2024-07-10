<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<f:view>
    <html>
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
            <title>Institution Detail</title>
            <link rel="stylesheet" type="text/css" href="/vmis/faces/jsfcrud.css" />
        </head>
        <body>
            <h:panelGroup id="messagePanel" layout="block">
                <h:messages errorStyle="color: red" infoStyle="color: green" layout="table"/>
            </h:panelGroup>
            <h1>Institution Detail</h1>
            <h:form>
                <h:panelGrid columns="2">
                    <h:outputText value="Id:"/>
                    <h:outputText value="#{institution.institution.id}" title="Id" />
                    <h:outputText value="Name:"/>
                    <h:outputText value="#{institution.institution.name}" title="Name" />
                    <h:outputText value="Address:"/>
                    <h:outputText value="#{institution.institution.address}" title="Address" />
                    <h:outputText value="Type:"/>
                    <h:outputText value="#{institution.institution.type}" title="Type" />
                    <h:outputText value="Parent:"/>
                    <h:panelGroup>
                        <h:outputText value="#{institution.institution.parent}"/>
                        <h:panelGroup rendered="#{institution.institution.parent != null}">
                            <h:outputText value=" ("/>
                            <h:commandLink value="Show" action="#{institution.detailSetup}">
                                <f:param name="jsfcrud.currentInstitution" value="#{jsfcrud_class['lk.gov.health.vmis.jsf.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][institution.institution][institution.converter].jsfcrud_invoke}"/>
                                <f:param name="jsfcrud.currentInstitution" value="#{jsfcrud_class['lk.gov.health.vmis.jsf.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][institution.institution.parent][institution.converter].jsfcrud_invoke}"/>
                                <f:param name="jsfcrud.relatedController" value="institution"/>
                                <f:param name="jsfcrud.relatedControllerType" value="lk.gov.health.vmis.jsf.InstitutionController"/>
                            </h:commandLink>
                            <h:outputText value=" "/>
                            <h:commandLink value="Edit" action="#{institution.editSetup}">
                                <f:param name="jsfcrud.currentInstitution" value="#{jsfcrud_class['lk.gov.health.vmis.jsf.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][institution.institution][institution.converter].jsfcrud_invoke}"/>
                                <f:param name="jsfcrud.currentInstitution" value="#{jsfcrud_class['lk.gov.health.vmis.jsf.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][institution.institution.parent][institution.converter].jsfcrud_invoke}"/>
                                <f:param name="jsfcrud.relatedController" value="institution"/>
                                <f:param name="jsfcrud.relatedControllerType" value="lk.gov.health.vmis.jsf.InstitutionController"/>
                            </h:commandLink>
                            <h:outputText value=" "/>
                            <h:commandLink value="Destroy" action="#{institution.destroy}">
                                <f:param name="jsfcrud.currentInstitution" value="#{jsfcrud_class['lk.gov.health.vmis.jsf.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][institution.institution][institution.converter].jsfcrud_invoke}"/>
                                <f:param name="jsfcrud.currentInstitution" value="#{jsfcrud_class['lk.gov.health.vmis.jsf.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][institution.institution.parent][institution.converter].jsfcrud_invoke}"/>
                                <f:param name="jsfcrud.relatedController" value="institution"/>
                                <f:param name="jsfcrud.relatedControllerType" value="lk.gov.health.vmis.jsf.InstitutionController"/>
                            </h:commandLink>
                            <h:outputText value=" )"/>
                        </h:panelGroup>
                    </h:panelGroup>


                </h:panelGrid>
                <br />
                <h:commandLink action="#{institution.remove}" value="Destroy">
                    <f:param name="jsfcrud.currentInstitution" value="#{jsfcrud_class['lk.gov.health.vmis.jsf.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][institution.institution][institution.converter].jsfcrud_invoke}" />
                </h:commandLink>
                <br />
                <br />
                <h:commandLink action="#{institution.editSetup}" value="Edit">
                    <f:param name="jsfcrud.currentInstitution" value="#{jsfcrud_class['lk.gov.health.vmis.jsf.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][institution.institution][institution.converter].jsfcrud_invoke}" />
                </h:commandLink>
                <br />
                <h:commandLink action="#{institution.createSetup}" value="New Institution" />
                <br />
                <h:commandLink action="#{institution.listSetup}" value="Show All Institution Items"/>
                <br />
                <br />
                <h:commandLink value="Index" action="welcome" immediate="true" />

            </h:form>
        </body>
    </html>
</f:view>
