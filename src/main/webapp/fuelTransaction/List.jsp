<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<f:view>
    <html>
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
            <title>Listing FuelTransaction Items</title>
            <link rel="stylesheet" type="text/css" href="/vmis/faces/jsfcrud.css" />
        </head>
        <body>
            <h:panelGroup id="messagePanel" layout="block">
                <h:messages errorStyle="color: red" infoStyle="color: green" layout="table"/>
            </h:panelGroup>
            <h1>Listing FuelTransaction Items</h1>
            <h:form styleClass="jsfcrud_list_form">
                <h:outputText escape="false" value="(No FuelTransaction Items Found)<br />" rendered="#{fuelTransaction.pagingInfo.itemCount == 0}" />
                <h:panelGroup rendered="#{fuelTransaction.pagingInfo.itemCount > 0}">
                    <h:outputText value="Item #{fuelTransaction.pagingInfo.firstItem + 1}..#{fuelTransaction.pagingInfo.lastItem} of #{fuelTransaction.pagingInfo.itemCount}"/>&nbsp;
                    <h:commandLink action="#{fuelTransaction.prev}" value="Previous #{fuelTransaction.pagingInfo.batchSize}" rendered="#{fuelTransaction.pagingInfo.firstItem >= fuelTransaction.pagingInfo.batchSize}"/>&nbsp;
                    <h:commandLink action="#{fuelTransaction.next}" value="Next #{fuelTransaction.pagingInfo.batchSize}" rendered="#{fuelTransaction.pagingInfo.lastItem + fuelTransaction.pagingInfo.batchSize <= fuelTransaction.pagingInfo.itemCount}"/>&nbsp;
                    <h:commandLink action="#{fuelTransaction.next}" value="Remaining #{fuelTransaction.pagingInfo.itemCount - fuelTransaction.pagingInfo.lastItem}"
                                   rendered="#{fuelTransaction.pagingInfo.lastItem < fuelTransaction.pagingInfo.itemCount && fuelTransaction.pagingInfo.lastItem + fuelTransaction.pagingInfo.batchSize > fuelTransaction.pagingInfo.itemCount}"/>
                    <h:dataTable value="#{fuelTransaction.fuelTransactionItems}" var="item" border="0" cellpadding="2" cellspacing="0" rowClasses="jsfcrud_odd_row,jsfcrud_even_row" rules="all" style="border:solid 1px">
                        <h:column>
                            <f:facet name="header">
                                <h:outputText value="Id"/>
                            </f:facet>
                            <h:outputText value="#{item.id}"/>
                        </h:column>
                        <h:column>
                            <f:facet name="header">
                                <h:outputText value="Intitite"/>
                            </f:facet>
                            <h:outputText value="#{item.intitite}"/>
                        </h:column>
                        <h:column>
                            <f:facet name="header">
                                <h:outputText value="Vehicle"/>
                            </f:facet>
                            <h:outputText value="#{item.vehicle}"/>
                        </h:column>
                        <h:column>
                            <f:facet name="header">
                                <h:outputText value="FromInstitution"/>
                            </f:facet>
                            <h:outputText value="#{item.fromInstitution}"/>
                        </h:column>
                        <h:column>
                            <f:facet name="header">
                                <h:outputText value="Driver"/>
                            </f:facet>
                            <h:outputText value="#{item.driver}"/>
                        </h:column>
                        <h:column>
                            <f:facet name="header">
                                <h:outputText value="Comments"/>
                            </f:facet>
                            <h:outputText value="#{item.comments}"/>
                        </h:column>
                        <h:column>
                            <f:facet name="header">
                                <h:outputText value="RequestQuantity"/>
                            </f:facet>
                            <h:outputText value="#{item.requestQuantity}"/>
                        </h:column>
                        <h:column>
                            <f:facet name="header">
                                <h:outputText value="IssuedQuantity"/>
                            </f:facet>
                            <h:outputText value="#{item.issuedQuantity}"/>
                        </h:column>
                        <h:column>
                            <f:facet name="header">
                                <h:outputText value="OdoMeterReading"/>
                            </f:facet>
                            <h:outputText value="#{item.odoMeterReading}"/>
                        </h:column>
                        <h:column>
                            <f:facet name="header">
                                <h:outputText value="RequestAt"/>
                            </f:facet>
                            <h:outputText value="#{item.requestAt}">
                                <f:convertDateTime pattern="MM/dd/yyyy HH:mm:ss" />
                            </h:outputText>
                        </h:column>
                        <h:column>
                            <f:facet name="header">
                                <h:outputText value="RequestedDate"/>
                            </f:facet>
                            <h:outputText value="#{item.requestedDate}">
                                <f:convertDateTime pattern="MM/dd/yyyy" />
                            </h:outputText>
                        </h:column>
                        <h:column>
                            <f:facet name="header">
                                <h:outputText value="RequestReferenceNumber"/>
                            </f:facet>
                            <h:outputText value="#{item.requestReferenceNumber}"/>
                        </h:column>
                        <h:column>
                            <f:facet name="header">
                                <h:outputText value="IssueReferenceNumber"/>
                            </f:facet>
                            <h:outputText value="#{item.issueReferenceNumber}"/>
                        </h:column>
                        <h:column>
                            <f:facet name="header">
                                <h:outputText escape="false" value="&nbsp;"/>
                            </f:facet>
                            <h:commandLink value="Show" action="#{fuelTransaction.detailSetup}">
                                <f:param name="jsfcrud.currentFuelTransaction" value="#{jsfcrud_class['lk.gov.health.vmis.jsf.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][item][fuelTransaction.converter].jsfcrud_invoke}"/>
                            </h:commandLink>
                            <h:outputText value=" "/>
                            <h:commandLink value="Edit" action="#{fuelTransaction.editSetup}">
                                <f:param name="jsfcrud.currentFuelTransaction" value="#{jsfcrud_class['lk.gov.health.vmis.jsf.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][item][fuelTransaction.converter].jsfcrud_invoke}"/>
                            </h:commandLink>
                            <h:outputText value=" "/>
                            <h:commandLink value="Destroy" action="#{fuelTransaction.remove}">
                                <f:param name="jsfcrud.currentFuelTransaction" value="#{jsfcrud_class['lk.gov.health.vmis.jsf.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][item][fuelTransaction.converter].jsfcrud_invoke}"/>
                            </h:commandLink>
                        </h:column>

                    </h:dataTable>
                </h:panelGroup>
                <br />
                <h:commandLink action="#{fuelTransaction.createSetup}" value="New FuelTransaction"/>
                <br />
                <br />
                <h:commandLink value="Index" action="welcome" immediate="true" />


            </h:form>
        </body>
    </html>
</f:view>
