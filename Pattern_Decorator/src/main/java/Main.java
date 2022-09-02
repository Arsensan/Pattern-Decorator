public class Main {
    public static void main(String[] args) {
        double cost;
        // Гадание на Таро
        Service taro = new Divination("Taro", 1000);
        // Персональный гороскоп
        Service personalHoroscope = new Horoscope("Персональный гороскоп", 900);
        cost = taro.getPrice() + personalHoroscope.getPrice();
        System.out.println(cost);


        /*
        Суть паттерна в том, что он позволяет не создавать новые классы
        и подклассы и огромным количеством ветвлений комбинаций услуг и цен, а
        создает единственный класс для доп. опций каждой услуги , который имплементирует
        Service  и так же содержать Service в поле . Кроме того мы так же добавляем
        будущие доп опции
         */

        // Гадание на таро с доп. опциями. Паттерн декоратор
        Service chakra = new Chakra(taro);
        Service aura = new Aura(chakra);

// Общая стоимость Таро + чарка + аура
        System.out.println(aura.getPrice());

// Тоже самое для с услугой Персональное гадание. Добавляем доп. поции последовательно       
        Service channeling = new Channeling(personalHoroscope); // новая доп опция channeling
        Service avatar = new Avatar(channeling); //  новая доп опция Avatar


        System.out.println(avatar.getPrice());
    }
}
