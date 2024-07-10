<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<f:view>
    <html>
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
            <title>Listing Vehicle Items</title>
            <link rel="stylesheet" type="text/css" href="/vmis/faces/jsfcrud.css" />
        </head>
        <body>
            <h:panelGroup id="messagePanel" layout="block">
                <h:messages errorStyle="color: red" infoStyle="color: green" layout="table"/>
            </h:panelGroup>
            <h1>Listing Vehicle Items</h1>
            <h:form styleClass="jsfcrud_list_form">
                <h:outputText escape="false" value="(No Vehicle Items Found)<br />" rendered="#{vehicle.pagingInfo.itemCount == 0}" />
                <h:panelGroup rendered="#{vehicle.pagingInfo.itemCount > 0}">
                    <h:outputText value="Item #{vehicle.pagingInfo.firstItem + 1}..#{vehicle.pagingInfo.lastItem} of #{vehicle.pagingInfo.itemCount}"/>&nbsp;
                    <h:commandLink action="#{vehicle.prev}" value="Previous #{vehicle.pagingInfo.batchSize}" rendered="#{vehicle.pagingInfo.firstItem >= vehicle.pagingInfo.batchSize}"/>&nbsp;
                    <h:commandLink action="#{vehicle.next}" value="Next #{vehicle.pagingInfo.batchSize}" rendered="#{vehicle.pagingInfo.lastItem + vehicle.pagingInfo.batchSize <= vehicle.pagingInfo.itemCount}"/>&nbsp;
                    <h:commandLink action="#{vehicle.next}" value="Remaining #{vehicle.pagingInfo.itemCount - vehicle.pagingInfo.lastItem}"
                                   rendered="#{vehicle.pagingInfo.lastItem < vehicle.pagingInfo.itemCount && vehicle.pagingInfo.lastItem + vehicle.pagingInfo.batchSize > vehicle.pagingInfo.itemCount}"/>
                    <h:dataTable value="#{vehicle.vehicleItems}" var="item" border="0" cellpadding="2" cellspacing="0" rowClasses="jsfcrud_odd_row,jsfcrud_even_row" rules="all" style="border:solid 1px">
                        <h:column>
                            <f:facet name="header">
                                <h:outputText value="Id"/>
                            </f:facet>
                            <h:outputText value="#{item.id}"/>
                        </h:column>
                        <h:column>
                            <f:facet name="header">
                                <h:outputText value="Make"/>
                            </f:facet>
                            <h:outputText value="#{item.make}"/>
                        </h:column>
                        <h:column>
                            <f:facet name="header">
                                <h:outputText value="Model"/>
                            </f:facet>
                            <h:outputText value="#{item.model}"/>
                        </h:column>
                        <h:column>
                            <f:facet name="header">
                                <h:outputText value="NumberPlateNum"/>
                            </f:facet>
                            <h:outputText value="#{item.numberPlateNum}"/>
                        </h:column>
                        <h:column>
                            <f:facet name="header">
                                <h:outputText value="ChassyNum"/>
                            </f:facet>
                            <h:outputText value="#{item.chassyNum}"/>
                        </h:column>
                        <h:column>
                            <f:facet name="header">
                                <h:outputText value="EngineNum"/>
                            </f:facet>
                            <h:outputText value="#{item.engineNum}"/>
                        </h:column>
                        <h:column>
                            <f:facet name="header">
                                <h:outputText value="EstimateFuelConsumtion"/>
                            </f:facet>
                            <h:outputText value="#{item.estimateFuelConsumtion}"/>
                        </h:column>
                        <h:column>
                            <f:facet name="header">
                                <h:outputText value="Mainpurpose"/>
                            </f:facet>
                            <h:outputText value="#{item.mainpurpose}"/>
                        </h:column>
                        <h:column>
                            <f:facet name="header">
                                <h:outputText value="Driver"/>
                            </f:facet>
                            <h:outputText value="#{item.driver}"/>
                        </h:column>
                        <h:column>
                            <f:facet name="header">
                                <h:outputText value="AverageFuelPerL"/>
                            </f:facet>
                            <h:outputText value="#{item.averageFuelPerL}"/>
                        </h:column>
                        <h:column>
                            <f:facet name="header">
                                <h:outputText value="Ownerinstitution"/>
                            </f:facet>
                            <h:outputText value="#{item.ownerinstitution}"/>
                        </h:column>
                        <h:column>
                            <f:facet name="header">
                                <h:outputText value="RegisteredDate"/>
                            </f:facet>
                            <h:outputText value="#{item.registeredDate}">
                                <f:convertDateTime pattern="MM/dd/yyyy" />
                            </h:outputText>
                        </h:column>
                        <h:column>
                            <f:facet name="header">
                                <h:outputText value="RegisteredAt"/>
                            </f:facet>
                            <h:outputText value="#{item.registeredAt}"/>
                        </h:column>
                        <h:column>
                            <f:facet name="header">
                                <h:outputText escape="false" value="&nbsp;"/>
                            </f:facet>
                            <h:commandLink value="Show" action="#{vehicle.detailSetup}">
                                <f:param name="jsfcrud.currentVehicle" value="#{jsfcrud_class['lk.gov.health.vmis.jsf.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][item][vehicle.converter].jsfcrud_invoke}"/>
                            </h:commandLink>
                            <h:outputText value=" "/>
                            <h:commandLink value="Edit" action="#{vehicle.editSetup}">
                                <f:param name="jsfcrud.currentVehicle" value="#{jsfcrud_class['lk.gov.health.vmis.jsf.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][item][vehicle.converter].jsfcrud_invoke}"/>
                            </h:commandLink>
                            <h:outputText value=" "/>
                            <h:commandLink value="Destroy" action="#{vehicle.remove}">
                                <f:param name="jsfcrud.currentVehicle" value="#{jsfcrud_class['lk.gov.health.vmis.jsf.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][item][vehicle.converter].jsfcrud_invoke}"/>
                            </h:commandLink>
                        </h:column>

                    </h:dataTable>
                </h:panelGroup>
                <br />
                <h:commandLink action="#{vehicle.createSetup}" value="New Vehicle"/>
                <br />
                <br />
                <h:commandLink value="Index" action="welcome" immediate="true" />


            </h:form>
        </body>
    </html>
</f:view>
