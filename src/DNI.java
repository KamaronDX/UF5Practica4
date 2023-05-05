import java.io.Serializable;

public class DNI implements Serializable {

    int numeric;
    char lletra;

    char[] lletraDNI = new char[]{'T', 'R', 'W', 'A', 'G', 'M', 'Y', 'F', 'P', 'D', 'X', 'B', 'N', 'J', 'Z', 'S', 'Q', 'V', 'H', 'L', 'C', 'K', 'E'};

    /**
     *
     * @param numeric numer
     * @param lletra char
     */
    //Constructor
    public DNI(int numeric, char lletra) {
        this.numeric = numeric;
        this.lletra = Character.toUpperCase(lletra);
    }

    //tostring

    /**
     *
     * @return string
     */
    @Override
    public String toString() {
        return Integer.toString(numeric)+lletra;
    }

    //check validity of DNI

    /**
     *
     * @return validity
     */
    public boolean isValid() {
        if (lletraDNI[numeric % 23] == lletra){
            return true;
        }else{
            return false;
        }
    }
}
