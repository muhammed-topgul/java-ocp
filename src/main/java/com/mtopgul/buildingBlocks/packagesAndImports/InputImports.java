package com.mtopgul.buildingBlocks.packagesAndImports;

//import java.nio.file.Files; // GOOD
//import java.nio.file.Paths; // GOOD

import java.nio.file.*;       // GOOD
import java.nio.*;            // NO GOOD - a wildcard only matches class names
// import java.nio.*.*;       // NO GOOD - you can only have one wildcard and it must be at the end
import java.nio.file.Paths.*; // NO GOOD - you cannot import methods only class names

/**
 * @author muhammed-topgul
 * @since 04/01/2024 09:05
 */
public class InputImports {
    public static void read(Files files) {
        Paths.get("name");
    }
}
