package lesson2;

public class homework {

    public static void main(String[] args) {
        String[][] strings1 = {{"1", "2", "3", "4"}, {"1", "2", "3", "4"}, {"5", "6", "7", "8"}, {"5", "6", "5", "7"}};

        try {
            System.out.println("Сумма всех элементов двумерного массива 4х4 равна: "+ Integerisation(strings1));

        } catch (MyArraySizeException e)  {
            System.out.println("Массив неверного размера.");
        }  catch (MyArrayDataException e) {
            System.out.println("Не удалось преобразовать в число значение ячейки ["+ e.getI() +"] [" + e.getJ() +"]");
        }
    }



    public static int Integerisation(String[][] strings) throws MyArraySizeException, MyArrayDataException {
        int sum = 0;
        if (strings.length != 4 || strings[0].length != 4) {
            throw new MyArraySizeException();
        } else {

            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                    try {
                        sum = (sum + Integer.parseInt(strings[i][j]));
                    } catch (NumberFormatException e) {
                        throw new MyArrayDataException(i, j);
                    }
                }
            }
            return sum;
        }
    }

}
