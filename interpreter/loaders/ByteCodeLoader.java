package interpreter.loaders;
import interpreter.bytecodes.ByteCode;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

public final class ByteCodeLoader {
    private String codSourceFileName;
    
    /**
     * Constructs ByteCodeLoader object given a COD source code
     * file name
     * @param fileName name of .cod File to load.
     */
    public ByteCodeLoader(String fileName){
        this.codSourceFileName = fileName;
    }
    
    /**
     * Loads a program from a .cod file.
     * @return a constructed Program Object.
     * @throws InvalidProgramException thrown when 
     * loadCodes fails.
     */
    public Program loadCodes() throws InvalidProgramException {

       Program program = new Program();

       try (BufferedReader reader = new BufferedReader(new FileReader(this.codSourceFileName))) {

           while (reader.ready()) {
               String line = reader.readLine();

               System.out.println(line);

               String[] tokens = line.split("\\s+");

               String className = CodeTable.getClassName(tokens[0]);

               Class<?> c = Class.forName("interpreter.bytecodes."+className);

               ByteCode bc = (ByteCode) c.getDeclaredConstructor().newInstance();

               bc.init(Arrays.asList(tokens));

               program.addCode(bc);
           }

       } catch (IOException | ClassNotFoundException | NoSuchMethodException | InvocationTargetException | InstantiationException | IllegalAccessException e) {
           throw new InvalidProgramException(e);
       }

        return program;
    }
}
