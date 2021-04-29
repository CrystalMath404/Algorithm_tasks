import java.util.*;

public class laba2Runner {
    public static void main(String[] args){

        int element = 7;
        int[] sortedAr = {1,4,5,7,9,13,15,17,19,22,25,27,30};
        List<Integer> arrayList = new ArrayList<Integer>();
        for (int i = 0; i < sortedAr.length; i++){
            arrayList.add(sortedAr[i]);
        }


/**
 * реализация добавления и удаления элементов
 */

        System.out.println("Задание №1:");
        System.out.println();
        System.out.println("Ищем элемент " + element + " в сортированном массиве " + arrayList);

        BinarySearch binary = new BinarySearch();
        int first = 0; //первый элемент массива
        int last = arrayList.size() - 1; //последний элемент массива
        System.out.println("Индекс элемента при бинарном поиске = " + binary.binarySearch(arrayList, element, first, last));

        FibonacciNumber fib = new FibonacciNumber();
        int index = fib.search(arrayList, element);
        System.out.println("Индекс элемента при Фибоначчиевом поиске = " + index);

        InterpSearch interpSearch = new InterpSearch();
        System.out.println("Индекс элемента при интерполяционном поиске = " + interpSearch.interpolationSearch(arrayList, element));

        LinkedList llist = new LinkedList();

        /* Let us create a sorted linked list to test the functions
           Created linked list will be 7->6->5->4->3->2->1 */
        for (int i = 0; i < sortedAr.length; i++){
            llist.push(sortedAr[sortedAr.length - 1 - i]);
        }

        Hashtable table1 = new Hashtable(300000);
        Hashtable table2 = new Hashtable(300000);
        Hashtable table3 = new Hashtable(300000);
        Random rand = new Random(System.currentTimeMillis());

        final int ARRSIZE = 100000;

        ArrayList<Integer> array = new ArrayList<Integer>();

        BinaryTree tree = null;
        ArrayList<Integer> l = new ArrayList<>(9);
        //заполняю массив элементами
        for (int i = 0; i < ARRSIZE; i++){
            int number = rand.nextInt(1000000);

            array.add(number);
            if(tree == null){
                tree = new BinaryTree(number);
            }
            tree.add(number);
        }
        //сортирую массив
        Collections.sort(array);

        long start1 = System.currentTimeMillis();
        for(int i = 0; i < 10000; i++){
            tree.B_search(i);
        }
        long end1 = System.currentTimeMillis();
        System.out.println("\nВремя поиска по бинарному дереву: " + (end1 - start1));

        BinarySearch bserch = new BinarySearch();
        start1 = System.currentTimeMillis();
        for(int i = 0; i < 10000; i++){
            bserch.binarySearch(array, i, 0, array.size() - 1);
        }
        end1 = System.currentTimeMillis();
        System.out.println("Время бинарного поиска: " + (end1 - start1));

        start1 = System.currentTimeMillis();
        for(int i = 0; i < 10000; i++){
            interpSearch.interpolationSearch(array, i);
        }
        end1 = System.currentTimeMillis();
        System.out.println("Время интерполяционного поиска: " + (end1 - start1));

        start1 = System.currentTimeMillis();
        for(int i = 0; i < 10000; i++){
            fib.search(array, i);
        }
        end1 = System.currentTimeMillis();
        System.out.println("Время фиббоначиева поиска : " + (end1 - start1));

        System.out.println();
        System.out.println("Задание №2:");

        System.out.println("\nВставка\n");

        for(int i = 0; i < 4; i++){
            long start = System.currentTimeMillis();
            switch(i){
                case 0:
                    for(int j = 0; j < ARRSIZE; j++){
                        int num = rand.nextInt(table1.size()*10);
                        table1.insert_simple(num);
                    }
                    System.out.println("Время вставки при простом хэшировании: " + (System.currentTimeMillis() - start));
                    break;
                case 1:
                    for(int j = 0; j < ARRSIZE; j++){
                        int num = rand.nextInt(table2.size()*10);
                        table2.insert_fake(num);
                    }
                    System.out.println("Время вставки при псевдо рехэшировании: " + (System.currentTimeMillis() - start));
                    break;
                case 2:
                    for(int j = 0; j < ARRSIZE; j++){
                        int num = rand.nextInt(table1.size()*10);
                        table1.insert_chain(num);
                    }
                    System.out.println("Время вставки в методе цепочек: " + (System.currentTimeMillis() - start));
                    break;
                case 3:
                    for (int j = 0; j < ARRSIZE; j++){
                        int number = rand.nextInt(10 * ARRSIZE);
                        if(tree == null){
                            tree = new BinaryTree(number);
                        }
                        tree.add(number);
                    }
                    System.out.println("Время вставки в двоичном дереве " + (System.currentTimeMillis() - start));
                    break;
                default:
                    break;
            }
        }

        System.out.println("\nПоиск\n");

        for(int i = 0; i < 4; i++){
            int num = rand.nextInt(100);
            long start = System.currentTimeMillis();
            switch(i){
                case 0:
                    for(int j = 0; j < ARRSIZE; j++){
                        table1.search_simple(j);
                    }
                    System.out.println("Время поиска при простое хэширование: " + (System.currentTimeMillis() - start));
                    break;
                case 1:
                    for(int j = 0; j < ARRSIZE; j++){
                        table2.search_fake(j);
                    }
                    System.out.println("Время поиска при псевдо рехэширование: " + (System.currentTimeMillis() - start));
                    break;
                case 2:
                    for(int j = 0; j < ARRSIZE; j++){
                        table1.search_chain(j);
                    }
                    System.out.println("Время поиска при методе цепочек: " + (System.currentTimeMillis() - start));
                    break;
                case 3:
                    break;
                default:
                    break;
            }
        }

        System.out.println("\nУдаление\n");

        for(int i = 0; i < 4; i++){
            int num = rand.nextInt(100);
            long start = System.currentTimeMillis();
            switch(i){
                case 0:
                    for(int j = 0; j < ARRSIZE; j++){
                        table1.delete_simple(num);
                    }
                    System.out.println("Время удаления при простом хэшировании: " + (System.currentTimeMillis() - start));
                    break;
                case 1:
                    for(int j = 0; j < ARRSIZE; j++){
                        table2.delete_fake(num);
                    }
                    System.out.println("Время удаления при псевдо рехэшировании: " + (System.currentTimeMillis() - start));
                    break;
                case 2:
                    for(int j = 0; j < ARRSIZE; j++){
                        table1.delete_chain(num);
                    }
                    System.out.println("Время удаления при методе цепочек: " + (System.currentTimeMillis() - start));
                    break;
                case 3:
                    for(int j = 0; j < ARRSIZE; j++){
                        tree.remove(num);
                    }
                    System.out.println("Время удаления из бинарного дерева: " + (System.currentTimeMillis() - start));
                    break;
                default:
                    break;
            }
        }

        // Задача о ферзях
        System.out.println();
        System.out.println("Задание № 3. Задача о 8 ферзях");
        System.out.println();

        Chess c = new Chess(8);
        int counter = 0;
        do {
            if (c.isPeace()) {
                counter ++;
                c.printState();
                System.out.println("----------------------");
            }
        } while (c.next());

        System.out.println("Итого: " + counter);

        System.out.println();
    }
}

