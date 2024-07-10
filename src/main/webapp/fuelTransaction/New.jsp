<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<f:view>
    <html>
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
            <title>New FuelTransaction</title>
            <link rel="stylesheet" type="text/css" href="/vmis/faces/jsfcrud.css" />
        </head>
        <body>
            <h:panelGroup id="messagePanel" layout="block">
                <h:messages errorStyle="color: red" infoStyle="color: green" layout="table"/>
            </h:panelGroup>
            <h1>New FuelTransaction</h1>
            <h:form>
                <h:inputHidden id="validateCreateField" validator="#{fuelTransaction.validateCreate}" value="value"/>
                <h:panelGrid columns="2">
                    <h:outputText value="Intitite:"/>
                    <h:selectOneMenu id="intitite" value="#{fuelTransaction.fuelTransaction.intitite}" title="Intitite" >
                        <f:selectItems value="#{institution.institutionItemsAvailableSelectOne}"/>
                    </h:selectOneMenu>
                    <h:outputText value="Vehicle:"/>
                    <h:selectOneMenu id="vehicle" value="#{fuelTransaction.fuelTransaction.vehicle}" title="Vehicle" >
                        <f:selectItems value="#{vehicle.vehicleItemsAvailableSelectOne}"/>
                    </h:selectOneMenu>
                    <h:outputText value="FromInstitution:"/>
                    <h:selectOneMenu id="fromInstitution" value="#{fuelTransaction.fuelTransaction.fromInstitution}" title="FromInstitution" >
                        <f:selectItems value="#{institution.institutionItemsAvailableSelectOne}"/>
                    </h:selectOneMenu>
                    <h:outputText value="Driver:"/>
                    <h:selectOneMenu id="driver" value="#{fuelTransaction.fuelTransaction.driver}" title="Driver" >
                        <f:selectItems value="#{driver.driverItemsAvailableSelectOne}"/>
                    </h:selectOneMenu>
                    <h:outputText value="Comments:"/>
                    <h:inputTextarea rows="4" cols="30" id="comments" value="#{fuelTransaction.fuelTransaction.comments}" title="Comments" />
                    <h:outputText value="RequestQuantity:"/>
                    <h:inputText id="requestQuantity" value="#{fuelTransaction.fuelTransaction.requestQuantity}" title="RequestQuantity" />
                    <h:outputText value="IssuedQuantity:"/>
                    <h:inputText id="issuedQuantity" value="#{fuelTransaction.fuelTransaction.issuedQuantity}" title="IssuedQuantity" />
                    <h:outputText value="OdoMeterReading:"/>
                    <h:inputText id="odoMeterReading" value="#{fuelTransaction.fuelTransaction.odoMeterReading}" title="OdoMeterReading" />
                    <h:outputText value="RequestAt (MM/dd/yyyy HH:mm:ss):"/>
                    <h:inputText id="requestAt" value="#{fuelTransaction.fuelTransaction.requestAt}" title="RequestAt" >
                        <f:convertDateTime pattern="MM/dd/yyyy HH:mm:ss" />
                    </h:inputText>
                    <h:outputText value="RequestedDate (MM/dd/yyyy):"/>
                    <h:inputText id="requestedDate" value="#{fuelTransaction.fuelTransaction.requestedDate}" title="RequestedDate" >
                        <f:convertDateTime pattern="MM/dd/yyyy" />
                    </h:inputText>
                    <h:outputText value="RequestReferenceNumber:"/>
                    <h:inputText id="requestReferenceNumber" value="#{fuelTransaction.fuelTransaction.requestReferenceNumber}" title="RequestReferenceNumber" />
                    <h:outputText value="IssueReferenceNumber:"/>
                    <h:inputText id="issueReferenceNumber" value="#{fuelTransaction.fuelTransaction.issueReferenceNumber}" title="IssueReferenceNumber" />

                </h:panelGrid>
                <br />
                <h:commandLink action="#{fuelTransaction.create}" value="Create"/>
                <br />
                <br />
                <h:commandLink action="#{fuelTransaction.listSetup}" value="Show All FuelTransaction Items" immediate="true"/>
                <br />
                <br />
                <h:commandLink value="Index" action="welcome" immediate="true" />

            </h:form>
        </body>
    </html>
</f:view>
