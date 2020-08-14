package org.dxctraining.ui;

import org.dxctraining.author.entities.Author;
import org.dxctraining.author.services.IAuthorService;
import org.dxctraining.book.entities.Book;
import org.dxctraining.book.entities.Fictionbook;
import org.dxctraining.book.entities.ITbook;
import org.dxctraining.book.exceptions.BookNotFoundException;
import org.dxctraining.book.exceptions.InvalidArgumentException;
import org.dxctraining.book.services.IbookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;

@Component
public class LibraryUI {
    @Autowired
    private IbookService bookservice;
    @Autowired
    private IAuthorService authorService;

@PostConstruct
public void runApp() {

    Author author1 = new Author("1", "vineel");
    Author author2 = new Author("2", "rudrapati");
    Author author3 = new Author("3", "Mathew");
    authorService.addAuthor(author1);
    authorService.addAuthor(author2);
    authorService.addAuthor(author3);
    //BOOKS
    Book book1 = new Book("animalfarm", 234, author1, "b1");
    Book book2 = new Book("gullivers travels", 432, author2, "b2");
    Book book3 = new Book("panchathantra", 650, author3, "b3");

    //FICTION AND ITBOOKS
    Fictionbook book4 = new Fictionbook("fiction1", 22, author1, "R44");
    ITbook book5 = new ITbook("IT1", 244, author3, "v44");
    bookservice.addBook(book1);
    bookservice.addBook(book2);
    bookservice.addBook(book3);
    bookservice.addBook(book4);
    bookservice.addBook(book5);
    Showbooks();
}
    public void Showbooks() {
    System.out.println("displaying the books details");
    List<Book> list=bookservice.showBooks();
    for(Book book:list)
    {
        displayAll(book); //display all books
        boolean isFiction=book instanceof Fictionbook;
        if(isFiction)
        {
            fictionBook(book);
        }
        else
        {
            itBook(book);
        }

    }
}
    private void displayAll(Book book) {

    Author author=book.getAuthor();
    System.out.println("The author is="+author.getName()+" Name of the book="+book.getName()+
            " The price= "+book.getCost()+" Author ID="+author.getId()+" The book Id "+book.getId());
}

    public void fictionBook(Book book)
    {

        Author author=book.getAuthor();
        System.out.println("The author is="+author.getName()+" Name of the book="+book.getName()+
                " The price= "+book.getCost()+" Author ID="+author.getId()+" The book Id "+book.getId());
    }

    private void itBook(Book book) {
    Author author=book.getAuthor();
    System.out.println("The author is="+author.getName()+" Name of the book="+book.getName()+
            " The price= "+book.getCost()+" Author ID="+author.getId()+" The book Id "+book.getId());
}

    }
