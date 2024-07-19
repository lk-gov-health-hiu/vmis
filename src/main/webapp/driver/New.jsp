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
                    <h:outputText value="Id:"/>
                    <h:inputText id="Id" value="#{driver.driver.id}" title="Nic" />
                    <h:outputText value="Nic:"/>
                    <h:inputText id="nic" value="#{driver.driver.nic}" title="Nic" />
                    <h:outputText value="Name:"/>
                    <h:inputText id="name" value="#{driver.driver.name}" title="Name" />
                    <h:outputText value="Address:"/>
                    <h:inputText id="address" value="#{driver.driver.address}" title="Address" />
                    <h:outputText value="Institution:"/>
                    <h:selectOneMenu id="institution" value="#{driver.driver.institution}" title="Institution" >
                        <f:selectItems value="#{institution.institutionItemsAvailableSelectOne}"/>
                    </h:selectOneMenu><!--

                </h:panelGrid>-->
<!--                <f:facet name="header" >
                   <h:outputLabel value="Add Doctor Details" style="font-size: 30px; font-family: sans-serif; margin-left: 6em"></h:outputLabel>
                  </f:facet>
                    
                    <h:panelGrid columns="1" style="margin-left: 12em">

                      <p:outputLabel for="txtname" value="name"> </p:outputLabel>
                      <p:inputText  id="txtname" required="true" value="" requiredMessage="Your must enter the name" style="color: gray"></p:inputText>
                      <p:outputLabel for="txtage" value="Address"> </p:outputLabel>
                      <p:inputText id ="txtage" required="true" value="" requiredMessage="Your must enter the age" style="color: blue"></p:inputText>
                    
                      <p:commandButton class="btn btn-success" value="Submit" action="" ajax="true" style="color: red; background-color:silver; font-size: 10px"></p:commandButton>

                    </h:panelGrid>
       
                    <f:facet name="footer">
                        <p:messages></p:messages>
                    </f:facet>-->
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
