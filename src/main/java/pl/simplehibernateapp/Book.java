package pl.simplehibernateapp;

import javax.persistence.*;

@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String title;
    private String author;
    //na poziomie Javy chcemy, żeby Book posiadała Reader'a
    //na poziomie relacyjnej BD musimy określić, że mamy Book i ona wskazuje na n-ty wiersz w tabeli Reader (konkretnego czytelnika)
    @OneToOne
    private Reader reader;

    public Book(String title, String author, Reader reader) {
        this.title = title;
        this.author = author;
        this.reader = reader;
    }
}
