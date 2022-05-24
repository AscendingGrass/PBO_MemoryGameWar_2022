/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mgw.gameplay;

/**
 *
 * @author mejap
 */


public abstract class StatusEffect {
    public static StatusEffect[] list = {
        
    };
    
    public final String name;
    public final Player caster, affected;

    public StatusEffect(String name, Player caster, Player affected) {
        this.name = name;
        this.caster = caster;
        this.affected = affected;
    }

}


