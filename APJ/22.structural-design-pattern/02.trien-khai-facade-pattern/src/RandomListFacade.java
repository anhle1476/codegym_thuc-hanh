public class RandomListFacade {
    public void printRandomEvenList(int size) {
        RandomList randomList = new RandomList();
        ListFilter listFilter = new ListFilter();
        ListPrinter listPrinter = new ListPrinter();

        Integer[] list = randomList.generateList(size);
        if (list == null) {
            System.out.println("Size invalid");
            return;
        }
        Integer[] filteredList = listFilter.filterOdd(list);
        System.out.println("Filtered list: ");
        listPrinter.printList(filteredList);
    }
}
