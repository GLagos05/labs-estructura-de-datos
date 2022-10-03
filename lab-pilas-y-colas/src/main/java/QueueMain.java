public class QueueMain {
    public static void main(String[] args) {
        //crear un queue
        //insertar elementos de cola con insert()
        //eliminar elementos de cola con remove()
        //mostrar elementos de cola con showQueue()

        Queue theQueue = new Queue(5);

        theQueue.insert(10);
        theQueue.insert(20);
        theQueue.insert(30);
        theQueue.insert(40);
        theQueue.insert(50);
        theQueue.showQueue();

        theQueue.remove();
        theQueue.showQueue();

        theQueue.insert(60);
        theQueue.showQueue();

        theQueue.remove();
        theQueue.showQueue();

        theQueue.insert(70);
        theQueue.showQueue();

/*
        thequeue.insert(10);            // insert 4 items
        thequeue.insert(20);
        thequeue.insert(30);
        thequeue.insert(40);

        thequeue.remove();              // remove 3 items
        thequeue.remove();              //    (10, 20, 30)
        thequeue.remove();

        thequeue.insert(50);            // insert 4 more items
        thequeue.insert(60);            //    (wraps around)
        thequeue.insert(70);
        thequeue.insert(80);
        thequeue.showQueue();
        */
    }
}
