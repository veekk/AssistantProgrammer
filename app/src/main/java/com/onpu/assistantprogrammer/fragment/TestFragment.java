package com.onpu.assistantprogrammer.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.onpu.assistantprogrammer.model.Item;
import com.onpu.assistantprogrammer.R;
import com.onpu.assistantprogrammer.model.Language;
import com.onpu.assistantprogrammer.util.CustomFragmentManager;
import com.onpu.assistantprogrammer.util.RecyclerViewAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Crafted by veek on 23.05.16 with love ♥
 */

public class TestFragment extends Fragment {

    CustomFragmentManager fragmentManager = CustomFragmentManager.getInstance();
    View rootView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_test, null);//Инфлейтим наш лэйаут

        RecyclerView mRecView = (RecyclerView)rootView.findViewById(R.id.mRecView); // Определяем RecyclerView
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());// Определяем llm
        mRecView.setLayoutManager(llm);//Присваиваем llm RecyclerView
        List<Item> items = new ArrayList<>();//Создаём навый список пунктов
        items.clear();
        //заполняем пункты по форме (id, текст, связи)
        items.add(new Item(0, "Зачем хотите изучить программирование?", new int[]{1, 2, 3, 4, 5, 6}));
        items.add(new Item(1, "Для детей", new int[]{7}));
        items.add(new Item(2, "Заработать", new int[]{8, 32}));
        items.add(new Item(3, "Я не знаю, выберите за меня", new int[]{56}));
        items.add(new Item(4, "Поразвлечься", new int[]{9}));
        items.add(new Item(5, "Интересно", new int[]{9}));
        items.add(new Item(6, "Саморазвитие", new int[]{9}));
        items.add(new Item(7, "Начните со Scratch, затем...", new int[]{56}));
        items.add(new Item(8, "Найти работу", new int[]{33}));
        items.add(new Item(9, "Уже есть идея на миллион?", new int[]{10, 19}));
        items.add(new Item(10, "Нет. Просто хочу начать", new int[]{11}));
        items.add(new Item(11, "Мне нравится учиться", new int[]{12, 13, 14, 15}));
        items.add(new Item(12, "Простым способом", new int[]{56}));
        items.add(new Item(13, "Лучшим способом", new int[]{56}));
        items.add(new Item(14, "Трудненьким способом", new int[]{16}));
        items.add(new Item(15, "Очень сложный путь (но потом будет легче)", new int[]{64}));
        items.add(new Item(16, "Какая коробка передач?", new int[]{17, 18}));
        items.add(new Item(17, "Автомат", new int[]{58}));
        items.add(new Item(18, "Ручная", new int[]{60}));
        items.add(new Item(19, "Да", new int[]{20}));
        items.add(new Item(20, "Какая платформа/сфера?", new int[]{31, 34, 35, 36}));
        items.add(new Item(21, "Не знаю", new int[]{23}));
        items.add(new Item(22, "Нет", new int[]{23}));
        items.add(new Item(23, "Какая у Вас любимая игрушка?", new int[]{24, 25, 26}));
        items.add(new Item(24, "Lego", new int[]{56}));
        items.add(new Item(25, "Пластилин", new int[]{61}));
        items.add(new Item(26, "Старенький, но любимый мишка", new int[]{62}));
        items.add(new Item(27, "Хотите попробовать что-то новое, но не очень трудоёмкое?", new int[]{21, 22, 28}));
        items.add(new Item(28, "Да", new int[]{57}));
        items.add(new Item(29, "Нет", new int[]{27}));
        items.add(new Item(30, "Ваш сервис будет работать в реальном времени, как twitter?", new int[]{28, 29}));
        items.add(new Item(31, "Веб", new int[]{30}));
        items.add(new Item(32, "У меня есть идея для стартапа!", new int[]{20}));
        items.add(new Item(33, "Какая платформа/сфера?", new int[]{34, 35, 36, 41, 49, 50}));
        items.add(new Item(34, "3D/игры", new int[]{64}));
        items.add(new Item(35, "Мобильная", new int[]{37}));
        items.add(new Item(36, "Корп. софт", new int[]{45}));
        items.add(new Item(37, "Какая OS?", new int[]{38, 39}));
        items.add(new Item(38, "iOS", new int[]{63}));
        items.add(new Item(39, "Android", new int[]{58}));
        items.add(new Item(40, "Фронтенд (веб-интерфейс)", new int[]{57}));
        items.add(new Item(41, "Веб", new int[]{40, 42}));
        items.add(new Item(42, "Бэкенд (то, что за вебсайтом)", new int[]{43}));
        items.add(new Item(43, "Хочу работать на...", new int[]{44, 55}));
        items.add(new Item(44, "Стартап", new int[]{27}));
        items.add(new Item(45, "Что скажете о Microsoft?", new int[]{46, 47, 48}));
        items.add(new Item(46, "Люблю его :)", new int[]{59}));
        items.add(new Item(47, "Неплохо :|", new int[]{58}));
        items.add(new Item(48, "Фууууу :(", new int[]{58}));
        items.add(new Item(49, "Я просто хочу $$$", new int[]{58}));
        items.add(new Item(50, "Я хочу работать в крупной IT-компании", new int[]{51, 52, 53, 54, 55}));
        items.add(new Item(51, "Facebook", new int[]{56}));
        items.add(new Item(52, "Windows", new int[]{59}));
        items.add(new Item(53, "Apple", new int[]{63}));
        items.add(new Item(54, "Google  ", new int[]{56}));
        items.add(new Item(55, "Корпорацию", new int[]{45}));
        items.add(new Item(56, "Показать результат!", new int[] {}));
        items.add(new Item(57, "Показать результат!", new int[] {}));
        items.add(new Item(58, "Показать результат!", new int[] {}));
        items.add(new Item(59, "Показать результат!", new int[] {}));
        items.add(new Item(60, "Показать результат!", new int[] {}));
        items.add(new Item(61, "Показать результат!", new int[] {}));
        items.add(new Item(62, "Показать результат!", new int[] {}));
        items.add(new Item(63, "Показать результат!", new int[] {}));
        items.add(new Item(64, "Показать результат!", new int[] {}));


        List<Language> languages = new ArrayList<>();//Создаём навый список языков
        //Забиваем наш список языков в формате (id, название языка, описание, ссылка на инфо, ссылка на видео) для диалогов
        //вызываемых после результатов теста
        languages.add(new Language(0, "Python", "pyth фловралофыралофыраоф", "https://py-info.com", "https://py-video.com"));
        languages.add(new Language(1, "JavaScript", "js фловралофыралофыраоф", "https://js-info.com", "https://js-video.com"));
        languages.add(new Language(2, "Java", "java фловралофыралофыраоф", "https://java-info.com", "https://java-video.com"));
        languages.add(new Language(3, "C#", "c# фловралофыралофыраоф", "https://csh-info.com", "https://csh-video.com"));
        languages.add(new Language(4, "C", "c фловралофыралофыраоф", "https://c-info.com", "https://c-video.com"));
        languages.add(new Language(5, "Ruby", "ruby фловралофыралофыраоф", "https://ruby-info.com", "https://ruby-video.com"));
        languages.add(new Language(6, "PHP", "php фловралофыралофыраоф", "https://php-info.com", "https://php-video.com"));
        languages.add(new Language(7, "Objective-C", "obj-c фловралофыралофыраоф", "https://objc-info.com", "https://objc-video.com"));
        languages.add(new Language(8, "C++", "c++ фловралофыралофыраоф", "https://cpp-info.com", "https://cpp-video.com"));





        RecyclerViewAdapter adapter = new RecyclerViewAdapter(items, languages, getActivity()); //определяем адаптер
        mRecView.setAdapter(adapter);//сетим адаптер
        return rootView;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }
}
