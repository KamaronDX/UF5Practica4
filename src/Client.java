import java.io.Serializable;

public class Client implements Serializable {

    //Args del client
    String nom;
    DNI dni;
    int telefon;
    String email;
    int id;

    boolean isEmpty = false;

    //Constructor

    public Client(String nom, DNI dni, int telefon, String email, int id) {
        this.nom = nom;
        this.dni = dni;
        this.telefon = telefon;
        this.email = email;
        this.id = id;
    }

    /**
     *
     * @param nom nom
     * @param dni dni
     * @param telefon telef
     * @param email email
     * @param id id
     */


    //Remove method

    public void remove() {
        boolean isEmpty = true;
    }

//ToString

    /**
     *
     * @return string
     */
    @Override
    public String toString() {
        return "Client{" +
                "nom='" + nom + '\'' +
                ", dni=" + dni.toString() +
                ", telefon=" + telefon +
                ", email='" + email + '\'' +
                ", id=" + id +
                '}';
    }

    //getters and setters

    /**
     *
     * @return dni
     */
    public DNI getDni() {
        return dni;
    }

    /**
     *
     * @param dni dni
     */
    public void setDni(DNI dni) {
        this.dni = dni;
    }


    /**
     *
     * @return telef
     */
    public int getTelefon() {
        return telefon;
    }


    /**
     *
     * @param telefon telef
     */
    public void setTelefon(int telefon) {
        this.telefon = telefon;
    }

    /**
     *
     * @return telef
     */
    public String getEmail() {
        return email;
    }


    /**
     *
     * @param email email
     */
    public void setEmail(String email) {
        this.email = email;
    }


    /**
     *
     * @return nom
     */
    public String getNom() {
        return nom;
    }

    /**
     *
     * @param nom  nom
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     *
     * @return empty
     */
    public boolean isEmpty() {
        return isEmpty;
    }
}
