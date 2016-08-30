package ru.pianotest.stackexchangeApiClient.util;

import java.util.ArrayList;
import java.util.List;

/**
 * Самодельный пагинатор для вывода ответов по страницам
 * @param <T> класс для постраничного вывода
 */
public class Paginator<T>{

    private int pageSize = 10;
    private int currentPage;
    private int lastPage;

    /**
     * получение списка для данной страницы
     * @param list исходный список
     * @param page выводимая страница
     * @return список объектов на странице
     */
    public List<T> getListByPage(List<T> list, int page){
        this.currentPage = page;
        List<T> result = new ArrayList<T>();
        int lastItem = list.size() <= (page - 1) * pageSize + pageSize ? list.size() :(page - 1) * pageSize + pageSize;
        lastPage = list.size() % pageSize == 0 ? list.size() / pageSize : 1 + (list.size() - list.size() % pageSize) / pageSize;
        for (int i = (page -1) * pageSize; i < lastItem; i++){
            result.add(list.get(i));
        }
        return result;
    }

    /**
     * получение количества страниц для списка
     * @param list исходный список
     * @return количество страниц
     */
    public int getCountPages(List<T> list){
        lastPage = list.size() % pageSize == 0 ? list.size() / pageSize : 1 + (list.size() - list.size() % pageSize) / pageSize;
        return lastPage;
    }

    /**
     * получение номера текущей страницы
     * @return номер страницы
     */
    public int getCurrentPage(){
        return currentPage;
    }

    /**
     * получение номера последней страницы
     * @return номер страницы
     */
    public int getLastPage() {
        return lastPage;
    }

    /**
     * получение максимального
     * @return размер страницы
     */
    public int getPageSize(){
        return pageSize;
    }

    /**
     * получение информации о наличии следющей страницы
     * @return страница есть/нет
     */
    public boolean isHasNext(){
        return currentPage < lastPage;
    }

    /**
     * получение информации о наличии предыдущей страницы
     * @return страница есть/нет
     */
    public boolean isHasPrevious(){
        return currentPage > 1;
    }

    /**
     * получение информации о том, является ли текущая страница первой
     * @return да/нет
     */
    public boolean isFirst(){
        return currentPage == 1;
    }

    /**
     * получение информации о том, является ли текущая страница последней
     * @return да/нет
     */
    public boolean isLast(){
        return currentPage == lastPage;
    }
}
