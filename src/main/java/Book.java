public class Book {
    private String yearPublished;
    private String author;
    private String title;

    public Book(String title){
        this.title = title;
        author = "";
        yearPublished = "";
    }

    public Book(String title, String author){
        this.title = title;
        this.author = author;
        yearPublished = "";
    }

    public Book(String title, String author, String yearPublished){
        this.title = title;
        this.author = author;
        this.yearPublished = yearPublished;
    }

    @Override
    public String toString(){
        return title + "\t" + author + "\t" + yearPublished;
    }
}
