package Prog2.Book;

import java.util.Arrays;

public class Book {
    String name;
    Author[] authors;
    double price;
    int qty = 0;

    public Book(String name, Author[] authors, double price) {
        this.name = name;
        this.authors = authors;
        this.price = price;
    }
    public Book(String name, Author[] authors, double price, int qty) {
        this.name = name;
        this.authors = authors;
        this.price = price;
        this.qty = qty;
    }

    //metodos

    String AuthorNames(){
        String names = "";
        int cont = 0;
        for(Author i : authors){
            names = names + i.name;
            cont++;
            if (cont != authors.length - 1) {
                names = names + (", ");
            }
        }
        return names;
    }


    @Override
    public String toString() {
        return "Prog2.Book{" +
                "name='" + name + '\'' +
                ", authors=" + Arrays.toString(authors) +
                ", price=" + price +
                ", qty=" + qty +
                '}';
    }

    //get y set

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }
}
