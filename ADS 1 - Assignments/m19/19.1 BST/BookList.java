/**.
 * List of books.
 *
 * @param      <Key>    The key
 * @param      <Value>  The value
 */
class BookList<Key extends Comparable<Key>, Value> {
    /**
     * Book name.
     */
    private String name;
    /**
     * Author name.
     */
    private String author;
    /**
     * Cost of the book.
     */
    private Float cost;
    /**
     * Constructs the object.
     *
     * @param      name1    The name
     * @param      author1  The author
     * @param      cost1    The cost
     */
    BookList(final String name1, final String author1, final Float cost1) {
        this.name = name1;
        this.author = author1;
        this.cost = cost1;
    }
    /**
     * Gets the name.
     *
     * @return     The name.
     */
    public String getName() {
        return this.name;
    }
    /**
     * Sets the name.
     *
     * @param      name1  The name
     */
    public void setName(final String name1) {
        this.name = name1;
    }
    /**
     * Gets the author.
     *
     * @return     The author.
     */
    public String getAuthor() {
        return this.author;
    }
    /**
     * Sets the author.
     *
     * @param      author1  The author
     */
    public void setAuthor(final String author1) {
        this.author = author1;
    }
    /**
     * Gets the cost.
     *
     * @return     The cost.
     */
    public float getCost() {
        return this.cost;
    }
    /**
     * Sets the cost.
     *
     * @param      cost1  The cost
     */
    public void setCost(final float cost1) {
        this.cost = cost1;
    }
    /**
     * Compare to function.
     *
     * @param      that  The that
     *
     * @return     { description_of_the_return_value }
     * Time complexity : O(1)
     */
    public int compareTo(final BookList that) {
        if (this.getName().compareTo(that.getName()) > 0) {
            return 1;
        } else if (this.getName().compareTo(that.getName()) < 0) {
            return -1;
        } else {
            if (this.getAuthor().compareTo(that.getAuthor()) > 0) {
                return 1;
            } else if (this.getAuthor().compareTo(that.getAuthor()) < 0) {
                return -1;
            } else {
                if (this.getCost() > that.getCost()) {
                    return 1;
                } else if (this.getCost() < that.getCost()) {
                    return -1;
                } else {
                    return 0;
                }
            }
        }
    }
    /**
     * Returns a string representation of the object.
     *
     * @return     String representation of the object.
     */
    public String toString() {
        return getName() + ", " + getAuthor() + ", " + getCost();
    }
}
