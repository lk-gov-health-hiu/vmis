<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<f:view>
    <html>
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
            <title>FuelTransaction Detail</title>
            <link rel="stylesheet" type="text/css" href="/vmis/faces/jsfcrud.css" />
        </head>
        <body>
            <h:panelGroup id="messagePanel" layout="block">
                <h:messages errorStyle="color: red" infoStyle="color: green" layout="table"/>
            </h:panelGroup>
            <h1>FuelTransaction Detail</h1>
            <h:form>
                <h:panelGrid columns="2">
                    <h:outputText value="Id:"/>
                    <h:outputText value="#{fuelTransaction.fuelTransaction.id}" title="Id" />
                    <h:outputText value="Intitite:"/>
                    <h:panelGroup>
                        <h:outputText value="#{fuelTransaction.fuelTransaction.intitite}"/>
                        <h:panelGroup rendered="#{fuelTransaction.fuelTransaction.intitite != null}">
                            <h:outputText value=" ("/>
                            <h:commandLink value="Show" action="#{institution.detailSetup}">
                                <f:param name="jsfcrud.currentFuelTransaction" value="#{jsfcrud_class['lk.gov.health.vmis.jsf.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][fuelTransaction.fuelTransaction][fuelTransaction.converter].jsfcrud_invoke}"/>
                                <f:param name="jsfcrud.currentInstitution" value="#{jsfcrud_class['lk.gov.health.vmis.jsf.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][fuelTransaction.fuelTransaction.intitite][institution.converter].jsfcrud_invoke}"/>
                                <f:param name="jsfcrud.relatedController" value="fuelTransaction"/>
                                <f:param name="jsfcrud.relatedControllerType" value="lk.gov.health.vmis.jsf.FuelTransactionController"/>
                            </h:commandLink>
                            <h:outputText value=" "/>
                            <h:commandLink value="Edit" action="#{institution.editSetup}">
                                <f:param name="jsfcrud.currentFuelTransaction" value="#{jsfcrud_class['lk.gov.health.vmis.jsf.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][fuelTransaction.fuelTransaction][fuelTransaction.converter].jsfcrud_invoke}"/>
                                <f:param name="jsfcrud.currentInstitution" value="#{jsfcrud_class['lk.gov.health.vmis.jsf.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][fuelTransaction.fuelTransaction.intitite][institution.converter].jsfcrud_invoke}"/>
                                <f:param name="jsfcrud.relatedController" value="fuelTransaction"/>
                                <f:param name="jsfcrud.relatedControllerType" value="lk.gov.health.vmis.jsf.FuelTransactionController"/>
                            </h:commandLink>
                            <h:outputText value=" "/>
                            <h:commandLink value="Destroy" action="#{institution.destroy}">
                                <f:param name="jsfcrud.currentFuelTransaction" value="#{jsfcrud_class['lk.gov.health.vmis.jsf.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][fuelTransaction.fuelTransaction][fuelTransaction.converter].jsfcrud_invoke}"/>
                                <f:param name="jsfcrud.currentInstitution" value="#{jsfcrud_class['lk.gov.health.vmis.jsf.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][fuelTransaction.fuelTransaction.intitite][institution.converter].jsfcrud_invoke}"/>
                                <f:param name="jsfcrud.relatedController" value="fuelTransaction"/>
                                <f:param name="jsfcrud.relatedControllerType" value="lk.gov.health.vmis.jsf.FuelTransactionController"/>
                            </h:commandLink>
                            <h:outputText value=" )"/>
                        </h:panelGroup>
                    </h:panelGroup>
                    <h:outputText value="Vehicle:"/>
                    <h:panelGroup>
                        <h:outputText value="#{fuelTransaction.fuelTransaction.vehicle}"/>
                        <h:panelGroup rendered="#{fuelTransaction.fuelTransaction.vehicle != null}">
                            <h:outputText value=" ("/>
                            <h:commandLink value="Show" action="#{vehicle.detailSetup}">
                                <f:param name="jsfcrud.currentFuelTransaction" value="#{jsfcrud_class['lk.gov.health.vmis.jsf.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][fuelTransaction.fuelTransaction][fuelTransaction.converter].jsfcrud_invoke}"/>
                                <f:param name="jsfcrud.currentVehicle" value="#{jsfcrud_class['lk.gov.health.vmis.jsf.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][fuelTransaction.fuelTransaction.vehicle][vehicle.converter].jsfcrud_invoke}"/>
                                <f:param name="jsfcrud.relatedController" value="fuelTransaction"/>
                                <f:param name="jsfcrud.relatedControllerType" value="lk.gov.health.vmis.jsf.FuelTransactionController"/>
                            </h:commandLink>
                            <h:outputText value=" "/>
                            <h:commandLink value="Edit" action="#{vehicle.editSetup}">
                                <f:param name="jsfcrud.currentFuelTransaction" value="#{jsfcrud_class['lk.gov.health.vmis.jsf.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][fuelTransaction.fuelTransaction][fuelTransaction.converter].jsfcrud_invoke}"/>
                                <f:param name="jsfcrud.currentVehicle" value="#{jsfcrud_class['lk.gov.health.vmis.jsf.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][fuelTransaction.fuelTransaction.vehicle][vehicle.converter].jsfcrud_invoke}"/>
                                <f:param name="jsfcrud.relatedController" value="fuelTransaction"/>
                                <f:param name="jsfcrud.relatedControllerType" value="lk.gov.health.vmis.jsf.FuelTransactionController"/>
                            </h:commandLink>
                            <h:outputText value=" "/>
                            <h:commandLink value="Destroy" action="#{vehicle.destroy}">
                                <f:param name="jsfcrud.currentFuelTransaction" value="#{jsfcrud_class['lk.gov.health.vmis.jsf.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][fuelTransaction.fuelTransaction][fuelTransaction.converter].jsfcrud_invoke}"/>
                                <f:param name="jsfcrud.currentVehicle" value="#{jsfcrud_class['lk.gov.health.vmis.jsf.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][fuelTransaction.fuelTransaction.vehicle][vehicle.converter].jsfcrud_invoke}"/>
                                <f:param name="jsfcrud.relatedController" value="fuelTransaction"/>
                                <f:param name="jsfcrud.relatedControllerType" value="lk.gov.health.vmis.jsf.FuelTransactionController"/>
                            </h:commandLink>
                            <h:outputText value=" )"/>
                        </h:panelGroup>
                    </h:panelGroup>
                    <h:outputText value="FromInstitution:"/>
                    <h:panelGroup>
                        <h:outputText value="#{fuelTransaction.fuelTransaction.fromInstitution}"/>
                        <h:panelGroup rendered="#{fuelTransaction.fuelTransaction.fromInstitution != null}">
                            <h:outputText value=" ("/>
                            <h:commandLink value="Show" action="#{institution.detailSetup}">
                                <f:param name="jsfcrud.currentFuelTransaction" value="#{jsfcrud_class['lk.gov.health.vmis.jsf.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][fuelTransaction.fuelTransaction][fuelTransaction.converter].jsfcrud_invoke}"/>
                                <f:param name="jsfcrud.currentInstitution" value="#{jsfcrud_class['lk.gov.health.vmis.jsf.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][fuelTransaction.fuelTransaction.fromInstitution][institution.converter].jsfcrud_invoke}"/>
                                <f:param name="jsfcrud.relatedController" value="fuelTransaction"/>
                                <f:param name="jsfcrud.relatedControllerType" value="lk.gov.health.vmis.jsf.FuelTransactionController"/>
                            </h:commandLink>
                            <h:outputText value=" "/>
                            <h:commandLink value="Edit" action="#{institution.editSetup}">
                                <f:param name="jsfcrud.currentFuelTransaction" value="#{jsfcrud_class['lk.gov.health.vmis.jsf.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][fuelTransaction.fuelTransaction][fuelTransaction.converter].jsfcrud_invoke}"/>
                                <f:param name="jsfcrud.currentInstitution" value="#{jsfcrud_class['lk.gov.health.vmis.jsf.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][fuelTransaction.fuelTransaction.fromInstitution][institution.converter].jsfcrud_invoke}"/>
                                <f:param name="jsfcrud.relatedController" value="fuelTransaction"/>
                                <f:param name="jsfcrud.relatedControllerType" value="lk.gov.health.vmis.jsf.FuelTransactionController"/>
                            </h:commandLink>
                            <h:outputText value=" "/>
                            <h:commandLink value="Destroy" action="#{institution.destroy}">
                                <f:param name="jsfcrud.currentFuelTransaction" value="#{jsfcrud_class['lk.gov.health.vmis.jsf.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][fuelTransaction.fuelTransaction][fuelTransaction.converter].jsfcrud_invoke}"/>
                                <f:param name="jsfcrud.currentInstitution" value="#{jsfcrud_class['lk.gov.health.vmis.jsf.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][fuelTransaction.fuelTransaction.fromInstitution][institution.converter].jsfcrud_invoke}"/>
                                <f:param name="jsfcrud.relatedController" value="fuelTransaction"/>
                                <f:param name="jsfcrud.relatedControllerType" value="lk.gov.health.vmis.jsf.FuelTransactionController"/>
                            </h:commandLink>
                            <h:outputText value=" )"/>
                        </h:panelGroup>
                    </h:panelGroup>
                    <h:outputText value="Driver:"/>
                    <h:panelGroup>
                        <h:outputText value="#{fuelTransaction.fuelTransaction.driver}"/>
                        <h:panelGroup rendered="#{fuelTransaction.fuelTransaction.driver != null}">
                            <h:outputText value=" ("/>
                            <h:commandLink value="Show" action="#{driver.detailSetup}">
                                <f:param name="jsfcrud.currentFuelTransaction" value="#{jsfcrud_class['lk.gov.health.vmis.jsf.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][fuelTransaction.fuelTransaction][fuelTransaction.converter].jsfcrud_invoke}"/>
                                <f:param name="jsfcrud.currentDriver" value="#{jsfcrud_class['lk.gov.health.vmis.jsf.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][fuelTransaction.fuelTransaction.driver][driver.converter].jsfcrud_invoke}"/>
                                <f:param name="jsfcrud.relatedController" value="fuelTransaction"/>
                                <f:param name="jsfcrud.relatedControllerType" value="lk.gov.health.vmis.jsf.FuelTransactionController"/>
                            </h:commandLink>
                            <h:outputText value=" "/>
                            <h:commandLink value="Edit" action="#{driver.editSetup}">
                                <f:param name="jsfcrud.currentFuelTransaction" value="#{jsfcrud_class['lk.gov.health.vmis.jsf.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][fuelTransaction.fuelTransaction][fuelTransaction.converter].jsfcrud_invoke}"/>
                                <f:param name="jsfcrud.currentDriver" value="#{jsfcrud_class['lk.gov.health.vmis.jsf.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][fuelTransaction.fuelTransaction.driver][driver.converter].jsfcrud_invoke}"/>
                                <f:param name="jsfcrud.relatedController" value="fuelTransaction"/>
                                <f:param name="jsfcrud.relatedControllerType" value="lk.gov.health.vmis.jsf.FuelTransactionController"/>
                            </h:commandLink>
                            <h:outputText value=" "/>
                            <h:commandLink value="Destroy" action="#{driver.destroy}">
                                <f:param name="jsfcrud.currentFuelTransaction" value="#{jsfcrud_class['lk.gov.health.vmis.jsf.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][fuelTransaction.fuelTransaction][fuelTransaction.converter].jsfcrud_invoke}"/>
                                <f:param name="jsfcrud.currentDriver" value="#{jsfcrud_class['lk.gov.health.vmis.jsf.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][fuelTransaction.fuelTransaction.driver][driver.converter].jsfcrud_invoke}"/>
                                <f:param name="jsfcrud.relatedController" value="fuelTransaction"/>
                                <f:param name="jsfcrud.relatedControllerType" value="lk.gov.health.vmis.jsf.FuelTransactionController"/>
                            </h:commandLink>
                            <h:outputText value=" )"/>
                        </h:panelGroup>
                    </h:panelGroup>
                    <h:outputText value="Comments:"/>
                    <h:outputText value="#{fuelTransaction.fuelTransaction.comments}" title="Comments" />
                    <h:outputText value="RequestQuantity:"/>
                    <h:outputText value="#{fuelTransaction.fuelTransaction.requestQuantity}" title="RequestQuantity" />
                    <h:outputText value="IssuedQuantity:"/>
                    <h:outputText value="#{fuelTransaction.fuelTransaction.issuedQuantity}" title="IssuedQuantity" />
                    <h:outputText value="OdoMeterReading:"/>
                    <h:outputText value="#{fuelTransaction.fuelTransaction.odoMeterReading}" title="OdoMeterReading" />
                    <h:outputText value="RequestAt:"/>
                    <h:outputText value="#{fuelTransaction.fuelTransaction.requestAt}" title="RequestAt" >
                        <f:convertDateTime pattern="MM/dd/yyyy HH:mm:ss" />
                    </h:outputText>
                    <h:outputText value="RequestedDate:"/>
                    <h:outputText value="#{fuelTransaction.fuelTransaction.requestedDate}" title="RequestedDate" >
                        <f:convertDateTime pattern="MM/dd/yyyy" />
                    </h:outputText>
                    <h:outputText value="RequestReferenceNumber:"/>
                    <h:outputText value="#{fuelTransaction.fuelTransaction.requestReferenceNumber}" title="RequestReferenceNumber" />
                    <h:outputText value="IssueReferenceNumber:"/>
                    <h:outputText value="#{fuelTransaction.fuelTransaction.issueReferenceNumber}" title="IssueReferenceNumber" />


                </h:panelGrid>
                <br />
                <h:commandLink action="#{fuelTransaction.remove}" value="Destroy">
                    <f:param name="jsfcrud.currentFuelTransaction" value="#{jsfcrud_class['lk.gov.health.vmis.jsf.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][fuelTransaction.fuelTransaction][fuelTransaction.converter].jsfcrud_invoke}" />
                </h:commandLink>
                <br />
                <br />
                <h:commandLink action="#{fuelTransaction.editSetup}" value="Edit">
                    <f:param name="jsfcrud.currentFuelTransaction" value="#{jsfcrud_class['lk.gov.health.vmis.jsf.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][fuelTransaction.fuelTransaction][fuelTransaction.converter].jsfcrud_invoke}" />
                </h:commandLink>
                <br />
                <h:commandLink action="#{fuelTransaction.createSetup}" value="New FuelTransaction" />
                <br />
                <h:commandLink action="#{fuelTransaction.listSetup}" value="Show All FuelTransaction Items"/>
                <br />
                <br />
                <h:commandLink value="Index" action="welcome" immediate="true" />

            </h:form>
        </body>
    </html>
</f:view>
