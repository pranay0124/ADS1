/**
 * Class for book.
 */
class Book implements Comparable<Book> {
    /**
     * varible for name.
     */
    private String name;
    /**
     * varible for author.
     */
    private String author;
    /**
     * varible for price.
     */
    private float price;
    /**
     * Constructs the object.
     */
    Book() { }
    /**
     * Constructs the object.
     *
     * @param      name1    The name 1
     * @param      author1  The author 1
     * @param      price1   The price 1
     */
    Book(final String name1, final String author1, final float price1) {
        this.name = name1;
        this.author = author1;
        this.price = price1;
    }
    /**
     * Gets the name.
     *
     * @return     The name.
     */
    public String getName() {
        return name;
    }
    /**
     * Gets the author.
     *
     * @return     The author.
     */
    public String getAuthor() {
        return author;
    }
    /**
     * Gets the price.
     *
     * @return     The price.
     */
    public float getPrice() {
        return price;
    }
    /**
     * compares the objects.
     *
     * @param      other  The other
     *
     * @return     integer
     */
    public int compareTo(final Book other) {
        return this.name.compareTo(other.name);
    }
    /**
     * Returns a string representation of the object.
     *
     * @return     String representation of the object.
     */
    public String toString() {
        return getName() + ", " + getAuthor() + ", " + getPrice();
    }
}
