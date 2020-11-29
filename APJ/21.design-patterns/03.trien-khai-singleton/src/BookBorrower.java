public class BookBorrower {
    private BookSingleton borrowedBook;
    private boolean haveBook = false;

    public void borrowBook() {
        borrowedBook = BookSingleton.borrowBook();
        haveBook = borrowedBook != null;
    }

    public String getAuthorAndTitle() {
        return haveBook ? borrowedBook.getAuthorAndTitle() : "I don't have the book";
    }

    public void returnBook() {
        borrowedBook.returnBook(borrowedBook);
    }
}
