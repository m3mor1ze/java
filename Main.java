import javax.swing.*;

public class Main {
    public static void main(String[] args) {
// Конструируем экземпляр фрейма
        //JFrame frame = new JFrame();
        MainFrame frame = new MainFrame();
// Задаѐм реакцию на нажатие кнопки закрытия фрейма
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
// Показываем фрейм на экране
        frame.draw(Context.displayables);
        frame.setVisible(true);
    }
}