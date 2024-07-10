<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<f:view>
    <html>
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
            <title>Driver Detail</title>
            <link rel="stylesheet" type="text/css" href="/vmis/faces/jsfcrud.css" />
        </head>
        <body>
            <h:panelGroup id="messagePanel" layout="block">
                <h:messages errorStyle="color: red" infoStyle="color: green" layout="table"/>
            </h:panelGroup>
            <h1>Driver Detail</h1>
            <h:form>
                <h:panelGrid columns="2">
                    <h:outputText value="Id:"/>
                    <h:outputText value="#{driver.driver.id}" title="Id" />
                    <h:outputText value="Nic:"/>
                    <h:outputText value="#{driver.driver.nic}" title="Nic" />
                    <h:outputText value="Name:"/>
                    <h:outputText value="#{driver.driver.name}" title="Name" />
                    <h:outputText value="Address:"/>
                    <h:outputText value="#{driver.driver.address}" title="Address" />
                    <h:outputText value="Institution:"/>
                    <h:panelGroup>
                        <h:outputText value="#{driver.driver.institution}"/>
                        <h:panelGroup rendered="#{driver.driver.institution != null}">
                            <h:outputText value=" ("/>
                            <h:commandLink value="Show" action="#{institution.detailSetup}">
                                <f:param name="jsfcrud.currentDriver" value="#{jsfcrud_class['lk.gov.health.vmis.jsf.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][driver.driver][driver.converter].jsfcrud_invoke}"/>
                                <f:param name="jsfcrud.currentInstitution" value="#{jsfcrud_class['lk.gov.health.vmis.jsf.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][driver.driver.institution][institution.converter].jsfcrud_invoke}"/>
                                <f:param name="jsfcrud.relatedController" value="driver"/>
                                <f:param name="jsfcrud.relatedControllerType" value="lk.gov.health.vmis.jsf.DriverController"/>
                            </h:commandLink>
                            <h:outputText value=" "/>
                            <h:commandLink value="Edit" action="#{institution.editSetup}">
                                <f:param name="jsfcrud.currentDriver" value="#{jsfcrud_class['lk.gov.health.vmis.jsf.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][driver.driver][driver.converter].jsfcrud_invoke}"/>
                                <f:param name="jsfcrud.currentInstitution" value="#{jsfcrud_class['lk.gov.health.vmis.jsf.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][driver.driver.institution][institution.converter].jsfcrud_invoke}"/>
                                <f:param name="jsfcrud.relatedController" value="driver"/>
                                <f:param name="jsfcrud.relatedControllerType" value="lk.gov.health.vmis.jsf.DriverController"/>
                            </h:commandLink>
                            <h:outputText value=" "/>
                            <h:commandLink value="Destroy" action="#{institution.destroy}">
                                <f:param name="jsfcrud.currentDriver" value="#{jsfcrud_class['lk.gov.health.vmis.jsf.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][driver.driver][driver.converter].jsfcrud_invoke}"/>
                                <f:param name="jsfcrud.currentInstitution" value="#{jsfcrud_class['lk.gov.health.vmis.jsf.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][driver.driver.institution][institution.converter].jsfcrud_invoke}"/>
                                <f:param name="jsfcrud.relatedController" value="driver"/>
                                <f:param name="jsfcrud.relatedControllerType" value="lk.gov.health.vmis.jsf.DriverController"/>
                            </h:commandLink>
                            <h:outputText value=" )"/>
                        </h:panelGroup>
                    </h:panelGroup>


                </h:panelGrid>
                <br />
                <h:commandLink action="#{driver.remove}" value="Destroy">
                    <f:param name="jsfcrud.currentDriver" value="#{jsfcrud_class['lk.gov.health.vmis.jsf.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][driver.driver][driver.converter].jsfcrud_invoke}" />
                </h:commandLink>
                <br />
                <br />
                <h:commandLink action="#{driver.editSetup}" value="Edit">
                    <f:param name="jsfcrud.currentDriver" value="#{jsfcrud_class['lk.gov.health.vmis.jsf.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][driver.driver][driver.converter].jsfcrud_invoke}" />
                </h:commandLink>
                <br />
                <h:commandLink action="#{driver.createSetup}" value="New Driver" />
                <br />
                <h:commandLink action="#{driver.listSetup}" value="Show All Driver Items"/>
                <br />
                <br />
                <h:commandLink value="Index" action="welcome" immediate="true" />

            </h:form>
        </body>
    </html>
</f:view>
