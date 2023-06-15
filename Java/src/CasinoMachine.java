import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class CasinoMachine {

    private ArrayList<Toy> listToy;

    public CasinoMachine() {
        listToy = new ArrayList<Toy>();
    }

    public void addToy(Toy newToy, int count) {
        for (int i = 0; i < count; i++) {
            listToy.add(newToy);
        }
    }

    /* Формируем массив чисел для определения случайной игрушки */
    private ArrayList<Integer> chanceList;
    /* Создаем массив для записи выигранных игрушек */
//    private ArrayList<String> winnerList;

    public void startGame() {
        chanceList = new ArrayList<Integer>();
        for (int i = 0; i < listToy.size(); i++) {
            int toyChance = listToy.get(i).getDropChance();
            for (int j = 0; j < toyChance; j++) {
                chanceList.add(listToy.get(i).getId());
            }
        }

        /* Определяем игрушку, записываем ее в список выигранных и выводим результат */
        int n = (int) Math.floor(Math.random() * chanceList.size());

        for (int i = 0; i < listToy.size(); i++) {
            if (listToy.get(i).getId() == chanceList.get(n)) {
                System.out.println("Поздравляем! Ваш приз - " + listToy.get(i).getName());
                listToy.remove(i);
                try (FileWriter writer = new FileWriter("winnerList.txt")) {
                    writer.write(listToy.get(i).getName());
                }
                catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    public void getListToy() {
        for (int i = 0; i < listToy.size(); i++) {
            System.out.println(listToy.get(i));
        }
    }
}
