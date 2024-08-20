/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lk.gov.health.enums;

/**
 *
 * @author Renuka Theminda Kirulapana
 */
public enum WebuserRole {

    // National Level Roles
    
    SYSTEM_ADMINISTRATOR("System Administrator", AccessLevel.NATIONAL),
    SUPER_USER("Super User", AccessLevel.NATIONAL),
    USER("User", AccessLevel.NATIONAL),
    
    // Health Institutional Level Roles
    
    INSTITUTION_ADMINISTRATOR("Institution Administrator", AccessLevel.INSTITUTIONAL),
    INSTITUTION_SUPER_USER("Institution Super User", AccessLevel.INSTITUTIONAL),
    INSTITUTION_TRANSPORT("Transport Branch Users", AccessLevel.INSTITUTIONAL),
    INSTITUTION_ACCOUNTS("Account Branch Users", AccessLevel.INSTITUTIONAL),
    INSTITUTION_USER("Institution User", AccessLevel.INSTITUTIONAL);

    private final String label;
    private final AccessLevel accessLevel;

    private WebuserRole(String label, AccessLevel accessLevel) {
        this.label = label;
        this.accessLevel = accessLevel;
    }

    public String getLabel() {
        return label;
    }

    public AccessLevel getAccessLevel() {
        return accessLevel;
    }

}
