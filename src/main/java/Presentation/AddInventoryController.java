package Presentation;

import Datasource.Hibernate.ItemHibernate;
import Datasource.Hibernate.LoginHibernate;
import Datasource.IitemHibernate;
import Datasource.IloginHibernate;
import Domain.Account;
import Domain.Item;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class AddInventoryController extends HttpServlet {

    IitemHibernate itemHibernate = new ItemHibernate();
    IloginHibernate login = new LoginHibernate();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/AddInventory.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String owner = (String)session.getAttribute("owner");

        if(checkName(owner)) {
            if (checkParameters(request)) {
                if (request.getParameterMap().containsKey("addOrSubtract_Add")) {
                    Item item = itemHibernate.find(request.getParameter("code"));
                    item.addAmount(Integer.parseInt(request.getParameter("amount")));
                    updateItem(item);
                } else if (request.getParameterMap().containsKey("addOrSubtract_Subtract")) {
                    Item item = itemHibernate.find(request.getParameter("code"));
                    item.subtractAmount(Integer.parseInt(request.getParameter("amount")));
                    updateOrDeleteItem(item);
                } else {
                    addOrUpdateItem(request.getParameter("name")
                            , request.getParameter("code")
                            , Integer.parseInt(request.getParameter("amount")));
                }
            }
        }
        response.sendRedirect("/ViewInventory");
    }

    private boolean checkName(String name) {
        boolean bool = false;
        try{
            for(Account account : login.getAccountByNameOnly(name)){
                if(account.getName().equalsIgnoreCase(name)){
                    bool = true;
                }
            }
        }catch (Exception e){
            bool = false;
        }
        return bool;
    }

    private void updateOrDeleteItem(Item item) {
        if (item.getAmount() > 0) {
            updateItem(item);
        } else {
            deleteItem(item);
        }
    }

    private void addOrUpdateItem(String name, String code, int amount){
        if(checkIfExsist(code)){
            Item item = itemHibernate.find(code);
            item.addAmount(amount);
            updateItem(item);
        } else {
            itemHibernate.add(new Item(name,code, amount));
        }
    }

    private boolean checkIfExsist(String code){
        if(itemHibernate.find(code) == null){
            return false;
        } else {
            return true;
        }
    }

    private boolean checkParameters(HttpServletRequest request){
        if(request.getParameterMap().containsKey("code")
                && request.getParameterMap().containsKey("name")
                && request.getParameterMap().containsKey("amount")){
            if(request.getParameter("code") != ""
                    && request.getParameter("name") != ""
                    && request.getParameter("amount") != ""){
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    private void updateItem(Item item){
        try{
            itemHibernate.update(item);
        } catch(Exception e){
            e.printStackTrace();
        }
    }

    private void deleteItem(Item item){
        try{
            itemHibernate.delete(item);
        } catch(Exception e){
            e.printStackTrace();
        }
    }
}
