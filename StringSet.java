public class StringSet{
    private String[] data;
    private int manyItems;

    public StringSet(){
        data = new String[2];
        manyItems = 0;
    }//end constructor

    public StringSet(int capacity){
        if(capacity < 0)
            throw new IllegalArgumentException();
        data = new String[capacity];
        manyItems = 0;
    }//end constructor

    /**
     * This constructor takes the data from a pre-existing object and copies it to a new object
     * @param obj the object that you are trying to copy
     */
    public StringSet(Object obj){
        if(obj != null){
            if(obj instanceof StringSet){
                StringSet temp = (StringSet) obj;
                data = temp.data;
                System.arraycopy(temp.data, 0, data, 0, temp.manyItems);
                manyItems = temp.manyItems;
            }
            else
                throw new IllegalArgumentException("You cannot create a new StringSet if the object is not of the StringSet class");
        }
        else
            throw new IllegalArgumentException("You cannot create a new StringSet if object is null");

    }//end constructor

    public int size(){
        return manyItems;
    }//end size

    public int capacity(){
        return data.length;
    }

    public String getData(int x){
        return data[x];
    }
    /**
     * ensureCapacity checks to see if the array is large enough to add another String to the data array
     * and if it isn't then it doubles the size of the array
     * @param minCapacity
     * @exception IllegalArgumentException
     * indicates minCapacity is less negative
     */
    private void ensureCapacity(int minCapacity){
        if(minCapacity < 0)
            throw new IllegalArgumentException();
        if(minCapacity < data.length)
            return;
        String[] temp = new String[(data.length + 1) * 2];
        System.arraycopy(data, 0, temp, 0, data.length);
        data = temp;
    }
    /**
     * The add function takes a string parameter and checks uses ensureCapacity to see if there is enough
     * space in the array and then adds the string data to the data array
     * 
     * 
     * @param s is a String object
     */
    public void add(String s){
        if(s != null){
            ensureCapacity(manyItems);
            for(int i = 0; i < manyItems; i++)
                if(data[i].equals(s)) return;
            data[manyItems] = s;
            manyItems++;
        }//end if
    }//end add

    /**
     * The contain function parses the collection to check if the string entered is in the collection
     * @param a this is the string you want to check for
     * @return returns true if the function found the string and false if it did not
     */
    public boolean contains(String a){
        if(a == null)
            return false;
        for(int i = 0; i < manyItems; i++)
            if(data[i].equals(a))
                return true;
        return false;
    }

    /**
     * The remove function parses the collection to check for the string entered and then removes it 
     * @param a this is the string you want removed
     * @return returns true if it found and removed the string and false if it did not
     */
    public boolean remove(String a){
        for(int i = 0; i < manyItems; i++)
            if(data[i].equals(a)){
                data[i] = data[manyItems - 1];
                manyItems--;
                return true;
            }
        return false;
    }//end remove

    /**
     * addOrdered adds a string to the collection and then orders the collection by the first letter 
     * of the string stored in each array index
     * @param a the string you want to add
     */
    public void addOrdered(String a){
        if(a != null){
            ensureCapacity(manyItems);
            for(int i = 0; i < manyItems; i++)
                if(data[i].equals(a)) return;
            data[manyItems] = a;
            manyItems++;
        }
        for(int i = 1; i < manyItems; i++)
            for(int j = i - 1; j < manyItems; j++)
                for(int k = 1; k < data[i].length(); k++){
                    if(data[i].charAt(0) == data[j].charAt(0) && data[i].length() > data[j].length())
                        return;
                    
                    if(data[i].charAt(0) == data[j].charAt(0) && data[j].length() < data[i].length()){
                        String temp = data[j];
                        data[j] = data[i];
                        data[i] = temp;
                    }//end if

                    if((int)data[i].charAt(0) == (int)data[j].charAt(0))
                        if((int)data[i].charAt(k) > (int)data[j].charAt(k)){
                            String temp = data[j];
                            data[j] = data[i];
                            data[i] = temp;
                        }//end nested if

                    if((int)data[i].charAt(0) > (int)data[j].charAt(0)){
                        String temp = data[j];
                        data[j] = data[i];
                        data[i] = temp;
                    }//end if

                }//end for 
    }//end addOdererd


    public static void main(String[] args) {
        String a = null;
        StringSet s1 = new StringSet();
        s1.add("your boi");
        s1.add("bonk");
        System.out.println(s1.size());
        s1.add("bonk");
        System.out.println(s1.size());
        s1.add("Player");
        s1.add(a);
        System.out.println("Does s1 contain a null string? " + s1.contains(a));
        System.out.println("Does s1 contain Bonk? " + s1.contains("Bonk"));
        System.out.println("Does s1 contain your boi? " + s1.contains("your boi"));
        System.out.println(s1.size());

        StringSet s2 = new StringSet(10);
        s2.add("aaa");
        s2.add("Jenny");
        s2.add("Bob");
        s2.addOrdered("John");
        System.out.println("I can remove the first string, " +  s2.remove("aaa"));
        System.out.println("I can remove the second string, " + s2.remove("cc"));
        System.out.println("The size of s2 is: " + s2.size() + " The capacity of s2 is: " + s2.capacity());
        if(s2.contains("Jenny") && s2.contains("John"))
            System.out.println("s2 contains that string");
        System.out.println(s2.getData(0) + " " + s2.getData(1) + " " + s2.getData(2));

        StringSet s3 = new StringSet(s2);
        System.out.println("The size of s3 is " + s3.size() + " The capacity of s3 is " + s3.capacity());

        StringSet s4 = new StringSet(a);
        System.out.println(s4);

        StringSet s5 = new StringSet(-1);
        System.out.println(s5);   
        

    }//end main
}