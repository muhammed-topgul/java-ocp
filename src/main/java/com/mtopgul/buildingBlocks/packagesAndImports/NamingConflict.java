package com.mtopgul.buildingBlocks.packagesAndImports;

// causes not compile together
// import java.util.Date;
// import java.sql.Date;

// causes Date declaration to not compile
// import java.util.*;
// import java.sql.*;

// compiles
// java.util.Date java.util.* önceliklidir
import java.util.Date;
import java.util.*;

/**
 * @author muhammed-topgul
 * @since 04/01/2024 09:17
 */
public class NamingConflict {
    Date utilDate;
    java.sql.Date sqlDate;
}
