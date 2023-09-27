package __Prog2__.Book;

public class main {
    public static void main(String[] args) {
        Author a1 = new Author("carlos","carlos@gmail.com",'h');
        Author a2 = new Author("pablo","pablo@email.com",'h');
        Author a3 = new Author("marina","mary@yahoo.com",'m');

        Author[] authors1 = {a1,a2};
        Author[] authors2 = {a1,a3};
        Author[] authors3 = {a2,a3};
        Book Libro1 = new Book("El arbol",authors1,1500);
        Book Libro2 = new Book("La bruja",authors2,3200);
        Book Libro3 = new Book("El muerto",authors3,1750);

        System.out.println(Libro1.toString());
        System.out.println(Libro2.toString());
        System.out.println(Libro3.toString());
    }
}
