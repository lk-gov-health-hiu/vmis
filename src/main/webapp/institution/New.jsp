<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<f:view>
    <html>
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
            <title>New Institution</title>
            <link rel="stylesheet" type="text/css" href="/vmis/faces/jsfcrud.css" />
        </head>
        <body>
            <h:panelGroup id="messagePanel" layout="block">
                <h:messages errorStyle="color: red" infoStyle="color: green" layout="table"/>
            </h:panelGroup>
            <h1>New Institution</h1>
            <h:form class="">
                <h:inputHidden id="validateCreateField" validator="#{institution.validateCreate}" value="value"/>
                <h:panelGrid columns="2">
                    <h:outputText value="Name:"/>
                    <h:inputText id="name" value="#{institution.institution.name}" title="Name" />
                    <h:outputText value="Address:"/>
                    <h:inputTextarea rows="4" cols="30" id="address" value="#{institution.institution.address}" title="Address" />
                    <h:outputText value="Type:"/>
                    <h:inputText id="type" value="#{institution.institution.type}" title="Type" />
                    <h:outputText value="Parent:"/>
                    <h:selectOneMenu id="parent" value="#{institution.institution.parent}" title="Parent" >
                        <f:selectItems value="#{institution.institutionItemsAvailableSelectOne}"/>
                    </h:selectOneMenu>

                </h:panelGrid>
                <br />
                <h:commandLink action="#{institution.create}" value="Create"/>
                <br />
                <br />
                <h:commandLink action="#{institution.listSetup}" value="Show All Institution Items" immediate="true"/>
                <br />
                <br />
                <h:commandLink value="Index" action="welcome" immediate="true" />

            </h:form>
        </body>
    </html>
</f:view>
