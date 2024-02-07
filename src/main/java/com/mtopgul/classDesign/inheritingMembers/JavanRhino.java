package com.mtopgul.classDesign.inheritingMembers;

/**
 * @author muhammed-topgul
 * @since 07/02/2024 09:39
 */
public class JavanRhino extends Rhino {
    public String getName() {
        return "new rhino";
    }

    // protected CharSequence getColor() {return "grey";} // DOES NOT COMPILE
}
