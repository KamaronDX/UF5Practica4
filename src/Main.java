import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //Variables base del programa
        boolean sortir = false;
        Scanner scanner = new Scanner(System.in);
        File file = new File("llistaClients.dat");


        //Inicialitzactió de la llista de clients
        ArrayList<Client> LlistaClients = new ArrayList<Client>();

        try {
            fileRead(file, LlistaClients);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        //Bucle principal del programa
        do {

            //Menu principal del programa
            System.out.println("MENU:");
            System.out.println("1. Afegir un nou client.");
            System.out.println("2. Modificar dades.");
            System.out.println("3. Donar de baixa un client.");
            System.out.println("4. Buscar un client i mostrar informacio.");
            System.out.println("5. Llistar clients.");
            System.out.println("6. Sortir.");

            //Boolea per la comprovació de la correcta introducció de valors
            boolean inputValueBoolean = false;


            //Redundancia sobre el input numeric per al menú
            if (scanner.hasNextInt()) {
                int menu = scanner.nextInt();
                if (menu >= 1 && menu <= 6) {
                    switch (menu) {

                        //1. Afegir un nou client.
                        case 1 -> {

                            //Creació de variables per al aposterior creació del objecte client
                            //Metodes de adició de valors.
                            String nom = InputName();
                            DNI dni = InputDNI();
                            int telefon = InputTelefon();
                            String email = InputEmail();

                            //Agregaci´po del client a la llista
                            Client client = new Client(nom, dni, telefon, email, LlistaClients.size());
                            LlistaClients.add(client);
                        }

//2. Modificar dades.
                        case 2 -> {
                            //bucle en cas de la incorrecta introducció de dades
                            do {
                                int id = InputIDClient(LlistaClients);

                                System.out.println("Selecciona el valor a modificar.");
                                System.out.println("1. Nom.");
                                System.out.println("2. DNI.");
                                System.out.println("3. Telefon.");
                                System.out.println("4. Email.");
                                if (scanner.hasNextInt()) {
                                    int menuDades = scanner.nextInt();
                                    if (menuDades >= 1 && menuDades <= 6) {
                                        System.out.println("Introdueix la dada modificada.");
                                        inputValueBoolean = true;
                                        switch (menuDades) {
                                            case 1 -> {
                                                LlistaClients.get(id).setNom(InputName());
                                            }
                                            case 2 -> {
                                                LlistaClients.get(id).setDni(InputDNI());
                                            }
                                            case 3 -> {
                                                LlistaClients.get(id).setTelefon(InputTelefon());
                                            }
                                            case 4 -> {
                                                LlistaClients.get(id).setEmail(InputEmail());
                                            }
                                        }
                                    } else {
                                        //Error de valor correcta rang no disponible
                                        System.out.println("La opció introduida no es troba al menu presentat.");
                                    }
                                } else {
                                    //Error de valor incorrecte
                                    System.out.println("Introdueix un numero enter de la llista seleccionada per continuar.");
                                }

                            } while (!inputValueBoolean);
                        }

                        //3. Donar de baixa un client.
                        case 3 -> {
                            //rebudad el id del client desijat
                            int id = InputIDClient(LlistaClients);
                            //eliminació del client
                            LlistaClients.get(id).remove();
                            System.out.println("El client ha sigut eliminat correctament.");

                        }

                        //4. Buscar un client i mostrar informacio.
                        case 4 -> {
                            //rebuda de id desitjat
                            int id = InputIDClient(LlistaClients);
                            //Tostring
                            LlistaClients.get(id).toString();

                        }

                        //5. Llistar clients.
                        case 5 -> {
                            //Bucle de llistat de clients utilitzant el metode toString de la classe Client
                            if (LlistaClients.size() > 0) {
                                for (int i = 0; i < LlistaClients.size(); i++) {
                                    //Comprovació que el client es valid i no ha sigut eliminat.
                                    if (!LlistaClients.get(i).isEmpty()) {
                                        System.out.println(LlistaClients.get(i).toString());
                                        System.out.println();
                                    }
                                }
                            } else {
                                //Error en cas de que el llistat no tingui cap client dins
                                System.out.println("El llistat de clients esta vuit.");
                            }
                        }

                        //6. Sortir.
                        case 6 -> {
                            sortir = true;
                        }
                    }
                } else {
                    //Error de valor correcta rang no disponible
                    System.out.println("La opció introduida no es troba al menu presentat.");

                }
            } else {
                //Error de valor incorrecte
                System.out.println("Introdueix un numero enter de la llista seleccionada per continuar.");
            }
        } while (!sortir);

        //Escriptura de dades
        fileWrite(LlistaClients);


    }

    /**
     *
     * @return name
     */
    //Metode per al input de un nom
    public static String InputName() {
        Scanner scanner = new Scanner(System.in);
        String nom = "";
        boolean inputValueBoolean2 = false;


        System.out.println("Nom:");
        do {
            if (scanner.hasNext()) {
                nom = scanner.next();
                if (!nom.matches(".*\\d.*") || !nom.matches("[!@#$%&*()_+=|<>?{}\\\\[\\\\]~-]+")) {
                    inputValueBoolean2 = true;
                } else {
                    System.out.println("El nom introduit conté un caracter no desitjat, torna a introduir un nom valid");
                }

            } else {
                System.out.println("Valor invalid. Torna a introduir un nom valid");
            }

        } while (!inputValueBoolean2);
        return nom;
    }

    /**
     *
     * @return dni
     */
    //Metode per al input de un dni
    public static DNI InputDNI() {
        Scanner scanner = new Scanner(System.in);
        DNI dni;
        boolean inputValueBoolean2 = false;
        boolean inputValueBoolean3 = false;

        int num = 0;
        char ch = 'a';
        System.out.println("DNI:");
        do {
            do {
                System.out.println("Introdueix el numero del dni.");
                if (scanner.hasNextInt()) {
                    num = scanner.nextInt();
                    if (num > 0 && num < 999999999) {
                        inputValueBoolean3 = true;
                    } else {
                        System.out.println("El numero de dni introduit no es valid.");
                    }

                } else {
                    System.out.println("Valor invalid. Torna a introduir un nom valid");
                }
            } while (!inputValueBoolean3);
            inputValueBoolean3 = false;
            do {
                System.out.println("Introdueix la lletra del dni.");
                if (scanner.hasNext()) {
                    ch = Character.toUpperCase(scanner.next().charAt(0));
                    inputValueBoolean3 = true;
                } else {
                    System.out.println("Valor invalid. Torna a introduir un nom valid");
                }
            } while (!inputValueBoolean3);


            dni = new DNI(num, ch);
            if (dni.isValid()) {
                inputValueBoolean2 = true;
            } else {
                System.out.println("El dni introduit no es valid, torna a introduir un dni valid");
            }


        } while (!inputValueBoolean2);
        inputValueBoolean2 = false;
        return dni;
    }

    /**
     *
     * @return telef
     */
    //Metode per al input de un telef
    public static int InputTelefon() {
        Scanner scanner = new Scanner(System.in);
        int telefon = 0;
        Boolean inputValueBoolean2 = false;


        System.out.println("Telefon:");
        do {
            if (scanner.hasNext()) {
                telefon = scanner.nextInt();
                if (telefon <= 999999999 && telefon >= 600000000) {
                    inputValueBoolean2 = true;
                } else {
                    System.out.println("El numero de telefon introduit conté un caracter no desitjat, torna a introduir un numero de telefon valid");
                }

            } else {
                System.out.println("Valor invalid. Torna a introduir un nom valid");
            }

        } while (!inputValueBoolean2);
        inputValueBoolean2 = false;
        return telefon;
    }

    /**
     *
     * @return email
     */
   //Metode per al input de un email
    public static String InputEmail() {
        Scanner scanner = new Scanner(System.in);
        String email = "";
        boolean inputValueBoolean2 = false;


        System.out.println("Email:");
        do {
            if (scanner.hasNext()) {
                email = scanner.next();
                if (email.contains("@")) {
                    inputValueBoolean2 = true;
                } else {
                    System.out.println("El email introduit no es valid, torna a introduir un email valid");
                }

            } else {
                System.out.println("Valor invalid. Torna a introduir un nom valid");
            }

        } while (!inputValueBoolean2);
        return email;
    }

    /***
     *
     * @param LlistaClients llistaclients
     * @return idclient
     */
    //Metode per al input de un idClient
    public static int InputIDClient(ArrayList<Client> LlistaClients) {
        boolean inputValueBoolean = false;
        Scanner scanner = new Scanner(System.in);
        int id = 0;
        do {
            System.out.println("Introdueix el ID del client desitjat (0-" + (LlistaClients.size() - 1) + ").");
            //Redundancia sobre el tipus de valor introduit al scanner
            if (scanner.hasNextInt()) {
                id = scanner.nextInt();

                //En cas de introduir un tipus de valor correcte el programa trencara el bucle principal del cas3

                //Comprovació que el numero introduit es troba disponible com a ID disponible (el metode isEmpty comprova si el client ha sigut
                //esborrat o segueix sen un client valid
                if (id >= 0 && id < LlistaClients.size() && !LlistaClients.get(id).isEmpty()) {
                    inputValueBoolean = true;
                } else {
                    //Error de valor correcta rang no disponible
                    System.out.println("El ID introduit no entra dins de el rang de id que tenim disponibles en el nostre llistat de clients.");
                }
            } else {
                //Error de valor incorrecte
                System.out.println("El valor introduit no es un ID valid, siusplau, introdueix un numero enter valid com a id");
            }
        } while (!inputValueBoolean);
        return id;
    }

    /**
     *
     * @param file fitxer
     * @param LlistaClients llistaclient
     * @throws IOException IOExcepciton
     */
    //Metode de lectura de ddades del fitxer
    public static void fileRead(File file, ArrayList<Client> LlistaClients) throws IOException {
        //Comprovació de que el fitxer existeix
        if (file.exists()) {
            //carrega de dades
            try (ObjectInputStream entrada = new ObjectInputStream(new FileInputStream("llistaClients.dat"))) {
                //Icizializació del lector
                Client line = (Client) entrada.readObject();
                LlistaClients.add(line);
                while (!line.isEmpty()) {
                    line = (Client) entrada.readObject();
                    if (!line.isEmpty()) {
                        LlistaClients.add(line);
                    }
                }

            } catch (EOFException ex) {
                System.out.println();
            } catch (IOException | ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
    }

    /**
     *
     * @param LlistaClients llista clients
     */
    //Metode per escriptura de daades al fitxer
    public static void fileWrite(ArrayList<Client> LlistaClients) {
        //Escriptura de dades

        try (ObjectOutputStream salida = new ObjectOutputStream(new FileOutputStream("llistaClients.dat"))) {
            String line = "a";
            for (int i = 0; i < LlistaClients.size(); i++) {
                salida.writeObject(LlistaClients.get(i));
            }
        } catch (IOException ex) {
            System.out.println(ex);
        }

    }

}