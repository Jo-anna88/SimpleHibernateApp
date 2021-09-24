package pl.simplehibernateapp;

public class App {
    public static void main(String[] args) {
        ReaderRepository repo = new ReaderRepository(); //here: creating Singleton of Entity Manager
        System.out.println("*** CREATE ***");
        repo.createReader("Paweł", 1980); //-> call next value for hibernate_sequence
        repo.createReader("Asia", 1988);
        System.out.println("*** READ ***");
        Reader reader = repo.getById(2);
        System.out.println(reader);
        System.out.println("*** DELETE ***");
        repo.deleteById(2);
        System.out.println(repo.getById(2)); //null
        System.out.println("*** UPDATE ***");
        System.out.println(repo.getById(1));
        repo.updateYearById(1,1981);
        System.out.println(repo.getById(1));
    }
}
