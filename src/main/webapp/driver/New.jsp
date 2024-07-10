<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<f:view>
    <html>
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
            <title>New Driver</title>
            <link rel="stylesheet" type="text/css" href="/vmis/faces/jsfcrud.css" />
        </head>
        <body>
            <h:panelGroup id="messagePanel" layout="block">
                <h:messages errorStyle="color: red" infoStyle="color: green" layout="table"/>
            </h:panelGroup>
            <h1>New Driver</h1>
            <h:form>
                <h:inputHidden id="validateCreateField" validator="#{driver.validateCreate}" value="value"/>
                <h:panelGrid columns="2">
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
                <h:commandLink action="#{driver.create}" value="Create"/>
                <br />
                <br />
                <h:commandLink action="#{driver.listSetup}" value="Show All Driver Items" immediate="true"/>
                <br />
                <br />
                <h:commandLink value="Index" action="welcome" immediate="true" />

            </h:form>
        </body>
    </html>
</f:view>
