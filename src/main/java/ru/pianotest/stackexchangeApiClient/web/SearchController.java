package ru.pianotest.stackexchangeApiClient.web;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.pianotest.stackexchangeApiClient.entities.*;
import ru.pianotest.stackexchangeApiClient.util.Paginator;

import java.util.*;

/**
 * Created by admin on 19.08.2016.
 */

@Controller
public class SearchController {

    private final static Logger LOGGER = Logger.getLogger(SearchController.class);

    @Autowired
    private RestApiClient restApiClient;

    private Paginator<StackExchangeResponse> paginator = new Paginator<>();

    private List<StackExchangeResponse> items = new ArrayList<>();

    private List<Integer> numbers = new ArrayList<>();

    private int countPages;

    @RequestMapping(value = {"/", "/index"}, method = RequestMethod.GET)
    public String index(StackExchangeRequest request) {
        return "index";
    }

    @RequestMapping(value = {"/search"}, method = RequestMethod.GET)
    public String search(StackExchangeRequest request, BindingResult bindingResult, Model model) {
        Map<String, Object> searchTerms = new HashMap<>();
        if (bindingResult.hasErrors()) {
            model.addAttribute("javaErrors", bindingResult.getAllErrors());
            return "index";
        }
        addSearchParam(searchTerms, "fromdate", request.getFromDate() != null ? request.getFromDate().getMillis() / 1000 : null);
        addSearchParam(searchTerms, "todate", request.getToDate() != null ? request.getToDate().getMillis() / 1000 : null);
        addSearchParam(searchTerms, "min", request.getMin() != null ? request.getMin().getMillis() / 1000 : null);
        addSearchParam(searchTerms, "max", request.getMax() != null ? request.getMax().getMillis() / 1000 : null);
        addSearchParam(searchTerms, "intitle", request.getInTitle());
        addSearchParam(searchTerms, "site", request.getSite());
        addSearchParam(searchTerms, "taged", request.getTagged());
        addSearchParam(searchTerms, "nottaged", request.getNotTagged());
        addSearchParam(searchTerms, "order", request.getOrder().getName());
        addSearchParam(searchTerms, "sort", request.getSort().getName());
        addSearchParam(searchTerms, "page", request.getPage());
        addSearchParam(searchTerms, "pageSize", request.getPageSize());
        try {
            items = restApiClient.search(searchTerms).getResponses();
            model.addAttribute("items", paginator.getListByPage(items, 1));
            countPages = paginator.getCountPages(items);
            numbers.clear();
            for (int i = 1; i <= countPages; i++)
                numbers.add(i);
            LOGGER.info(new StringBuilder().append("количество страниц: ").append(numbers.size()));
            LOGGER.info(new StringBuilder().append("количество строк: ").append(items.size()));
        } catch (Exception e) {
            e.printStackTrace();
            LOGGER.error(e);
            model.addAttribute("javaErrors", e);
        }
        return "index";
    }

    @RequestMapping(value = {"/{pageNumber}"}, method = RequestMethod.GET)
    public String getPage(@PathVariable("pageNumber") int pageNumber, StackExchangeRequest request, Model model){
        StringBuilder redirect = new StringBuilder().append("redirect:/");
        if (items.size() == 0){
            LOGGER.error(new StringBuilder().append("поисковый запрос не выполнен или результрующий список пуст"));
            return redirect.toString();
        }
        if (pageNumber > countPages || pageNumber < 1){
            int currentPage = paginator.getCurrentPage();
            LOGGER.error(new StringBuilder().append("страница №").append(pageNumber).append(" не существует, выполнен переход на страницу №").append(currentPage));
            redirect = redirect.append(currentPage);
            return redirect.toString();
        }
        model.addAttribute("items", paginator.getListByPage(items, pageNumber));
        LOGGER.info(new StringBuilder().append("текущая страница: ").append(pageNumber));
        return "index";
    }
    
    private void addSearchParam(Map<String, Object> searchTerms, String key, Object value){
        if (value != null && String.valueOf(value).length() != 0)
            searchTerms.put(key, value);
    }

    @ModelAttribute("allOrders")
    public List<Order> allOrders() {
        return Arrays.asList(Order.ALL);
    }

    @ModelAttribute("allSorts")
    public List<Sort> allSorts() {
        return Arrays.asList(Sort.ALL);
    }

    @ModelAttribute("numbers")
    public List<Integer> getNumbers() {
        return numbers;
    }

    @ModelAttribute("countPages")
    public int getCountPages(){
        return countPages;
    }

    @ModelAttribute("paginator")
    public Paginator<StackExchangeResponse> getPaginator(){
        return paginator;
    }
}
