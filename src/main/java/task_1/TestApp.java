package task_1;


//16-30 26.05.2021
//17-00 26.05.2021
public class TestApp {
    public static void main(String[] args) {
        Parent parent = new Parent();
        parent.print();
        Parent child = new Child();
        child.print();
    }

    private static class Parent {
        String fio;

        Parent() {
            this.fio = "анна мария оглы";
        }

        private void print() {
            if (this instanceof Child) {
                String[] array = fio.trim().split("");
                for (int i = 0; i < array.length; i++) {
                    if (i == 0) {
                        array[i] = array[i].toUpperCase();
                    } else if (array[i - 1].equals(" ") ||
                            array[i - 1].equals("'") ||
                            array[i - 1].equals("-")
                    ) {
                        array[i] = array[i].toUpperCase();
                    } else array[i] = array[i].toLowerCase();
                    System.out.print(array[i]);
                }
            } else
                System.out.println(fio + "!");
        }
    }

    private static class Child extends Parent {
        Child() {
            super.fio = "АН'НА-МАРИЯ оглы";
        }

    }
}
