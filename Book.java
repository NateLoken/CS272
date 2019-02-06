//CS-272
//Nate Loken
//January 18, 2019
public class Book{
    private String title;
    private int authorNumber;
    private String authors[];
    private String isbn;

    public Book(){
        title = "";
        authorNumber = 0;
        authors = new String[3];
        isbn = "";
    }//end default constructor
    
    public Book(String t){
        title = t;
        isbn = "";
        authorNumber = 0;
        authors = new String[3];
    }// end constructor
    
    /**
     * This is a copy constructor which takes the information from another object and puts into a new one
     * @param obj is has the information that is being copied to the new object if is a Book object
     */
    public Book (Object obj){
        if(obj != null)
            if( obj instanceof Book){
                Book copy = (Book) obj;
                title = copy.getTitle();
                authorNumber = copy.getAuthorNumber();
                isbn = copy.getISBN();
                authors = new String[3];
                for(int i = 0; i < authorNumber; i++)
                    authors[i] = copy.getAuthors(i);
            }//end if
      
    }//end constructor

    public String getTitle(){
        return title;
    }

    public int getAuthorNumber(){
        return authorNumber;
    }

    public String getISBN(){
        return isbn;
    }

    public String getAuthors(int index){
        return authors[index];
    }

    public void setTitle(String t){
        title  = t;
    }

    public void setISBN(String i){
        isbn = i;
    }

    /**
     * addAuthor adds an authors name to the list of authors only if there aren't more than three authors
     * already on the book
     * @param a is the authors name
     * @return returns true if you can add an author and false if it can't
     */
    public boolean addAuthor(String a){
        if(authorNumber < 3){
            if(authors[0] != ""){
                authors[0] = a;
                authorNumber++;
                return true;
            }//end if
            
            if(authors[1] != ""){
                authors[1] = a;
                authorNumber++;
                return true;
            }//end if

            if(authors[2] != ""){
                authors[2] = a;
                authorNumber++;
                return true;
            }//end if
        }//end if
        return false;
    }//end addAuthor

   public boolean equals(Object obj){
        if( obj instanceof Book){
            Book candidate = (Book) obj;
            if(candidate.isbn == isbn)
                return true;
            else    
                return false;
        }//end if
        else
            return false;
   }//end equals

   /**
    * This function gets all the authors of book 1 and book 2 by checking if the two books have similar authors 
    in each slot then adds the strings to an array.
    * @param b1 this is Book 1 
    * @param b2 this is Book 2
    * @return totalAuthors 
    */
    public static String[] getAllAuthors(Book b1, Book b2){
        String totalAuthors[] = new String[6];
        if(b1 != null || b2 != null){
            for(int i = 0; i < (b1.getAuthorNumber() + b2.getAuthorNumber()); i++){
                if(b1.getAuthors(i).equals(b2.getAuthors(i)))
                    totalAuthors[i] = b1.getAuthors(i);
                else{
                    totalAuthors[i] = b1.getAuthors(i);
                    totalAuthors[i + 1] = b2.getAuthors(i);
                }//end else
             }//end for
        }//end if
        return totalAuthors;
    }//end getAllAuthors

    public String toString(){
        String result;
        result = title + " " + isbn + " " + authorNumber;
        for(int i = 0; i < 3; i++){
            result = result + " " + authors[i];
        }//end for
        return result;
    }//end toString
    
    public static void main(String[]args) {
        Book b1 = new Book();
        System.out.println(b1.toString());
        b1.setTitle("Moby Dick");
        System.out.println("The new book title is " + b1.getTitle());
        b1.setISBN("978-3-16-148410-0");
        System.out.println("The new ISBN is " +  b1.getISBN());
        b1.addAuthor("Starbuck");
        System.out.println(b1.toString());
    
        Book b2 = new Book("Harry Potter");
        System.out.println(b2.toString());
        b2.addAuthor("J.K. Rowling");
        System.out.println(b2.toString());

        if(b1.equals(b2))
            System.out.println("Book 1 and Book 2 are the same");
        else    
            System.out.println("They are different");
        
        Book b3 = new Book(b2);
        System.out.println(b3.toString());
        if(b3.equals(b2))
            System.out.println("These Books are the same");
        else
            System.out.println("They are different");
        
        System.out.println(getAllAuthors(b1, b2));
    }//end main

}//end book class