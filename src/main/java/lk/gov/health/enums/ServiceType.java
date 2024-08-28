/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lk.gov.health.enums;

/**
 *
 * @author Lenovo
 */
public enum ServiceType {
    
    Battery_Repair("Battery Repair", ServiceCategory.REPAIR),
    Tire_Repair("Tire Repair", ServiceCategory.REPAIR),
    Engine_Repair("Engine Repair", ServiceCategory.REPAIR),
    Full_Service("Full Service",ServiceCategory.MAINTENANCE),
    
    Oil_Change("Oil Change", ServiceCategory.MAINTENANCE),
    Filter_Change("Filter Change", ServiceCategory.MAINTENANCE),
    
    Battery_Replacement("Battery Replacement", ServiceCategory.REPLACEMENT),
    Tire_Replacement("Tire Replacement", ServiceCategory.REPLACEMENT),
    Engine_Replacement("Engine Replacement", ServiceCategory.REPLACEMENT),
    
    Other_Service("Other Service", ServiceCategory.OTHER);
    
    private final String label;
    private final ServiceCategory category;

    private ServiceType(String label, ServiceCategory category) {
        this.label = label;
        this.category = category;
    }

    public String getLabel() {
        return label;
    }

    public ServiceCategory getCategory() {
        return category;
    }
    
}
