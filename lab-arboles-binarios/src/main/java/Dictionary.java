import java.util.Stack;
class Word {
    public String name;
    public String description;
    public String qualification;
    public Word leftChild;
    public Word rightChild;

    public void displayWord(){
        System.out.println('{');
        System.out.println("Name: "+ name);
        System.out.println("Description: "+ description);
        System.out.println("Qualification: "+ qualification);
        System.out.println("} ");
    }

}

class Dictionary {

    private Word root;

    public Dictionary() {
        root = null;
    }

    public Word find(String name)      // find node with given key
    {                           // (assumes non-empty tree)
        Word current = root;               // start at root
        while(!current.name.equals(name))        // while no match,
        {
            if(name.compareTo(current.name) < 0)         // go left?
                current = current.leftChild;
            else                            // or go right?
                current = current.rightChild;
            if(current == null)             // if no child,
                return null;                 // didn't find it
        }
        current.displayWord();
        return current;                    // found it
    }  // end find()

    public void insert(String name, String des, String qual)
    {
        Word newWord = new Word();    // make new node
        newWord.name = name;           // insert data
        newWord.description = des;
        newWord.qualification = qual;
        if(root==null)                // no node in root
            root = newWord;
        else                          // root occupied
        {
            Word current = root;       // start at root
            Word parent;
            while(true)                // (exits internally)
            {
                parent = current;
                if(name.compareTo(current.name) < 0)  // go left?
                {
                    current = current.leftChild;
                    if(current == null)  // if end of the line,
                    {                 // insert on left
                        parent.leftChild = newWord;
                        return;
                    }
                }  // end if go left
                else                    // or go right?
                {
                    current = current.rightChild;
                    if(current == null)  // if end of the line
                    {                 // insert on right
                        parent.rightChild = newWord;
                        return;
                    }
                }  // end else go right
            }  // end while
        }  // end else not root
    }  // end insert()

    public void displayTree()
    {
        Stack globalStack = new Stack();
        globalStack.push(root);
        int nBlanks = 10;
        boolean isRowEmpty = false;
        System.out.println(
                "......................................................");
        while(isRowEmpty==false)
        {
            Stack localStack = new Stack();
            isRowEmpty = true;

            for(int j=0; j<nBlanks; j++)
                System.out.print(' ');

            while(globalStack.isEmpty()==false)
            {
                Word temp = (Word) globalStack.pop();
                if(temp != null)
                {
                    temp.displayWord();
                    localStack.push(temp.leftChild);
                    localStack.push(temp.rightChild);

                    if(temp.leftChild != null ||
                            temp.rightChild != null)
                        isRowEmpty = false;
                }
                else
                {
                    System.out.print("--");
                    localStack.push(null);
                    localStack.push(null);
                }
                for(int j=0; j<nBlanks*2-2; j++)
                    System.out.print(' ');
            }  // end while globalStack not empty
            System.out.println();
            nBlanks /= 2;
            while(localStack.isEmpty()==false)
                globalStack.push( localStack.pop() );
        }  // end while isRowEmpty is false
        System.out.println(
                "......................................................");
    }  // end displayTree()

}

class DictionaryApp {
    public static void main(String[] args) {

        Dictionary theDictionary = new Dictionary();

        theDictionary.insert("Asignatura ","La palabra asignatura procede del latín assignātus, signado.","sustantivo");
        theDictionary.insert("Videojuego ","Videojuego es una palabra llana de 5 sílabas.","sustantivo");
        theDictionary.insert("Felicidad ","La palabra felicidad procede del latín felicĭtas, -ātis.","sustantivo");

        theDictionary.find("Videojuego");

        theDictionary.displayTree();
    }
}
