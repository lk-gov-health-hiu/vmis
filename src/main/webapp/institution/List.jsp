<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<f:view>
    <html>
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
            <title>Listing Institution Items</title>
            <link rel="stylesheet" type="text/css" href="/vmis/faces/jsfcrud.css" />
        </head>
        <body>
            <h:panelGroup id="messagePanel" layout="block">
                <h:messages errorStyle="color: red" infoStyle="color: green" layout="table"/>
            </h:panelGroup>
            <h1>Listing Institution Items</h1>
            <h:form styleClass="jsfcrud_list_form">
                <h:outputText escape="false" value="(No Institution Items Found)<br />" rendered="#{institution.pagingInfo.itemCount == 0}" />
                <h:panelGroup rendered="#{institution.pagingInfo.itemCount > 0}">
                    <h:outputText value="Item #{institution.pagingInfo.firstItem + 1}..#{institution.pagingInfo.lastItem} of #{institution.pagingInfo.itemCount}"/>&nbsp;
                    <h:commandLink action="#{institution.prev}" value="Previous #{institution.pagingInfo.batchSize}" rendered="#{institution.pagingInfo.firstItem >= institution.pagingInfo.batchSize}"/>&nbsp;
                    <h:commandLink action="#{institution.next}" value="Next #{institution.pagingInfo.batchSize}" rendered="#{institution.pagingInfo.lastItem + institution.pagingInfo.batchSize <= institution.pagingInfo.itemCount}"/>&nbsp;
                    <h:commandLink action="#{institution.next}" value="Remaining #{institution.pagingInfo.itemCount - institution.pagingInfo.lastItem}"
                                   rendered="#{institution.pagingInfo.lastItem < institution.pagingInfo.itemCount && institution.pagingInfo.lastItem + institution.pagingInfo.batchSize > institution.pagingInfo.itemCount}"/>
                    <h:dataTable value="#{institution.institutionItems}" var="item" border="0" cellpadding="2" cellspacing="0" rowClasses="jsfcrud_odd_row,jsfcrud_even_row" rules="all" style="border:solid 1px">
                        <h:column>
                            <f:facet name="header">
                                <h:outputText value="Id"/>
                            </f:facet>
                            <h:outputText value="#{item.id}"/>
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
                                <h:outputText value="Type"/>
                            </f:facet>
                            <h:outputText value="#{item.type}"/>
                        </h:column>
                        <h:column>
                            <f:facet name="header">
                                <h:outputText value="Parent"/>
                            </f:facet>
                            <h:outputText value="#{item.parent}"/>
                        </h:column>
                        <h:column>
                            <f:facet name="header">
                                <h:outputText escape="false" value="&nbsp;"/>
                            </f:facet>
                            <h:commandLink value="Show" action="#{institution.detailSetup}">
                                <f:param name="jsfcrud.currentInstitution" value="#{jsfcrud_class['lk.gov.health.vmis.jsf.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][item][institution.converter].jsfcrud_invoke}"/>
                            </h:commandLink>
                            <h:outputText value=" "/>
                            <h:commandLink value="Edit" action="#{institution.editSetup}">
                                <f:param name="jsfcrud.currentInstitution" value="#{jsfcrud_class['lk.gov.health.vmis.jsf.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][item][institution.converter].jsfcrud_invoke}"/>
                            </h:commandLink>
                            <h:outputText value=" "/>
                            <h:commandLink value="Destroy" action="#{institution.remove}">
                                <f:param name="jsfcrud.currentInstitution" value="#{jsfcrud_class['lk.gov.health.vmis.jsf.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][item][institution.converter].jsfcrud_invoke}"/>
                            </h:commandLink>
                        </h:column>

                    </h:dataTable>
                </h:panelGroup>
                <br />
                <h:commandLink action="#{institution.createSetup}" value="New Institution"/>
                <br />
                <br />
                <h:commandLink value="Index" action="welcome" immediate="true" />


            </h:form>
        </body>
    </html>
</f:view>
