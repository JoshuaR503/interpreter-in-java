/**
 * Code table of byte codes in language X
 * @key name of a specific byte code
 * @value name of the class that the key belongs to.
 */
package interpreter.loaders;

import java.util.HashMap;
import java.util.Map;

public final class CodeTable {

   // make up a map 
   private final static Map<String, String> codes = new HashMap<>();

   private CodeTable() {
      // do nothing
   }

   /**
    * fill code table with class name mappings
    */
   public static void init() {
      codes.put("ARGS", "ArgsByteCode");
      codes.put("BOP", "BopByteCode");
      codes.put("CALL", "CallByteCode");
      codes.put("FALSEBRANCH", "FalseBranchByteCode");
      codes.put("GOTO", "GotoByteCode");
      codes.put("HALT", "HaltByteCode");
      codes.put("LABEL", "LabelByteCode");
      codes.put("LIT", "LitByteCode");
      codes.put("LOAD", "LoadByteCode");
      codes.put("POP", "PopByteCode");
      codes.put("READ", "ReadByteCode");
      codes.put("RETURN", "ReturnByteCode");
      codes.put("STORE", "StoreByteCode");
      codes.put("VERBOSE", "VerboseByteCode");
      codes.put("WRITE", "WriteByteCode");
   }

   /**
    * Returns the ByteCode class name for a given token.
    * 
    * @param token bytecode to map. For example, HALT --> HaltCode
    * @return class name of bytecode
    */
   public static String getClassName(String token) {
       return CodeTable.codes.get(token);
   }

}
