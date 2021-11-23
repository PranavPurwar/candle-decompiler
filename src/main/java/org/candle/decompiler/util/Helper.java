package org.candle.decompiler.util;

import org.candle.decompiler.ast.ClassBlock;

public class Helper {

    public static ClassBlock current;
    
    public static ClassBlock getCurrentClass() {
        return current;
    }
    
    public static void setCurrentClass(ClassBlock block) {
        current = block;
    }
}
