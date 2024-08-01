<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<f:view>
    <html>
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
            <title>Listing Driver Items</title>
            <link rel="stylesheet" type="text/css" href="/vmis/faces/jsfcrud.css" />
        </head>
        <body>
            <h:panelGroup id="messagePanel" layout="block">
                <h:messages errorStyle="color: red" infoStyle="color: green" layout="table"/>
            </h:panelGroup>
            <h1>Listing Driver Items</h1>
            <h:form styleClass="jsfcrud_list_form">
                <h:outputText escape="false" value="(No Driver Items Found)<br />" rendered="#{driver.pagingInfo.itemCount == 0}" />
                <h:panelGroup rendered="#{driver.pagingInfo.itemCount > 0}">
                    <h:outputText value="Item #{driver.pagingInfo.firstItem + 1}..#{driver.pagingInfo.lastItem} of #{driver.pagingInfo.itemCount}"/>&nbsp;
                    <h:commandLink action="#{driver.prev}" value="Previous #{driver.pagingInfo.batchSize}" rendered="#{driver.pagingInfo.firstItem >= driver.pagingInfo.batchSize}"/>&nbsp;
                    <h:commandLink action="#{driver.next}" value="Next #{driver.pagingInfo.batchSize}" rendered="#{driver.pagingInfo.lastItem + driver.pagingInfo.batchSize <= driver.pagingInfo.itemCount}"/>&nbsp;
                    <h:commandLink action="#{driver.next}" value="Remaining #{driver.pagingInfo.itemCount - driver.pagingInfo.lastItem}"
                                   rendered="#{driver.pagingInfo.lastItem < driver.pagingInfo.itemCount && driver.pagingInfo.lastItem + driver.pagingInfo.batchSize > driver.pagingInfo.itemCount}"/>
                    <h:dataTable value="#{driver.driverItems}" var="item" border="0" cellpadding="2" cellspacing="0" rowClasses="jsfcrud_odd_row,jsfcrud_even_row" rules="all" style="border:solid 1px" >
                        <h:column>
                            <f:facet name="header">
                                <h:outputText value="Id"/>
                            </f:facet>
                            <h:outputText value="#{item.id}"/>
                        </h:column>
                        <h:column>
                            <f:facet name="header">
                                <h:outputText value="Nic"/>
                            </f:facet>
                            <h:outputText value="#{item.nic}"/>
                        </h:column>
                        <h:column>
                            <f:facet name="header">
                                <h:outputText value="Name"/>
                            </f:facet>
                            <h:outputText value="#{item.name}"/>
                        </h:column>
                        <h:column>
                            <f:facet name="header">
                                <h:outputText value="Address"/>
                            </f:facet>
                            <h:outputText value="#{item.address}"/>
                        </h:column>
                        <h:column>
                            <f:facet name="header">
                                <h:outputText value="Institution"/>
                            </f:facet>
                            <h:outputText value="#{item.institution}"/>
                        </h:column>
                        <h:column>
                            <f:facet name="header">
                                <h:outputText escape="false" value="&nbsp;"/>
                            </f:facet>
                            <h:commandLink value="Show" action="#{driver.detailSetup}">
                                <f:param name="jsfcrud.currentDriver" value="#{jsfcrud_class['lk.gov.health.vmis.jsf.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][item][driver.converter].jsfcrud_invoke}"/>
                            </h:commandLink>
                            <h:outputText value=" "/>
                            <h:commandLink value="Edit" action="#{driver.editSetup}">
                                <f:param name="jsfcrud.currentDriver" value="#{jsfcrud_class['lk.gov.health.vmis.jsf.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][item][driver.converter].jsfcrud_invoke}"/>
                            </h:commandLink>
                            <h:outputText value=" "/>
                            <h:commandLink value="Destroy" action="#{driver.remove}">
                                <f:param name="jsfcrud.currentDriver" value="#{jsfcrud_class['lk.gov.health.vmis.jsf.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][item][driver.converter].jsfcrud_invoke}"/>
                            </h:commandLink>
                        </h:column>

                    </h:dataTable>
                </h:panelGroup>
                <br />
                <h:commandLink action="#{driver.createSetup1}" value="New Driver"/>

                <br />
                <br />
                <h:commandLink value="Index" action="welcome" immediate="true" />


            </h:form>
        </body>
    </html>
</f:view>
