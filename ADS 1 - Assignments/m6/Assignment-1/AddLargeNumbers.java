class AddLargeNumbers {
    static LinkedList l1;
    static LinkedList fl;

    public static LinkedList numberToDigits(String number) {
        l1 = new LinkedList();
        for (int i = number.length() - 1; i >= 0 ; i--) {
            String digit = "" + number.charAt(i);
            l1.push(Integer.parseInt(digit));
        }
        // l1.print();
        return l1;
    }

    public static String digitsToNumber(LinkedList list) {
        return list.print();
        // System.out.println("Present out");
        // String str = "";
        // for (int i = 0; i < list.size(); i++) {
        //     System.out.println("Present in");
        //     // System.out.println(temp);
        //     str = str + Integer.toString(list.pop());
        // }
        // return str;
    }

    public static LinkedList addLargeNumbers(LinkedList list1, LinkedList list2) {
        fl = new LinkedList();
        // for (int i = 0; i < list1.size(); i++) {
        //     int a = list1.pop() + list2.pop();
        //     fl.push(a);
        // }
        // return fl;
        fl.push(0);
        int place = 0;
        String result = "";
        while (!list1.isEmpty()) {
            place = fl.pop() + list1.insertafter(list1.size) + list2.insertafter(list2.size);
            result =  (place % 10) + result;
            if (place > 9) {
                fl.push(place / 10);
            } else {
                fl.push(0);
            }
        }
        while (!list2.isEmpty()) {
            result =  list2.insertafter(list2.size) + fl.pop() + result;
            fl.push(0);
        }
        if (fl.first.data != 0) {
            result = fl.pop() + result;
        }
        return numberToDigits(result);
    }
}