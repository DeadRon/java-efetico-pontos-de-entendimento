import java.io.BufferedReader;
import java.lang.reflect.Array;
import java.math.BigInteger;
import java.nio.file.FileStore;
import java.nio.file.Files;
import java.sql.Date;
import java.util.*;

public class Person {

    public static void main(String... args){

        Cliente cliente = NovoCliente.getInstance("Ronaldo", "Melo");

        /**

        Date date = Date.from(instant);
        Set<Rank> faceCards = EnumSet.of(JACK, QUEEN, KING);
        BigInteger prime = BigInteger.valueOf(Integer.MAX_VALUE);
        StackWalker tuke = StackWalker.getInstance(options);
        Object newArray = Array.newInstance(classObject, arrayLen);
        FileStore fs = Files.getFileStore(path);
        BufferedReader bf = Files.newBufferedReader(path);
        Lisy<Complaint> litany = Collections.list(legacyLitany);

        **/
        System.out.println(cliente.getNome() + " " + cliente.getSobrenome());
    }

}
