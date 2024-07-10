<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<f:view>
    <html>
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
            <title>Editing Driver</title>
            <link rel="stylesheet" type="text/css" href="/vmis/faces/jsfcrud.css" />
        </head>
        <body>
            <h:panelGroup id="messagePanel" layout="block">
                <h:messages errorStyle="color: red" infoStyle="color: green" layout="table"/>
            </h:panelGroup>
            <h1>Editing Driver</h1>
            <h:form>
                <h:panelGrid columns="2">
                    <h:outputText value="Id:"/>
                    <h:outputText value="#{driver.driver.id}" title="Id" />
                    <h:outputText value="Nic:"/>
                    <h:inputText id="nic" value="#{driver.driver.nic}" title="Nic" />
                    <h:outputText value="Name:"/>
                    <h:inputText id="name" value="#{driver.driver.name}" title="Name" />
                    <h:outputText value="Address:"/>
                    <h:inputText id="address" value="#{driver.driver.address}" title="Address" />
                    <h:outputText value="Institution:"/>
                    <h:selectOneMenu id="institution" value="#{driver.driver.institution}" title="Institution" >
                        <f:selectItems value="#{institution.institutionItemsAvailableSelectOne}"/>
                    </h:selectOneMenu>

                </h:panelGrid>
                <br />
                <h:commandLink action="#{driver.edit}" value="Save">
                    <f:param name="jsfcrud.currentDriver" value="#{jsfcrud_class['lk.gov.health.vmis.jsf.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][driver.driver][driver.converter].jsfcrud_invoke}"/>
                </h:commandLink>
                <br />
                <br />
                <h:commandLink action="#{driver.detailSetup}" value="Show" immediate="true">
                    <f:param name="jsfcrud.currentDriver" value="#{jsfcrud_class['lk.gov.health.vmis.jsf.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][driver.driver][driver.converter].jsfcrud_invoke}"/>
                </h:commandLink>
                <br />
                <h:commandLink action="#{driver.listSetup}" value="Show All Driver Items" immediate="true"/>
                <br />
                <br />
                <h:commandLink value="Index" action="welcome" immediate="true" />

            </h:form>
        </body>
    </html>
</f:view>
