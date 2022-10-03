public class Principal {
    public static void main(String[] args) {
        StackX theStack = new StackX(2);
        System.out.println(theStack.push(new Objeto("German", 75)));
        System.out.println(theStack.push(new Objeto("Ignacio", 90)));
        System.out.println(theStack.push(new Objeto("Jose", 62)));
        theStack.showStack();
    }
}
